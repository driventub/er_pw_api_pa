package uce.edu.er_pw_api_pa.service;

import java.util.List;

import uce.edu.er_pw_api_pa.model.Profesor;
import uce.edu.er_pw_api_pa.service.to.ProfesorTO;

public interface IProfesorService {
    public void insertar(Profesor p);
    public List<ProfesorTO> buscarTodos();
    public ProfesorTO buscarPorId(Integer id);
    public void eliminar(Integer id); 
}
