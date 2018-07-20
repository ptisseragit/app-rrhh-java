package app.rrhh;


import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cristian
 */
public abstract class Empleado {
    private Integer id;
    private String nombre;
    private String correoElectronico;
    private String cuil;
    private Date fechaIngreso;
    private Integer horasTrabajadas;

    /*public Empleado(Integer id, String nombre, String correoElectronico, String cuil, Date fechaIngreso, Integer horasTrabajadas) {
        this.id = id;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.cuil = cuil;
        this.fechaIngreso = fechaIngreso;
        this.horasTrabajadas = horasTrabajadas;
    }*/

    public abstract Double salario();
    public abstract boolean esEfectivo();
    public abstract boolean esContratado();
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(Integer horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }
    
}
