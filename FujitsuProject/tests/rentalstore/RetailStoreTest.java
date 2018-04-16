package rentalstore;

import customer.Customer;
import film.Film;
import inventory.Inventory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RetailStoreTest {
    @Test
    public void rentARegularTypeFilmTest() {
        Film film1 = new Film("Inception", "Regular film", true);
        Inventory inventory = new Inventory();
        inventory.addFilm(film1);
        RetailStore retailStore = new RetailStore();
        Customer customer = new Customer("Bob");
        assertEquals(0, customer.getPaymentSum());
        assertEquals(0, customer.getBonusPoints());
        retailStore.rentAFilm(customer, film1, 2, inventory);
        assertEquals(3, customer.getPaymentSum());
        assertEquals(1, customer.getBonusPoints());

    }

    @Test
    public void rentANewReleaseTypeFilmTest() {
        Film film1 = new Film("Justice League", "New release", true);
        Inventory inventory = new Inventory();
        inventory.addFilm(film1);
        RetailStore retailStore = new RetailStore();
        Customer customer = new Customer("Bob");
        assertEquals(0, customer.getPaymentSum());
        assertEquals(0, customer.getBonusPoints());
        retailStore.rentAFilm(customer, film1, 3, inventory);
        assertEquals(12, customer.getPaymentSum());
        assertEquals(2, customer.getBonusPoints());


    }

    @Test
    public void rentAnOldFilmTest() {
        Film film1 = new Film("Pulp Fiction", "Old film", true);
        Inventory inventory = new Inventory();
        inventory.addFilm(film1);
        RetailStore retailStore = new RetailStore();
        Customer customer = new Customer("Bob");
        assertEquals(0, customer.getPaymentSum());
        assertEquals(0, customer.getBonusPoints());
        retailStore.rentAFilm(customer, film1, 6, inventory);
        assertEquals(8, customer.getPaymentSum());
        assertEquals(1, customer.getBonusPoints());
    }

    @Test
    public void rentEachTypeOfFilmForOneDayTest() {
        Film film1 = new Film("Pulp Fiction", "Old film", true);
        Film film2 = new Film("Inception", "Regular film", true);
        Film film3 = new Film("Justice League", "New release", true);
        Inventory inventory = new Inventory();
        inventory.addFilm(film1);
        inventory.addFilm(film2);
        inventory.addFilm(film3);
        RetailStore retailStore = new RetailStore();
        Customer customer = new Customer("Bob");
        assertEquals(0, customer.getPaymentSum());
        assertEquals(0, customer.getBonusPoints());
        retailStore.rentAFilm(customer, film1, 1, inventory);
        retailStore.rentAFilm(customer, film2, 1, inventory);
        retailStore.rentAFilm(customer, film3, 1, inventory);
        assertEquals(12, customer.getPaymentSum());
        assertEquals(4, customer.getBonusPoints());

    }

    @Test
    public void rentEachTypeOfFilmForSixDaysTest() {
        Film film1 = new Film("Pulp Fiction", "Old film", true);
        Film film2 = new Film("Inception", "Regular film", true);
        Film film3 = new Film("Justice League", "New release", true);
        Inventory inventory = new Inventory();
        inventory.addFilm(film1);
        inventory.addFilm(film2);
        inventory.addFilm(film3);
        RetailStore retailStore = new RetailStore();
        Customer customer = new Customer("Bob");
        assertEquals(0, customer.getPaymentSum());
        assertEquals(0, customer.getBonusPoints());
        retailStore.rentAFilm(customer, film1, 6, inventory);
        retailStore.rentAFilm(customer, film2, 6, inventory);
        retailStore.rentAFilm(customer, film3, 6, inventory);
        assertEquals(44, customer.getPaymentSum());
        assertEquals(4, customer.getBonusPoints());

    }

    @Test
    public void rentAFilmWhichIsNotInTheInventoryTest() {
        Film film1 = new Film("Pulp Fiction", "Old film", true);
        Film film2 = new Film("Inception", "Regular film", true);
        Inventory inventory = new Inventory();
        inventory.addFilm(film1);
        RetailStore retailStore = new RetailStore();
        Customer customer = new Customer("Bob");
        assertEquals(0, customer.getPaymentSum());
        assertEquals(0, customer.getBonusPoints());
        retailStore.rentAFilm(customer, film2, 3, inventory);
        assertEquals(0, customer.getPaymentSum());
        assertEquals(0, customer.getBonusPoints());

    }

    @Test
    public void rentAFilmWithBonusPointsTest() {
        Film film1 = new Film("Justice League", "New release", true);
        Inventory inventory = new Inventory();
        inventory.addFilm(film1);
        RetailStore retailStore = new RetailStore();
        Customer customer = new Customer("Bob");
        assertEquals(0, customer.getPaymentSum());
        assertEquals(0, customer.getBonusPoints());
        customer.setBonusPoints(27);
        retailStore.rentAFilmWithBonusPoints(customer, film1, 1, inventory);
        assertEquals(0, customer.getPaymentSum());
        assertEquals(4, customer.getBonusPoints());
    }

    @Test
    public void rentAFilmWithBonusPointsButWrongType() {
        Film film1 = new Film("Inception", "Regular film", true);
        Inventory inventory = new Inventory();
        inventory.addFilm(film1);
        RetailStore retailStore = new RetailStore();
        Customer customer = new Customer("Bob");
        customer.setBonusPoints(25);
        assertEquals(25, customer.getBonusPoints());
        retailStore.rentAFilmWithBonusPoints(customer, film1, 2, inventory);
        assertEquals(25, customer.getBonusPoints());
    }

    @Test
    public void returnAFilmOnTimeTest() {
        Film film1 = new Film("Inception", "Regular film", true);
        Inventory inventory = new Inventory();
        inventory.addFilm(film1);
        RetailStore retailStore = new RetailStore();
        Customer customer = new Customer("Bob");
        retailStore.rentAFilm(customer, film1, 2, inventory);
        assertEquals(3, customer.getPaymentSum());
        retailStore.submitRent(customer);
        retailStore.returnAFilm(customer, film1, 2);
        assertEquals(0, customer.getPaymentSum());
    }

    @Test
    public void lateFilmReturnTest() {
        Film film1 = new Film("Inception", "Regular film", true);
        Inventory inventory = new Inventory();
        inventory.addFilm(film1);
        RetailStore retailStore = new RetailStore();
        Customer customer = new Customer("Bob");
        retailStore.rentAFilm(customer, film1, 2, inventory);
        assertEquals(3, customer.getPaymentSum());
        retailStore.submitRent(customer);
        retailStore.returnAFilm(customer, film1, 3);
        assertEquals(3, customer.getPaymentSum());

    }
}
