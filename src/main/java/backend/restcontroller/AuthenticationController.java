package backend.restcontroller;

import backend.entity.User;
import backend.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    // READ auth data
    @RequestMapping(value="/authenticationdata/{username}", method= RequestMethod.GET)
    public User findUserByUsername(@PathVariable String username) {
        return authenticationService.findUserByUsername(username);
    }
}
