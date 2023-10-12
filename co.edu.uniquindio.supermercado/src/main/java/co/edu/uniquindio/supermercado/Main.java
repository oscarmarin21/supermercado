package co.edu.uniquindio.supermercado;

import co.edu.uniquindio.supermercado.enumeracion.RolEmpleado;
import co.edu.uniquindio.supermercado.model.Empleado;
import co.edu.uniquindio.supermercado.model.Producto;

public class Main {
    public static void main(String[] args) {
        Producto producto1 = inicializaProductosPrueba("001","Galletas", "Noel","31/11/2023", 7500, 7500);
        Producto producto2 = inicializaProductosPrueba("002","Crispetas", "Doria","24/12/2024", 4200, 4700);
        Producto producto3 = inicializaProductosPrueba("003","Frijol", "La granja","15/05/2024", 3400, 2600);
        Producto producto4 = inicializaProductosPrueba("004","Alitas", "Cock","30/10/2023", 2000, 14100);

        Empleado empleado1 = inicializaEmpleadosPrueba( "102030","Ivan","Cortez", RolEmpleado.Surtidor, "13/05/1997","3104569887");
        Empleado empleado2 = inicializaEmpleadosPrueba( "908070","Casper","Galeon", RolEmpleado.Empacador, "31/05/1995","3205897412");
        Empleado empleado3 = inicializaEmpleadosPrueba( "506040","Isco","Martinel", RolEmpleado.Gerente, "25/01/1996", "3189636547");
        Empleado empleado4 = inicializaEmpleadosPrueba( "123456","Pocholo","Garcia", RolEmpleado.Domiciliario, "01/01/1990", "3128529647");

        







        /**
        System.out.println("El empleado con mejor salario es: "+mostrarNombreMejorSalario(empleado1,empleado2,empleado3,empleado4)+"\n");
        System.out.println("El producto mas costoso es: "+mostrarProductoMasCostoso(producto1,producto2,producto3,producto4)+"\n");
        System.out.println("El producto con menor existencia es: "+mostrarProductoMenorExistencia(producto1,producto2,producto3,producto4)+"\n");
        System.out.println("El total de productos en existencia es: "+mostrarTotalInventario(producto1,producto2,producto3,producto4)+"\n");
        System.out.println("Los productos que comienzan por C son: \n"+mostrarProductosComienzanC(producto1,producto2,producto3,producto4));
        System.out.println("El total de la nomina mensual es de: "+mostrarTotalNomina(empleado1,empleado2,empleado3,empleado4));
        **/
    }


    private static Producto inicializaProductosPrueba(String idProducto, String nombre, String marca, String fechaVencimiento, int cantidad, double precio) {
        Producto producto = new Producto(idProducto, nombre, marca, fechaVencimiento, cantidad, precio);
        return producto;
    }
    private static Empleado inicializaEmpleadosPrueba(String identificacion, String nombre, String apellido, RolEmpleado rol, String fechaNacimiento, String telefono) {
        Empleado empleado = new Empleado(identificacion,nombre, apellido, rol, fechaNacimiento, telefono);
        return empleado;
    }






    /**
    private static String mostrarNombreMejorSalario(Empleado empleado1, Empleado empleado2, Empleado empleado3, Empleado empleado4){
        String nombre = "";
        double mejorSalario = 0;
        if(empleado1.getSalario()>mejorSalario){
            mejorSalario = empleado1.getSalario();
            nombre = empleado1.getNombre();
        }
        if(empleado2.getSalario()>mejorSalario){
            mejorSalario = empleado2.getSalario();
            nombre = empleado2.getNombre();
        }
        if(empleado3.getSalario()>mejorSalario){
            mejorSalario = empleado3.getSalario();
            nombre = empleado3.getNombre();
        }
        if(empleado4.getSalario()>mejorSalario){
            nombre = empleado4.getNombre();
        }
        return nombre;
    }

    private static String mostrarProductoMasCostoso(Producto producto1, Producto producto2, Producto producto3, Producto producto4){
        String productoMasCostoso = "";
        double precio = 0;
        if(producto1.getPrecio()>precio){
            precio = producto1.getPrecio();
            productoMasCostoso = producto1.getNombre();
        }
        if(producto2.getPrecio()>precio){
            precio = producto2.getPrecio();
            productoMasCostoso = producto2.getNombre();
        }
        if(producto3.getPrecio()>precio){
            precio = producto3.getPrecio();
            productoMasCostoso = producto3.getNombre();
        }
        if(producto4.getPrecio()>precio){
            precio = producto4.getPrecio();
            productoMasCostoso = producto4.getNombre();
        }
        return productoMasCostoso;
    }

    private static String mostrarProductoMenorExistencia(Producto producto1, Producto producto2, Producto producto3, Producto producto4){
        String productoMenorExistencia = producto1.getNombre();
        double existencia = producto1.getCantidad();
        if(producto2.getCantidad()<existencia){
            existencia = producto2.getCantidad();
            productoMenorExistencia = producto2.getNombre();
        }
        if(producto3.getCantidad()<existencia){
            existencia = producto3.getCantidad();
            productoMenorExistencia = producto3.getNombre();
        }
        if(producto4.getCantidad()<existencia){
            existencia = producto4.getCantidad();
            productoMenorExistencia = producto4.getNombre();
        }
        return productoMenorExistencia;
    }

    private static int mostrarTotalInventario(Producto producto1, Producto producto2, Producto producto3, Producto producto4){
        int totalInventario = producto1.getCantidad()+producto2.getCantidad()+producto3.getCantidad()+producto4.getCantidad();
        return totalInventario;
    }

    private static String mostrarProductosComienzanC(Producto producto1, Producto producto2, Producto producto3, Producto producto4){
        String productos = "";
        if(producto1.getNombre().toLowerCase().startsWith("c")){
            productos += producto1.getNombre()+"\n";
        }
        if(producto2.getNombre().toLowerCase().startsWith("c")){
            productos += producto2.getNombre()+"\n";
        }
        if(producto3.getNombre().toLowerCase().startsWith("c")){
            productos += producto3.getNombre()+"\n";
        }
        if(producto4.getNombre().toLowerCase().startsWith("c")){
            productos += producto4.getNombre()+"\n";
        }
        return productos;
    }

    private static double mostrarTotalNomina(Empleado empleado1, Empleado empleado2, Empleado empleado3, Empleado empleado4){
        double totalNomina = empleado1.getSalario()+empleado2.getSalario()+empleado3.getSalario()+empleado4.getSalario();
        return totalNomina;
    } **/
}