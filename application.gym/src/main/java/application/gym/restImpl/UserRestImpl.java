package application.gym.restImpl;

import application.gym.constents.GymConstants;
import application.gym.rest.UserRest;
import application.gym.service.UserService;
import application.gym.utils.GymUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserRestImpl implements UserRest {

    @Autowired
    UserService userService;
    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        try{
           return userService.signUp(requestMap);
        } catch (Exception ex) {
            ex.printStackTrace();

        }
     return GymUtils.getResponseEntity(GymConstants.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
