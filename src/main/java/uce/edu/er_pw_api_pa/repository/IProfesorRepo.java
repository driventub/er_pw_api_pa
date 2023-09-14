package uce.edu.er_pw_api_pa.repository;

import java.util.List;

import uce.edu.er_pw_api_pa.model.Profesor;

public interface IProfesorRepo {
    public void insertar(Profesor p);
    public List<Profesor> buscarTodos();
    public Profesor buscarPorId(Integer id);
    public void eliminar(Integer id); 
}
