/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao;

import app.rrhh.Contratado;
import app.rrhh.Efectivo;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Cristian
 */
public class TestInsertarEmpleadoDAOJDBC {
    
    private EmpleadoDAOJDBC empleadoJDBC;
            
    @Before //AQUI COLOCO TODO LO QUE DEBE EJECUTARSE ANTES DE CADA TEST
    public void setUp() {
        empleadoJDBC = new EmpleadoDAOJDBC();
    }
    
    @Test
    public void testInsertarEmpleado() {
        //Inserta Empleado Efectivo
        Efectivo efectivo = new Efectivo();
        efectivo.setNombre("Cristian");
        efectivo.setCorreoElectronico("critian@email.com");
        efectivo.setCuil("20-12345678-7");
        efectivo.setFechaIngreso(new Date());
        efectivo.setHorasTrabajadas(60);
        efectivo.setHorasObligatorias(40);
        efectivo.setSueldoBasico(10000.00);
        efectivo.setComisiones(5000.00);
        //Aseguro que hubo un registro afectado
        assertEquals(empleadoJDBC.crear(efectivo),1);
                
        //Inserta Empleado Contratado
        Contratado contratado = new Contratado();
        contratado.setNombre("Pablo");
        contratado.setCorreoElectronico("pablo@email.com");
        contratado.setCuil("20-12345678-7");
        contratado.setFechaIngreso(new Date());
        contratado.setHorasTrabajadas(30);
        contratado.setValorHoraTrabajada(500.00);
        //Aseguro que hubo un registro afectado
        assertEquals(empleadoJDBC.crear(contratado),1);
        
        
              
        //No es posible realizar estas comparaciones debido a que desconocemos el ID
        //dado que de autogenera en la BD.
        /*Empleado e1=empleadoJDBC.buscarPorId(efectivo.getId());
        Empleado e2=empleadoJDBC.buscarPorId(contratado.getId());
        assertEquals(efectivo.getNombre(),e1.getNombre());
        assertEquals(contratado.getNombre(),e2.getNombre());*/
    }
    
}
