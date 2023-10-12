package co.edu.uniquindio.supermercado;

import co.edu.uniquindio.supermercado.enumeracion.RolEmpleado;
import co.edu.uniquindio.supermercado.enumeracion.TipoIdentificacion;
import co.edu.uniquindio.supermercado.model.Cliente;
import co.edu.uniquindio.supermercado.model.Empleado;
import co.edu.uniquindio.supermercado.model.Producto;
import co.edu.uniquindio.supermercado.model.Supermercado;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Supermercado supermercado = inicializarDatosPrueba();

        //CRUD CLIENTE

        //Create
        crearCliente(supermercado,"529753", TipoIdentificacion.Cedula, "Teresa", "Ramirez");
        crearCliente(supermercado,"756351", TipoIdentificacion.Cedula, "Gloria", "Valencia");
        crearCliente(supermercado,"764865", TipoIdentificacion.Cedula, "Santiago", "Castrillon");
        crearCliente(supermercado,"557691", TipoIdentificacion.Cedula, "Steven", "Marin");

        //Read
        mostrarInformacionClientes(supermercado);

        //Update
        editarCliente(supermercado, "764865", TipoIdentificacion.Cedula, "Mariana", "Castrillon");
        System.out.println("\nDespues de editar Cliente");
        mostrarInformacionClientes(supermercado);


        //Delete
        eliminarCliente(supermercado, "529753");
        System.out.println("\nDespues de eliminar Cliente");
        mostrarInformacionClientes(supermercado);
        System.out.println();


        //CRUD EMPLEADO

        //Create
        crearEmpleado(supermercado,"102030","Ivan","Cortez", RolEmpleado.Surtidor, "13/05/1997","3104569887");
        crearEmpleado(supermercado,"908070","Casper","Galeon", RolEmpleado.Empacador, "31/05/1995","3205897412");
        crearEmpleado(supermercado,"506040","Isco","Martinel", RolEmpleado.Gerente, "25/01/1996", "3189636547");
        crearEmpleado(supermercado,"123456","Pocholo","Garcia", RolEmpleado.Domiciliario, "01/01/1990", "3128529647");

        //Read
        mostrarImformacionEmpleados(supermercado);

        //Update
        editarEmpleado(supermercado,"123456","Pocholo","Marquez",RolEmpleado.Domiciliario,"01/01/1990","3128529647");
        System.out.println("\nDespues de editar Cliente");
        mostrarImformacionEmpleados(supermercado);


        //Delete
        eliminarEmpleados(supermercado, "506040");
        System.out.println("\nDespues de eliminar Cliente");
        mostrarImformacionEmpleados(supermercado);
        System.out.println();

    }

    private static Supermercado inicializarDatosPrueba() {
        Supermercado supermercado = new Supermercado();
        supermercado.setNit("951753852");
        supermercado.setNombre("SuperCundi");
        return supermercado;
    }

    private static void crearCliente(Supermercado supermercado, String numIdentificacion, TipoIdentificacion tipoIdentificacion, String nombres, String apellidos) {
        supermercado.crearCliente(numIdentificacion, tipoIdentificacion, nombres, apellidos, supermercado);

    }

    private static void mostrarInformacionClientes(Supermercado supermercado) {
        List<Cliente> listaClientes = supermercado.obtenerClientes();
        int tamanioLista = listaClientes.size();
        for(int i=0; i<tamanioLista; i++) {
            Cliente cliente = listaClientes.get(i);
            System.out.println(cliente.toString());
        }
    }

    private static void editarCliente(Supermercado supermercado, String numIdentificacion, TipoIdentificacion tipoIdentificacion, String nombres, String apellidos) {
        supermercado.editarCliente(numIdentificacion, tipoIdentificacion, nombres, apellidos, supermercado);
    }

    private static void eliminarCliente(Supermercado supermercado, String numIdentificacion){
        supermercado.eliminarCliente(numIdentificacion);
    }

    private static void crearEmpleado(Supermercado supermercado, String numIdentificacion, String nombres, String apellidos, RolEmpleado rol, String fechaNacimiento, String telefono){
        supermercado.crearEmpleado(numIdentificacion,nombres,apellidos,rol, fechaNacimiento, telefono,supermercado);
    }

    private static void mostrarImformacionEmpleados(Supermercado supermercado){
        List<Empleado> listaEmpleados = supermercado.obtenerEmpleados();
        int tamanioLista = listaEmpleados.size();
        for(int i=0; i<tamanioLista; i++){
            Empleado empleado = listaEmpleados.get(i);
            System.out.println(empleado.toString());
        }
    }

    private static void editarEmpleado(Supermercado supermercado, String numIdentificacion, String nombres, String apellidos, RolEmpleado rolEmpleado, String fechaNacimiento, String telefono) {
        supermercado.editarEmpleado(numIdentificacion, nombres, apellidos, rolEmpleado, fechaNacimiento, telefono, supermercado);
    }

    private static void eliminarEmpleados(Supermercado supermercado, String numIdentificacion){
        supermercado.eliminarEmpleado(numIdentificacion);
    }

}