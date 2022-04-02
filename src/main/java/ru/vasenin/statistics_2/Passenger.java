package ru.vasenin.statistics_2;

public class Passenger {

    private String survived;
    private String name;
    private String sex;
    private Double age;

    public Passenger() {
    }

    public Passenger(String survived, String name, String sex, Double age) {
        this.survived = survived;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getSurvived() {
        return survived;
    }

    public void setSurvived(String survived) {
        this.survived = survived;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(String age) {
        if (age.equals("")) {
            this.age = 0d;
        } else
            this.age = Double.parseDouble(age);
    }

    @Override
    public String toString() {
        return "Выживший " + survived + sex + "\n";
    }
}
