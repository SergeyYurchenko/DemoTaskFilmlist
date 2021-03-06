package testgroup.filmography.dao;

import testgroup.filmography.model.Film;

import java.util.List;

/**
 * DAO class for database operation with Film
 * @author s.yurchenko
 */

public interface FilmDAO {
    /**
     * Get all films
     * @return List of films
     */
    List<Film> allFilms();

    /**
     *  search film with searchPart in title
     * @param searchPart
     * @return List of film wich contains "searchPart"
     */
    List<Film> searchFilms(String searchPart);

    /**
     * Add film to the base
     * @param film
     */
    void add(Film film);

    /**
     * Delete film from the base
     * @param film
     */
    void delete(Film film);

    /**
     * Edit film in base with Id
     * @param film
     */
    void edit(Film film);

    /**
     * Search film with Id to delete or edit
     * @param id
     * @return id film
     */
    Film getById(int id);
}
