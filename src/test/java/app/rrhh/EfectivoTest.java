package app.rrhh;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import app.rrhh.Efectivo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cristian
 */
public class EfectivoTest {
    
    public EfectivoTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

   
    
    /** * Test of salario method, of class Efectivo. */ 
    @Test public void testSalarioSinHorasExtras() { 
        System.out.println("Salario Efectivo SIN Horas Extras"); 
        Efectivo empleado = new Efectivo(); 
        empleado.setHorasTrabajadas(40); 
        empleado.setHorasObligatorias(40); 
        empleado.setComisiones(2000.0); 
        empleado.setSueldoBasico(30000.0); 
        Double expResult = 30000.0+2000.0; 
        Double result = empleado.salario(); 
        assertEquals(expResult, result); 
    } 
    
    /** * Test of salario method, of class Efectivo. */ 
    @Test public void testSalario2HorasExtras() { 
        System.out.println("Salario Efectivo CON Horas Extras"); 
        Efectivo empleado = new Efectivo(); 
        empleado.setHorasTrabajadas(42); 
        empleado.setHorasObligatorias(40); 
        empleado.setComisiones(2000.0); 
        empleado.setSueldoBasico(30000.0); 
        Double expResult = 30000.0+2000.0+3000.0; 
        Double result = empleado.salario(); 
        assertEquals(expResult, result); 
    }
    
}
