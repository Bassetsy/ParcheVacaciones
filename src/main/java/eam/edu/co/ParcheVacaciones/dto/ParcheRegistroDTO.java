package eam.edu.co.ParcheVacaciones.dto;

import org.springframework.web.multipart.MultipartFile;

public class ParcheRegistroDTO {
    private Long id;

    private String titulo;

    private String description;

    private String fecha;

    private String lugar;

    private String rutaImagen;

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

    public ParcheRegistroDTO(String titulo, String description, String fecha, String lugar, String rutaImagen, MultipartFile imagen) {
        super();
        this.id = id;
        this.titulo = titulo;
        this.description = description;
        this.fecha = fecha;
        this.lugar = lugar;
        this.rutaImagen = rutaImagen;
        this.imagen = imagen;
    }

    public ParcheRegistroDTO() {

    }
}
