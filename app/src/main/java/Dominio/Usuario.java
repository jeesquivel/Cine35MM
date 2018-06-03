package Dominio;

import java.io.Serializable;

public class Usuario implements Serializable{
    private String name, email, contrasenna;
    private boolean isAdmin;
    private boolean bloqueado;

    public Usuario(){}

    public Usuario(String name, String email, String contrasenna, boolean admin, boolean bloqueado) {
        this.name = name;
        this.email = email;
        this.contrasenna = contrasenna;
        this.isAdmin = admin;
        this.bloqueado = bloqueado;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public boolean getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }
}
