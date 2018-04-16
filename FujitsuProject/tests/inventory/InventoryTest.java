package inventory;

import film.Film;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InventoryTest {
    @Test
    public void addFilmToInventoryTest() {
        Film film1 = new Film("Inception", "Regular film", true);
        Inventory inventory = new Inventory();
        assertEquals(0, inventory.getFilms().size());
        inventory.addFilm(film1);
        assertEquals(1, inventory.getFilms().size());
    }

    @Test
    public void changeFilmTypeTest() {
        Film film1 = new Film("Inception", "Regular film", true);
        Inventory inventory = new Inventory();
        inventory.addFilm(film1);
        assertEquals("Regular film", film1.getType());
        inventory.changeFilmType(film1, "New release");
        assertEquals("New release", film1.getType());
    }

    @Test
    public void deleteFilmFromInventoryTest() {
        Film film1 = new Film("Inception", "Regular film", true);
        Inventory inventory = new Inventory();
        inventory.addFilm(film1);
        assertEquals(1, inventory.getFilms().size());
        inventory.deleteFilm(film1);
        assertEquals(0, inventory.getFilms().size());
    }

    @Test
    public void availableFilmsTest() {
        Film film1 = new Film("Inception", "Regular film", false);
        Inventory inventory = new Inventory();
        inventory.addFilm(film1);
        assertEquals(0, inventory.getAvailableFilms().size());
    }
}
