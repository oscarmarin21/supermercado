package co.edu.uniquindio.supermercado;

import co.edu.uniquindio.supermercado.enumeracion.RolEmpleado;
import co.edu.uniquindio.supermercado.enumeracion.TipoIdentificacion;
import co.edu.uniquindio.supermercado.model.*;
import co.edu.uniquindio.supermercado.util.CapturaDatosUtil;

import javax.swing.*;
import java.sql.Struct;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Supermercado supermercado = inicializarDatosPrueba();

        //CREATE

        //INICIALIZAR CLIENTE ----------------------------------------------------------------
        crearCliente(supermercado, "001", TipoIdentificacion.Cedula, "Teresa", "Ramirez");
        crearCliente(supermercado, "002", TipoIdentificacion.Cedula, "Gloria", "Valencia");
        crearCliente(supermercado, "003", TipoIdentificacion.Cedula, "Santiago", "Castrillon");
        crearCliente(supermercado, "004", TipoIdentificacion.Cedula, "Steven", "Marin");

        //INICIALIZAR EMPLEADOS ----------------------------------------------------------------
        crearEmpleado(supermercado, "001", "Ivan", "Cortez", RolEmpleado.Surtidor, "13/05/1997", "3104569887");
        crearEmpleado(supermercado, "002", "Casper", "Galeon", RolEmpleado.Empacador, "31/05/1995", "3205897412");
        crearEmpleado(supermercado, "003", "Isco", "Martinel", RolEmpleado.Gerente, "25/01/1996", "3189636547");
        crearEmpleado(supermercado, "004", "Pocholo", "Garcia", RolEmpleado.Domiciliario, "01/01/1990", "3128529647");

        //INICIALIZAR PRODUCTOS ----------------------------------------------------------------
        crearProducto(supermercado, "001", "Arepas", "El paisa", "17/12/2023", 200, 4.500);
        crearProducto(supermercado, "002", "Arroz", "Roa", "05/05/2024", 1200, 1.500);
        crearProducto(supermercado, "003", "Natilla", "La abuela", "03/03/2024", 150, 6.200);
        crearProducto(supermercado, "004", "Buñuelos", "Promasa", "25/02/2024", 350, 6.500);

        //INICIALIZAR PRODUCTOS ----------------------------------------------------------------
        crearProveedor(supermercado, "001", "Rammo", "3159456374");

        gestionarOpcionesAplicacion(supermercado);
    }

    private static void gestionarOpcionesAplicacion(Supermercado supermercado){
        boolean continuar = true;
        int valorSeleccion;
        //MENU
        do {
            valorSeleccion = CapturaDatosUtil.leerEnteroVentana("Ingrese el número de la acción que se desea realizar \n " +
                    "1. Gestionar clientes \n " +
                    "2. Gestionar empleados \n " +
                    "3. Gestionar productos \n " +
                    "4. Gestionar proveedor \n " +
                    "5. Salir");
            switch (valorSeleccion) {
                case 1:
                    //Gestión clientes
                    valorSeleccion = CapturaDatosUtil.leerEnteroVentana("Ingrese el número de la acción que se desea realizar \n" +
                            "1. Registrar cliente \n" +
                            "2. Actualizar cliente \n" +
                            "3. Eliminar cliente \n" +
                            "4. Imprimir clientes \n" +
                            "5. Salir");
                    switch (valorSeleccion) {
                        case 1 ->
                            //Create
                                crearCliente(supermercado);
                        case 2 ->
                            //Update
                                editarCliente(supermercado);
                        case 3 ->
                            //Delete
                                eliminarCliente(supermercado);
                        case 4 ->
                            //Read
                                mostrarClientes(supermercado);
                        case 5 -> continuar = false;
                    }
                    break;
                case 2:
                    //Gestión empledos
                    valorSeleccion = CapturaDatosUtil.leerEnteroVentana("Ingrese el número de la acción que se desea realizar \n" +
                            "1. Registrar empleado \n" +
                            "2. Actualizar empleado \n" +
                            "3. Eliminar empleado \n" +
                            "4. Imprimir empleado \n" +
                            "5. Salir");

                    switch (valorSeleccion) {
                        case 1 ->
                            //Create
                                crearEmpleado(supermercado);
                        case 2 ->
                            //Update
                                editarEmpleado(supermercado);
                        case 3 ->
                            //Delete
                                eliminarEmpleado(supermercado);
                        case 4 ->
                            //Read
                                mostrarEmpleados(supermercado);
                        case 5 -> continuar = false;
                    }
                    break;
                case 3:
                    valorSeleccion = CapturaDatosUtil.leerEnteroVentana("Ingrese el número de la acción que se desea realizar \n" +
                            "1. Registrar producto \n" +
                            "2. Actualizar producto \n" +
                            "3. Eliminar producto \n" +
                            "4. Imprimir producto \n" +
                            "5. Salir");

                    switch (valorSeleccion) {
                        case 1 ->
                            //Create
                                crearProducto(supermercado);
                        case 2 ->
                            //Update
                                editarProducto(supermercado);
                        case 3 ->
                            //Delete
                                eliminarProducto(supermercado);
                        case 4 ->
                            //Read
                                mostrarProductos(supermercado);
                        case 5 -> continuar = false;
                    }
                    break;
                case 4:
                    valorSeleccion = CapturaDatosUtil.leerEnteroVentana("Ingrese el número de la acción que se desea realizar \n" +
                            "1. Registrar proveedor \n" +
                            "2. Actualizar proveedor \n" +
                            "3. Eliminar proveedor \n" +
                            "4. Imprimir proveedor \n" +
                            "5. Salir");

                    switch (valorSeleccion) {
                        case 1 ->
                            //Create
                                crearProveedor(supermercado);
                        case 2 ->
                            //Update
                                editarProveedor(supermercado);
                        case 3 ->
                            //Delete
                                eliminarProveedor(supermercado);
                        case 4 ->
                            //Read
                                mostrarProveedor(supermercado);
                        case 5 -> continuar = false;
                    }
                    break;
                case 5:
                    continuar = false;
                    break;
            }
        } while (continuar);
    }

//INICIALIZADOR ----------------------------------------------------------------
    private static Supermercado inicializarDatosPrueba() {
        Supermercado supermercado = new Supermercado();
        supermercado.setNit("951753852");
        supermercado.setNombre("SuperCundi");
        return supermercado;
    }

//VENTANAS - CRUD ----------------------------------------------------------------
    //Cliente
    private static void crearCliente(Supermercado supermercado) {
        String identificacion = CapturaDatosUtil.leerStringVentana("Ingrese el número de identificación del cliente");
        TipoIdentificacion tipoIdentificacion = null;
        boolean continuar = false;
        do {
            int tipo = CapturaDatosUtil.leerEnteroVentana("Tipo de identificación\n" +
                    "1. Cedula\n" +
                    "2. Pasaporte");
            switch (tipo) {
                case 1:
                    tipoIdentificacion = TipoIdentificacion.Cedula;
                    continuar = true;
                    break;
                case 2:
                    tipoIdentificacion = TipoIdentificacion.Pasaporte;
                    continuar = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion Invalida");
            }
        } while (continuar == false);
        String nombres = CapturaDatosUtil.leerStringVentana("Ingrese los nombres del cliente");
        String apellidos = CapturaDatosUtil.leerStringVentana("Ingrese los apellidos del cliente");
        boolean respuesta = supermercado.crearCliente(identificacion, tipoIdentificacion, nombres, apellidos, supermercado);
        CapturaDatosUtil.mostrarMensajeRespuesta(respuesta, "Se ha creado correctamente el cliente", "No ha sido posible crear el cliente");
    }

    private static void editarCliente(Supermercado supermercado) {
        String identificacion = CapturaDatosUtil.leerStringVentana("Ingrese el número de identificación del cliente");
        boolean exist = supermercado.validarExistenciaCliente(identificacion);
        if (exist) {
            TipoIdentificacion tipoIdentificacion = null;
            boolean continuar = false;
            do {
                int tipo = CapturaDatosUtil.leerEnteroVentana("Tipo de identificación\n" +
                        "1. Cedula\n" +
                        "2. Pasaporte");
                switch (tipo) {
                    case 1:
                        tipoIdentificacion = TipoIdentificacion.Cedula;
                        continuar = true;
                        break;
                    case 2:
                        tipoIdentificacion = TipoIdentificacion.Pasaporte;
                        continuar = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion Invalida");
                }
            } while (continuar == false);
            String nombres = CapturaDatosUtil.leerStringVentana("Ingrese los nombres del cliente");
            String apellidos = CapturaDatosUtil.leerStringVentana("Ingrese los apellidos del cliente");

            //Actualizar Cliente
            boolean respuesta = supermercado.editarCliente(identificacion, tipoIdentificacion, nombres, apellidos, supermercado);
            CapturaDatosUtil.mostrarMensajeRespuesta(respuesta, "Producto actualizado", "No se ha podido actualizar el producto");
        } else {
            CapturaDatosUtil.mostrarMensajeRespuesta(exist, "", "No se encuentra registrado este identificador");
        }
    }

    private static void eliminarCliente(Supermercado supermercado) {
        String identificacion = CapturaDatosUtil.leerStringVentana("Ingrese el número de identificación del cliente");
        boolean exist = supermercado.validarExistenciaCliente(identificacion);
        if (exist) {
            //Eliminar cliente
            boolean respuesta = supermercado.eliminarCliente(identificacion);
            CapturaDatosUtil.mostrarMensajeRespuesta(respuesta, "Producto actualizado", "No se ha podido actualizar el producto");
        } else {
            CapturaDatosUtil.mostrarMensajeRespuesta(exist, "", "No se encuentra registrado este identificador");
        }
    }

    private static void mostrarClientes(Supermercado supermercado) {
        List<Cliente> listaClientes = supermercado.obtenerClientes();
        String mensaje = "";
        int tamanioLista = listaClientes.size();
        for (int i = 0; i < tamanioLista; i++) {
            Cliente cliente = listaClientes.get(i);
            mensaje += cliente + "\n";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    //Empleado
    private static void crearEmpleado(Supermercado supermercado) {
        RolEmpleado rolEmpleado = null;
        boolean continuar = false;

        String identificacion = CapturaDatosUtil.leerStringVentana("Ingrese el número de identificación del empleado");
        String nombres = CapturaDatosUtil.leerStringVentana("Ingrese el nombre del empleado");
        String apellidos = CapturaDatosUtil.leerStringVentana("Ingrese el apellido del empleado");
        do {
            int tipo = CapturaDatosUtil.leerEnteroVentana("Rol del empleado\n" +
                    "1. Gerente\n" +
                    "2. Caja\n" +
                    "3. Operario\n" +
                    "4. Surtidor\n" +
                    "5. Empacador\n" +
                    "6. Domiciliario");
            switch (tipo) {
                case 1:
                    rolEmpleado = RolEmpleado.Gerente;
                    continuar = true;
                    break;
                case 2:
                    rolEmpleado = RolEmpleado.Caja;
                    continuar = true;
                    break;
                case 3:
                    rolEmpleado = RolEmpleado.Operario;
                    continuar = true;
                    break;
                case 4:
                    rolEmpleado = RolEmpleado.Surtidor;
                    continuar = true;
                    break;
                case 5:
                    rolEmpleado = RolEmpleado.Empacador;
                    continuar = true;
                    break;
                case 6:
                    rolEmpleado = RolEmpleado.Domiciliario;
                    continuar = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion Invalida");
            }
        } while (continuar == false);
        String fechaNacimiento = CapturaDatosUtil.leerStringVentana("Ingrese la fecha de nacimiento del empleado");
        String telefono = CapturaDatosUtil.leerStringVentana("Ingrese el teléfono del empleado");

        boolean respuesta = supermercado.crearEmpleado(identificacion, nombres, apellidos, rolEmpleado, fechaNacimiento, telefono, supermercado);
        CapturaDatosUtil.mostrarMensajeRespuesta(respuesta, "Se ha creado correctamente el empleado", "No ha sido posible crear el empleado");
    }

    private static void editarEmpleado(Supermercado supermercado) {
        String identificacion = CapturaDatosUtil.leerStringVentana("Ingrese el número de identificación del cliente");
        boolean exist = supermercado.validarExistenciaEmpleado(identificacion);
        if (exist) {
            RolEmpleado rolEmpleado = null;
            boolean continuar = false;

            String nombres = CapturaDatosUtil.leerStringVentana("Ingrese el nombre del empleado");
            String apellidos = CapturaDatosUtil.leerStringVentana("Ingrese el apellido del empleado");
            String fechaNacimiento = CapturaDatosUtil.leerStringVentana("Ingrese la fecha de nacimiento del empleado");
            String telefono = CapturaDatosUtil.leerStringVentana("Ingrese el teléfono del empleado");
            do {
                int tipo = CapturaDatosUtil.leerEnteroVentana("Rol del empleado\n" +
                        "1. Gerente\n" +
                        "2. Caja\n" +
                        "3. Operario\n" +
                        "4. Surtidor\n" +
                        "5. Empacador\n" +
                        "6. Domiciliario");
                switch (tipo) {
                    case 1:
                        rolEmpleado = RolEmpleado.Gerente;
                        continuar = true;
                        break;
                    case 2:
                        rolEmpleado = RolEmpleado.Caja;
                        continuar = true;
                        break;
                    case 3:
                        rolEmpleado = RolEmpleado.Operario;
                        continuar = true;
                        break;
                    case 4:
                        rolEmpleado = RolEmpleado.Surtidor;
                        continuar = true;
                        break;
                    case 5:
                        rolEmpleado = RolEmpleado.Empacador;
                        continuar = true;
                        break;
                    case 6:
                        rolEmpleado = RolEmpleado.Domiciliario;
                        continuar = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion Invalida");
                }
            } while (continuar == false);
            //Actualizar Empleado
            boolean respuesta = supermercado.editarEmpleado(identificacion, nombres, apellidos, rolEmpleado, fechaNacimiento, telefono, supermercado);
            CapturaDatosUtil.mostrarMensajeRespuesta(respuesta, "Empleado actualizado", "No se ha podido actualizar el empleado");
        } else {
            CapturaDatosUtil.mostrarMensajeRespuesta(exist, "", "No se encuentra registrado este identificador");
        }

    }

    private static void eliminarEmpleado(Supermercado supermercado) {
        String identificacion = CapturaDatosUtil.leerStringVentana("Ingrese el número de identificación del empleado");

        boolean exist = supermercado.validarExistenciaEmpleado(identificacion);
        if (exist) {
            //Eliminar empleado
            boolean respuesta = supermercado.eliminarEmpleado(identificacion);
            CapturaDatosUtil.mostrarMensajeRespuesta(respuesta, "Producto actualizado", "No se ha podido actualizar el producto");
        } else {
            CapturaDatosUtil.mostrarMensajeRespuesta(exist, "", "No se encuentra registrado este identificador");
        }

    }

    private static void mostrarEmpleados(Supermercado supermercado) {
        List<Empleado> listaEmpleado = supermercado.obtenerEmpleados();
        String mensaje = "";
        int tamanioLista = listaEmpleado.size();
        for (int i = 0; i < tamanioLista; i++) {
            Empleado empleado = listaEmpleado.get(i);
            mensaje += empleado + "\n";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    //Producto
    private static void crearProducto(Supermercado supermercado) {

        String idProducto = CapturaDatosUtil.leerStringVentana("Ingrese el identificación del producto");
        String nombre = CapturaDatosUtil.leerStringVentana("Ingrese el nombre del producto");
        String marca = CapturaDatosUtil.leerStringVentana("Ingrese la marca del producto");
        String fechaVencimiento = CapturaDatosUtil.leerStringVentana("Ingrese la fecha de vencimiento del producto");
        int cantidad = CapturaDatosUtil.leerEnteroVentana("Ingrese la cantidad del producto");
        double precio = CapturaDatosUtil.leerDoubleVentana("Ingrese el precio del producto");

        boolean respuesta = supermercado.crearProducto(supermercado, idProducto, nombre, marca, fechaVencimiento, cantidad, precio);
        CapturaDatosUtil.mostrarMensajeRespuesta(respuesta, "Se ha creado correctamente el producto", "No ha sido posible crear el producto");
    }

    private static void editarProducto(Supermercado supermercado) {
        String idProducto = CapturaDatosUtil.leerStringVentana("Ingrese el número de identificación del producto");
        boolean exist = supermercado.validarExistenciaProducto(idProducto);
        if (exist) {
            String nombre = CapturaDatosUtil.leerStringVentana("Ingrese el nombre del producto");
            String marca = CapturaDatosUtil.leerStringVentana("Ingrese la marca del producto");
            String fechaVencimiento = CapturaDatosUtil.leerStringVentana("Ingrese la fecha de vencimiento del producto");
            int cantidad = CapturaDatosUtil.leerEnteroVentana("Ingrese la cantidad del producto");
            double precio = CapturaDatosUtil.leerDoubleVentana("Ingrese el precio del producto");
            //Actualizar Producto
            boolean respuesta = supermercado.editarProducto(supermercado, idProducto, nombre, marca, fechaVencimiento, cantidad, precio);
            CapturaDatosUtil.mostrarMensajeRespuesta(respuesta, "Producto actualizado", "No se ha podido actualizar el producto");
        } else {
            CapturaDatosUtil.mostrarMensajeRespuesta(exist, "", "No se encuentra registrado este identificador");
        }

    }

    private static void eliminarProducto(Supermercado supermercado) {
        String idProducto = CapturaDatosUtil.leerStringVentana("Ingrese el número de identificación del producto");
        boolean exist = supermercado.validarExistenciaProducto(idProducto);
        if (exist) {

            boolean respuesta = supermercado.eliminarProducto(idProducto);
            CapturaDatosUtil.mostrarMensajeRespuesta(respuesta, "Producto eliminado", "No se ha podido eliminar el producto");
        } else {
            CapturaDatosUtil.mostrarMensajeRespuesta(exist, "", "No se encuentra registrado este identificador");
        }
    }

    private static void mostrarProductos(Supermercado supermercado) {
        List<Producto> listaProducto = supermercado.getListaProductos();
        String mensaje = "";
        int tamanioLista = listaProducto.size();
        for (int i = 0; i < tamanioLista; i++) {
            Producto producto = listaProducto.get(i);
            mensaje += producto + "\n";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    //Proveedor
    private static void crearProveedor(Supermercado supermercado) {
        String identificacion = CapturaDatosUtil.leerStringVentana("Ingrese el número de identificación del proveedor");
        String nombre = CapturaDatosUtil.leerStringVentana("Ingrese el nombre del proveedor");
        String telefono = CapturaDatosUtil.leerStringVentana("Ingrese el teléfono del proveedor");

        boolean respuesta = supermercado.crearProveedor(supermercado, identificacion, nombre, telefono);
        CapturaDatosUtil.mostrarMensajeRespuesta(respuesta, "Se ha creado correctamente el producto", "No ha sido posible crear el producto");
    }

    private static void editarProveedor(Supermercado supermercado) {
        String identificacion = CapturaDatosUtil.leerStringVentana("Ingrese el número de identificación del proveedor");
        boolean exist = supermercado.validarExistenciaProveedor(identificacion);
        if (exist) {
            String nombre = CapturaDatosUtil.leerStringVentana("Ingrese el nombre del proveedor");
            String telefono = CapturaDatosUtil.leerStringVentana("Ingrese el teléfono del proveedor");
            //Actualizar Producto
            boolean respuesta = supermercado.editarProveedor(supermercado, identificacion, nombre, telefono);
            CapturaDatosUtil.mostrarMensajeRespuesta(respuesta, "Producto actualizado", "No se ha podido actualizar el producto");
        } else {
            CapturaDatosUtil.mostrarMensajeRespuesta(exist, "", "No se encuentra registrado este identificador");
        }

    }

    private static void eliminarProveedor(Supermercado supermercado) {
        String identificacion = CapturaDatosUtil.leerStringVentana("Ingrese el número de identificación del proveedor");
        boolean exist = supermercado.validarExistenciaProveedor(identificacion);
        if (exist) {

            boolean respuesta = supermercado.eliminarProveedor(identificacion);
            CapturaDatosUtil.mostrarMensajeRespuesta(respuesta, "Producto eliminado", "No se ha podido eliminar el producto");
        } else {
            CapturaDatosUtil.mostrarMensajeRespuesta(exist, "", "No se encuentra registrado este identificador");
        }
    }

    private static void mostrarProveedor(Supermercado supermercado) {
        List<Proveedor> listaProveedores = supermercado.getListaProveedores();
        String mensaje = "";
        int tamanioLista = listaProveedores.size();
        for (int i = 0; i < tamanioLista; i++) {
            Proveedor proveedor = listaProveedores.get(i);
            mensaje += proveedor + "\n";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

//METODOS CREATE SIN VENTANA ----------------------------------------------------------------

    //CREATE

    //Cliente
    private static void crearCliente(Supermercado supermercado, String numIdentificacion, TipoIdentificacion tipoIdentificacion, String nombres, String apellidos) {
        boolean respuesta = supermercado.crearCliente(numIdentificacion, tipoIdentificacion, nombres, apellidos, supermercado);
    }

    //Empleado
    private static void crearEmpleado(Supermercado supermercado, String numIdentificacion, String nombres, String apellidos, RolEmpleado rol, String fechaNacimiento, String telefono) {
        boolean respuesta = supermercado.crearEmpleado(numIdentificacion, nombres, apellidos, rol, fechaNacimiento, telefono, supermercado);
    }

    //Producto
    private static void crearProducto(Supermercado supermercado, String idProducto, String nombre, String marca, String fechaVencimiento, int cantidad, double precio) {
        boolean respuesta = supermercado.crearProducto(supermercado, idProducto, nombre, marca, fechaVencimiento, cantidad, precio);
    }

    //Proveedor
    private static void crearProveedor(Supermercado supermercado, String numIdentificacion, String nombre, String telefono){
        boolean respuesta = supermercado.crearProveedor(supermercado, numIdentificacion, nombre, telefono);
    }

}