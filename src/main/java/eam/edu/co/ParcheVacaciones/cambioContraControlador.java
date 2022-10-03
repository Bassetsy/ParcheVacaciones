package eam.edu.co.ParcheVacaciones;

import eam.edu.co.ParcheVacaciones.dao.UsuarioDao;
import eam.edu.co.ParcheVacaciones.domain.Usuario;
import eam.edu.co.ParcheVacaciones.dto.UsuarioRegistroDTO;
import eam.edu.co.ParcheVacaciones.services.AlmacenImplementation;
import eam.edu.co.ParcheVacaciones.services.UsuarioService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;

@Controller
public class cambioContraControlador {

    private UsuarioService usuarioService;

    public cambioContraControlador(UsuarioService usuarioService) {
        super();
        this.usuarioService = usuarioService;
    }

    @Autowired
    private AlmacenImplementation serviceImpl;

    @Autowired
    UsuarioDao usuarioDao;

    @GetMapping("/cambio")
    public String cambiarContrasenia(@AuthenticationPrincipal User user, Model model){
        Usuario usuario = usuarioDao.findByEmail(user.getUsername());
        model.addAttribute("user", usuario);
        return "cambioContrasenia";
    }

    @PostMapping("/cambiarContrasenia/{email}")
    public String obtenerContraAnt (Usuario usuario, String nueva, String old){
        Usuario user = usuarioDao.findByEmail(usuario.getEmail());
        System.out.println("Contra user: " + user.getPassword());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(encoder.matches(old, user.getPassword())){
            user.setPassword(encoder.encode(nueva));
            usuarioService.editar(user);
            return "redirect:/";
        }else {
            return "redirect:/cambio?error";
        }
    }

    @GetMapping("/cambioImagen")
    public String cambiarImagen(@AuthenticationPrincipal User user, Model model){
        Usuario usuario = usuarioDao.findByEmail(user.getUsername());
        model.addAttribute("user", usuario);
        return "cambioImagen";
    }

    @PostMapping("/cambiarImagenPerfil/{email}")
    public String establecerNuevaImagen (Usuario usuario, File img){
        //Usuario user = usuarioDao.findByEmail(usuario.getEmail());
        //String ruta = serviceImpl.almacenarArchivo(img);
        //user.setRutaImagen(ruta);
        //usuarioService.editarImagen(user);
        return "redirect:/cambioImagen?exito";
    }

}
