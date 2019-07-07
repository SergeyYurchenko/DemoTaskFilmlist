package testgroup.filmography.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import testgroup.filmography.exceptions.FilmNotExistsException;


@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = Logger.getLogger(GlobalExceptionHandler.class);

    @ResponseStatus(value = HttpStatus.NOT_FOUND,
            reason = "This ID Film is not found")
    @ExceptionHandler(FilmNotExistsException.class)
    public void filmNotExists(FilmNotExistsException exception) {
        log.error("Film not exists", exception);
    }


    @ExceptionHandler(Exception.class)
    public ModelAndView unhandledException(Exception exception) {
        log.error("Unexpected error", exception);
        ModelAndView m = new ModelAndView("error");
        m.addObject("errorMessage", exception.getMessage());
        return m;
    }

}
