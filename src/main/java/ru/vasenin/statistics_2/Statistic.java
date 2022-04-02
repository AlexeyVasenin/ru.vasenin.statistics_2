package ru.vasenin.statistics_2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Statistic {

    public static void averageAge(List<Passenger> passengers) {

        Stream<Passenger> passengerStream =
                passengers.stream()
                        .filter(passenger -> "female".equals(passenger.getSex()))
                        .filter(passenger -> "1".equals(passenger.getSurvived()));

        List<Passenger> females = passengerStream.collect(Collectors.toList());
        for (Passenger female : females) {
            System.out.printf(String.valueOf(female));
        }
    }


}
