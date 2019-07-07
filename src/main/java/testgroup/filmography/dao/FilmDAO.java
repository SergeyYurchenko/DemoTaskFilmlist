package testgroup.filmography.dao;

import testgroup.filmography.model.Film;

import java.util.List;

public interface FilmDAO {
    List<Film> allFilms();
    List<Film> searchFilms(String searchPart);
    void add(Film film);
    void delete(Film film);
    void edit(Film film);

    Film getById(int id);
}
