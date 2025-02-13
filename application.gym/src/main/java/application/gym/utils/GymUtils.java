package application.gym.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GymUtils {

    private GymUtils(){

    }
    public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus) {
        return new ResponseEntity<String>("{\"message\":\""+responseMessage+"\"}", httpStatus);
    }
}
