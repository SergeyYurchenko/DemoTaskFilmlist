package testgroup.filmography.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import testgroup.filmography.exceptions.FilmNotExistsException;
import testgroup.filmography.model.Film;
import testgroup.filmography.service.FilmService;


import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class FilmController {

    private FilmService filmService;

    @Autowired
    public void setFilmService(FilmService filmService)  {
        this.filmService = filmService;
    }

    private static final Logger log = Logger.getLogger(Film.class);

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView allFilms() {
        List<Film> films = filmService.allFilms();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("films");
        modelAndView.addObject("filmsList", films);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") Integer id) throws FilmNotExistsException {
        Film film = filmService.getById(id);
        if (film == null) {
            throw new FilmNotExistsException(
                    String.format("Film with id %s not exists", id));
        }
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
    public ModelAndView deleteFilm(@PathVariable("id") int id) throws FilmNotExistsException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Film film = filmService.getById(id);
        if (film == null) {
            throw new FilmNotExistsException(
                    String.format("Film with id %s not exists", id));
        }
        filmService.delete(film);
        return modelAndView;
    }

    @RequestMapping(value = "/search-page", method = RequestMethod.GET)
    public ModelAndView search() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("searchFilms");
        return modelAndView;
    }

    @RequestMapping(value="/search-film", method = RequestMethod.GET)
    public ModelAndView searchFilm(String searchPart) {
        List<Film> films = filmService.searchFilms(searchPart);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("films");
        modelAndView.addObject("filmsList", films);
        return modelAndView;
    }





}