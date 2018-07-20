/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao;

import app.rrhh.Empleado;
import java.util.List;

/**
 *
 * @author Cristian
 */
public interface EmpleadoDAO {
    public int crear(Empleado e);
    public int actualizar(Empleado e);
    public void eliminar(Empleado e);
    public Empleado buscarPorId(Integer id);
    public List<Empleado> buscarTodos();
}
