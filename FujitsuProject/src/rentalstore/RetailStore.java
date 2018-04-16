package rentalstore;

import customer.Customer;
import film.Film;
import inventory.Inventory;

import java.util.List;

public class RetailStore {

    private static final int BONUS_POINTS_NEEDED = 25;

    public void rentAFilm(Customer customer, Film film, int rentPeriodInDays, Inventory inventory) {
        boolean check = filmCheck(film, inventory);
        if (check) {
            customer.addFilm(film, rentPeriodInDays);
            film.setInStore(false);
        } else {
            System.out.println("Sorry, this film is not in our inventory");
        }
    }

    public void rentAFilmWithBonusPoints(Customer customer, Film film, int rentPeriodInDays, Inventory inventory) {
        if (film.getType().equals("New release")) {
            int bonusDays = customer.getBonusPoints() / BONUS_POINTS_NEEDED;
            boolean check = filmCheck(film, inventory);
            if (check) {
                customer.addFilmWithBonus(film, rentPeriodInDays, bonusDays);
                film.setInStore(false);
            } else {
                System.out.println("Sorry, this film is not in our inventory");
            }
        } else {
            System.out.println("Sorry, but you can only rent new releases with bonus points");
        }

    }

    private boolean filmCheck(Film film, Inventory inventory) {
        List<Film> availableFilms = inventory.getAvailableFilms();
        boolean filmCheck = false;
        for (Film availableFilm : availableFilms) {
            if (availableFilm.toString().equals(film.toString())) {
                filmCheck = true;
            }
        }
        return filmCheck;
    }

    public void submitRent(Customer customer) {
        System.out.println("Total price : " + customer.getPaymentSum() + " eur");
        customer.setPaymentSum(0);
    }

    public void returnAFilm(Customer customer, Film film, int rentedDays) {
        int extraDays = 0;
        if (customer.getRentedFilms().containsKey(film)) {
            if (customer.getRentedFilms().get(film) < rentedDays) {
                extraDays = rentedDays - customer.getRentedFilms().get(film);
            }
            customer.removeFilm(film, extraDays);
            film.setInStore(true);
        } else {
            System.out.println("You haven't rented this film!");
        }
    }

    public void submitReturns(Customer customer) {
        System.out.println("Total extra price : " + customer.getPaymentSum() + " eur");
        customer.setPaymentSum(0);
    }
}
