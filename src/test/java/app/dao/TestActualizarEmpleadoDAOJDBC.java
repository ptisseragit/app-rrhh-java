/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao;

import app.rrhh.Empleado;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Cristian
 */
public class TestActualizarEmpleadoDAOJDBC {
    private EmpleadoDAOJDBC empleadoJDBC;
            
    @Before //AQUI COLOCO TODO LO QUE DEBE EJECUTARSE ANTES DE CADA TEST
    public void setUp() {
        empleadoJDBC = new EmpleadoDAOJDBC();
    }
    
    @Test
    public void testActualizarEmpleado() {
        //Chequeo el campo actualizado. Debería de chequear con cada campo. 
        Empleado e = empleadoJDBC.buscarPorId(25);
        e.setCuil("20-87654321-7");
        empleadoJDBC.actualizar(e);
        e = empleadoJDBC.buscarPorId(25);
        assertEquals("20-87654321-7",e.getCuil());
    }
}
