package backend.restcontroller;

import backend.service.FollowerService;
import backend.service.TravelerService;
import backend.service.TripService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    public TravelerService travelerService() {
        return Mockito.mock(TravelerService.class);
    }

    @Bean
    public TripService tripService() {
        return Mockito.mock(TripService.class);
    }

    @Bean
    public FollowerService followerService() {
        return Mockito.mock(FollowerService.class);
    }

}