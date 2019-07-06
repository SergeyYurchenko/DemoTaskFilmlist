package testgroup.filmography.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import testgroup.filmography.exceptions.FilmException;
import testgroup.filmography.model.Film;
import testgroup.filmography.service.FilmService;


import java.util.List;


@Controller
public class FilmController {

    private FilmService filmService;

    @Autowired
    public void setFilmService(FilmService filmService)  {
        this.filmService = filmService;
    }
    FilmException filmException = new FilmException();
    private static final Logger log = Logger.getLogger(Film.class);
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView allFilms() {
        List<Film> films = filmService.allFilms();
        ModelAndView modelAndView = new ModelAndView();
        log.error("method allFilms in class FilmController get error");
        modelAndView.setViewName("films");
        modelAndView.addObject("filmsList", films);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id) {
        Film film = filmService.getById(id);
        if(film==null){
            filmException.nullIDFilm();}
        log.error("method editPage in class FilmController get error");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("film", film);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editFilm(@ModelAttribute("film") Film film) {
        ModelAndView modelAndView = new ModelAndView();
        log.error("method editFilm in class FilmController get error");
        modelAndView.setViewName("redirect:/");
        filmService.edit(film);
        return modelAndView;
    }

    @RequestMapping(value = "/add-page", method = RequestMethod.GET)
    public ModelAndView addPage() {
        log.error("method addPage in class FilmController get error");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }

    @RequestMapping(value = "/add-operation", method = RequestMethod.POST)
    public ModelAndView addFilm(@ModelAttribute("film") Film film) {
        ModelAndView modelAndView = new ModelAndView();
        log.error("method addFilm in class FilmController get error");
        modelAndView.setViewName("redirect:/");
        filmService.add(film);
        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteFilm(@PathVariable("id") int id)  {
        ModelAndView modelAndView = new ModelAndView();
        log.error("method deleteFilm in class FilmController get error");
        modelAndView.setViewName("redirect:/");
        Film film = filmService.getById(id);
        System.out.println("Film controller used");
        if(film==null){
            filmException.nullIDFilm();
            System.out.println("Film is null");

        }
        filmService.delete(film);
        return modelAndView;

    }

    @RequestMapping(value = "/search-page", method = RequestMethod.GET)
    public ModelAndView search() {
        log.error("method deleteFilm in class FilmController get error");
        System.out.println("Controller SEARCH started");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("searchFilms");
        return modelAndView;
    }

    @RequestMapping(value="/search-film", method = RequestMethod.GET)
    public ModelAndView searchFilm(String searchPart) {
        List<Film> films = filmService.searchFilms(searchPart);
        log.error("method searchFilm in class FilmController get error");
        System.out.println("I'm working"+ searchPart);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("films");
        modelAndView.addObject("filmsList", films);
        return modelAndView;
    }





}