package testgroup.filmography.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import testgroup.filmography.model.Film;

import javax.sql.DataSource;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class FilmDAOImpl implements FilmDAO {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(1);
    private static Map<Integer, Film> films = new HashMap<>();
    @Autowired
    private DataSource ds;
    static {
        Film film1 = new Film();
        film1.setId(AUTO_ID.getAndIncrement());
        film1.setTitle("Inception");
        film1.setYear(2010);
        film1.setGenre("sci-fi");
        film1.setWatched(true);
        film1.setLanguage("UA");
        films.put(film1.getId(), film1);
    }
    @Override
    public List<Film> allFilms() {
        //System.out.println("ds is"+ds);
        return new ArrayList<>(films.values());
    }

    @Override
    public void add(Film film) {
        film.setId(AUTO_ID.getAndIncrement());
        films.put(film.getId(), film);
    }

    @Override
    public void delete(Film film) {
        films.remove(film.getId());
    }

    @Override
    public void edit(Film film) {
        films.put(film.getId(), film);
    }

    @Override
    public Film getById(int id) {
        return films.get(id);
    }

   /* @Override
    public List<Film> search (String filmName,List<Film> list) {
        Film nameFilms;
        int symbolPosition;
        for (int i=0;i<list.size();i++){
          nameFilms=list.get(i);
            symbolPosition=nameFilms.getTitle().indexOf(filmName);
            if(symbolPosition==-1){

            }
        }
        return new ArrayList<>(films.values());
    }*/
}
