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
public class Efectivo extends Empleado{
    
    
    private Integer horasObligatorias;
    private Double sueldoBasico;
    private Double comisiones;

    /*public Efectivo(Integer horasObligatorias, Double sueldoBasico, Double comisiones, Integer id, String nombre, String correoElectronico, String cuil, Date fechaIngreso, Integer horasTrabajadas) {
        super(id, nombre, correoElectronico, cuil, fechaIngreso, horasTrabajadas);
        this.horasObligatorias = horasObligatorias;
        this.sueldoBasico = sueldoBasico;
        this.comisiones = comisiones;
    }*/
       
    @Override
    public Double salario() {
        Double valorHorasExtra=0.0;
        if(this.getHorasTrabajadas()-this.getHorasObligatorias() > 0){
            valorHorasExtra= (this.getHorasTrabajadas()-this.getHorasObligatorias()) * (this.getSueldoBasico()/20);
        }
        return (this.getSueldoBasico() + this.getComisiones() + valorHorasExtra);
    }
    
    @Override
    public boolean esEfectivo(){
        return true;
    }
    
    @Override
    public boolean esContratado(){
        return false;
    }
    
    public Integer getHorasObligatorias() {
        return horasObligatorias;
    }

    public void setHorasObligatorias(Integer horasObligatorias) {
        this.horasObligatorias = horasObligatorias;
    }

    public Double getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(Double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public Double getComisiones() {
        return comisiones;
    }

    public void setComisiones(Double comisiones) {
        this.comisiones = comisiones;
    }
    
}
