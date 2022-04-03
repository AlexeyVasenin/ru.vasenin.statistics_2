package ru.vasenin.statistics_2;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        List<Passenger> list = ParceCsv.parceCsv();

        Statistic.getStatisticForPassengers(list, Statistic.FEMALE, Statistic.FEMALE_LIFE);
        Statistic.getStatisticForPassengers(list, Statistic.MALE, Statistic.MALE_DEATH);

        Statistic.countName(list);

    }


}
