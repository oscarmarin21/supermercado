package co.edu.uniquindio.supermercado.model;

import co.edu.uniquindio.supermercado.enumeracion.RolEmpleado;

public class Empleado {
    private String numIdentificacion;
    private String nombres;
    private String apellidos;
    private RolEmpleado rol;
    private String fechaNacimiento;
    private String telefono;
    Supermercado ownedBySupermercado;

    public Empleado() {
    }

    public Empleado(String numIdentificacion, String nombres, String apellidos, RolEmpleado rol, String fechaNacimiento, String telefono) {
        this.numIdentificacion = numIdentificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.rol = rol;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
    }

    public String getNumIdentificacion() {
        return numIdentificacion;
    }

    public void setNumIdentificacion(String numIdentificacion) {
        this.numIdentificacion = numIdentificacion;
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

    @Override
    public String toString() {
        return "Empleado{" +
                "numIdentificacion='" + numIdentificacion + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", rol=" + rol +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
