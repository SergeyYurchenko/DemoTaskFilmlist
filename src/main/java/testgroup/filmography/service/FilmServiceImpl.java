package testgroup.filmography.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import testgroup.filmography.dao.FilmDAO;
import testgroup.filmography.model.Film;

import java.util.List;

/**
 * @author s.yurchenko
 */

@Service
public class FilmServiceImpl implements FilmService {

    private FilmDAO filmDAO;

    @Autowired
    public void setFilmDAOImpl(FilmDAO filmDAO) {
        this.filmDAO = filmDAO;
    }

    @Transactional
    @Override
    public List<Film> allFilms() {
        return filmDAO.allFilms();
    }

    @Transactional
    @Override
    public void add(Film film) {
        filmDAO.add(film);
    }

    @Transactional
    @Override
    public void delete(Film film) {
        filmDAO.delete(film);
    }

    @Transactional
    @Override
    public void edit(Film film) {
        filmDAO.edit(film);
    }

    @Transactional
    @Override
    public Film getById(int id) {
        return filmDAO.getById(id);
    }

    @Transactional
    @Override
    public List<Film> searchFilms(String searchPart) {
        return filmDAO.searchFilms(searchPart);
    }

}