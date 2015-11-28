package backend.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Deprecated // DEPRECATED. This class can only be used for experimenting with Hibernate
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

    /*@Transactional
    public List<Trip> findAllTripsOfFriendsForTraveler(String name) {
        List<Trip> list = (List<Trip>) sessionFactory.getCurrentSession()
                .createQuery("select trip from Trip trip, Traveler traveler, FriendshipData friendship_data, PersonalData personal_data" +
                        "        where personal_data.username = :name" +
                        "        and traveler.personaldata = personal_data.id" +
                        "        and friendship_data.traveler1 = traveler.personaldata" +
                        "        and trip.traveler = friendship_data.traveler2")
                .setParameter("name", name).list();
        //System.out.println(list.get(0).getGallery().getUrl());
        return list;
    }*/


    // Find all trips os friends of a Traveler by traveler name
    /*
    select trip.* from trip, traveler, friendship_data, personal_data
        where personal_data.username = "testuser"
        and traveler.personaldata_id = personal_data.id
        and friendship_data.traveler1_id = traveler.personaldata_id
        and trip.traveler_id = friendship_data.traveler2_id;
    */

    // Find all trips for a Traveler by name
    // this is not efficient
    //select trip.traveler_id, trip.timeline_id, trip.gallery_id, trip.place_id from trip, personal_data, traveler
    //where personal_data.username = "testuser" and personal_data.id = traveler.personaldata_id and traveler.id = trip.traveler_id;


    /*@Transactional
    public List<Traveler> findFriendshipsForTraveler(int id) {
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
