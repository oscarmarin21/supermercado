package co.edu.uniquindio.supermercado;

import co.edu.uniquindio.supermercado.enumeracion.RolEmpleado;
import co.edu.uniquindio.supermercado.enumeracion.TipoIdentificacion;
import co.edu.uniquindio.supermercado.model.Cliente;
import co.edu.uniquindio.supermercado.model.Empleado;
import co.edu.uniquindio.supermercado.model.Producto;
import co.edu.uniquindio.supermercado.model.Supermercado;

import javax.swing.*;
import java.sql.Struct;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Supermercado supermercado = inicializarDatosPrueba();
        boolean continuar = true;
        int valorSeleccion;

        //CREATE

        //INICIALIZAR CLIENTE ----------------------------------------------------------------
        crearCliente(supermercado, "001", TipoIdentificacion.Cedula, "Teresa", "Ramirez", false);
        crearCliente(supermercado, "002", TipoIdentificacion.Cedula, "Gloria", "Valencia", false);
        crearCliente(supermercado, "003", TipoIdentificacion.Cedula, "Santiago", "Castrillon", false);
        crearCliente(supermercado, "004", TipoIdentificacion.Cedula, "Steven", "Marin", false);

        //INICIALIZAR EMPLEADOS ----------------------------------------------------------------
        crearEmpleado(supermercado, "001", "Ivan", "Cortez", RolEmpleado.Surtidor, "13/05/1997", "3104569887");
        crearEmpleado(supermercado, "002", "Casper", "Galeon", RolEmpleado.Empacador, "31/05/1995", "3205897412");
        crearEmpleado(supermercado, "003", "Isco", "Martinel", RolEmpleado.Gerente, "25/01/1996", "3189636547");
        crearEmpleado(supermercado, "004", "Pocholo", "Garcia", RolEmpleado.Domiciliario, "01/01/1990", "3128529647");

        //INICIALIZAR PRODUCTOS ----------------------------------------------------------------
        crearProducto(supermercado, "001", "Arepas", "El paisa", "17/12/2023", 200, 4.500, false);
        crearProducto(supermercado, "002", "Arroz", "Roa", "05/05/2024", 1200, 1.500, false);
        crearProducto(supermercado, "003", "Natilla", "La abuela", "03/03/2024", 150, 6.200, false);
        crearProducto(supermercado, "004", "Buñuelos", "Promasa", "25/02/2024", 350, 6.500, false);


        //MENU
        do {
            valorSeleccion = leerEnteroVentana("Ingrese el número de la acción que se desea realizar \n " +
                    "1. Gestionar clientes \n " +
                    "2. Gestionar empleados \n " +
                    "3. Gestionar productos \n " +
                    "4. Salir");
            switch (valorSeleccion) {
                case 1:
                    //Gestión clientes
                    valorSeleccion = leerEnteroVentana("Ingrese el número de la acción que se desea realizar \n" +
                            "1. Registrar cliente \n" +
                            "2. Actualizar cliente \n" +
                            "3. Eliminar cliente \n" +
                            "4. Imprimir clientes \n" +
                            "5. Salir");
                    switch (valorSeleccion) {
                        case 1 ->
                            //Create
                                solicitarDatosClienteCrear(supermercado);
                        case 2 ->
                            //Update
                                solicitarDatosClienteEditar(supermercado);
                        case 3 ->
                            //Delete
                                solicitarDatosClienteEliminar(supermercado);
                        case 4 ->
                            //Read
                                mostrarInformacionClientes(supermercado);
                        case 5 -> continuar = false;
                    }
                    break;
                case 2:
                    //Gestión empledos
                    valorSeleccion = leerEnteroVentana("Ingrese el número de la acción que se desea realizar \n" +
                            "1. Registrar empleado \n" +
                            "2. Actualizar empleado \n" +
                            "3. Eliminar empleado \n" +
                            "4. Imprimir empleado \n" +
                            "5. Salir");

                    switch (valorSeleccion) {
                        case 1 ->
                            //Create
                                solicitarDatosEmpleadoCrear(supermercado);
                        case 2 ->
                            //Update
                                solicitarDatosEmpleadoEditar(supermercado);
                        case 3 ->
                            //Delete
                                solicitarDatosEmpleadoEliminar(supermercado);
                        case 4 ->
                            //Read
                                mostrarInformacionEmpleado(supermercado);
                        case 5 -> continuar = false;
                    }
                    break;
                case 3:
                    valorSeleccion = leerEnteroVentana("Ingrese el número de la acción que se desea realizar \n" +
                            "1. Registrar producto \n" +
                            "2. Actualizar producto \n" +
                            "3. Eliminar producto \n" +
                            "4. Imprimir producto \n" +
                            "5. Salir");

                    switch (valorSeleccion) {
                        case 1 ->
                            //Create
                                solicitarDatosProductoCrear(supermercado);
                        case 2 ->
                            //Update
                                solicitarDatosProductoEditar(supermercado);
                        case 3 ->
                            //Delete
                                solicitarDatosProductoEliminar(supermercado);
                        case 4 ->
                            //Read
                                mostrarInformacionProducto(supermercado);
                        case 5 -> continuar = false;
                    }
                    break;
                case 4:
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

//VENTANAS DE SOLICITUD ----------------------------------------------------------------


    //SOLICITAR DATOS PARA ACTUALIZAR
    //Cliente
    private static void solicitarDatosClienteEditar(Supermercado supermercado) {
        String identificacion = leerStringVentana("Ingrese el número de identificación del cliente");
        boolean exist = supermercado.validarExistenciaCliente(identificacion);
        if (exist == true) {
            TipoIdentificacion tipoIdentificacion = null;
            boolean continuar = false;
            do {
                int tipo = leerEnteroVentana("Tipo de identificación\n" +
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
            String nombres = leerStringVentana("Ingrese los nombres del cliente");
            String apellidos = leerStringVentana("Ingrese los apellidos del cliente");

            //Actualizar Cliente
            supermercado.editarCliente(identificacion, tipoIdentificacion, nombres, apellidos, supermercado);
        } else {
            JOptionPane.showMessageDialog(null, "No se encuentra registrado este documento");
        }
        ;
    }

    //Empleado
    private static void solicitarDatosEmpleadoEditar(Supermercado supermercado) {
        String identificacion = leerStringVentana("Ingrese el número de identificación del cliente");
        boolean exist = supermercado.validarExistenciaEmpleado(identificacion);
        if (exist == true) {
            RolEmpleado rolEmpleado = null;
            boolean continuar = false;

            String nombres = leerStringVentana("Ingrese el nombre del empleado");
            String apellidos = leerStringVentana("Ingrese el apellido del empleado");
            String fechaNacimiento = leerStringVentana("Ingrese la fecha de nacimiento del empleado");
            String telefono = leerStringVentana("Ingrese el teléfono del empleado");


            do {
                int tipo = leerEnteroVentana("Rol del empleado\n" +
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
            supermercado.editarEmpleado(identificacion, nombres, apellidos, rolEmpleado, fechaNacimiento, telefono, supermercado);

            JOptionPane.showMessageDialog(null, "Empleado actualizado");


        } else {
            JOptionPane.showMessageDialog(null, "No se encuentra registrado este documento");
        }

    }

    private static void solicitarDatosProductoEditar(Supermercado supermercado) {
        String identificacion = leerStringVentana("Ingrese el número de identificación del producto");
        boolean exist = supermercado.validarExistenciaEmpleado(identificacion);
        if (exist == true) {

            String nombre = leerStringVentana("Ingrese el nombre del producto");
            String marca = leerStringVentana("Ingrese la marca del producto");
            String fechaVencimiento = leerStringVentana("Ingrese la fecha de vencimiento del producto");
            int cantidad = leerEnteroVentana("Ingrese la cantidad del producto");
            double precio = leerDoubleVentana("Ingrese el precio del producto");

            //Actualizar Producto
            supermercado.editarProducto(supermercado, identificacion, nombre, marca, fechaVencimiento, cantidad, precio);

            JOptionPane.showMessageDialog(null, "Producto actualizado");


        } else {
            JOptionPane.showMessageDialog(null, "No se encuentra registrado este identificador");
        }

    }


    //SOLICITAR DATOS PARA CREAR

    //Cliente
    private static void solicitarDatosClienteCrear(Supermercado supermercado) {
        String identificacion = leerStringVentana("Ingrese el número de identificación del cliente");
        TipoIdentificacion tipoIdentificacion = null;
        boolean continuar = false;
        do {
            int tipo = leerEnteroVentana("Tipo de identificación\n" +
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
        String nombres = leerStringVentana("Ingrese los nombres del cliente");
        String apellidos = leerStringVentana("Ingrese los apellidos del cliente");
        crearCliente(supermercado, identificacion, tipoIdentificacion, nombres, apellidos, true);
    }

    //Empleado
    private static void solicitarDatosEmpleadoCrear(Supermercado supermercado) {
        RolEmpleado rolEmpleado = null;
        boolean continuar = false;

        String identificacion = leerStringVentana("Ingrese el número de identificación del empleado");
        String nombres = leerStringVentana("Ingrese el nombre del empleado");
        String apellidos = leerStringVentana("Ingrese el apellido del empleado");

        do {
            int tipo = leerEnteroVentana("Rol del empleado\n" +
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

        String fechaNacimiento = leerStringVentana("Ingrese la fecha de nacimiento del empleado");
        String telefono = leerStringVentana("Ingrese el teléfono del empleado");


        crearEmpleado(supermercado, identificacion, rolEmpleado, nombres, apellidos, fechaNacimiento, telefono, true);
    }

    //Producto
    private static void solicitarDatosProductoCrear(Supermercado supermercado) {

        String idProducto = leerStringVentana("Ingrese el identificación del producto");
        String nombre = leerStringVentana("Ingrese el nombre del producto");
        String marcas = leerStringVentana("Ingrese la marca del producto");
        String fechaVencimiento = leerStringVentana("Ingrese la fecha de vencimiento del producto");
        int cantidad = leerEnteroVentana("Ingrese la cantidad del producto");
        double precio = leerDoubleVentana("Ingrese el precio del producto");

        crearProducto(supermercado, idProducto, nombre, marcas, fechaVencimiento, cantidad, precio, true);
    }

//METODOS CRUD ----------------------------------------------------------------

    //CREATE

    //Cliente
    private static void crearCliente(Supermercado supermercado, String numIdentificacion, TipoIdentificacion tipoIdentificacion, String nombres, String apellidos, boolean mostrarVendtana) {
        boolean respuesta = supermercado.crearCliente(numIdentificacion, tipoIdentificacion, nombres, apellidos, supermercado);

        if ((respuesta == true && mostrarVendtana == true)) {
            JOptionPane.showMessageDialog(null, "Cliente Registrado con exito");
        } else if (respuesta == false || mostrarVendtana == true) {
            JOptionPane.showMessageDialog(null, "El número de identificación ingresado ya existe");
        }
    }

    //Empleado
    private static void crearEmpleado(Supermercado supermercado, String identificacion, RolEmpleado rolEmpleado,
                                      String nombres, String apellidos, String fechaNacimiento, String telefono, boolean mostrarVendtana) {

        boolean respuesta = supermercado.crearEmpleado(identificacion, nombres, apellidos, rolEmpleado, fechaNacimiento, telefono, supermercado);

        if ((respuesta == true && mostrarVendtana == true)) {
            JOptionPane.showMessageDialog(null, "Empleado Registrado con exito");
        } else if (respuesta == false || mostrarVendtana == true) {
            JOptionPane.showMessageDialog(null, "El número de identificación ingresado ya existe");
        }
    }

    private static void crearEmpleado(Supermercado supermercado, String numIdentificacion, String nombres, String apellidos, RolEmpleado rol, String fechaNacimiento, String telefono) {
        supermercado.crearEmpleado(numIdentificacion, nombres, apellidos, rol, fechaNacimiento, telefono, supermercado);
    }


    //Producto
    private static void crearProducto(Supermercado supermercado, String idProducto, String nombre, String marca,
                                      String fechaVencimiento, int cantidad, double precio, boolean mostrarVendtana) {

        boolean respuesta = supermercado.crearProducto(supermercado, idProducto, nombre, marca, fechaVencimiento, cantidad, precio);

        if ((respuesta == true && mostrarVendtana == true)) {
            JOptionPane.showMessageDialog(null, "Producto Registrado con exito");
        } else if (respuesta == false || mostrarVendtana == true) {
            JOptionPane.showMessageDialog(null, "El número de identificación ingresado ya existe");
        }
    }

    //READ
    //Cliente
    private static void mostrarInformacionClientes(Supermercado supermercado) {
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
    private static void mostrarInformacionEmpleado(Supermercado supermercado) {
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
    private static void mostrarInformacionProducto(Supermercado supermercado) {
        List<Producto> listaProducto = supermercado.getListaProductos();
        String mensaje = "";
        int tamanioLista = listaProducto.size();
        for (int i = 0; i < tamanioLista; i++) {
            Producto producto = listaProducto.get(i);
            mensaje += producto + "\n";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }


    //DELETE
    //Empleado
    private static void solicitarDatosEmpleadoEliminar(Supermercado supermercado) {
        String identificacion = leerStringVentana("Ingrese el número de identificación del empleado");

        boolean exist = supermercado.validarExistenciaEmpleado(identificacion);
        if (exist == true) {
            //Eliminar empleado
            supermercado.eliminarEmpleado(identificacion);
            JOptionPane.showMessageDialog(null, "Empleado eliminado");
        } else {
            JOptionPane.showMessageDialog(null, "No se encuentra registrado este identificador");
        }

    }

    //Cliente
    private static void solicitarDatosClienteEliminar(Supermercado supermercado) {
        String identificacion = leerStringVentana("Ingrese el número de identificación del cliente");

        boolean exist = supermercado.validarExistenciaCliente(identificacion);
        if (exist == true) {
            //Eliminar cliente
            supermercado.eliminarCliente(identificacion);
            JOptionPane.showMessageDialog(null, "Cliente eliminado");
        } else {
            JOptionPane.showMessageDialog(null, "No se encuentra registrado este identificador");
        }
    }


    //Eliminar producto
    private static void solicitarDatosProductoEliminar(Supermercado supermercado) {
        String idProducto = leerStringVentana("Ingrese el número de identificación del producto");

        boolean exist = supermercado.validarExistenciaProducto(idProducto);
        if (exist == true) {

            supermercado.eliminarProducto(idProducto);

            JOptionPane.showMessageDialog(null, "Producto eliminado");
        } else {
            JOptionPane.showMessageDialog(null, "No se encuentra registrado este identificador");
        }
    }


    //LECTOR DE VENTANA ----------------------------------------------------------------
    public static int leerEnteroVentana(String mensaje) {
        boolean bucle = true;
        int dato = 0;
        do {
            try {
                dato = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
                bucle = false;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid: Ingresa solo numeros");
            }
        } while (bucle);
        return dato;
    }

    public static double leerDoubleVentana(String mensaje) {
        boolean bucle = true;
        double dato = 0.0;
        do {
            try {
                dato = Double.parseDouble(JOptionPane.showInputDialog(mensaje));
                bucle = false;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid: Ingresa solo numeros");
            }
        } while (bucle);
        return dato;
    }

    public static String leerStringVentana(String mensaje) {
        String respuesta = "";
        respuesta = JOptionPane.showInputDialog(mensaje);
        return respuesta;
    }
}