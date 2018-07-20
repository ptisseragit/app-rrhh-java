/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao;

import app.rrhh.Contratado;
import app.rrhh.Efectivo;
import app.rrhh.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cristian
 */
public class EmpleadoDAOJDBC implements EmpleadoDAO{
    
    private final String INSERT_EMPLEADO = "INSERT INTO empleados (NOMBRE, CORREO, CUIL, "
        + "FECHA_INGRESO, HS_TRABAJADAS, SUELDO_BASICO, COMISIONES, HS_MINIMAS, COSTO_HORA, TIPO_EMPLEADO) "
        + "VALUES (?,?,?,?,?,?,?,?,?,?)";
    
    private final String UPDATE_EMPLEADO = "UPDATE empleados SET "
        + "NOMBRE=?, CORREO=?, CUIL=?,FECHA_INGRESO=?, HS_TRABAJADAS=?, SUELDO_BASICO=?, COMISIONES=?, "
        + "HS_MINIMAS=?, COSTO_HORA=?, TIPO_EMPLEADO=? WHERE ID=?";
    
    
    private final String ELIMINAR_EMPLEADO = "DELETE FROM empleados WHERE ID=?";
    
    private final String BUSCAR_EMPLEADO = "SELECT * FROM empleados WHERE ID=?";
    
    private final String BUSCAR_EMPLEADOS = "SELECT * FROM empleados";
    
    @Override
    public int crear(Empleado e) {
        Connection conn = ConexionJDBC.getConexion();
        try(PreparedStatement ps = conn.prepareStatement(INSERT_EMPLEADO)){
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getCorreoElectronico());
            ps.setString(3, e.getCuil());
            ps.setDate(4, new java.sql.Date(e.getFechaIngreso().getTime()));
            ps.setInt(5, e.getHorasTrabajadas());
            if(e.esEfectivo()){
                Efectivo empEf = (Efectivo) e;
                ps.setDouble(6, empEf.getSueldoBasico());
                ps.setDouble(7, empEf.getComisiones());
                ps.setInt(8, empEf.getHorasObligatorias());
                ps.setDouble(9, 0.00);
                ps.setInt(10, 1);//EMPLEADO EFECTIVO
            }
            if(e.esContratado()){
                Contratado c = (Contratado) e; 
                ps.setDouble(6, 0.00);
                ps.setDouble(7, 0.00);
                ps.setInt(8, 0);
                ps.setDouble(9, c.getValorHoraTrabajada());
                ps.setInt(10, 2);//EMPLEADO CONTRATADO
            }
            return(ps.executeUpdate());
        }catch(SQLException ex){
            ex.printStackTrace();
            return(0);
        }
        finally{
            if(conn!=null) {
                ConexionJDBC.liberarConexion();
            }
        }
    }

    @Override
    public int actualizar(Empleado e) {
        Connection conn = ConexionJDBC.getConexion();
        try(PreparedStatement ps = conn.prepareStatement(UPDATE_EMPLEADO)){
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getCorreoElectronico());
            ps.setString(3, e.getCuil());
            ps.setDate(4, new java.sql.Date(e.getFechaIngreso().getTime()));
            ps.setInt(5, e.getHorasTrabajadas());
            if(e.esEfectivo()){
                Efectivo empEf = (Efectivo) e;
                ps.setDouble(6, empEf.getSueldoBasico());
                ps.setDouble(7, empEf.getComisiones());
                ps.setInt(8, empEf.getHorasObligatorias());
                ps.setDouble(9, 0.00);
                ps.setInt(10, 1);//EMPLEADO EFECTIVO
            }
            if(e.esContratado()){
                Contratado c = (Contratado) e; 
                ps.setDouble(6, 0.00);
                ps.setDouble(7, 0.00);
                ps.setInt(8, 0);
                ps.setDouble(9, c.getValorHoraTrabajada());
                ps.setInt(10, 2);//EMPLEADO CONTRATADO
            }
            ps.setInt(11, e.getId());
            return(ps.executeUpdate());
        }catch(SQLException ex){
            ex.printStackTrace();
            return(0);
        }
        finally{
            if(conn!=null){
                ConexionJDBC.liberarConexion();
            }
        }
    }

    @Override
    public void eliminar(Empleado e) {
        Connection conn = ConexionJDBC.getConexion();
        try(PreparedStatement ps = conn.prepareStatement(ELIMINAR_EMPLEADO)){
            ps.setInt(1, e.getId());
            int filasInsertadas = ps.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        finally{
           if(conn!=null){
                ConexionJDBC.liberarConexion();
            }
        }
    }

    @Override
    public Empleado buscarPorId(Integer id) {
        Empleado empleado=null;
        Connection conn = ConexionJDBC.getConexion();
        try(PreparedStatement ps = conn.prepareStatement(BUSCAR_EMPLEADO)){
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                if(rs.getInt("TIPO_EMPLEADO")==1){
                    empleado=new Efectivo();
                    ((Efectivo)empleado).setSueldoBasico( new Double (Float.toString(rs.getFloat("SUELDO_BASICO"))));
                    ((Efectivo)empleado).setComisiones( new Double (Float.toString(rs.getFloat("COMISIONES"))));
                    ((Efectivo)empleado).setHorasObligatorias(rs.getInt("HS_MINIMAS"));
                }
                else{
                    empleado= new Contratado();
                    ((Contratado)empleado).setValorHoraTrabajada(new Double (Float.toString(rs.getFloat("COSTO_HORA"))));
                }
                empleado.setId(rs.getInt("ID"));
                empleado.setNombre(rs.getString("NOMBRE"));
                empleado.setCorreoElectronico(rs.getString("CORREO"));
                empleado.setCuil(rs.getString("CUIL"));
                empleado.setFechaIngreso(rs.getDate("FECHA_INGRESO", new GregorianCalendar()));
                empleado.setHorasTrabajadas(rs.getInt("HS_TRABAJADAS"));
            }  
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        finally{
            if(conn!=null){
                ConexionJDBC.liberarConexion();
            }
        }
        return empleado;
    }

    @Override
    public List<Empleado> buscarTodos() {
        Empleado empleado=null;
        List listaEmpleados = new LinkedList<Empleado>();
        Connection conn = ConexionJDBC.getConexion();
        try(PreparedStatement ps = conn.prepareStatement(BUSCAR_EMPLEADOS)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                if(rs.getInt("TIPO_EMPLEADO")==1){
                    empleado=new Efectivo();
                    ((Efectivo)empleado).setSueldoBasico( new Double (Float.toString(rs.getFloat("SUELDO_BASICO"))));
                    ((Efectivo)empleado).setComisiones( new Double (Float.toString(rs.getFloat("COMISIONES"))));
                    ((Efectivo)empleado).setHorasObligatorias(rs.getInt("HS_MINIMAS"));
                }
                else{
                    empleado= new Contratado();
                    ((Contratado)empleado).setValorHoraTrabajada(new Double (Float.toString(rs.getFloat("COSTO_HORA"))));
                }
                empleado.setId(rs.getInt("ID"));
                empleado.setNombre(rs.getString("NOMBRE"));
                empleado.setCorreoElectronico(rs.getString("CORREO"));
                empleado.setCuil(rs.getString("CUIL"));
                empleado.setFechaIngreso(rs.getDate("FECHA_INGRESO", new GregorianCalendar()));
                empleado.setHorasTrabajadas(rs.getInt("HS_TRABAJADAS"));
                listaEmpleados.add(empleado);
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        finally{
           if(conn!=null){
                ConexionJDBC.liberarConexion();
            }
        }
        return listaEmpleados;
    }
    
}
