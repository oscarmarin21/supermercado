package co.edu.uniquindio.supermercado;

import co.edu.uniquindio.supermercado.enumeracion.RolEmpleado;
import co.edu.uniquindio.supermercado.enumeracion.TipoIdentificacion;
import co.edu.uniquindio.supermercado.model.Cliente;
import co.edu.uniquindio.supermercado.model.Empleado;
import co.edu.uniquindio.supermercado.model.Supermercado;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Supermercado supermercado = inicializarDatosPrueba();
        boolean continuar = true;
        int valorSeleccion;

    //INICIALIZAR CLIENTE ----------------------------------------------------------------

        //Create
        crearCliente(supermercado, "001", TipoIdentificacion.Cedula, "Teresa", "Ramirez", false);
        crearCliente(supermercado, "002", TipoIdentificacion.Cedula, "Gloria", "Valencia", false);
        crearCliente(supermercado, "003", TipoIdentificacion.Cedula, "Santiago", "Castrillon", false);
        crearCliente(supermercado, "004", TipoIdentificacion.Cedula, "Steven", "Marin", false);

    //INICIALIZAR EMPLEADOS ----------------------------------------------------------------

        //Create
        crearEmpleado(supermercado, "102030", "Ivan", "Cortez", RolEmpleado.Surtidor, "13/05/1997", "3104569887");
        crearEmpleado(supermercado, "908070", "Casper", "Galeon", RolEmpleado.Empacador, "31/05/1995", "3205897412");
        crearEmpleado(supermercado, "506040", "Isco", "Martinel", RolEmpleado.Gerente, "25/01/1996", "3189636547");
        crearEmpleado(supermercado, "123456", "Pocholo", "Garcia", RolEmpleado.Domiciliario, "01/01/1990", "3128529647");

    //MENU
        do {
            valorSeleccion = leerEnteroVentana("Ingrese el número de la acción que se desea realizar \n " +
                    "1. Gestionar clientes \n " +
                    "2. Salir");
            switch (valorSeleccion) {
                case 1:
                    valorSeleccion = leerEnteroVentana("Ingrese el número de la acción que se desea realizar \n" +
                            "1. Registrar cliente \n" +
                            "2. Actualizar cliente \n" +
                            "3. Eliminar cliente \n" +
                            "4. Imprimir clientes \n" +
                            "5. Salir");
                    switch (valorSeleccion) {
                        case 1:
                            //Create
                            solicitarDatosClienteCrear(supermercado);
                            break;
                        case 2:
                            //Update
                            solicitarDatosClienteEditar(supermercado);
                            break;
                        case 3:
                            //Delete
                            solicitarDatosClienteEliminar(supermercado);
                            break;
                        case 4:
                            //Read
                            mostrarInformacionClientes(supermercado);
                            break;
                        case 5:
                            continuar = false;
                    }
                    break;
                case 2:
                    continuar = false;
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

    private static void solicitarDatosClienteEditar(Supermercado supermercado) {
        String identificacion = leerStringVentana("Ingrese el número de identificación del cliente");
        boolean exist = supermercado.validarExistenciaCliente(identificacion);
        if (exist==true){
            TipoIdentificacion tipoIdentificacion = null;
            boolean continuar = false;
            do {
                int tipo = leerEnteroVentana("Tipo de identificación\n" +
                        "1. Cedula\n" +
                        "2. Pasaporte");
                switch (tipo) {
                    case 1:
                        tipoIdentificacion = TipoIdentificacion.Cedula; continuar=true; break;
                    case 2:
                        tipoIdentificacion = TipoIdentificacion.Pasaporte; continuar=true; break;
                    default: JOptionPane.showMessageDialog(null, "Opcion Invalida");
                }
            }while (continuar==false);
            String nombres = leerStringVentana("Ingrese los nombres del cliente");
            String apellidos = leerStringVentana("Ingrese los apellidos del cliente");
            editarCliente( supermercado, identificacion, tipoIdentificacion, nombres, apellidos);
        } else {
            JOptionPane.showMessageDialog(null, "No se encuentra registrado este documento");
        };
    }

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
                    tipoIdentificacion = TipoIdentificacion.Cedula; continuar=true; break;
                case 2:
                    tipoIdentificacion = TipoIdentificacion.Pasaporte; continuar=true; break;
                default: JOptionPane.showMessageDialog(null, "Opcion Invalida");
            }
        }while (continuar==false);
        String nombres = leerStringVentana("Ingrese los nombres del cliente");
        String apellidos = leerStringVentana("Ingrese los apellidos del cliente");
        crearCliente(supermercado, identificacion, tipoIdentificacion, nombres, apellidos, true);
    }


    private static void solicitarDatosClienteEliminar(Supermercado supermercado) {
        String identificacion = leerStringVentana("Ingrese el número de identificación del cliente");
        eliminarCliente(supermercado, identificacion);
    }


//METODOS CRUD ----------------------------------------------------------------

    //CLIENTE
    //create
    private static void crearCliente(Supermercado supermercado, String numIdentificacion, TipoIdentificacion tipoIdentificacion, String nombres, String apellidos, boolean mostrarVendtana) {
        supermercado.crearCliente(numIdentificacion, tipoIdentificacion, nombres, apellidos, supermercado, mostrarVendtana);
    }
    //read
    private static void mostrarInformacionClientes(Supermercado supermercado) {
        List<Cliente> listaClientes = supermercado.obtenerClientes();
        String mensaje = "";
        int tamanioLista = listaClientes.size();
        for (int i = 0; i < tamanioLista; i++) {
            Cliente cliente = listaClientes.get(i);
            mensaje += cliente+"\n";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }
    //update
    private static void editarCliente(Supermercado supermercado, String numIdentificacion, TipoIdentificacion tipoIdentificacion, String nombres, String apellidos) {
        supermercado.editarCliente(numIdentificacion, tipoIdentificacion, nombres, apellidos, supermercado);
    }
    //delete
    private static void eliminarCliente(Supermercado supermercado, String numIdentificacion) {
        supermercado.eliminarCliente(numIdentificacion);
    }
    //EMPLEADO
    private static void crearEmpleado(Supermercado supermercado, String numIdentificacion, String nombres, String apellidos, RolEmpleado rol, String fechaNacimiento, String telefono) {
        supermercado.crearEmpleado(numIdentificacion, nombres, apellidos, rol, fechaNacimiento, telefono, supermercado);
    }

    private static void mostrarImformacionEmpleados(Supermercado supermercado) {
        List<Empleado> listaEmpleados = supermercado.obtenerEmpleados();
        int tamanioLista = listaEmpleados.size();
        for (int i = 0; i < tamanioLista; i++) {
            Empleado empleado = listaEmpleados.get(i);
            System.out.println(empleado.toString());
        }
    }

    private static void editarEmpleado(Supermercado supermercado, String numIdentificacion, String nombres, String apellidos, RolEmpleado rolEmpleado, String fechaNacimiento, String telefono) {
        supermercado.editarEmpleado(numIdentificacion, nombres, apellidos, rolEmpleado, fechaNacimiento, telefono, supermercado);
    }

    private static void eliminarEmpleados(Supermercado supermercado, String numIdentificacion) {
        supermercado.eliminarEmpleado(numIdentificacion);
    }


//LECTOR DE VENTANA ----------------------------------------------------------------
    public static int leerEnteroVentana(String mensaje) {
        boolean bucle = true;
        int dato = 0;
        do {
            try {
                dato = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
                bucle=false;
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Invalid: Ingresa solo numeros");
            }
        }while (bucle);
        return dato;
    }

    public static String leerStringVentana(String mensaje) {
        String respuesta = "";
        respuesta = JOptionPane.showInputDialog(mensaje);
        return respuesta;
    }
}