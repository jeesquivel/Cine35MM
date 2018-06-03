package Dominio;

public class Comentario {
    private Usuario user;
    private String comentario;

    public Comentario(Usuario user, String comentario)
    {
        this.user = user;
        this.comentario = comentario;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
