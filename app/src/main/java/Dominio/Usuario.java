package Dominio;

import java.io.Serializable;

public class Usuario implements Serializable{
    private String name,email, contrasenna;
    private int isAdmin;

    public int getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(int bloqueado) {
        this.bloqueado = bloqueado;
    }

    private int bloqueado;

    public Usuario(){}

    public Usuario(String name, String email,String contrasenna,int admin) {
        this.name = name;
        this.email = email;
        this.contrasenna=contrasenna;
        this.isAdmin=admin;
        this.bloqueado=0;

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

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }
}
