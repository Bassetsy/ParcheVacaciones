package eam.edu.co.ParcheVacaciones.services;

import eam.edu.co.ParcheVacaciones.domain.Parche;
import eam.edu.co.ParcheVacaciones.dto.ParcheRegistroDTO;

import java.util.List;

public interface ParcheService {
    public List<Parche> listar();
    public Parche buscar(Parche parche);
    public Parche guardar(ParcheRegistroDTO parche);
    public void eliminar(Parche parche);
}
