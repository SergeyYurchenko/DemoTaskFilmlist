package testgroup.filmography.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import testgroup.filmography.exceptions.FilmException;
import testgroup.filmography.model.Film;
import testgroup.filmography.service.FilmService;


import java.util.List;


@Controller
public class FilmController extends RuntimeException {

    private FilmService filmService;

    @Autowired
    public void setFilmService(FilmService filmService) {
        this.filmService = filmService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView allFilms() {
        List<Film> films = filmService.allFilms();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("films");
        modelAndView.addObject("filmsList", films);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id) {
        Film film = filmService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("film", film);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editFilm(@ModelAttribute("film") Film film) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        filmService.edit(film);
        return modelAndView;
    }

    @RequestMapping(value = "/add-page", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }

    @RequestMapping(value = "/add-operation", method = RequestMethod.POST)
    public ModelAndView addFilm(@ModelAttribute("film") Film film) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        filmService.add(film);
        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteFilm(@PathVariable("id") int id)  {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("redirect:/");
        Film film = filmService.getById(id);
        System.out.println("Film controller used");
        if(film==null){
            FilmException filmException = new FilmException();
            filmException.nullIDFilm();
            System.out.println("Film is null");

        }
        filmService.delete(film);
        return modelAndView;

    }

    @RequestMapping(value = "/search-page", method = RequestMethod.GET)
    public ModelAndView search() {
        System.out.println("Controller SEARCH started");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("searchFilms");
        return modelAndView;
    }

    @RequestMapping(value="/search-film", method = RequestMethod.GET)
    public ModelAndView searchFilm(String searchPart) {
        List<Film> films = filmService.searchFilms(searchPart);
        System.out.println("I'm working"+ searchPart);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        modelAndView.addObject("filmsList", films);
        return modelAndView;
    }





}