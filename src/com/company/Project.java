package com.company;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private double expensableAirfare;
    private double expensableMeals;
    private double expensableAmountForAccomodation;
    private double expensableSoftware;
    private Country country;

    private int idealNumberOfConsultantsForThisProject;
    private List<Consultant> consultantList = new ArrayList<Consultant>();

    public Project(Country country) {
        this(country, 0);
    }

    public Project(Country country, int idealNumberOfConsultantsForThisProject) {
        this.idealNumberOfConsultantsForThisProject = idealNumberOfConsultantsForThisProject;
        this.country = country;
    }

    public double getExpensableAirfare() {
        return expensableAirfare;
    }

    public double getExpensableMeals() {
        return expensableMeals;
    }

    public double getExpensableAmountForAccommodation() {
        return expensableAmountForAccomodation;
    }

    public double getExpensableSoftware() {
        return expensableSoftware;
    }

    public Country getCountry() {
        return country;
    }

    public void setExpensableAmountForAccomodation(double expensableAmountForAccomodation) {
        this.expensableAmountForAccomodation = expensableAmountForAccomodation;
    }

    public void setExpensableAirfare(double expensableAirfare) {
        this.expensableAirfare = expensableAirfare;
    }

    public void setExpensableMeals(double expensableMeals) {
        this.expensableMeals = expensableMeals;
    }

    public void setExpensableSoftware(double expensableSoftware) {
        this.expensableSoftware = expensableSoftware;
    }

    public void addConsultant(Consultant consultant) {
        consultantList.add(consultant);
    }

    public boolean hasConsultant(Consultant consultant) {
        return consultantList.contains(consultant);
    }
}
