package co.edu.uniquindio.supermercado.model;

import co.edu.uniquindio.supermercado.dto.ProductoDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductoTest {
    ProductoDto productoDto;

    @BeforeEach
    void init(){
        productoDto = new ProductoDto("001","Choclitos","Fritolay","25/11/2023",150,7500,6200);
    }

    @Test
    void testCrearProducto(){
        String id = productoDto.idProducto();
        String nombre = productoDto.nombre();
        String marca = productoDto.marca();
        String fechaV = productoDto.fechaVencimiento();
        int cantidad = productoDto.cantidad();
        double precio = productoDto.precio();
        double precioCompra = productoDto.precioDeCompra();
        assertEquals(id,"001");
        assertEquals(nombre,"Choclitos");
        assertEquals(marca,"Fritolay");
        assertEquals(fechaV,"25/11/2023");
        assertEquals(cantidad,150);
        assertEquals(precio,7500);
        assertEquals(precioCompra,6200);
    }

    @Test
    void testReferenciaProducto(){
        ProductoDto productoDto1 = new ProductoDto("001","Choclitos","Fritolay","25/11/2023",150,7500,6200);
        ProductoDto productoDto2 = new ProductoDto("001","Choclitos","Fritolay","25/11/2023",150,7500,6200);
        assertEquals(productoDto1, productoDto2);
    }

    @Test
    void testSetCantidadProducto(){
        Producto producto = new Producto("001","Choclitos","Fritolay","25/11/2023",150,7500,6200);
        producto.setCantidad(500);
        assertEquals(500,producto.getCantidad());
    }

    @Test
    void testTypeRecordProducto(){
        ProductoDto productoDto1 = new ProductoDto("001","Choclitos","Fritolay","25/11/2023",150,7500,6200);
        String record = productoDto1.getClass().getName();
        assertEquals("co.edu.uniquindio.supermercado.dto.ProductoDto", record);
    }

    @Test
    void testTypeClassProducto(){
        Producto producto = new Producto("001","Choclitos","Fritolay","25/11/2023",150,7500,6200);
        String clase = producto.getClass().getName();
        assertEquals("co.edu.uniquindio.supermercado.model.Producto", clase);
    }
}
