package co.edu.uniquindio.supermercado;

import co.edu.uniquindio.supermercado.enumeracion.RolEmpleado;
import co.edu.uniquindio.supermercado.enumeracion.TipoIdentificacion;
import co.edu.uniquindio.supermercado.model.*;
import co.edu.uniquindio.supermercado.util.ServicesUtil;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Supermercado supermercado = inicializarDatosPrueba();

        //CREATE

        //INICIALIZAR CLIENTE ----------------------------------------------------------------
        crearCliente(supermercado, "001", TipoIdentificacion.Cedula, "Teresac", "Ramirez");
        crearCliente(supermercado, "002", TipoIdentificacion.Pasaporte, "Gloria", "Valencia");
        crearCliente(supermercado, "003", TipoIdentificacion.Cedula, "SantiagoC", "Castrillon");
        crearCliente(supermercado, "004", TipoIdentificacion.Cedula, "Steven", "Marin");

        //INICIALIZAR EMPLEADOS ----------------------------------------------------------------
        crearEmpleado(supermercado, "001", "Ivan", "Cortez", RolEmpleado.Surtidor, "13/05/1997", "3104569887");
        crearEmpleado(supermercado, "002", "Casper", "Galeon", RolEmpleado.Empacador, "31/05/1995", "3205897412");
        crearEmpleado(supermercado, "003", "Isco", "Martinel", RolEmpleado.Gerente, "25/01/1996", "3189636547");
        crearEmpleado(supermercado, "004", "Pocholo", "Garcia", RolEmpleado.Domiciliario, "01/01/1990", "3128529647");

        //INICIALIZAR PRODUCTOS ----------------------------------------------------------------
        crearProducto(supermercado, "001", "Arepas", "El paisa", "17/12/2023", 200, 4500, 3500);
        crearProducto(supermercado, "002", "Arroz", "Roa", "05/05/2024", 1200, 1500, 800);
        crearProducto(supermercado, "003", "Natilla", "La abuela", "03/03/2024", 150, 6200, 5000);
        crearProducto(supermercado, "004", "Buñuelos", "Promasa", "25/02/2024", 350, 6500, 5200);

        //INICIALIZAR PROVEEDOR ----------------------------------------------------------------
        crearProveedor(supermercado, "001", "Rammo", "3159456374");
        crearProveedor(supermercado, "002", "Zenu", "3104587825");
        crearProveedor(supermercado, "003", "Fritolay", "3249876542");
        crearProveedor(supermercado, "004", "Cocacola", "3112699947");

        //INICIALIZAR VENTAS ----------------------------------------------------------------
        crearVenta(supermercado, "22/11/2023", "002", "002", "003", 4);
        crearVenta(supermercado, "23/11/2023", "004", "002", "002", 2);

        //INICIALIZAR COMPRAS ----------------------------------------------------------------
        crearCompra(supermercado, "17/11/2023", "002", "004", "004", 10);
        crearCompra(supermercado, "15/11/2023", "004", "001", "002", 20);

        gestionarOpcionesAplicacion(supermercado);
    }

    private static void gestionarOpcionesAplicacion(Supermercado supermercado) {
        boolean continuar = true;
        int valorSeleccion;
        //MENU
        do {
            valorSeleccion = ServicesUtil.leerEnteroVentana("Ingrese el número de la acción que se desea realizar \n " +
                    "1. Gestionar clientes \n " +
                    "2. Gestionar empleados \n " +
                    "3. Gestionar productos \n " +
                    "4. Gestionar proveedor \n " +
                    "5. Gestionar ventas \n " +
                    "6. Gestionar compra de insumos \n " +
                    "7. Requerimientos\n " +
                    "8. Salir");
            switch (valorSeleccion) {
                case 1:
                    //Gestión clientes
                    valorSeleccion = ServicesUtil.leerEnteroVentana("Ingrese el número de la acción que se desea realizar \n" +
                            "1. Registrar cliente \n" +
                            "2. Actualizar cliente \n" +
                            "3. Eliminar cliente \n" +
                            "4. Imprimir clientes \n" +
                            "5. Consultar clientes \n" +
                            "6. Salir");
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
                        case 5 ->
                            //Read
                                obtenerCliente(supermercado);
                        case 6 -> continuar = false;
                    }
                    break;
                case 2:
                    //Gestión empledos
                    valorSeleccion = ServicesUtil.leerEnteroVentana("Ingrese el número de la acción que se desea realizar \n" +
                            "1. Registrar empleado \n" +
                            "2. Actualizar empleado \n" +
                            "3. Eliminar empleado \n" +
                            "4. Imprimir empleados \n" +
                            "5. Consultar empleado \n" +
                            "6. Salir");

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
                        case 5 ->
                            //Read
                                obtenerEmpleado(supermercado);
                        case 6 -> continuar = false;
                    }
                    break;
                case 3:
                    //Gestión Productos
                    valorSeleccion = ServicesUtil.leerEnteroVentana("Ingrese el número de la acción que se desea realizar \n" +
                            "1. Registrar producto \n" +
                            "2. Actualizar producto \n" +
                            "3. Eliminar producto \n" +
                            "4. Imprimir producto \n" +
                            "5. Consultar producto \n" +
                            "6. Salir");

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
                        case 5 ->
                            //Read
                                obtenerProducto(supermercado);
                        case 6 -> continuar = false;
                    }
                    break;
                case 4:
//                    Gestión Proveedor
                    valorSeleccion = ServicesUtil.leerEnteroVentana("Ingrese el número de la acción que se desea realizar \n" +
                            "1. Registrar proveedor \n" +
                            "2. Actualizar proveedor \n" +
                            "3. Eliminar proveedor \n" +
                            "4. Imprimir proveedor \n" +
                            "5. Consultar proveedor \n" +
                            "6. Salir");

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
                        case 5 ->
                            //Read
                                obtenerProveedor(supermercado);
                        case 6 -> continuar = false;
                    }
                    break;
                case 5:
//                    Gestión ventas
                    valorSeleccion = ServicesUtil.leerEnteroVentana("Ingrese el número de la acción que se desea realizar \n" +
                            "1. Registrar ventas \n" +
                            "2. Actualizar ventas \n" +
                            "3. Eliminar ventas \n" +
                            "4. Imprimir ventas \n" +
                            "5. Consultar venta \n" +
                            "6. Salir");

                    switch (valorSeleccion) {
                        case 1 ->
                            //Create
                                crearVenta(supermercado);
                        case 2 ->
                            //Update
                                editarVenta(supermercado);
                        case 3 ->
                            //Delete
                                eliminarVenta(supermercado);
                        case 4 ->
                            //Read
                                mostrarVentas(supermercado);
                        case 5 ->
                            //Read
                                obtenerVenta(supermercado);
                        case 6 -> continuar = false;
                    }
                    break;
                case 6:
                    //Gestionar compra de insumos
                    valorSeleccion = ServicesUtil.leerEnteroVentana("Ingrese el número de la acción que se desea realizar \n" +
                            "1. Registrar compra \n" +
                            "2. Actualizar compra \n" +
                            "3. Eliminar compra \n" +
                            "4. Imprimir compras \n" +
                            "5. Consultar compra \n" +
                            "6. Salir");

                    switch (valorSeleccion) {
                        case 1 ->
                            //Create
                                crearCompra(supermercado);
                        case 2 ->
                            //Update
                                editarCompra(supermercado);
                        case 3 ->
                            //Delete
                                eliminarCompra(supermercado);
                        case 4 ->
                            //Read
                                mostrarCompras(supermercado);
                        case 5 ->
                            //Read
                                obtenerCompra(supermercado);
                        case 6 -> continuar = false;
                    }
                    break;

                case 7:
                    //Gestionar requerimientos
                    valorSeleccion = ServicesUtil.leerEnteroVentana("Ingrese el número de la acción que se desea realizar \n" +
                            "1. Obtener el producto mas costoso \n" +
                            "2. Obtener el producto con mayor stock \n" +
                            "3. Obtener el valor de todo el inventario \n" +
                            "4. Obtener los clientes que tiene una 'C' en su nombre \n" +
                            "5. Obtener los clientes los cuales su apellido terminen en 'N' \n" +
                            "6. Obtener los clientes con codigo par\n" +
                            "7. Obtener los empleados con rol 'Empacador'\n" +
                            "8. Obtener la cantidad de empleados\n" +
                            "9. Obtener la suma del telefono de los empleados\n" +
                            "10. Obtener correo autogenerado de cada proveedor\n" +
                            "11. Contar proveedores del Supermercado\n" +
                            "12. Total valor de compras de proveedor" +
                            "13. Obtener ventas por Fecha\n" +
                            "14. Ordenar ascendentemente totales las Ventas\n" +
                            "15. Obtener Compra de Insumos por Fecha\n" +
                            "16. Ordenar desendentemente totales las Compra de Insumos\n" +
                            "17. Obtener totales de compras por proveedor\n" +
                            "18. Salir");


                    switch (valorSeleccion) {
                        case 1 -> obtenerProductoMasCostoso(supermercado);
                        case 2 -> obtenerProductoMayorStok(supermercado);
                        case 3 -> obtenerValorTotalInventario(supermercado);
                        case 4 -> obtenerClienteConC(supermercado);
                        case 5 -> obtenerClienteIFinalApellidoN(supermercado);
                        case 6 -> obtenerClienteCodigoPar(supermercado);
                        case 7 -> obtenerEmpleadoEmpacador(supermercado);
                        case 8 -> obtenerCantidadEmpleados(supermercado);
                        case 9 -> obtenerSumatelefono(supermercado);
                        case 10 -> obtenerCorreoAutogeneado(supermercado);
                        case 11 -> contarProveedores(supermercado);
                        case 12 -> obtenerTotalComprasProveedor(supermercado);
                        case 13 -> obtenerVentasByFecha(supermercado);
                        case 14 -> orderAscVentas(supermercado);
                        case 15 -> obtenerComprasByFecha(supermercado);
                        case 16 -> orderDesCompras(supermercado);
                        case 17 -> obtenerTotalComprasProveedor(supermercado);
                        case 18 -> continuar = false;
                    }
                    break;
                case 8:
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
        String identificacion = ServicesUtil.leerStringVentana("Ingrese el número de identificación del cliente");
        TipoIdentificacion tipoIdentificacion = null;
        boolean continuar = false;
        do {
            int tipo = ServicesUtil.leerEnteroVentana("Tipo de identificación\n" +
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
        String nombres = ServicesUtil.leerStringVentana("Ingrese los nombres del cliente");
        String apellidos = ServicesUtil.leerStringVentana("Ingrese los apellidos del cliente");
        boolean respuesta = supermercado.crearCliente(identificacion, tipoIdentificacion, nombres, apellidos, supermercado);
        ServicesUtil.mostrarMensajeRespuesta(respuesta, "Se ha creado correctamente el cliente", "No ha sido posible crear el cliente");
    }

    private static void editarCliente(Supermercado supermercado) {
        String identificacion = ServicesUtil.leerStringVentana("Ingrese el número de identificación del cliente");
        boolean exist = supermercado.validarExistenciaCliente(identificacion);
        if (exist) {
            TipoIdentificacion tipoIdentificacion = null;
            boolean continuar = false;
            do {
                int tipo = ServicesUtil.leerEnteroVentana("Tipo de identificación\n" +
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
            String nombres = ServicesUtil.leerStringVentana("Ingrese los nombres del cliente");
            String apellidos = ServicesUtil.leerStringVentana("Ingrese los apellidos del cliente");

            //Actualizar Cliente
            boolean respuesta = supermercado.editarCliente(identificacion, tipoIdentificacion, nombres, apellidos, supermercado);
            ServicesUtil.mostrarMensajeRespuesta(respuesta, "Producto actualizado", "No se ha podido actualizar el producto");
        } else {
            ServicesUtil.mostrarMensajeRespuesta(exist, "", "No se encuentra registrado este identificador");
        }
    }

    private static void eliminarCliente(Supermercado supermercado) {
        String identificacion = ServicesUtil.leerStringVentana("Ingrese el número de identificación del cliente");
        boolean exist = supermercado.validarExistenciaCliente(identificacion);
        if (exist) {
            if (!supermercado.validarRelacionClienteVenta(identificacion)){
                if (JOptionPane.showConfirmDialog(null, "¿Esta seguro?\n"+supermercado.obtenerCliente(identificacion))==0){
                    //Eliminar cliente
                    boolean respuesta = supermercado.eliminarCliente(identificacion);
                    ServicesUtil.mostrarMensajeRespuesta(respuesta, "Cliente eliminado", "No se ha podido eliminar el cliente");
                }
            }else {
                JOptionPane.showMessageDialog(null, "Este cliente no se puede Eliminar ya que se encuentra conectado a una venta");
            }
        } else {
            ServicesUtil.mostrarMensajeRespuesta(exist, "", "No se encuentra registrado este identificador");
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

    private static void obtenerCliente(Supermercado supermercado) {
        String identificacion = ServicesUtil.leerStringVentana("Ingrese el número de identificación del cliente");
        boolean exist = supermercado.validarExistenciaCliente(identificacion);
        if (exist) {
            //Obtener cliente
            Cliente cliente = supermercado.obtenerCliente(identificacion);
            JOptionPane.showMessageDialog(null, cliente);
        } else {
            ServicesUtil.mostrarMensajeRespuesta(exist, "", "No se encuentra registrado este identificador");
        }
    }

    //Empleado
    private static void crearEmpleado(Supermercado supermercado) {
        RolEmpleado rolEmpleado = null;
        boolean continuar = false;

        String identificacion = ServicesUtil.leerStringVentana("Ingrese el número de identificación del empleado");
        String nombres = ServicesUtil.leerStringVentana("Ingrese el nombre del empleado");
        String apellidos = ServicesUtil.leerStringVentana("Ingrese el apellido del empleado");
        do {
            int tipo = ServicesUtil.leerEnteroVentana("Rol del empleado\n" +
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
        String fechaNacimiento = ServicesUtil.leerStringVentana("Ingrese la fecha de nacimiento del empleado");
        String telefono = ServicesUtil.leerStringVentana("Ingrese el teléfono del empleado");

        boolean respuesta = supermercado.crearEmpleado(identificacion, nombres, apellidos, rolEmpleado, fechaNacimiento, telefono, supermercado);
        ServicesUtil.mostrarMensajeRespuesta(respuesta, "Se ha creado correctamente el empleado", "No ha sido posible crear el empleado");
    }

    private static void editarEmpleado(Supermercado supermercado) {
        String identificacion = ServicesUtil.leerStringVentana("Ingrese el número de identificación del cliente");
        boolean exist = supermercado.validarExistenciaEmpleado(identificacion);
        if (exist) {
            RolEmpleado rolEmpleado = null;
            boolean continuar = false;

            String nombres = ServicesUtil.leerStringVentana("Ingrese el nombre del empleado");
            String apellidos = ServicesUtil.leerStringVentana("Ingrese el apellido del empleado");
            String fechaNacimiento = ServicesUtil.leerStringVentana("Ingrese la fecha de nacimiento del empleado");
            String telefono = ServicesUtil.leerStringVentana("Ingrese el teléfono del empleado");
            do {
                int tipo = ServicesUtil.leerEnteroVentana("Rol del empleado\n" +
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
            ServicesUtil.mostrarMensajeRespuesta(respuesta, "Empleado actualizado", "No se ha podido actualizar el empleado");
        } else {
            ServicesUtil.mostrarMensajeRespuesta(exist, "", "No se encuentra registrado este identificador");
        }

    }

    private static void eliminarEmpleado(Supermercado supermercado) {
        String identificacion = ServicesUtil.leerStringVentana("Ingrese el número de identificación del empleado");
        boolean exist = supermercado.validarExistenciaEmpleado(identificacion);
        if (exist) {
            if (!supermercado.validarRelacionEmpleadoVentaCompra(identificacion)){
                if (JOptionPane.showConfirmDialog(null, "¿Esta seguro?\n"+supermercado.obtenerEmpleado(identificacion))==0){
                    //Eliminar empleado
                    boolean respuesta = supermercado.eliminarEmpleado(identificacion);
                    ServicesUtil.mostrarMensajeRespuesta(respuesta, "Empleado eliminado", "No se ha podido eliminar el empleado");
                }
            }else {
                JOptionPane.showMessageDialog(null, "Este empleado no se puede Eliminar ya que se encuentra conectado a una venta o una compra");
            }
        } else {
            ServicesUtil.mostrarMensajeRespuesta(exist, "", "No se encuentra registrado este identificador");
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

    private static void obtenerEmpleado(Supermercado supermercado) {
        String identificacion = ServicesUtil.leerStringVentana("Ingrese el número de identificación del empleado");
        boolean exist = supermercado.validarExistenciaEmpleado(identificacion);
        if (exist) {
            //Obtener empleado
            Empleado empleado = supermercado.obtenerEmpleado(identificacion);
            JOptionPane.showMessageDialog(null, empleado);
        } else {
            ServicesUtil.mostrarMensajeRespuesta(exist, "", "No se encuentra registrado este identificador");
        }
    }

    //Producto
    private static void crearProducto(Supermercado supermercado) {

        String idProducto = ServicesUtil.nextId(supermercado.obtenerMayorIdProducto());
        String nombre = ServicesUtil.leerStringVentana("Ingrese el nombre del producto");
        String marca = ServicesUtil.leerStringVentana("Ingrese la marca del producto");
        String fechaVencimiento = ServicesUtil.leerStringVentana("Ingrese la fecha de vencimiento del producto");
        int cantidad = ServicesUtil.leerEnteroVentana("Ingrese la cantidad del producto");
        double precio = ServicesUtil.leerDoubleVentana("Ingrese el precio del producto");
        double precioDeCompra = ServicesUtil.leerDoubleVentana("Ingrese el precio de compra del producto");


        boolean respuesta = supermercado.crearProducto(supermercado, idProducto, nombre, marca, fechaVencimiento, cantidad, precio, precioDeCompra);
        ServicesUtil.mostrarMensajeRespuesta(respuesta, "Se ha creado correctamente el producto", "No ha sido posible crear el producto");
    }

    private static void editarProducto(Supermercado supermercado) {
        String idProducto = ServicesUtil.leerStringVentana("Ingrese el número de identificación del producto");
        boolean exist = supermercado.validarExistenciaProducto(idProducto);
        if (exist) {
            String nombre = ServicesUtil.leerStringVentana("Ingrese el nombre del producto");
            String marca = ServicesUtil.leerStringVentana("Ingrese la marca del producto");
            String fechaVencimiento = ServicesUtil.leerStringVentana("Ingrese la fecha de vencimiento del producto");
            int cantidad = ServicesUtil.leerEnteroVentana("Ingrese la cantidad del producto");
            double precio = ServicesUtil.leerDoubleVentana("Ingrese el precio del producto");
            double precioDeCompra = ServicesUtil.leerDoubleVentana("Ingrese el precio de compra del producto");

            //Actualizar Producto
            boolean respuesta = supermercado.editarProducto(supermercado, idProducto, nombre, marca, fechaVencimiento, cantidad, precio, precioDeCompra);
            ServicesUtil.mostrarMensajeRespuesta(respuesta, "Producto actualizado", "No se ha podido actualizar el producto");
        } else {
            ServicesUtil.mostrarMensajeRespuesta(exist, "", "No se encuentra registrado este identificador");
        }

    }

    private static void eliminarProducto(Supermercado supermercado) {
        String idProducto = ServicesUtil.leerStringVentana("Ingrese el número de identificación del producto");
        boolean exist = supermercado.validarExistenciaProducto(idProducto);
        if (exist) {
            if (!supermercado.validarRelacionProductoVentaCompra(idProducto)){
                if (JOptionPane.showConfirmDialog(null, "¿Esta seguro?\n"+supermercado.obtenerProducto(idProducto))==0){
                    //Eliminar producto
                    boolean respuesta = supermercado.eliminarProducto(idProducto);
                    ServicesUtil.mostrarMensajeRespuesta(respuesta, "Producto eliminado", "No se ha podido eliminar el producto");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Este producto no se puede Eliminar ya que se encuentra conectado a una venta o una compra");
            }
        } else {
            ServicesUtil.mostrarMensajeRespuesta(exist, "", "No se encuentra registrado este identificador");
        }
    }

    private static void mostrarProductos(Supermercado supermercado) {
        List<Producto> listaProducto = supermercado.obtenerProductos();
        String mensaje = "";
        int tamanioLista = listaProducto.size();
        for (int i = 0; i < tamanioLista; i++) {
            Producto producto = listaProducto.get(i);
            mensaje += producto + "\n";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static void obtenerProducto(Supermercado supermercado) {
        String identificacion = ServicesUtil.leerStringVentana("Ingrese el número de Id del Producto");
        boolean exist = supermercado.validarExistenciaProducto(identificacion);
        if (exist) {
            //Obtener producto
            Producto producto = supermercado.obtenerProducto(identificacion);
            JOptionPane.showMessageDialog(null, producto);
        } else {
            ServicesUtil.mostrarMensajeRespuesta(exist, "", "No se encuentra registrado este identificador");
        }
    }

    //Proveedor
    private static void crearProveedor(Supermercado supermercado) {
        String identificacion = ServicesUtil.leerStringVentana("Ingrese el número de identificación del proveedor");
        String nombre = ServicesUtil.leerStringVentana("Ingrese el nombre del proveedor");
        String telefono = ServicesUtil.leerStringVentana("Ingrese el teléfono del proveedor");

        boolean respuesta = supermercado.crearProveedor(supermercado, identificacion, nombre, telefono);
        ServicesUtil.mostrarMensajeRespuesta(respuesta, "Se ha creado correctamente el producto", "No ha sido posible crear el producto");
    }

    private static void editarProveedor(Supermercado supermercado) {
        String identificacion = ServicesUtil.leerStringVentana("Ingrese el número de identificación del proveedor");
        boolean exist = supermercado.validarExistenciaProveedor(identificacion);
        if (exist) {
            String nombre = ServicesUtil.leerStringVentana("Ingrese el nombre del proveedor");
            String telefono = ServicesUtil.leerStringVentana("Ingrese el teléfono del proveedor");
            //Actualizar Producto
            boolean respuesta = supermercado.editarProveedor(supermercado, identificacion, nombre, telefono);
            ServicesUtil.mostrarMensajeRespuesta(respuesta, "Producto actualizado", "No se ha podido actualizar el producto");
        } else {
            ServicesUtil.mostrarMensajeRespuesta(exist, "", "No se encuentra registrado este identificador");
        }

    }

    private static void eliminarProveedor(Supermercado supermercado) {
        String identificacion = ServicesUtil.leerStringVentana("Ingrese el número de identificación del proveedor");
        boolean exist = supermercado.validarExistenciaProveedor(identificacion);
        if (exist) {
            if (!supermercado.validarRelacionProveedorCompra(identificacion)){
                if (JOptionPane.showConfirmDialog(null, "¿Esta seguro?\n"+supermercado.obtenerProveedor(identificacion))==0){
                    //Eliminar proveedor
                    boolean respuesta = supermercado.eliminarProveedor(identificacion);
                    ServicesUtil.mostrarMensajeRespuesta(respuesta, "Producto eliminado", "No se ha podido eliminar el producto");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Este proveedor no se puede Eliminar ya que se encuentra conectado a una compra");
            }
        } else {
            ServicesUtil.mostrarMensajeRespuesta(exist, "", "No se encuentra registrado este identificador");
        }
    }

    private static void mostrarProveedor(Supermercado supermercado) {
        List<Proveedor> listaProveedores = supermercado.obtenerProveedores();
        String mensaje = "";
        int tamanioLista = listaProveedores.size();
        for (int i = 0; i < tamanioLista; i++) {
            Proveedor proveedor = listaProveedores.get(i);
            mensaje += proveedor + "\n";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static void obtenerProveedor(Supermercado supermercado) {
        String identificacion = ServicesUtil.leerStringVentana("Ingrese el número de Id del Producto");
        boolean exist = supermercado.validarExistenciaProveedor(identificacion);
        if (exist) {
            //Obtener proveedor
            Proveedor proveedor = supermercado.obtenerProveedor(identificacion);
            JOptionPane.showMessageDialog(null, proveedor);
        } else {
            ServicesUtil.mostrarMensajeRespuesta(exist, "", "No se encuentra registrado este identificador");
        }
    }

    //Venta
    private static void crearVenta(Supermercado supermercado) {
        String idVenta = ServicesUtil.nextId(supermercado.obtenerMayorIdVenta());
        String fecha = ServicesUtil.leerStringVentana("Ingrese la fecha de la venta DD/MM/AA");
        String identificacionCliente = "";
        do {
            identificacionCliente = ServicesUtil.leerStringVentana("Ingrese el número de identificación del cliente");
            if (!supermercado.validarExistenciaCliente(identificacionCliente)) {
                JOptionPane.showMessageDialog(null, "No existe un cliente registrado con esta identificacion");
            }
        } while (!supermercado.validarExistenciaCliente(identificacionCliente));
        String identificacionEmpleado = "";
        do {
            identificacionEmpleado = ServicesUtil.leerStringVentana("Ingrese el número de identificación del empleado");
            if (!supermercado.validarExistenciaEmpleado(identificacionEmpleado)) {
                JOptionPane.showMessageDialog(null, "No existe un empleado registrado con esta identificacion");
            }
        } while (!supermercado.validarExistenciaEmpleado(identificacionEmpleado));

        boolean respuesta = supermercado.crearVenta(idVenta, fecha, identificacionCliente, identificacionEmpleado, supermercado);
        if (respuesta) {
            Venta venta = supermercado.obtenerVenta(idVenta);
            boolean respuestaDetalle = generarDetalle(venta, supermercado);
            double totalVenta = venta.calcularTotal(idVenta);
            venta.setTotalVenta(totalVenta);
            ServicesUtil.mostrarMensajeRespuesta(respuestaDetalle, "Se ha creado correctamente la venta", "No ha sido posible crear la venta");
            JOptionPane.showMessageDialog(null, venta);
        }
    }

    private static boolean generarDetalle(Venta venta, Supermercado supermercado) {
        boolean continuar = true;
        boolean generado = false;
        do {
            generado = false;
            String idDetalle = ServicesUtil.nextId(venta.obtenerMayorIdDetalle());
            String idProducto = "";
            boolean exist = false;
            while (exist == false) {
                idProducto = ServicesUtil.leerStringVentana("Ingrese el id del producto");
                exist = supermercado.validarExistenciaProducto(idProducto);
                if (exist == false) {
                    JOptionPane.showMessageDialog(null, "No existe producto registrado con este ID");
                }
            }
            int cantidad = ServicesUtil.leerEnteroVentana("Ingrese la cantidad del producto");
            boolean detalle = venta.crearDetalleVenta(idDetalle, cantidad, venta.getIdVenta(), idProducto, supermercado);
            if (detalle) {
                generado = true;
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrio un error. No se pudo registrar");
            }
            int opcion = ServicesUtil.leerEnteroVentana("1. Continuar registrando\n2. Salir");
            switch (opcion) {
                case 1:
                    continuar = true;
                    break;
                case 2:
                    continuar = false;
                    break;
                default:
                    continuar = false;
                    break;
            }
        } while (continuar);
        return generado;
    }

    private static void editarVenta(Supermercado supermercado) {
        String idVenta = ServicesUtil.leerStringVentana("Ingrese el ID de la venta");
        boolean exist = supermercado.validarExistenciaVenta(idVenta);
        if (exist) {
            String fecha = ServicesUtil.leerStringVentana("Ingrese la fecha de la venta DD/MM/AA");
            String identificacionCliente = ServicesUtil.leerStringVentana("Ingrese el número de identificación del cliente");
            String identificacionEmpleado = ServicesUtil.leerStringVentana("Ingrese el número de identificación del empleado");
            //Actualizar Producto
            boolean respuesta = supermercado.editarVenta(idVenta, fecha, identificacionCliente, identificacionEmpleado, supermercado);
            Venta venta = supermercado.obtenerVenta(idVenta);
            boolean respuestaDetalle = false;
            if (respuesta) {
                venta.eliminarDetalleVenta(idVenta);
                respuestaDetalle = generarDetalle(venta, supermercado);
                double totalVenta = venta.calcularTotal(idVenta);
                venta.setTotalVenta(totalVenta);
            }
            ServicesUtil.mostrarMensajeRespuesta(respuestaDetalle, "Venta actualizada", "No se ha podido actualizar la venta");
            JOptionPane.showMessageDialog(null, venta);
        } else {
            ServicesUtil.mostrarMensajeRespuesta(exist, "", "No se encuentra registrado este identificador");
        }
    }

    private static void eliminarVenta(Supermercado supermercado) {
        String idVenta = ServicesUtil.leerStringVentana("Ingrese el ID de la venta");
        boolean exist = supermercado.validarExistenciaVenta(idVenta);
        if (exist) {
            Venta venta = supermercado.obtenerVenta(idVenta);
            venta.eliminarDetalleVenta(idVenta);
            boolean respuesta = supermercado.eliminarVenta(idVenta);
            ServicesUtil.mostrarMensajeRespuesta(respuesta, "Venta eliminado", "No se ha podido eliminar la venta");
        } else {
            ServicesUtil.mostrarMensajeRespuesta(exist, "", "No se encuentra registrado este identificador");
        }
    }

    private static void mostrarVentas(Supermercado supermercado) {
        List<Venta> listaVentas = supermercado.obtenerVentas();
        String mensaje = "";
        int tamanioLista = listaVentas.size();
        for (int i = 0; i < tamanioLista; i++) {
            Venta venta = listaVentas.get(i);
            mensaje += venta + "\n";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static void obtenerVenta(Supermercado supermercado){
        String idVenta = ServicesUtil.leerStringVentana("Ingrese el ID de la venta");
        boolean exist = supermercado.validarExistenciaVenta(idVenta);
        if (exist) {
            Venta venta = supermercado.obtenerVenta(idVenta);
            JOptionPane.showMessageDialog(null, venta);
        } else {
            ServicesUtil.mostrarMensajeRespuesta(exist, "", "No se encuentra registrado este identificador");
        }
    }

    //Compra

    private static void crearCompra(Supermercado supermercado) {
        String idCompra = ServicesUtil.nextId(supermercado.obtenerMayorIdCompra());
        String fecha = ServicesUtil.leerStringVentana("Ingrese la fecha de la compra DD/MM/AA");
        String identificacionProveedor = "";
        do {
            identificacionProveedor = ServicesUtil.leerStringVentana("Ingrese el número de identificación del proveedor");
            if (!supermercado.validarExistenciaProveedor(identificacionProveedor)) {
                JOptionPane.showMessageDialog(null, "No existe un proveedor registrado con esta identificacion");
            }
        } while (!supermercado.validarExistenciaProveedor(identificacionProveedor));
        String identificacionEmpleado = "";
        do {
            identificacionEmpleado = ServicesUtil.leerStringVentana("Ingrese el número de identificación del empleado");
            if (!supermercado.validarExistenciaEmpleado(identificacionEmpleado)) {
                JOptionPane.showMessageDialog(null, "No existe un empleado registrado con esta identificacion");
            }
        } while (!supermercado.validarExistenciaEmpleado(identificacionEmpleado));

        boolean respuesta = supermercado.crearCompraInsumos(idCompra, fecha, identificacionProveedor, identificacionEmpleado, supermercado);
        if (respuesta) {
            CompraInsumos compra = supermercado.obtenerCompraInsumos(idCompra);
            boolean respuestaDetalle = generarDetalle(compra, supermercado);
            double totalCompra = compra.calcularTotal(idCompra);
            compra.setTotalCompra(totalCompra);
            ServicesUtil.mostrarMensajeRespuesta(respuestaDetalle, "Se ha creado correctamente la compra", "No ha sido posible crear la compra");
            JOptionPane.showMessageDialog(null, compra);
        }
    }

    //Sobrecarga de metodos
    private static boolean generarDetalle(CompraInsumos compra, Supermercado supermercado) {
        boolean continuar = true;
        boolean generado = false;
        do {
            generado = false;
            String idDetalle = ServicesUtil.nextId(compra.obtenerMayorIdDetalle());
            String idProducto = "";
            boolean exist = false;
            while (exist == false) {
                idProducto = ServicesUtil.leerStringVentana("Ingrese el id del producto");
                exist = supermercado.validarExistenciaProducto(idProducto);
                if (exist == false) {
                    JOptionPane.showMessageDialog(null, "No existe producto registrado con este ID");
                }
            }
            int cantidad = ServicesUtil.leerEnteroVentana("Ingrese la cantidad del producto");
            boolean detalle = compra.crearDetalleCompraInsumos(idDetalle, cantidad, compra.getIdCompra(), idProducto, supermercado);
            if (detalle) {
                generado = true;
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrio un error. No se pudo registrar");
            }
            int opcion = ServicesUtil.leerEnteroVentana("1. Continuar registrando\n2. Salir");
            switch (opcion) {
                case 1:
                    continuar = true;
                    break;
                case 2:
                    continuar = false;
                    break;
                default:
                    continuar = false;
                    break;
            }
        } while (continuar);
        return generado;
    }

    private static void editarCompra(Supermercado supermercado) {
        String idCompra = ServicesUtil.leerStringVentana("Ingrese el ID de la compra");
        boolean exist = supermercado.validarExistenciaCompra(idCompra);
        if (exist) {
            String fecha = ServicesUtil.leerStringVentana("Ingrese la fecha de la compra DD/MM/AA");
            String identificacionProveedor = ServicesUtil.leerStringVentana("Ingrese el número de identificación del proveedor");
            String identificacionEmpleado = ServicesUtil.leerStringVentana("Ingrese el número de identificación del empleado");
            //Actualizar Compra
            boolean respuesta = supermercado.editarCompraInsumos(idCompra, fecha, identificacionProveedor, identificacionEmpleado, supermercado);
            CompraInsumos compra = supermercado.obtenerCompraInsumos(idCompra);
            boolean respuestaDetalle = false;
            if (respuesta) {
                compra.eliminarDetalleCompraInsumos(idCompra);
                respuestaDetalle = generarDetalle(compra, supermercado);
                double totalCompra = compra.calcularTotal(idCompra);
                compra.setTotalCompra(totalCompra);
            }
            ServicesUtil.mostrarMensajeRespuesta(respuestaDetalle, "compra actualizada", "No se ha podido actualizar la compra");
            JOptionPane.showMessageDialog(null, compra);
        } else {
            ServicesUtil.mostrarMensajeRespuesta(exist, "", "No se encuentra registrado este identificador");
        }
    }

    private static void eliminarCompra(Supermercado supermercado) {
        String idCompra = ServicesUtil.leerStringVentana("Ingrese el ID de la compra");
        boolean exist = supermercado.validarExistenciaCompra(idCompra);
        if (exist) {
            CompraInsumos compra = supermercado.obtenerCompraInsumos(idCompra);
            compra.eliminarDetalleCompraInsumos(idCompra);
            boolean respuesta = supermercado.eliminarCompraInsumos(idCompra);
            ServicesUtil.mostrarMensajeRespuesta(respuesta, "compra eliminado", "No se ha podido eliminar la compra");
        } else {
            ServicesUtil.mostrarMensajeRespuesta(exist, "", "No se encuentra registrado este identificador");
        }
    }

    private static void mostrarCompras(Supermercado supermercado) {
        List<CompraInsumos> listaCompras = supermercado.getListaCompraInsumos();
        String mensaje = "";
        int tamanioLista = listaCompras.size();
        for (int i = 0; i < tamanioLista; i++) {
            CompraInsumos compra = listaCompras.get(i);
            mensaje += compra + "\n";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static void obtenerCompra(Supermercado supermercado){
        String idCompra = ServicesUtil.leerStringVentana("Ingrese el ID de la compra");
        boolean exist = supermercado.validarExistenciaCompra(idCompra);
        if (exist) {
            CompraInsumos compra = supermercado.obtenerCompraInsumos(idCompra);
            JOptionPane.showMessageDialog(null, compra);
        } else {
            ServicesUtil.mostrarMensajeRespuesta(exist, "", "No se encuentra registrado este identificador");
        }
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
    private static void crearProducto(Supermercado supermercado, String idProducto, String nombre, String marca, String fechaVencimiento, int cantidad, double precio, double precioDeCompra) {
        boolean respuesta = supermercado.crearProducto(supermercado, idProducto, nombre, marca, fechaVencimiento, cantidad, precio, precioDeCompra);
    }

    //Proveedor
    private static void crearProveedor(Supermercado supermercado, String numIdentificacion, String nombre, String telefono) {
        boolean respuesta = supermercado.crearProveedor(supermercado, numIdentificacion, nombre, telefono);
    }

    private  static void crearVenta(Supermercado supermercado, String fechaVenta, String numIdentificacionCliente, String numIdentificacionEmpleado, String idProducto, int cantidad){
        String idVenta = ServicesUtil.nextId(supermercado.obtenerMayorIdVenta());
        supermercado.crearVenta(idVenta, fechaVenta, numIdentificacionCliente, numIdentificacionEmpleado, supermercado);
        Venta venta = supermercado.obtenerVenta(idVenta);
        generarDetalle(venta, supermercado, idProducto, cantidad);
        double totalVenta = venta.calcularTotal(idVenta);
        venta.setTotalVenta(totalVenta);
    }

    private static void generarDetalle(Venta venta, Supermercado supermercado, String idProducto, int cantidad) {
            String idDetalle = ServicesUtil.nextId(venta.obtenerMayorIdDetalle());
            boolean detalle = venta.crearDetalleVenta(idDetalle, cantidad, venta.getIdVenta(), idProducto, supermercado);
    }

    private  static void crearCompra(Supermercado supermercado, String fechaVenta, String numIdentificacionProveedor, String numIdentificacionEmpleado, String idProducto, int cantidad){
        String idCompra = ServicesUtil.nextId(supermercado.obtenerMayorIdCompra());
        supermercado.crearCompraInsumos(idCompra, fechaVenta, numIdentificacionProveedor, numIdentificacionEmpleado, supermercado);
        CompraInsumos compra = supermercado.obtenerCompraInsumos(idCompra);
        generarDetalle(compra, supermercado, idProducto, cantidad);
        double totalCompra = compra.calcularTotal(idCompra);
        compra.setTotalCompra(totalCompra);
    }

    private static void generarDetalle(CompraInsumos compra, Supermercado supermercado, String idProducto, int cantidad) {
        String idDetalle = ServicesUtil.nextId(compra.obtenerMayorIdDetalle());
        boolean detalle = compra.crearDetalleCompraInsumos(idDetalle, cantidad, compra.getIdCompra(), idProducto, supermercado);
    }

    // METODOS DE REQUERIMIENTOS

    //Productos
    private static void obtenerProductoMasCostoso(Supermercado supermercado) {
        Producto producto = supermercado.obtenerProductoMasCostoso();
        JOptionPane.showMessageDialog(null, producto.toString());

    }

    private static void obtenerProductoMayorStok(Supermercado supermercado) {
        Producto producto = supermercado.obtenerProductoMayorStok();
        JOptionPane.showMessageDialog(null, producto.toString());

    }

    private static void obtenerValorTotalInventario(Supermercado supermercado) {
        double total = supermercado.obtenerValorTotalInventario();
        JOptionPane.showMessageDialog(null, "$ " + total);

    }

    private static void obtenerClienteConC(Supermercado supermercado){
        List<Cliente> clientes = new ArrayList<>();
        clientes = supermercado.obtenerClienteConC();

        String mensaje = "";
        int tamanioLista = clientes.size();
        for (int i = 0; i < tamanioLista; i++) {
            Cliente cliente = clientes.get(i);
            mensaje += cliente + "\n";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static void obtenerClienteIFinalApellidoN(Supermercado supermercado){
        List<Cliente> clientes = new ArrayList<>();
        clientes = supermercado.obtenerClienteIFinalApellidoN();

        String mensaje = "";
        int tamanioLista = clientes.size();
        for (int i = 0; i < tamanioLista; i++) {
            Cliente cliente = clientes.get(i);
            mensaje += cliente + "\n";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static void obtenerClienteCodigoPar(Supermercado supermercado){
        List<Cliente> clientes = new ArrayList<>();
        clientes = supermercado.obtenerClienteCodigoPar();

        String mensaje = "";
        int tamanioLista = clientes.size();
        for (int i = 0; i < tamanioLista; i++) {
            Cliente cliente = clientes.get(i);
            mensaje += cliente + "\n";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static void obtenerEmpleadoEmpacador(Supermercado supermercado){
        List<Empleado> empleados = new ArrayList<>();
        empleados = supermercado.obtenerEmpleadoEmpacador();

        String mensaje = "";
        int tamanioLista = empleados.size();
        for (int i = 0; i < tamanioLista; i++) {
            Empleado empleado = empleados.get(i);
            mensaje += empleado + "\n";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static void obtenerCantidadEmpleados(Supermercado supermercado){

        int total = supermercado.obtenerCantidadEmpleados();

        JOptionPane.showMessageDialog(null, total + "empleados");
    }

    private static void obtenerSumatelefono(Supermercado supermercado){

        List<String> suma = new ArrayList<>();
        suma = supermercado.obtenerSumatelefono();

        String mensaje = "";
        int tamanioLista = suma.size();
        for (int i = 0; i < tamanioLista; i++) {
            String lugar = suma.get(i);
            mensaje += lugar + "\n";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static void obtenerCorreoAutogeneado(Supermercado supermercado){

        List<String> correo = new ArrayList<>();
        correo = supermercado.obtenerCorreoAutogeneado();

        String mensaje = "";
        int tamanioLista = correo.size();
        for (int i = 0; i < tamanioLista; i++) {
            String lugar = correo.get(i);
            mensaje += lugar + "\n";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static void contarProveedores(Supermercado supermercado) {
        int proveedores = 0;
        for (Proveedor proveedor : supermercado.getListaProveedores()) {
            proveedores += 1;
        }
        String mensaje = "La cantidad de proveedores con los que cuenta el suermercado es de "+proveedores;
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static void obtenerVentasByFecha(Supermercado supermercado) {
        String fecha = ServicesUtil.leerStringVentana("Ingresa la fecha a filtar");
        List<Venta> listaVentas = supermercado.obtenerVentas();
        String mensaje = "";
        int tamanioLista = listaVentas.size();
        for (int i = 0; i < tamanioLista; i++) {
            Venta venta = listaVentas.get(i);
            if (venta.getFechaVenta().equalsIgnoreCase(fecha)){
                mensaje += venta + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static void orderAscVentas(Supermercado supermercado) {
        List<Venta> listaVentas = supermercado.obtenerVentas();
        listaVentas.sort(Comparator.comparing(Venta::getTotalVenta).reversed());
        String mensaje = "";
        int tamanioLista = listaVentas.size();
        for (int i = 0; i < tamanioLista; i++) {
            Venta venta = listaVentas.get(i);
            mensaje += venta + "\n";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static void orderDesCompras(Supermercado supermercado) {
        List<CompraInsumos> listaCompras = supermercado.obtenerComprasInsumos();
        listaCompras.sort(Comparator.comparing(CompraInsumos::getTotalCompra).reversed());
        String mensaje = "";
        int tamanioLista = listaCompras.size();
        for (int i = 0; i < tamanioLista; i++) {
            CompraInsumos compra = listaCompras.get(i);
            mensaje += compra + "\n";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static void obtenerComprasByFecha(Supermercado supermercado) {
        String fecha = ServicesUtil.leerStringVentana("Ingresa la fecha a filtar");
        List<CompraInsumos> listaCompras = supermercado.obtenerComprasInsumos();
        String mensaje = "";
        int tamanioLista = listaCompras.size();
        for (int i = 0; i < tamanioLista; i++) {
            CompraInsumos compra = listaCompras.get(i);
            if (compra.getFechaCompra().equalsIgnoreCase(fecha)){
                mensaje += compra + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static void obtenerTotalComprasProveedor(Supermercado supermercado) {
        String identificacion = ServicesUtil.leerStringVentana("Ingresa la identificacion del proveedor");
        if (supermercado.validarExistenciaProveedor(identificacion)) {
            double total = supermercado.totalProveedorCompra(identificacion);
            JOptionPane.showMessageDialog(null, "El total de compras de con el proveedor "+supermercado.obtenerProveedor(identificacion).getNombre()+" es de "+total);
        } else {
            JOptionPane.showMessageDialog(null, "No se encuentra registrado este identificador");
        }
    }

}