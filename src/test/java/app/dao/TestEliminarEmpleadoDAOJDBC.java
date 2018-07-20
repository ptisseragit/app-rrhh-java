/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao;

import app.rrhh.Empleado;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Cristian
 */
public class TestEliminarEmpleadoDAOJDBC {
    private EmpleadoDAOJDBC empleadoJDBC;
            
    @Before //AQUI COLOCO TODO LO QUE DEBE EJECUTARSE ANTES DE CADA TEST
    public void setUp() {
        empleadoJDBC = new EmpleadoDAOJDBC();
    }
    
    @Test
    public void testEliminarEmpleado() {
        //Debo colocar un ID de empleado Empleado existente
        Empleado e = empleadoJDBC.buscarPorId(23);
        empleadoJDBC.eliminar(e);
        assertNull(empleadoJDBC.buscarPorId(23));
    }
}
