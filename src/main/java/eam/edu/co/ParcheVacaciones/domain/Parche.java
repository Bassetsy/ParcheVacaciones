package eam.edu.co.ParcheVacaciones.domain;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Collection;

@Data
@Entity
@Table(name = "parches")
public class Parche {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min=1, max=145)
    private String titulo;

    @NotNull
    private String description;

    @NotNull
    @Size(min=1, max=10000)
    private String fecha;

    @NotNull
    @Size(min=1, max=25)
    private String lugar;

    @NotNull
    @Size(min=1, max=255)
    private String rutaImagen;

    @Transient
    private MultipartFile imagen;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public MultipartFile getImagen() {
        return imagen;
    }

    public void setImagen(MultipartFile imagen) {
        this.imagen = imagen;
    }

    public Parche(Long id, String titulo, String description, String fecha, String lugar, String rutaImagen, MultipartFile imagen) {
        super();
        this.id = id;
        this.titulo = titulo;
        this.description = description;
        this.fecha = fecha;
        this.lugar = lugar;
        this.rutaImagen = rutaImagen;
        this.imagen = imagen;
    }

    public Parche(String titulo, String description, String fecha, String lugar, String rutaImagen, MultipartFile imagen) {
        super();
        this.titulo = titulo;
        this.description = description;
        this.fecha = fecha;
        this.lugar = lugar;
        this.rutaImagen = rutaImagen;
        this.imagen = imagen;
    }

    public Parche() {

    }
}
