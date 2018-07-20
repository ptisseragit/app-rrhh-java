/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao;

import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Cristian
 */
public class TestBuscarEmpleadoTodosDAOJDBC {
    
    private EmpleadoDAOJDBC empleadoJDBC;
             
    @Before //AQUI COLOCO TODO LO QUE DEBE EJECUTARSE ANTES DE CADA TEST
    public void setUp() {
        empleadoJDBC = new EmpleadoDAOJDBC();
    }
    @Test
    public void testConsultarTodosEmpleados() {
        assertNotNull(empleadoJDBC.buscarTodos());
    }
    
}
