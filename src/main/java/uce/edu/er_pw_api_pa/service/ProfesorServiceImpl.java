package uce.edu.er_pw_api_pa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uce.edu.er_pw_api_pa.model.Profesor;
import uce.edu.er_pw_api_pa.repository.IProfesorRepo;
import uce.edu.er_pw_api_pa.service.to.ProfesorTO;

@Service
public class ProfesorServiceImpl implements IProfesorService{

    @Autowired
    private IProfesorRepo profesorRepo;

    @Override
    public void insertar(Profesor p) {
       this.profesorRepo.insertar(p);
    }

    @Override
    public List<ProfesorTO> buscarTodos() {
        List<Profesor> lista = this.profesorRepo.buscarTodos();
        return lista.stream().map(profesor -> this.convertir(profesor)).collect(Collectors.toList());
    }

    private ProfesorTO convertir(Profesor p){
        ProfesorTO profe = new ProfesorTO();
        profe.setId(p.getId());
        profe.setNombre(p.getNombre());
        profe.setApellido(p.getApellido());
        profe.setFechaNacimiento(p.getFechaNacimiento());
        profe.setCedula(p.getCedula());
        return profe;
    }

    @Override
    public ProfesorTO buscarPorId(Integer id) {
        return this.convertir(this.profesorRepo.buscarPorId(id));
    }

    @Override
    public void eliminar(Integer id) {
        this.profesorRepo.eliminar(id);
    }

    
}
