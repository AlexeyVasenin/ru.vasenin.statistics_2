package ru.vasenin.statistics_2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Statistic {

    public static final String FEMALE = "female";
    public static final String MALE = "male";
    public static final Integer FEMALE_LIFE = 1;
    public static final Integer MALE_DEATH = 0;

    public static void countName(List<Passenger> passengers) {
        Map<Integer, Integer> numberOfRepetitions = new HashMap<>();

        for (Passenger passenger : passengers) {
            numberOfRepetitions.compute(passenger.getName().length(), (k, v) -> (v == null) ? 1 : v + 1);
        }

        for (Map.Entry<Integer, Integer> item : numberOfRepetitions.entrySet()) {
            System.out.println("Длина имени: " + item.getKey() + " " + "Кол-во раз повторяется: " + item.getValue());
        }
    }

    public static void getStatisticForPassengers(List<Passenger> passengers, String sex, Integer survived) {

        double age = 0d;
        int countPassenger = 0;

        List<Passenger> arrSortPassenger = passengers.stream()
                .filter(passenger -> sex.equals(passenger.getSex()))
                .filter(passenger -> survived.equals(passenger.getSurvived()))
                .collect(Collectors.toList());

        switch (sex) {
            case FEMALE:
                for (Passenger passenger : arrSortPassenger) {
                    age += passenger.getAge();
                    countPassenger++;

                    System.out.printf("Name: %s, Sex: %s, Age: %s \n", passenger.getName(), passenger.getSex(), passenger.getAge());
                }
                if (countPassenger != 0) {
                    System.out.println("Средний возраст выживших женщин: " + age / countPassenger);
                } else System.out.println("Кол-во пассажиров = 0");
                break;
            case MALE:
                for (Passenger passenger : arrSortPassenger) {
                    age += passenger.getAge();
                    countPassenger++;

                    System.out.printf("Name: %s, Sex: %s, Age: %s \n", passenger.getName(), passenger.getSex(), passenger.getAge());
                }
                if (countPassenger != 0) {
                    System.out.println("Средний возраст утонувших мужчин: " + age / countPassenger);
                } else System.out.println("Кол-во пассажиров = 0");
                break;
            default:
                break;
        }
    }
}
