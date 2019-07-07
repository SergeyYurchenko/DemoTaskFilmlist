package testgroup.filmography.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import testgroup.filmography.exceptions.FilmNotExistsException;
import testgroup.filmography.model.Film;
import testgroup.filmography.service.FilmService;
import java.util.List;

/**
 * Class FilmController contains all controller program
 * @author s.yurchenko
 */

@Controller
public class FilmController {

    private FilmService filmService;
    private static final Logger log = Logger.getLogger(Film.class);
    @Autowired
    public void setFilmService(FilmService filmService)  {
        this.filmService = filmService;
    }

    /**
     * Controller which find all films and send ifo to filmsList
     * @return list of films
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView allFilms() {
        List<Film> films = filmService.allFilms();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("films");
        modelAndView.addObject("filmsList", films);
        return modelAndView;
    }

    /**
     * Controller which find film with id and send to the editPage, if id is not find, throws Exception
     * @param id
     * @return info about film with id for edit
     * @throws FilmNotExistsException
     */
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

    /**
     * Controller which get id and set field in database then went to filmsList
     * @param film
     * @return edit info film
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editFilm(@ModelAttribute("film") Film film) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        filmService.edit(film);
        return modelAndView;
    }

    /**
     * Controller went to editPage and give users form enter new films
     * @return info about new film from users
     */
    @RequestMapping(value = "/add-page", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }

    /**
     * Controller which get information about film and write to the database
     * @param film
     * @return list of all films with new film
     */
    @RequestMapping(value = "/add-operation", method = RequestMethod.POST)
    public ModelAndView addFilm(@ModelAttribute("film") Film film) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        filmService.add(film);
        return modelAndView;
    }

    /**
     * Controller delete information with selected films
     * @param id
     * @return list of film without selected
     * @throws FilmNotExistsException
     */
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

    /**
     * Controller give users form for find films
     * @return searchPart of films
     */
    @RequestMapping(value = "/search-page", method = RequestMethod.GET)
    public ModelAndView search() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("searchFilms");
        return modelAndView;
    }

    /**
     * Controller take searchPart of films and rerurn film with this part
     * @param searchPart
     * @return film which contain searchPart
     */
    @RequestMapping(value="/search-film", method = RequestMethod.GET)
    public ModelAndView searchFilm(String searchPart) {
        List<Film> films = filmService.searchFilms(searchPart);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("films");
        modelAndView.addObject("filmsList", films);
        return modelAndView;
    }
}