package co.edu.uniquindio.supermercado.model;

import co.edu.uniquindio.supermercado.enumeracion.RolEmpleado;

import java.util.List;

public class Empleado extends Persona{
    private RolEmpleado rol;
    private String fechaNacimiento;
    private String telefono;
    private Supermercado ownedBySupermercado;
    private List<Venta> listaVentasAsociadas;
    private List<CompraInsumos> listaComprasInsumosAsociadas;

    public Empleado(String numIdentificacion, String nombres, String apellidos, RolEmpleado rol, String fechaNacimiento, String telefono) {
        super(numIdentificacion, nombres, apellidos);
        this.rol = rol;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
    }

    public RolEmpleado getRol() {
        return rol;
    }

    public void setRol(RolEmpleado rol) {
        this.rol = rol;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Supermercado getOwnedBySupermercado() {
        return ownedBySupermercado;
    }

    public void setOwnedBySupermercado(Supermercado ownedBySupermercado) {
        this.ownedBySupermercado = ownedBySupermercado;
    }

    public List<Venta> getListaVentasAsociadas() {
        return listaVentasAsociadas;
    }

    public void setListaVentasAsociadas(List<Venta> listaVentasAsociadas) {
        this.listaVentasAsociadas = listaVentasAsociadas;
    }

    public List<CompraInsumos> getListaComprasInsumosAsociadas() {
        return listaComprasInsumosAsociadas;
    }

    public void setListaComprasInsumosAsociadas(List<CompraInsumos> listaComprasInsumosAsociadas) {
        this.listaComprasInsumosAsociadas = listaComprasInsumosAsociadas;
    }

    @Override
    public String toString() {
        return
                super.toString() + "," +
                " rol=" + rol +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", telefono='" + telefono;
    }
}
