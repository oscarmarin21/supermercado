package co.edu.uniquindio.supermercado.model;

import co.edu.uniquindio.supermercado.dto.ProductoDto;
import co.edu.uniquindio.supermercado.enumeracion.RolEmpleado;
import co.edu.uniquindio.supermercado.util.ServicesUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class SupermercadoTest {

    Supermercado supermercado;
    @BeforeEach
    void init(){
        supermercado = new Supermercado("001","SuperCundi");
    }

    @Test
    void testIdAutoincremental(){
        String nuevoId = ServicesUtil.nextId("001");
        assertEquals("002", nuevoId);
    }

    @Test
    void testCantidadEmpleados(){
        supermercado.crearEmpleado("001", "Oscar","marin", RolEmpleado.Empacador, "21/06/2004", "3134195025", supermercado);
        int  cantidadEmpleados = supermercado.obtenerCantidadEmpleados();
        assertEquals(1, cantidadEmpleados);
    }

    @Test
    void testTotalInventario(){
        supermercado.crearProducto(supermercado,"001","Choclitos","Fritolay","25/11/2023",150,7500,6200);
        double totalInventario = supermercado.obtenerValorTotalInventario();
        assertEquals(7500*150, totalInventario);
    }

    @Test
    void testEmpleadosEmpacadores(){
        supermercado.crearEmpleado("001", "Oscar","marin", RolEmpleado.Empacador, "21/06/2004", "3134195025", supermercado);
        int  cantidadEmpleados = supermercado.obtenerCantidadEmpleados();
        assertEquals(1, cantidadEmpleados);
    }

    @Test
    void testTotalProveedorCompra(){
        supermercado.crearEmpleado("001", "Oscar","marin", RolEmpleado.Empacador, "21/06/2004", "3134195025", supermercado);
        supermercado.crearProducto(supermercado,"001","Choclitos","Fritolay","25/11/2023",150,7500,6200);
        supermercado.crearProveedor(supermercado,"001", "Rammo", "3127538951");
        supermercado.crearCompraInsumos("001","17/11/2023", "001", "001", supermercado);
        CompraInsumos compra = supermercado.obtenerCompraInsumos("001");
        compra.crearDetalleCompraInsumos("001", 3,"001", "001", supermercado);
        double totalCompra = compra.calcularTotal("001");
        compra.setTotalCompra(totalCompra);
        double totalProveedor = supermercado.totalProveedorCompra("001");
        assertEquals(6200*3, totalProveedor);
    }

}
