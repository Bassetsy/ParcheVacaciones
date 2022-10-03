package eam.edu.co.ParcheVacaciones;

import eam.edu.co.ParcheVacaciones.domain.Usuario;
import eam.edu.co.ParcheVacaciones.dto.UsuarioRegistroDTO;
import eam.edu.co.ParcheVacaciones.services.AlmacenImplementation;
import eam.edu.co.ParcheVacaciones.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {

    private UsuarioService usuarioService;

    @Autowired
    private AlmacenImplementation serviceImpl;

    public RegistroUsuarioControlador(UsuarioService usuarioService) {
        super();
        this.usuarioService = usuarioService;
    }

    @ModelAttribute("usuario")
    public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
        return new UsuarioRegistroDTO();
    }

    @GetMapping
    public String mostrarFormularioDeRegistro() {
        return "registro";
    }

    @PostMapping
    public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO) {
        String rutaPortada = serviceImpl.almacenarArchivo(registroDTO.getImagen());
        registroDTO.setRutaImagen(rutaPortada);
        usuarioService.guardar(registroDTO);
        return "redirect:/registro?exito";
    }

}
