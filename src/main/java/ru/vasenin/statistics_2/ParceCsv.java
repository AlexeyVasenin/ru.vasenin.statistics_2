package ru.vasenin.statistics_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParceCsv {

    private static final String DATA_FILE_CSV = "src/main/resources/train.csv";

    public static List<Passenger> parceCsv() throws IOException {

        List<Passenger> passengers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(DATA_FILE_CSV))) {
            List<String> fileLines = br
                    .lines()
                    .skip(1)
                    .collect(Collectors.toList());

            for (String fileLine : fileLines) {
                String[] splitText = fileLine.split(",");
                ArrayList<String> columnList = new ArrayList<>();

                for (String s : splitText) {
                    if (isColumnPart(s)) {
                        String lastText = columnList.get(columnList.size() - 1);
                        columnList.set(columnList.size() - 1,
                                lastText + "," + s);
                    } else {
                        columnList.add(s);
                    }
                }

                Passenger passenger = new Passenger();
                passenger.setSurvived(columnList.get(1));
                passenger.setName(columnList.get(3));
                passenger.setSex(columnList.get(4));
                passenger.setAge(columnList.get(5));
                passengers.add(passenger);
            }
            return passengers;
        }
    }

    private static boolean isColumnPart(String text) {
        String trimText = text.trim();
        return trimText.indexOf("\"") == trimText.lastIndexOf("\"") && trimText.endsWith("\"") || trimText.endsWith("\"\"\"") || trimText.endsWith(")\"");

    }

}
