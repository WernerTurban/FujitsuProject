package inventory;

import film.Film;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Film> films = new ArrayList<>();
    private List<Film> availableFilms = new ArrayList<>();


    public void addFilm(Film film) {
        films.add(film);
    }

    public void deleteFilm(Film film) {
        films.remove(film);
    }

    public void changeFilmType(Film film, String newType) {
        film.setType(newType);
    }

    public List<Film> getFilms() {
        return films;
    }

    public List<Film> getAvailableFilms() {
        availableFilms.clear();
        for (Film film : films) {
            if (film.isInStore()) {
                availableFilms.add(film);
            }
        }
        return availableFilms;
    }
}
