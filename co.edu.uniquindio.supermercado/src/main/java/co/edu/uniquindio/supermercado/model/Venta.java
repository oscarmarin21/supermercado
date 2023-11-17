package co.edu.uniquindio.supermercado.model;

import java.util.Date;

public class Venta {
    String idVenta;
    String fechaVenta;

    public Venta() {
    }

    public Venta(String idVenta, String fechaVenta) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "idVenta='" + idVenta + '\'' +
                ", fechaVenta='" + fechaVenta + '\'' +
                '}';
    }
}
