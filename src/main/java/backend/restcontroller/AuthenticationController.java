package backend.restcontroller;

import backend.entity.User;
import backend.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    // READ auth data
    @RequestMapping(value="/authenticationdata/{username}", method= RequestMethod.GET)
    public User findUserByUsername(@PathVariable String username) {
        return authenticationService.findUserByUsername(username);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorMessage handleErrors(Exception ex, HttpServletResponse response) {
        return new ErrorMessage(String.valueOf(response.getStatus()), ex.getMessage());
    }
}
