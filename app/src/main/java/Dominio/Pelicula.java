package Dominio;

import java.util.List;

public class Pelicula {
    private String nbrPelicula;
    private int anno;
    private String director;
    private String actorName;
    private String genero;
    private Double calificacion;
    private List<Comentario> comentarios;

    public Pelicula(String nbrPelicula, int anno, String director, String actorName, String genero,
                    Double calificacion, List<Comentario> comentarios)
    {
        this.nbrPelicula = nbrPelicula;
        this.anno = anno;
        this.director = director;
        this.actorName = actorName;
        this.genero = genero;
        this.calificacion = calificacion;
        this.comentarios = comentarios;
    }

    public String getNbrPelicula() {
        return nbrPelicula;
    }

    public void setNbrPelicula(String nbrPelicula) {
        this.nbrPelicula = nbrPelicula;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
}
