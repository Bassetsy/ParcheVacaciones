package eam.edu.co.ParcheVacaciones.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import eam.edu.co.ParcheVacaciones.dao.UsuarioDao;
import eam.edu.co.ParcheVacaciones.domain.Rol;
import eam.edu.co.ParcheVacaciones.domain.Usuario;
import eam.edu.co.ParcheVacaciones.dto.UsuarioRegistroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;


@Service
public class UsuarioServiceImpl implements UsuarioService {


    private UsuarioDao usuarioDao;


    public UsuarioServiceImpl(UsuarioDao usuarioDao) {
        super();
        this.usuarioDao = usuarioDao;
    }

    @Override
    public Usuario guardar(UsuarioRegistroDTO registroDTO) {
        Usuario usuario = new Usuario(registroDTO.getNombre(),
                registroDTO.getApellido(),registroDTO.getEmail(),
                new BCryptPasswordEncoder().encode(registroDTO.getPassword()),
                registroDTO.getEdad(), registroDTO.getGenero(),
                registroDTO.getTelefono(), registroDTO.getCiudadResidencia(),
                registroDTO.getPais(), Arrays.asList(new Rol("ROLE_USER")),
                registroDTO.getRutaImagen(), registroDTO.getImagen());
        return usuarioDao.save(usuario);
    }

    @Override
    public void editar(Usuario user) {
        usuarioDao.delete(user);
        usuarioDao.save(user);
    }

    @Override
    public void editarImagen(Usuario user) {
        usuarioDao.delete(user);
        usuarioDao.save(user);
    }

    @Override
    public Usuario buscar(String email) {
        return usuarioDao.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioDao.findByEmail(username);
        if(usuario == null) {
            throw new UsernameNotFoundException("Usuario o password inválidos");
        }
        return new User(usuario.getEmail(),usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioDao.findAll();
    }
}
