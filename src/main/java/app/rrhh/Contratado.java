/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.rrhh;

/**
 *
 * @author Cristian
 */
public class Contratado extends Empleado{
    private Double valorHoraTrabajada;
    
    @Override
    public Double salario() {
        return(this.getHorasTrabajadas()*this.valorHoraTrabajada);
    }
    
    @Override
    public boolean esEfectivo(){
        return false;
    }
    
    @Override
    public boolean esContratado(){
        return true;
    }
    
    public Double getValorHoraTrabajada() {
        return valorHoraTrabajada;
    }

    public void setValorHoraTrabajada(Double valorHoraTrabajada) {
        this.valorHoraTrabajada = valorHoraTrabajada;
    }
    
}
