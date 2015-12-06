package backend.service;

import backend.entity.PersonalData;
import backend.entity.Traveler;
import backend.repository.PersonalDataRepository;
import backend.repository.TravelerRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class TravelerService {

    @Resource
    private TravelerRepository travelerRepository;

    @Resource
    private PersonalDataRepository personalDataRepository;

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
    public Traveler findById (int id) throws TravelerNotFoundException {
        Traveler t = travelerRepository.findOne(id);
        if(t == null) {
            throw new TravelerNotFoundException("Traveler Not Found!");
        }
        return t;
    }

    @Transactional
    public void update(Traveler updatedTraveler) {
        travelerRepository.save(updatedTraveler);
    }

    public void deleteById(int id) {
        travelerRepository.delete(id);
    }

    @Transactional
    public PersonalData findByUsername(String name) {
        return personalDataRepository.findByUsername(name);
    }

    @Transactional
    public void updatePersonalData(PersonalData personalData) {
        personalDataRepository.save(personalData);
    }

    @Transactional
    public Traveler findByPersonalDataId(int id) {
        return travelerRepository.findByPersonaldata_id(id);
    }
}
