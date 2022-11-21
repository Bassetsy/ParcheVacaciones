package eam.edu.co.ParcheVacaciones;

import eam.edu.co.ParcheVacaciones.domain.Parche;
import eam.edu.co.ParcheVacaciones.dto.ParcheRegistroDTO;
import eam.edu.co.ParcheVacaciones.dto.UsuarioRegistroDTO;
import eam.edu.co.ParcheVacaciones.services.AlmacenImplementation;
import eam.edu.co.ParcheVacaciones.services.ParcheService;
import eam.edu.co.ParcheVacaciones.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/registroParche")
public class ControladorParche {

    private ParcheService parcheService;

    @Autowired
    private AlmacenImplementation serviceImpl;

    public ControladorParche (ParcheService parcheService) {
        super();
        this.parcheService = parcheService;
    }

    @ModelAttribute("parche")
    public ParcheRegistroDTO retornarNuevoParcheRegistroDTO() {
        return new ParcheRegistroDTO();
    }

    @GetMapping
    public String mostrarFormularioDeRegistro() {
        return "registroParche";
    }

    @PostMapping
    public String registrarParche(@ModelAttribute("parche") ParcheRegistroDTO registroDTO) {
        String rutaPortada = serviceImpl.almacenarArchivo(registroDTO.getImagen());
        registroDTO.setRutaImagen(rutaPortada);
        parcheService.guardar(registroDTO);
        return "redirect:/registroParche?exito";
    }




}

