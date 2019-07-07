package testgroup.filmography.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import testgroup.filmography.model.Film;

import java.util.*;

/**
 * @author s.yurchenko
 */

@Repository
public class FilmDAOImpl implements FilmDAO {

    private SessionFactory sessionFactory;
    private static final Logger log = Logger.getLogger(Film.class);

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Film> allFilms() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Film ").list();

    }

    @Override
    public void add(Film film) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(film);
    }

    @Override
    public void delete(Film film) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(film);
    }

    @Override
    public void edit(Film film) {
        Session session = sessionFactory.getCurrentSession();
        session.update(film);
    }

    @Override
    public Film getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Film.class, id);
    }

    @Override
    public List<Film> searchFilms(String searchPart) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Film where title like ('%" + searchPart + "%')").list();
    }

}
