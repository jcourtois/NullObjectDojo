package com.company;

public class Consultant {
    String name;

    Project currentProject;

    private double timeWorked = 0;
    private boolean hasACorporateApartment = false;
    private Country homeCountry;

    public Consultant(Country homeCountry) {
        this.homeCountry = homeCountry;
    }

    public void assignProject(Project project) {
        currentProject = project;
        project.addConsultant(this);
        if (homeCountry != currentProject.getCountry()) {
            hasACorporateApartment = true;
        }
        else {
            hasACorporateApartment = false;
        }
    }

    public Project getCurrentProject() {
        return currentProject;
    }

    public double getExpensableAmountForAirfare() {
        if (currentProject == null) {
            return 0;
        }
        else {
            return currentProject.getExpensableAirfare();
        }
    }

    public double getExpensableAmountForMeals() {
        if (currentProject == null) {
            return 0;
        }
        else {
            return currentProject.getExpensableMeals();
        }
    }

    public double getExpensableAmountForAccommodation() {
        if (currentProject == null) {
            return 0;
        }
        else {
            if (hasACorporateApartment == true) {
                return 0;
            }
            else {
                return currentProject.getExpensableAmountForAccommodation();
            }
        }
    }

    public double getExpensableAmountForSoftwareLicenses() {
        if (currentProject == null) {
            return 0;
        }
        else {
            return currentProject.getExpensableSoftware();
        }
    }

    public double getExpensableAmountForBooks() {
        return 150;
    }

    public double getExpensableAmountForPersonalHealthServices() {
        if (timeWorked < 6) {
            return 250;
        }
        else {
            return 500;
        }
    }

    public void hasWorkedAnotherMonth() {
        timeWorked++;
    }

    public boolean hasACorporateApartment() {
        return hasACorporateApartment;
    }
}
