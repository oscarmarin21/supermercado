package co.edu.uniquindio.supermercado.model;

public class CompraInsumos {
    private String idCompra;
    private String fechaCompra;

    public CompraInsumos() {
    }

    public CompraInsumos(String idCompra, String fechaCompra) {
        this.idCompra = idCompra;
        this.fechaCompra = fechaCompra;
    }

    public String getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(String idCompra) {
        this.idCompra = idCompra;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    @Override
    public String toString() {
        return "CompraInsumos{" +
                "idCompra='" + idCompra + '\'' +
                ", fechaCompra='" + fechaCompra + '\'' +
                '}';
    }
}
