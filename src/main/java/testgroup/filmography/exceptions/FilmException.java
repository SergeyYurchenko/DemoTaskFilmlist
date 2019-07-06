package testgroup.filmography.exceptions;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;




@ControllerAdvice
public class FilmException {
private static final Logger log = Logger.getLogger(FilmException.class);
    @ResponseStatus(value=HttpStatus.BAD_REQUEST,
            reason="This ID Film is not found")
    @ExceptionHandler(IllegalArgumentException.class)
    public void nullIDFilm(){
        System.out.println("Method throws Exception started");
        log.info("Method nullIDFilm in FilmException");

    }


}
