package main;

import customer.Customer;
import film.Film;
import inventory.Inventory;
import rentalstore.RetailStore;

public class Main {
    public static void main(String[] args) {
        Film film1 = new Film("Pulp Fiction", "Old film", true);
        Film film2 = new Film("Inception", "Regular film", true);
        Film film3 = new Film("Justice League", "New release", true);
        Inventory inventory = new Inventory();
        inventory.addFilm(film1);
        inventory.addFilm(film2);
        inventory.addFilm(film3);
        Customer customer = new Customer("Harry");
        RetailStore retailStore = new RetailStore();
        retailStore.rentAFilm(customer, film1, 6, inventory);
        retailStore.rentAFilm(customer, film2, 4, inventory);
        retailStore.rentAFilm(customer, film3, 2, inventory);
        retailStore.submitRent(customer);
        retailStore.returnAFilm(customer, film1, 7);
        retailStore.returnAFilm(customer, film2, 4);
        retailStore.returnAFilm(customer, film3, 3);
        retailStore.submitReturns(customer);
        customer.setBonusPoints(50);
        retailStore.rentAFilmWithBonusPoints(customer, film3, 3, inventory);
        retailStore.submitRent(customer);
        System.out.println(inventory.getAvailableFilms());
    }


}
