package eam.edu.co.ParcheVacaciones.services;

import java.util.List;

import eam.edu.co.ParcheVacaciones.domain.Usuario;
import eam.edu.co.ParcheVacaciones.dto.UsuarioRegistroDTO;
import org.springframework.security.core.userdetails.UserDetailsService;




public interface UsuarioService extends UserDetailsService{

    public Usuario guardar(UsuarioRegistroDTO registroDTO);

    public void editar(Usuario user);

    public void editarImagen(Usuario user);

    public Usuario buscar(String email);

    public List<Usuario> listarUsuarios();

}
