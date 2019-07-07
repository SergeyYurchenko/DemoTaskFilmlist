package testgroup.filmography.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import testgroup.filmography.exceptions.FilmNotExistsException;

/**
 * @author s.yurchenko
 */

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = Logger.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler({Exception.class, FilmNotExistsException.class})
    public ModelAndView unhandledException(Exception exception) {
        log.error("Unexpected error", exception);
        ModelAndView m = new ModelAndView("error");
        m.addObject("errorMessage", exception.getMessage());
        return m;
    }

}
