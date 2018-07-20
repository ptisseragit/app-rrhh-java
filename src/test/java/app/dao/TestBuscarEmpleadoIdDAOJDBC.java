/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao;

import app.rrhh.Empleado;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Cristian
 */
public class TestBuscarEmpleadoIdDAOJDBC {
    
    private EmpleadoDAOJDBC empleadoJDBC;
            
    @Before //AQUI COLOCO TODO LO QUE DEBE EJECUTARSE ANTES DE CADA TEST
    public void setUp() {
        empleadoJDBC = new EmpleadoDAOJDBC();
    }
    
    @Test
    public void testConsultarEmpleadoPorId() {
        
        
        //Realizamos comparaciones
        Empleado empleadoBuscado=empleadoJDBC.buscarPorId(25);
        assertNotNull(empleadoBuscado);
        
       
        //CASO DE BUSCAR EMPLEADO INEXISTENTE
        //Los Identificadores no pueden tomar valores negtivos. Busco un empleado inexistente. Debería de retornar null
        Integer id=-5;
        empleadoBuscado = empleadoJDBC.buscarPorId(id);
        assertNull(empleadoBuscado);
    }
}
