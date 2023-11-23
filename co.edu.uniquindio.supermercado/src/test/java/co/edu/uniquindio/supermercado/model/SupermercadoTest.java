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

}
