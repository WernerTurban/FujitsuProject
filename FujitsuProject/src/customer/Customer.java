package customer;

import film.Film;
import price.Price;

import java.util.HashMap;
import java.util.Map;

public class Customer {
    private static final int BONUS_POINTS_NEEDED = 25;
    private String name;
    private Map<Film, Integer> rentedFilms = new HashMap<>();
    private int paymentSum = 0;
    private int bonusPoints = 0;

    public Customer(String name) {
        this.name = name;
    }

    public void calculateBonusPoints(Film film) {
        if (film.getType().equals("New release")) {
            bonusPoints += 2;
        } else {
            bonusPoints += 1;
        }

    }

    public void addFilm(Film film, int rentPeriodInDays) {
        rentedFilms.put(film, rentPeriodInDays);
        Price price = new Price();
        int filmPrice = price.calculatePrice(film, rentPeriodInDays);
        paymentSum += filmPrice;
        System.out.println(film.toString() + " " + rentPeriodInDays + " days " + filmPrice + " eur");
        calculateBonusPoints(film);

    }

    public void addFilmWithBonus(Film film, int rentPeriodInDays, int paidDaysWithBonusPoints) {
        int bonusPointsSpent = paidDaysWithBonusPoints * BONUS_POINTS_NEEDED;
        if (paidDaysWithBonusPoints < rentPeriodInDays) {
            rentedFilms.put(film, rentPeriodInDays);
            Price price = new Price();
            int daysToPay = rentPeriodInDays - paidDaysWithBonusPoints;
            int filmPrice = price.calculatePrice(film, daysToPay);
            paymentSum += filmPrice;
            System.out.println(film.toString() + " " + rentPeriodInDays + " days ," + " Paid with: " + bonusPointsSpent
                    + " bonus points and with: " + filmPrice + " eur");
            bonusPoints = bonusPoints - bonusPointsSpent;
        } else {
            System.out.println(film.toString() + " " + rentPeriodInDays + " days ," + " Paid with: " + bonusPointsSpent
                    + " bonus points");
            bonusPoints = bonusPoints - bonusPointsSpent;
        }
        calculateBonusPoints(film);
        System.out.println("Remaining bonus points: " + bonusPoints);

    }

    public void removeFilm(Film film, int extraDays) {
        rentedFilms.remove(film);
        if (extraDays > 0) {
            Price price = new Price();
            int extraPrice = price.calculatePrice(film, extraDays);
            paymentSum += extraPrice;
            System.out.println(film.toString() + " " + extraDays + " extra days " + extraPrice + " eur");
        } else {
            System.out.println(film.toString() + " no extra days");
        }

    }

    public void setPaymentSum(int paymentSum) {
        this.paymentSum = paymentSum;
    }

    public String getName() {
        return name;
    }

    public Map<Film, Integer> getRentedFilms() {
        return rentedFilms;
    }

    public int getPaymentSum() {
        return paymentSum;
    }

    public int getBonusPoints() {
        return bonusPoints;
    }

    public void setBonusPoints(int bonusPoints) {
        this.bonusPoints = bonusPoints;
    }
}
