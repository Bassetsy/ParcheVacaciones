package eam.edu.co.ParcheVacaciones.services;


import eam.edu.co.ParcheVacaciones.dao.ParcheDao;
import eam.edu.co.ParcheVacaciones.dao.UsuarioDao;
import eam.edu.co.ParcheVacaciones.domain.Parche;
import eam.edu.co.ParcheVacaciones.domain.Rol;
import eam.edu.co.ParcheVacaciones.domain.Usuario;
import eam.edu.co.ParcheVacaciones.dto.ParcheRegistroDTO;
import eam.edu.co.ParcheVacaciones.dto.UsuarioRegistroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@Service
public class ParcheImplementation implements ParcheService {

    @Autowired
    private ParcheDao parcheDao;

    public ParcheImplementation(ParcheDao parcheDao) {
        super();
        this.parcheDao = parcheDao;
    }
    @Override
    @Transactional(readOnly = true)
    public List<Parche> listar() {
        return (List<Parche>) parcheDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Parche buscar(Parche parche) {
        return parcheDao.findById(parche.getId()).orElse(null);
    }

    @Override
    @Transactional
    public Parche guardar(ParcheRegistroDTO registroDTO) {
        Parche parche = new Parche(registroDTO.getTitulo(), registroDTO.getDescription(),
                registroDTO.getFecha(), registroDTO.getLugar(), registroDTO.getRutaImagen(),
                registroDTO.getImagen());
        parcheDao.save(parche);
        return parche;
    }

    @Override
    @Transactional
    public void eliminar(Parche parche) {
        parcheDao.delete(parche);
    }
}
