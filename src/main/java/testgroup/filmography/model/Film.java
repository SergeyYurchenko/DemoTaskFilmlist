package testgroup.filmography.model;




import org.apache.log4j.Logger;


import javax.persistence.*;



@Entity
@Table(name = "films")
public class Film {
    private static final Logger log = Logger.getLogger(Film.class);


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private int year;

    @Column(name = "genre")
    private String genre;

    @Column(name = "watched")
    private boolean watched;

    @Column(name = "language")
    private String language;

    public int getId() {
        log.error("method getId in class film get error");
        return id;
    }

    public void setId(int id) {
        log.error("method setId in class film get error");
        this.id = id;
    }

    public String getTitle() {
        log.error("method getTitle in class film get error");
        return title;
    }

    public void setTitle(String title) {
        log.error("method setTitle in class film get error");
        this.title = title;
    }

    public int getYear() {
        log.error("method getTear in class film get error");
        return year;
    }

    public void setYear(int year) {
        log.error("method setYear in class film get error");
        this.year = year;
    }

    public String getGenre() {
        log.error("method getGenre in class film get error");
        return genre;
    }

    public void setGenre(String genre) {
        log.error("method setGenre in class film get error");
        this.genre = genre;
    }

    public boolean isWatched() {
        log.error("method isWatched in class film get error");
        return watched;
    }

    public void setWatched(boolean watched) {
        log.error("method setWatched in class film get error");
        this.watched = watched;
    }

    public String getLanguage() {
        log.error("method getLanguage in class film get error");
        return language;
    }

    public void setLanguage(String language) {
        log.error("method setLanguage in class film get error");
        this.language = language;
    }
}