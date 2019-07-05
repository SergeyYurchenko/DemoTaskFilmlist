package testgroup.filmography.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class FilmException {

    @ResponseStatus(value=HttpStatus.BAD_REQUEST,
            reason="This ID Film is not found to delete")
    @ExceptionHandler(IllegalArgumentException.class)
    public void nullIDFilm(){
        System.out.println("Method throws Exception started");

    }
}
