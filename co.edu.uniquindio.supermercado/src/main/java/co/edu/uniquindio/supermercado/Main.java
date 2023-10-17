package co.edu.uniquindio.supermercado;

import co.edu.uniquindio.supermercado.enumeracion.RolEmpleado;
import co.edu.uniquindio.supermercado.enumeracion.TipoIdentificacion;
import co.edu.uniquindio.supermercado.model.Cliente;
import co.edu.uniquindio.supermercado.model.Empleado;
import co.edu.uniquindio.supermercado.model.Producto;
import co.edu.uniquindio.supermercado.model.Supermercado;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Supermercado supermercado = inicializarDatosPrueba();
        boolean continuar = true;
        int valorSeleccion;


        //CRUD CLIENTE

        //Create
        crearCliente(supermercado, "001", TipoIdentificacion.Cedula, "Teresa", "Ramirez", false);
        crearCliente(supermercado, "002", TipoIdentificacion.Cedula, "Gloria", "Valencia", false);
        crearCliente(supermercado, "003", TipoIdentificacion.Cedula, "Santiago", "Castrillon", false);
        crearCliente(supermercado, "004", TipoIdentificacion.Cedula, "Steven", "Marin", false);

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
                            eliminarCliente(supermercado);
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


        //CRUD EMPLEADO

        //Create
        crearEmpleado(supermercado, "102030", "Ivan", "Cortez", RolEmpleado.Surtidor, "13/05/1997", "3104569887");
        crearEmpleado(supermercado, "908070", "Casper", "Galeon", RolEmpleado.Empacador, "31/05/1995", "3205897412");
        crearEmpleado(supermercado, "506040", "Isco", "Martinel", RolEmpleado.Gerente, "25/01/1996", "3189636547");
        crearEmpleado(supermercado, "123456", "Pocholo", "Garcia", RolEmpleado.Domiciliario, "01/01/1990", "3128529647");

        //Read
        mostrarImformacionEmpleados(supermercado);

        //Update
        editarEmpleado(supermercado, "123456", "Pocholo", "Marquez", RolEmpleado.Domiciliario, "01/01/1990", "3128529647");
        System.out.println("\nDespues de editar Cliente");
        mostrarImformacionEmpleados(supermercado);


        //Delete
        eliminarEmpleados(supermercado, "506040");
        System.out.println("\nDespues de eliminar Cliente");
        mostrarImformacionEmpleados(supermercado);
        System.out.println();

    }

    private static void solicitarDatosClienteEditar(Supermercado supermercado) {
        String identificacion = leerStringVentana("Ingrese el número de identificación del cliente");
        String tipoIdentificacion = leerStringVentana("Tipo de identificación\n" +
                "1. Cedula\n" +
                "2. Pasaporte");
        String nombres = leerStringVentana("Ingrese los nombres del cliente");
        String apellidos = leerStringVentana("Ingrese los apellidos del cliente");

        if (tipoIdentificacion.equalsIgnoreCase("1")) {
            supermercado.editarCliente(identificacion, TipoIdentificacion.Cedula, nombres, apellidos, supermercado);
        } else {
            supermercado.editarCliente(identificacion, TipoIdentificacion.Pasaporte, nombres, apellidos, supermercado);
        }
    }

    private static void solicitarDatosClienteCrear(Supermercado supermercado) {
        String identificacion = leerStringVentana("Ingrese el número de identificación del cliente");
        String tipoIdentificacion = leerStringVentana("Tipo de identificación\n" +
                "1. Cedula\n" +
                "2. Pasaporte");
        String nombres = leerStringVentana("Ingrese los nombres del cliente");
        String apellidos = leerStringVentana("Ingrese los apellidos del cliente");

        if (tipoIdentificacion.equalsIgnoreCase("1")) {
            supermercado.crearCliente(identificacion, TipoIdentificacion.Cedula, nombres, apellidos, supermercado, true);
        } else {
            supermercado.crearCliente(identificacion, TipoIdentificacion.Pasaporte, nombres, apellidos, supermercado, true);
        }

    }

    private static void eliminarCliente(Supermercado supermercado) {
        String identificacion = leerStringVentana("Ingrese el número de identificación del cliente");
        supermercado.eliminarCliente(identificacion);
    }

    private static Supermercado inicializarDatosPrueba() {
        Supermercado supermercado = new Supermercado();
        supermercado.setNit("951753852");
        supermercado.setNombre("SuperCundi");
        return supermercado;
    }

    private static void crearCliente(Supermercado supermercado, String numIdentificacion, TipoIdentificacion tipoIdentificacion, String nombres, String apellidos, boolean mostrarVendtana) {
        supermercado.crearCliente(numIdentificacion, tipoIdentificacion, nombres, apellidos, supermercado, mostrarVendtana);

    }

    private static void mostrarInformacionClientes(Supermercado supermercado) {
        List<Cliente> listaClientes = supermercado.obtenerClientes();
        String mensaje = "";
        int tamanioLista = listaClientes.size();
        for (int i = 0; i < tamanioLista; i++) {
            Cliente cliente = listaClientes.get(i);
            System.out.println(cliente.toString());
            mensaje += cliente.toString().replace("Cliente{", "").replace("}", "") + "\n";
        }

        JOptionPane.showMessageDialog(null, mensaje);


    }

    private static void editarCliente(Supermercado supermercado, String numIdentificacion, TipoIdentificacion tipoIdentificacion, String nombres, String apellidos) {
        supermercado.editarCliente(numIdentificacion, tipoIdentificacion, nombres, apellidos, supermercado);
    }



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

    public static int leerEnteroVentana(String mensaje) {
        int dato = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
        return dato;
    }

    public static String leerStringVentana(String mensaje) {
        String respuesta = "";
        respuesta = JOptionPane.showInputDialog(mensaje);
        return respuesta;
    }
}