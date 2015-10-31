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
    public List<Trip> findAllTripsOfFriendsForTraveler(String name) {
        // todo: optimize query
        return (List<Trip>) sessionFactory.getCurrentSession()
                .createSQLQuery("select trip.* from trip, traveler, friendship_data, personal_data" +
                        "        where personal_data.username = :name" +
                        "        and traveler.personaldata_id = personal_data.id" +
                        "        and friendship_data.traveler1_id = traveler.personaldata_id" +
                        "        and trip.traveler_id = friendship_data.traveler2_id;")
                .setParameter("name", name).list();
    }


    // Find all trips os friends of a Traveler by traveler name
    /*
    select trip.* from trip, traveler, friendship_data, personal_data
        where personal_data.username = "testuser"
        and traveler.personaldata_id = personal_data.id
        and friendship_data.traveler1_id = traveler.personaldata_id
        and trip.traveler_id = friendship_data.traveler2_id;
    */

    // Find all trips for a Traveler by name
    // TODO: write better join
    //select trip.traveler_id, trip.timeline_id, trip.gallery_id, trip.places_id from trip, personal_data, traveler
    //where personal_data.username = "testuser" and personal_data.id = traveler.personaldata_id and traveler.id = trip.traveler_id;


    /*@Transactional
    public List<Traveler> findFriendshipsForTraveler(int id) {
        // todo rename to findFriends and implement separate getfriendship with all friendshipdata
        return (List<Traveler>) sessionFactory.getCurrentSession().
                createSQLQuery("select t.* from traveler t right join friendship_data f on f.traveler2_id = t.id where f.traveler1_id = :id").
                setParameter("id", id).list();
    }*/

    /*@Transactional
    public List<Trip> findTripsForTraveler(int id) {
        return (List<Trip>) sessionFactory.getCurrentSession().
                createSQLQuery("select * from Trip t where t.traveler_id = :id ").setParameter("id", id).list();
    }*/

    /*@Transactional
    public Traveler findById(int id) {
        return (Traveler) sessionFactory.getCurrentSession().createQuery("from Traveler t where t.id = :id ").setParameter("id", id).uniqueResult();
    }*/
}
