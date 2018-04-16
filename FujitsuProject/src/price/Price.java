package price;

import film.Film;

public class Price {


    private static final int PREMIUM_PRICE = 4;
    private static final int BASIC_PRICE = 3;
    private static final int REGULAR_FILM_FIRST_THREE_DAYS_PRICE = 3;
    private static final int OLD_FILM_FIRST_FIVE_DAYS_PRICE = 5;

    public int calculatePrice(Film film, int rentPeriodOfDays) {
        switch (film.getType()) {
            case "New release":
                return rentPeriodOfDays * PREMIUM_PRICE;
            case "Regular film":
                if (rentPeriodOfDays > REGULAR_FILM_FIRST_THREE_DAYS_PRICE) {
                    return REGULAR_FILM_FIRST_THREE_DAYS_PRICE + ((rentPeriodOfDays
                            - REGULAR_FILM_FIRST_THREE_DAYS_PRICE)
                            * BASIC_PRICE);
                } else {
                    return REGULAR_FILM_FIRST_THREE_DAYS_PRICE;
                }
            default:
                if (rentPeriodOfDays > OLD_FILM_FIRST_FIVE_DAYS_PRICE) {
                    return OLD_FILM_FIRST_FIVE_DAYS_PRICE + ((rentPeriodOfDays - OLD_FILM_FIRST_FIVE_DAYS_PRICE)
                            * BASIC_PRICE);
                } else {
                    return OLD_FILM_FIRST_FIVE_DAYS_PRICE;
                }
        }
    }
}
