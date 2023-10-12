package co.edu.uniquindio.supermercado.model;

import co.edu.uniquindio.supermercado.enumeracion.RolEmpleado;
import co.edu.uniquindio.supermercado.enumeracion.TipoIdentificacion;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {
    private String nit;
    private String nombre;
    List<Cliente> listaClientes = new ArrayList<>();
    List<Empleado> listaEmpleados = new ArrayList<>();
    List<Producto> listaProductos = new ArrayList<>();

    public Supermercado() {
    }

    public Supermercado(String nit, String nombre) {
        this.nit = nit;
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    /**
     * Metodo para crear un cliente
     * @param numIdentificacion
     * @param tipoIdentificacion
     * @param nombres
     * @param apellidos
     * @param supermercado
     * @return boolean
     */
    public boolean crearCliente(String numIdentificacion, TipoIdentificacion tipoIdentificacion, String nombres, String apellidos, Supermercado supermercado){
        Cliente cliente = new Cliente(numIdentificacion, tipoIdentificacion, nombres, apellidos);
        cliente.setOwnedBySupermercado(supermercado);
        getListaClientes().add(cliente);
        return true;
    }

    /**
     * Metodo para obtener la lista de clientes
     * @return List<Cliente>
     */
    public List<Cliente> obtenerClientes() {
        return getListaClientes();
    }

    /**
     * Metodo para obtener editar cliente
     * @param numIdentificacion
     * @param tipoIdentificacion
     * @param nombres
     * @param apellidos
     * @param supermercado
     */
    public void editarCliente(String numIdentificacion, TipoIdentificacion tipoIdentificacion, String nombres, String apellidos, Supermercado supermercado) {
        int tamanioLista = getListaClientes().size();
        for(int i = 0; i < tamanioLista; i++){
            Cliente cliente = getListaClientes().get(i);
            if(cliente.getNumIdentificacion().equalsIgnoreCase(numIdentificacion)){
                cliente.setTipoIdentificacion(tipoIdentificacion);
                cliente.setNombres(nombres);
                cliente.setApellidos(apellidos);
                cliente.setOwnedBySupermercado(supermercado);
                break;
            }
        }
    }

    /**
     * Metodo para eliminar cliente
     * @param numIdentificacion
     */
    public void eliminarCliente(String numIdentificacion) {
        int tamanioLista = getListaClientes().size();
        for(int i = 0; i < tamanioLista; i++){
            Cliente cliente = getListaClientes().get(i);
            if(cliente.getNumIdentificacion().equalsIgnoreCase(numIdentificacion)){
                getListaClientes().remove(i);
                break;
            }
        }
    }


    /**
     * Metodo para crear un empleado
     * @param numIdentificacion
     * @param nombres
     * @param apellidos
     * @param rol
     * @param fechaNcimiento
     * @param telefono
     * @param supermercado
     * @return boolean
     */
    public boolean crearEmpleado(String numIdentificacion, String nombres, String apellidos, RolEmpleado rol, String fechaNcimiento, String telefono, Supermercado supermercado) {
        Empleado empleado = new Empleado(numIdentificacion,nombres,apellidos,rol,fechaNcimiento,telefono);
        empleado.setOwnedBySupermercado(supermercado);
        getListaEmpleados().add(empleado);
        return true;
    }

    /**
     * Metodo para obtener los empleados
     * @return List<Empleado>
     */
    public List<Empleado> obtenerEmpleados(){
        return getListaEmpleados();
    }

    /**
     * Metodo para esitar empleados
     * @param numIdentificacion
     * @param nombres
     * @param apellidos
     * @param rol
     * @param fechaNacimiento
     * @param telefono
     * @param supermercado
     */
    public void editarEmpleado(String numIdentificacion, String nombres, String apellidos, RolEmpleado rol, String fechaNacimiento, String telefono, Supermercado supermercado){
        int tamanioLista = getListaEmpleados().size();
        for(int i = 0; i < tamanioLista; i++){
            Empleado empleado = getListaEmpleados().get(i);
            if (empleado.getNumIdentificacion().equalsIgnoreCase(numIdentificacion)){
                empleado.setNombres(nombres);
                empleado.setApellidos(apellidos);
                empleado.setRol(rol);
                empleado.setFechaNacimiento(fechaNacimiento);
                empleado.setTelefono(telefono);
                empleado.setOwnedBySupermercado(supermercado);
                break;
            }
        }
    }

    /**
     * Metodo para eliminar empleados
     * @param numIdentificacion
     */
    public void eliminarEmpleado(String numIdentificacion){
        int tamanioLista = getListaEmpleados().size();
        for(int i=0; i<tamanioLista; i++){
            Empleado empleado = getListaEmpleados().get(i);
            if (empleado.getNumIdentificacion().equalsIgnoreCase(numIdentificacion)){
                getListaEmpleados().remove(i);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Supermercado{" +
                "nit='" + nit + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }

}
