package backend.restcontroller;

import backend.entity.PersonalData;
import backend.entity.Traveler;
import backend.service.TravelerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// Use MockitoJUnitRunner for testing with mocked context
@RunWith(MockitoJUnitRunner.class)
// Use SpringJUnit4ClassRunner for testing with real context
/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebAppConfig.class})
@WebAppConfiguration*/
public class TravelerServiceTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Mock
    private TravelerService travelerServiceMock;

    @Mock
    private TravelerController travelerControllerMock;

    @Before
    public void setUp() {
        TravelerController mockedController = Mockito.mock(TravelerController.class);
        Traveler t = new Traveler();
        t.setId(1);
        t.setPersonaldata(new PersonalData());
        t.getPersonaldata().setUsername("testuser");
        Mockito.when(mockedController.getTravelerById(1)).thenReturn(t);
        mockMvc = MockMvcBuilders.standaloneSetup(mockedController).build();
    }

    // This test uses the live database:
    @Test
    public void validateGetTravelers() throws Exception {
        mockMvc.perform(get("/travelers"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }

    // This test uses the live database:
    @Test
    public void validateGetTraveler1LiveDatabase() throws Exception {
        mockMvc.perform(get("/travelers/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.personaldata.username").value("csabi"));
    }

    // This test uses the mocked context:
    @Test
    public void validateGetTraveler1MockedContext() throws Exception {
        mockMvc.perform(get("/travelers/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.personaldata.username").value("testuser"));
    }

}