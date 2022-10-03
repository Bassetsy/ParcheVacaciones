package eam.edu.co.ParcheVacaciones;

import eam.edu.co.ParcheVacaciones.domain.Usuario;
import eam.edu.co.ParcheVacaciones.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class RegistroControlador {

    @Autowired
    private UsuarioService servicio;

    @GetMapping("/login")
    public String iniciarSesion() {
        return "login";
    }

    @GetMapping("/")
    public String verPaginaDeInicio(@AuthenticationPrincipal User user, Model model) {
        Usuario usuario = servicio.buscar(user.getUsername());
        model.addAttribute("usuario", usuario);
        return "index";
    }
}
