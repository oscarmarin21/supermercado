package co.edu.uniquindio.supermercado.model;

import co.edu.uniquindio.supermercado.enumeracion.TipoIdentificacion;

public class Cliente {
    private String numIdentificacion;
    private TipoIdentificacion tipoIdentificacion;
    private String nombres;
    private String apellidos;
    Supermercado ownedBySupermercado;

    public Cliente() {
    }

    public Cliente(String numIdentificacion, TipoIdentificacion tipoIdentificacion, String nombres, String apellidos) {
        this.numIdentificacion = numIdentificacion;
        this.tipoIdentificacion = tipoIdentificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public String getNumIdentificacion() {
        return numIdentificacion;
    }

    public void setNumIdentificacion(String numIdentificacion) {
        this.numIdentificacion = numIdentificacion;
    }

    public TipoIdentificacion getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Supermercado getOwnedBySupermercado() {
        return ownedBySupermercado;
    }

    public void setOwnedBySupermercado(Supermercado ownedBySupermercado) {
        this.ownedBySupermercado = ownedBySupermercado;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "numIdentificacion='" + numIdentificacion + '\'' +
                ", tipoIdentificacion=" + tipoIdentificacion +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                '}';
    }
}
