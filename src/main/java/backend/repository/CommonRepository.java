package backend.repository;

import backend.entity.Traveler;
import backend.entity.Trip;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CommonRepository {
    // TODO: remove this class and implement specific repository interfaces for these functionalities

    //private EntityManager em; // todo confiure entitymanager in webappconfig

    /*@Autowired
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }*/

    /*@Transactional
    public List<Traveler> findFriendshipsForTraveler(String id) {
        // todo rename to findFriends and implement separate getfriendship with all friendshipdata
        // todo create HQL query instead of sql query
        return (List<Traveler>) sessionFactory.getCurrentSession().
                createSQLQuery("select t.* from traveler t right join friendship_data f on f.traveler2_id = t.id where f.traveler1_id = :id").
                setParameter("id", Integer.parseInt(id)).list();
    }*/

    /*@Transactional
    public List<Trip> findTripsForTraveler(String id) {
        // todo create HQL query instead of sql query
        return (List<Trip>) sessionFactory.getCurrentSession().
                createSQLQuery("select * from Trip t where t.traveler_id = :id ").setParameter("id", Integer.parseInt(id)).list();
    }*/

    /*@Transactional
    public Traveler findById(String id) {
        return (Traveler) sessionFactory.getCurrentSession().createQuery("from Traveler t where t.id = :id ").setParameter("id", Integer.parseInt(id)).uniqueResult();
    }*/
}
