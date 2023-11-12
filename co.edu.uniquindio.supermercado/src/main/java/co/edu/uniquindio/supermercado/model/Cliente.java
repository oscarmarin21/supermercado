package co.edu.uniquindio.supermercado.model;

import co.edu.uniquindio.supermercado.enumeracion.TipoIdentificacion;

public class Cliente extends Persona {
    private TipoIdentificacion tipoIdentificacion;
    Supermercado ownedBySupermercado;

    public Cliente(String numIdentificacion, TipoIdentificacion tipoIdentificacion, String nombres, String apellidos) {
        super(numIdentificacion,nombres,apellidos);
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public TipoIdentificacion getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
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
                super.toString()+
                "tipoIdentificacion=" + tipoIdentificacion +
                ", ownedBySupermercado=" + ownedBySupermercado +
                '}';
    }
}
