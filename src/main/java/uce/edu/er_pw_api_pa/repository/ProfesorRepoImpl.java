package uce.edu.er_pw_api_pa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import uce.edu.er_pw_api_pa.model.Profesor;

@Repository
@Transactional
public class ProfesorRepoImpl implements IProfesorRepo{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void insertar(Profesor p) {
        this.em.persist(p);
    }

    @Override
    public List<Profesor> buscarTodos() {
        TypedQuery<Profesor> pQuery = this.em.createQuery("SELECT p FROM Profesor p", Profesor.class);
        return pQuery.getResultList();
    }

    @Override
    public Profesor buscarPorId(Integer id) {
       return this.em.find(Profesor.class, id);
    }

    @Override
    public void eliminar(Integer id) {
        this.em.remove(buscarPorId(id));
    }
    
}
