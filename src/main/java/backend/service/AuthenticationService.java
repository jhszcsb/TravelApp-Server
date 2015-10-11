package backend.service;

import backend.entity.PersonalData;
import backend.entity.User;
import backend.repository.PersonalDataRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AuthenticationService {

    @Resource
    private PersonalDataRepository personalDataRepository;


    public User findUserByUsername(String username) {
        User user = new User();
        PersonalData personalData = personalDataRepository.findByUsername(username);
        user.setUsername(personalData.getUsername());
        user.setPassword(personalData.getPassword());
        return user;
        // todo: return personalDataRepository. ;
    }
}
