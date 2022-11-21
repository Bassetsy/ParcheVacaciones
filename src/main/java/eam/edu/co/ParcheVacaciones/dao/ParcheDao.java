package eam.edu.co.ParcheVacaciones.dao;

import eam.edu.co.ParcheVacaciones.domain.Parche;
import eam.edu.co.ParcheVacaciones.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcheDao extends JpaRepository<Parche, Long> {
    public Parche findById(String id);
}
