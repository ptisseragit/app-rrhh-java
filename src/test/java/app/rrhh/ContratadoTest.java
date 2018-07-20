/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.rrhh;

import app.rrhh.Contratado;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cristian
 */
public class ContratadoTest {
    
    public ContratadoTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSalario() {
        System.out.println("Salario Contratado"); 
        Contratado empleado = new Contratado(); 
        empleado.setHorasTrabajadas(20); 
        empleado.setValorHoraTrabajada(750.00);
        Double expResult = 15000.0; 
        Double result = empleado.salario(); 
        assertEquals(expResult, result); 
    }
}
