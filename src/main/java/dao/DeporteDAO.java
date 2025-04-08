package dao;

import modelo.Deporte;
import jakarta.persistence.*;

import java.util.List;

public class DeporteDAO {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("poli_apuestasPU");

    public void insertar(Deporte deporte) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(deporte);
        em.getTransaction().commit();
        em.close();
    }

    public List<Deporte> listar() {
        EntityManager em = emf.createEntityManager();
        List<Deporte> deportes = em.createQuery("SELECT d FROM Deporte d", Deporte.class).getResultList();
        em.close();
        return deportes;
    }

    public void actualizar(Deporte deporte) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(deporte);
        em.getTransaction().commit();
        em.close();
    }

    public void eliminar(int id) {
        EntityManager em = emf.createEntityManager();
        Deporte deporte = em.find(Deporte.class, id);
        if (deporte != null) {
            em.getTransaction().begin();
            em.remove(deporte);
            em.getTransaction().commit();
        }
        em.close();
    }
}
