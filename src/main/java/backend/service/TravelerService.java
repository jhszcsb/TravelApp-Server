package backend.service;

import backend.entity.Traveler;
import backend.repository.TravelerRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class TravelerService {

    @Resource
    private TravelerRepository travelerRepository;

    //@Resource
    //private CommonRepository commonRepository;

    @Transactional
    public List findAll() {
        return travelerRepository.findAll();
    }

    public void save(Traveler newTraveler) {
        travelerRepository.save(newTraveler);
    }

    @Transactional
    public Traveler findById(int id) {
        return travelerRepository.findOne(id);
    }

    @Transactional
    public void update(Traveler updatedTraveler) {
        travelerRepository.save(updatedTraveler);
    }

    public void deleteById(int id) {
        travelerRepository.delete(id);
    }
}
