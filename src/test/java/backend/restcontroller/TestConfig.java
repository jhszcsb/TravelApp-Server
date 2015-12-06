package backend.restcontroller;

import backend.entity.PersonalData;
import backend.entity.Traveler;
import backend.repository.PersonalDataRepository;
import backend.repository.TravelerRepository;
import backend.service.FollowerService;
import backend.service.TravelerService;
import backend.service.TripService;
import org.junit.Before;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@Configuration
public class TestConfig {

    @Bean
    public TravelerService travelerService() {
        Traveler t = new Traveler();
        t.setId(1);
        t.setPersonaldata(new PersonalData());
        t.getPersonaldata().setUsername("testuser");
        TravelerService mockedService = Mockito.mock(TravelerService.class);
        Mockito.when(mockedService.findById(1)).thenReturn(t);
        return mockedService;
    }

    @Bean
    public TravelerController travelerController() {
        Traveler t = new Traveler();
        t.setId(1);
        t.setPersonaldata(new PersonalData());
        t.getPersonaldata().setUsername("testuser");
        TravelerController mockedController = Mockito.mock(TravelerController.class);
        Mockito.when(mockedController.getTravelerById(1)).thenReturn(t);
        return mockedController;
    }

    @Bean
    public TravelerRepository travelerRepository() {
        Traveler t = new Traveler();
        t.setId(1);
        t.setPersonaldata(new PersonalData());
        t.getPersonaldata().setUsername("testuser");
        TravelerRepository mockedRepository = Mockito.mock(TravelerRepository.class);
        Mockito.when(mockedRepository.findByPersonaldata_id(1)).thenReturn(t);
        return mockedRepository;
    }

    @Bean
    public PersonalDataRepository personalDataRepository() {
        return Mockito.mock(PersonalDataRepository.class);
    }

    /*@Bean
    public TripService tripService() {
        return Mockito.mock(TripService.class);
    }

    @Bean
    public FollowerService followerService() {
        return Mockito.mock(FollowerService.class);
    }*/

}