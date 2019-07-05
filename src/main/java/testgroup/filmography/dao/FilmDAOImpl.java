package testgroup.filmography.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import testgroup.filmography.model.Film;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class FilmDAOImpl implements FilmDAO {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(1);



    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Film> allFilms() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Film ").list();
    }




    public void add(Film film) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(film);
    }


    public void delete(Film film) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(film);
    }


    public void edit(Film film) {
        Session session = sessionFactory.getCurrentSession();
        session.update(film);
    }


    public Film getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Film.class, id);
    }

    public List<Film> searchFilms(String searchPart) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Film where title like (:searchPart)").list();
    }

}
