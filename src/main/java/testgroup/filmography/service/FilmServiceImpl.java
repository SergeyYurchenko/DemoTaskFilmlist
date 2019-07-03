package testgroup.filmography.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import testgroup.filmography.dao.FilmDAO;
import testgroup.filmography.model.Film;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    private FilmDAO filmDAO;

    @Autowired
    public void setFilmDAOImpl(FilmDAO filmDAO) {
        this.filmDAO = filmDAO;
    }

    @Transactional
    public List<Film> allFilms() {
        return filmDAO.allFilms();
    }

    @Transactional
    public void add(Film film) {
        filmDAO.add(film);
    }

    @Transactional
    public void delete(Film film) {
        filmDAO.delete(film);
    }

    @Transactional
    public void edit(Film film) {
        filmDAO.edit(film);
    }

    @Transactional
    public Film getById(int id) {
        return filmDAO.getById(id);
    }

   /*Override
    public List<Film> search (String filmName,List<Film> list){
       return filmDAO.search(filmName,list);
    }*/
}