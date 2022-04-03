package ru.vasenin.statistics_2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Passenger {

    private Integer survived;
    private String name;
    private String sex;
    private Double age;

    public Passenger() {
    }

    public Passenger(Integer survived, String name, String sex, Double age) {
        this.survived = survived;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public void setSurvived(String survived) {
        if (!survived.equals("")) {
            this.survived = Integer.parseInt(survived);
        } else this.survived = 0;

    }

    public void setAge(String age) {
        if (age.equals("")) {
            this.age = 0d;
        } else this.age = Double.parseDouble(age);
    }
}
