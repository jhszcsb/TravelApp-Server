package backend.repository;

import backend.entity.Traveler;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
public class CommonRepository {

    //private EntityManager em; // todo confiure entitymanager in webappconfig

    @Autowired
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public Traveler findById(String id) {
        return (Traveler) sessionFactory.getCurrentSession().createQuery("from Traveler t where t.id = :id ").setParameter("id", Integer.parseInt(id)).uniqueResult();
    }
}
