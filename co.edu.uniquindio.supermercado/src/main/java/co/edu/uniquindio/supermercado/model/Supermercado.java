package co.edu.uniquindio.supermercado.model;

import co.edu.uniquindio.supermercado.enumeracion.RolEmpleado;
import co.edu.uniquindio.supermercado.enumeracion.TipoIdentificacion;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Supermercado {
    private String nit;
    private String nombre;
    private List<Cliente> listaClientes = new ArrayList<>();
    private List<Empleado> listaEmpleados = new ArrayList<>();
    private List<Producto> listaProductos = new ArrayList<>();
    private List<Proveedor> listaProveedores = new ArrayList<>();
    private List<Venta> listaVentas = new ArrayList<>();

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

    public List<Cliente> getListaClientes() { return listaClientes; }

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

    public List<Proveedor> getListaProveedores() {
        return listaProveedores;
    }

    public void setListaProveedores(List<Proveedor> listaProveedores) {
        this.listaProveedores = listaProveedores;
    }

    public List<Venta> getListaVentas() {   return listaVentas; }

    public void setListaVentas(List<Venta> listaVentas) {   this.listaVentas = listaVentas; }

    /**
     * Metodo para crear un cliente
     *
     * @param numIdentificacion
     * @param tipoIdentificacion
     * @param nombres
     * @param apellidos
     * @param supermercado
     * @return boolean
     */
    public boolean crearCliente(String numIdentificacion, TipoIdentificacion tipoIdentificacion, String nombres, String apellidos, Supermercado supermercado) {
        boolean exist = validarExistenciaCliente(numIdentificacion);
        if (exist==false) {
            Cliente cliente = new Cliente(numIdentificacion, tipoIdentificacion, nombres, apellidos);
            cliente.setOwnedBySupermercado(supermercado);
            getListaClientes().add(cliente);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo para obtener la lista de clientes
     *
     * @return List<Cliente>
     */
    public List<Cliente> obtenerClientes() {
        return getListaClientes();
    }

    /**
     * Metodo para obtener un cliente por identificacion
     * @param numIdentificacion
     * @return Cliente
     */
    public Cliente obtenerCliente(String numIdentificacion) {
        Cliente clienteEncontrado = null;
        for (Cliente cliente : getListaClientes()) {
            if (cliente.getNumIdentificacion().equalsIgnoreCase(numIdentificacion)){
                clienteEncontrado = cliente;
                break;
            }
        }
        return clienteEncontrado;
    }

    /**
     * Metodo para obtener validar si existe Cliente
     * @param numIdentificacion
     * @return boolean
     */
    public boolean validarExistenciaCliente(String numIdentificacion) {
        int tamanioLista = getListaClientes().size();
        boolean exist = false;
        for (int i = 0; i < tamanioLista; i++) {
            Cliente cliente = getListaClientes().get(i);
            if (cliente.getNumIdentificacion().equalsIgnoreCase(numIdentificacion)) {
                exist = true;
                break;
            }
        }
        return exist;
    }

    /**
     * Metodo para obtener editar cliente
     *
     * @param numIdentificacion
     * @param tipoIdentificacion
     * @param nombres
     * @param apellidos
     * @param supermercado
     * @return boolean
     */
    public boolean editarCliente(String numIdentificacion, TipoIdentificacion tipoIdentificacion, String nombres, String apellidos, Supermercado supermercado) {
        int tamanioLista = getListaClientes().size();
        boolean actualizar = false;
        for (int i = 0; i < tamanioLista; i++) {
            Cliente cliente = getListaClientes().get(i);
            if (cliente.getNumIdentificacion().equalsIgnoreCase(numIdentificacion)) {
                cliente.setTipoIdentificacion(tipoIdentificacion);
                cliente.setNombres(nombres);
                cliente.setApellidos(apellidos);
                cliente.setOwnedBySupermercado(supermercado);
                actualizar = true;
                break;
            }
        }
        return actualizar;
    }

    /**
     * Metodo para eliminar cliente
     *
     * @param numIdentificacion
     * @return boolean
     */
    public boolean eliminarCliente(String numIdentificacion) {
        int tamanioLista = getListaClientes().size();
        boolean eliminar = false;

        for (int i = 0; i < tamanioLista; i++) {
            Cliente cliente = getListaClientes().get(i);
            if (cliente.getNumIdentificacion().equalsIgnoreCase(numIdentificacion)) {
                getListaClientes().remove(i);
                eliminar = true;
                break;
            }
        }
        return eliminar;
    }

    /**
     * Metodo para crear un empleado
     *
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

        boolean exist = validarExistenciaEmpleado(numIdentificacion);
        if (exist==false) {
            Empleado empleado = new Empleado(numIdentificacion, nombres, apellidos, rol, fechaNcimiento, telefono);
            empleado.setOwnedBySupermercado(supermercado);
            getListaEmpleados().add(empleado);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo para validar la existencia empleado
     *
     * @param numIdentificacion
     * @return boolean
     */
    public boolean validarExistenciaEmpleado(String numIdentificacion) {
        int tamanioLista = getListaEmpleados().size();
        boolean exist = false;

        for (int i = 0; i < tamanioLista; i++) {
            Empleado empleado = getListaEmpleados().get(i);
            if (empleado.getNumIdentificacion().equalsIgnoreCase(numIdentificacion)) {
                exist = true;
                break;
            }
        }
        return exist;
    }

    /**
     * Metodo para obtener los empleados
     *
     * @return List<Empleado>
     */
    public List<Empleado> obtenerEmpleados() {
        return getListaEmpleados();
    }

    /**
     * Metodo para obtener un empleado por identificacion
     * @param numIdentificacion
     * @return Empleado
     */
    public Empleado obtenerEmpleado(String numIdentificacion) {
        Empleado empleadoEncontrado = null;
        for (Empleado empleado : getListaEmpleados()) {
            if (empleado.getNumIdentificacion().equalsIgnoreCase(numIdentificacion)){
                empleadoEncontrado = empleado;
                break;
            }
        }
        return empleadoEncontrado;
    }

    /**
     * Metodo para editar empleados
     *
     * @param numIdentificacion
     * @param nombres
     * @param apellidos
     * @param rol
     * @param fechaNacimiento
     * @param telefono
     * @param supermercado
     * @return boolean
     */
    public boolean editarEmpleado(String numIdentificacion, String nombres, String apellidos, RolEmpleado rol, String fechaNacimiento, String telefono, Supermercado supermercado) {
        int tamanioLista = getListaEmpleados().size();
        boolean actualizar = false;
        for (int i = 0; i < tamanioLista; i++) {
            Empleado empleado = getListaEmpleados().get(i);
            if (empleado.getNumIdentificacion().equalsIgnoreCase(numIdentificacion)) {
                empleado.setNombres(nombres);
                empleado.setApellidos(apellidos);
                empleado.setRol(rol);
                empleado.setFechaNacimiento(fechaNacimiento);
                empleado.setTelefono(telefono);
                empleado.setOwnedBySupermercado(supermercado);
                actualizar = true;
                break;
            }
        }
        return actualizar;
    }

    /**
     * Metodo para eliminar empleados
     *
     * @param numIdentificacion
     * @return boolean
     */
    public boolean eliminarEmpleado(String numIdentificacion) {
        int tamanioLista = getListaEmpleados().size();
        boolean eliminar = false;
        for (int i = 0; i < tamanioLista; i++) {
            Empleado empleado = getListaEmpleados().get(i);
            if (empleado.getNumIdentificacion().equalsIgnoreCase(numIdentificacion)) {
                getListaEmpleados().remove(i);
                eliminar = true;
                break;
            }
        }
        return eliminar;
    }

    /**
     * Metodo para crear un producto
     *
     * @param supermercado
     * @param idProducto
     * @param nombre
     * @param marca
     * @param fechaVencimiento
     * @param cantidad
     * @param precio
     * @return boolean
     */
    public boolean crearProducto(Supermercado supermercado, String idProducto, String nombre, String marca,
                                String fechaVencimiento, int cantidad, double precio) {
        boolean exist = validarExistenciaProducto(idProducto);
        if (exist==false) {
            Producto producto = new Producto(idProducto, nombre, marca, fechaVencimiento, cantidad, precio);
            producto.setOwnedBySupermercado(supermercado);
            getListaProductos().add(producto);
            return true;
        } else {
            return false;
        }

    }

    /**
     * Metodo para obtener los Productos
     *
     * @return List<Producto>
     */
    public List<Producto> obtenerProductos() {
        return getListaProductos();
    }

    /**
     * Metodo para obtener un empleado por identificacion
     * @param idProducto
     * @return Empleado
     */
    public Producto obtenerProducto(String idProducto) {
        Producto productoEncontrado = null;
        for (Producto producto : getListaProductos()) {
            if (producto.getIdProducto().equalsIgnoreCase(idProducto)){
                productoEncontrado = producto;
                break;
            }
        }
        return productoEncontrado;
    }

    /**
     * Metodo para editar producto
     *
     * @param supermercado
     * @param idProducto
     * @param nombre
     * @param marca
     * @param fechaVencimiento
     * @param cantidad
     * @param precio
     * @return boolean
     */
    public boolean editarProducto(Supermercado supermercado, String idProducto, String nombre, String marca, String fechaVencimiento, int cantidad, double precio) {
        int tamanioLista = getListaProductos().size();
        boolean actualizar = false;
        for (int i = 0; i < tamanioLista; i++) {
            Producto producto = getListaProductos().get(i);
            if (producto.getIdProducto().equalsIgnoreCase(idProducto)) {
                producto.setIdProducto(idProducto);
                producto.setNombre(nombre);
                producto.setFechaVencimiento(fechaVencimiento);
                producto.setCantidad(cantidad);
                producto.setPrecio(precio);
                producto.setOwnedBySupermercado(supermercado);
                actualizar = true;
                break;
            }
        }
        return actualizar;
    }

    /**
     * Metodo para validar la existencia producto
     *
     * @param idProducto
     * @return boolean
     */
    public boolean validarExistenciaProducto(String idProducto) {
        int tamanioLista = getListaProductos().size();
        boolean exist = false;

        for (int i = 0; i < tamanioLista; i++) {
            Producto producto = getListaProductos().get(i);
            if (producto.getIdProducto().equalsIgnoreCase(idProducto)) {
                exist = true;
                break;
            }
        }
        return exist;
    }

    /**
     * Metodo para eliminar Producto
     *
     * @param idProducto
     * @return boolean
     */
    public boolean eliminarProducto(String idProducto) {
        int tamanioLista = getListaProductos().size();
        boolean eliminar = false;
        for (int i = 0; i < tamanioLista; i++) {
            Producto producto = getListaProductos().get(i);
            if (producto.getIdProducto().equalsIgnoreCase(idProducto)) {
                getListaProductos().remove(i);
                eliminar = true;
                break;
            }
        }
        return eliminar;
    }

    /**
     * Metodo para crear un producto
     *
     * @param supermercado
     * @param numIdentificacion
     * @param nombre
     * @param telefono
     * @return boolean
     */
    public boolean crearProveedor(Supermercado supermercado, String numIdentificacion, String nombre, String telefono) {
        boolean exist = validarExistenciaProveedor(numIdentificacion);
        if (exist==false) {
            Proveedor proveedor = new Proveedor(numIdentificacion, nombre, telefono);
            proveedor.setOwnedBySupermercado(supermercado);
            getListaProveedores().add(proveedor);
            return true;
        } else {
            return false;
        }

    }

    /**
     * Metodo para obtener los proveedores
     *
     * @return List<Proveedor>
     */
    public List<Proveedor> obtenerProveedores() {
        return getListaProveedores();
    }

    /**
     * Metodo para editar Proveedor
     *
     * @param supermercado
     * @param numIdentificacion
     * @param nombre
     * @param telefono
     * @return boolean
     */
    public boolean editarProveedor(Supermercado supermercado, String numIdentificacion, String nombre, String telefono) {
        int tamanioLista = getListaProveedores().size();
        boolean actualizar = false;
        for (int i = 0; i < tamanioLista; i++) {
            Proveedor proveedor = getListaProveedores().get(i);
            if (proveedor.getNumIdentificacion().equalsIgnoreCase(numIdentificacion)) {
                proveedor.setNumIdentificacion(numIdentificacion);
                proveedor.setNombre(nombre);
                proveedor.setTelefono(telefono);
                proveedor.setOwnedBySupermercado(supermercado);
                actualizar = true;
                break;
            }
        }
        return actualizar;
    }

    /**
     * Metodo para validar la existencia Proveedor
     *
     * @param numIdentificacion
     * @return boolean
     */
    public boolean validarExistenciaProveedor(String numIdentificacion) {
        int tamanioLista = getListaProveedores().size();
        boolean exist = false;

        for (int i = 0; i < tamanioLista; i++) {
            Proveedor proveedor = getListaProveedores().get(i);
            if (proveedor.getNumIdentificacion().equalsIgnoreCase(numIdentificacion)) {
                exist = true;
                break;
            }
        }
        return exist;
    }

    /**
     * Metodo para eliminar Proveedor
     *
     * @param numIdentificacion
     * @return boolean
     */
    public boolean eliminarProveedor(String numIdentificacion) {
        int tamanioLista = getListaProveedores().size();
        boolean eliminar = false;
        for (int i = 0; i < tamanioLista; i++) {
            Proveedor proveedor = getListaProveedores().get(i);
            if (proveedor.getNumIdentificacion().equalsIgnoreCase(numIdentificacion)) {
                getListaProveedores().remove(i);
                eliminar = true;
                break;
            }
        }
        return eliminar;
    }

    /**
     * Metodo para crear un venta
     *
     * @param idVenta
     * @param fechaVenta
     * @param numIdentificacionCliente
     * @param numIdentificacionEmpleado
     * @param supermercado
     * @return boolean
     */
    public boolean crearVenta(String idVenta, String fechaVenta, String numIdentificacionCliente, String numIdentificacionEmpleado, Supermercado supermercado) {
        boolean exist = validarExistenciaVenta(idVenta);
        if (exist==false) {
            Cliente cliente = obtenerCliente(numIdentificacionCliente);
            Empleado empleado = obtenerEmpleado(numIdentificacionEmpleado);
            if (cliente == null || empleado == null) {
                return false;
            }
            Venta venta = new Venta(idVenta, fechaVenta);
            venta.setClienteAsociado(cliente);
            venta.setEmpleadoAsociado(empleado);
            venta.setOwnedBySupermercado(supermercado);
            getListaVentas().add(venta);
            return true;
        } else {
            return false;
        }
    }

    public String obtenerMayorIdVenta(){
        String mayorId = "000";
        for (Venta venta:listaVentas) {
            if (Integer.parseInt(venta.getIdVenta())>Integer.parseInt(mayorId)){
                mayorId = venta.getIdVenta();
            }
        }
        return  mayorId;
    }

    /**
     * Metodo para obtener la lista de ventas
     *
     * @return List<Venta>
     */
    public List<Venta> obtenerVentas() {
        return getListaVentas();
    }

    /**
     * Metodo para obtener un Venta por IdVenta
     * @param idVenta
     * @return Venta
     */
    public Venta obtenerVenta(String idVenta) {
        Venta ventaEncontrada = null;
        for (Venta venta : getListaVentas()) {
            if (venta.getIdVenta().equalsIgnoreCase(idVenta)){
                ventaEncontrada = venta;
                break;
            }
        }
        return ventaEncontrada;
    }

    /**
     * Metodo para obtener validar si existe Venta
     * @param idVenta
     * @return boolean
     */
    public boolean validarExistenciaVenta(String idVenta) {
        int tamanioLista = getListaVentas().size();
        boolean exist = false;
        for (int i = 0; i < tamanioLista; i++) {
            Venta venta = getListaVentas().get(i);
            if (venta.getIdVenta().equalsIgnoreCase(idVenta)) {
                exist = true;
                break;
            }
        }
        return exist;
    }

    /**
     * Metodo para obtener editar venta
     *
     * @param idVenta
     * @param fechaVenta
     * @param numIdentificacionCliente
     * @param numIdentificacionEmpleado
     * @param supermercado
     * @return boolean
     */
    public boolean editarVenta(String idVenta, String fechaVenta, String numIdentificacionCliente, String numIdentificacionEmpleado, Supermercado supermercado) {
        int tamanioLista = getListaVentas().size();
        boolean actualizar = false;
        for (int i = 0; i < tamanioLista; i++) {
            Venta venta = getListaVentas().get(i);
            if (venta.getIdVenta().equalsIgnoreCase(idVenta)) {
                Cliente cliente = obtenerCliente(numIdentificacionCliente);
                Empleado empleado = obtenerEmpleado(numIdentificacionEmpleado);
                if (cliente == null || empleado == null) {
                    return false;
                }
                venta.setFechaVenta(fechaVenta);
                venta.setClienteAsociado(cliente);
                venta.setEmpleadoAsociado(empleado);
                venta.setOwnedBySupermercado(supermercado);
                actualizar = true;
                break;
            }
        }
        return actualizar;
    }

    /**
     * Metodo para eliminar venta
     *
     * @param idVenta
     * @return boolean
     */
    public boolean eliminarVenta(String idVenta) {
        int tamanioLista = getListaVentas().size();
        boolean eliminar = false;

        for (int i = 0; i < tamanioLista; i++) {
            Venta venta = getListaVentas().get(i);
            if (venta.getIdVenta().equalsIgnoreCase(idVenta)) {
                getListaVentas().remove(i);
                eliminar = true;
                break;
            }
        }
        return eliminar;
    }
    @Override
    public String toString() {
        return "Supermercado{" +
                "nit='" + nit + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }

}
