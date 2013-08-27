package com.company;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class ConsultantTest {
    @Test
    public void newConsultantsDoNotHaveProjects() {
        Consultant consultant = new Consultant(Country.USA);
        assertThat(consultant.getCurrentProject(), is(nullValue()));
    }

    @Test
    public void canAssignProjectToConsultant() {
        Consultant consultant = new Consultant(Country.USA);
        //final?
        Project project = new Project(Country.USA);
        assertThat(project.hasConsultant(consultant), is(false));

        consultant.assignProject(project);
        assertThat(consultant.getCurrentProject(), is(project));
        assertThat(project.hasConsultant(consultant), is(true));
    }

    @Test
    public void whenConsultantHasNoProjectThenTheyShouldNotHaveCorporateApartment() {
        Consultant consultant = new Consultant(Country.USA);
        assertThat(consultant.hasACorporateApartment(),is(false));
    }

    @Test
    public void whenConsultantHasProjectInHomeCountryThenTheyShouldNotHaveCorporateApartment() {
        Consultant consultant = new Consultant(Country.USA);
        assertThat(consultant.hasACorporateApartment(), is(false));

        Project project = new Project(Country.USA);
        consultant.assignProject(project);
        assertThat(consultant.hasACorporateApartment(), is(false));
    }

    @Test
    public void whenConsultantHasProjectOutOfHomeCountryThenTheyShouldHaveACorporateApartment() {
        Consultant consultant = new Consultant(Country.USA);
        assertThat(consultant.hasACorporateApartment(), is(false));

        Project project = new Project(Country.Fiji);
        consultant.assignProject(project);
        assertThat(consultant.hasACorporateApartment(),is(true));
    }

    @Test
    public void whenConsultantHasExpensableAmountForAccommodationForProjectThenItShouldBeReturned() {
        double expensableAmountForAccomodation = Math.random();

        Consultant consultant = new Consultant(Country.USA);
        Project project = new Project(Country.USA);
        project.setExpensableAmountForAccomodation(expensableAmountForAccomodation);
        consultant.assignProject(project);
        assertThat(consultant.getExpensableAmountForAccommodation(),is(project.getExpensableAmountForAccommodation()));
    }

    @Test
    public void whenConsultantHasNoProjectThenExpensableAmountForAccomodationIsZero() {
        Consultant consultant = new Consultant(Country.USA);
        assertThat(consultant.getExpensableAmountForAccommodation(),is(0.0));
    }

    @Test
    public void whenConsultantHasExpensableAmountForAirfareForProjectThenItShouldBeReturned() {
        double expensableAmountForAirfare = Math.random();

        Consultant consultant = new Consultant(Country.USA);
        Project project = new Project(Country.USA);
        project.setExpensableAirfare(expensableAmountForAirfare);
        consultant.assignProject(project);
        assertThat(consultant.getExpensableAmountForAirfare(),is(project.getExpensableAirfare()));
    }

    @Test
    public void whenConsultantHasNoProjectThenExpensableAmountForAirfareIsZero() {
        Consultant consultant = new Consultant(Country.USA);
        assertThat(consultant.getExpensableAmountForAirfare(),is(0.0));
    }

    @Test
    public void whenConsultantHasExpensableAmountForMealsForProjectThenItShouldBeReturned() {
        double expensableAmountForMeals = Math.random();

        Consultant consultant = new Consultant(Country.USA);
        Project project = new Project(Country.USA);
        project.setExpensableMeals(expensableAmountForMeals);
        consultant.assignProject(project);
        assertThat(consultant.getExpensableAmountForMeals(),is(project.getExpensableMeals()));
    }

    @Test
    public void whenConsultantHasNoProjectThenExpensableAmountForMealsIsZero() {
        Consultant consultant = new Consultant(Country.USA);
        assertThat(consultant.getExpensableAmountForMeals(),is(0.0));
    }

    @Test
    public void whenConsultantHasExpensableAmountForForSoftwareLicenseThenItShouldBeReturned() {
        double expensableAmountForSoftwareLicense = Math.random();

        Consultant consultant = new Consultant(Country.USA);
        Project project = new Project(Country.USA);
        project.setExpensableSoftware(expensableAmountForSoftwareLicense);
        consultant.assignProject(project);
        assertThat(consultant.getExpensableAmountForSoftwareLicenses(),is(project.getExpensableSoftware()));
    }

    @Test
    public void whenConsultantHasNoProjectThenExpensableAmountForSoftwareLicenseIsZero() {
        Consultant consultant = new Consultant(Country.USA);
        assertThat(consultant.getExpensableAmountForSoftwareLicenses(),is(0.0));
    }

    @Test
    public void whenConsultantHasWorkedLessThanSixMonthsThenExpensablePersonalHealthServicesIsTwoHundredAndFifty() {
        Consultant consultant = new Consultant(Country.USA);
        consultant.hasWorkedAnotherMonth();
        consultant.hasWorkedAnotherMonth();
        consultant.hasWorkedAnotherMonth();
        consultant.hasWorkedAnotherMonth();
        consultant.hasWorkedAnotherMonth();
        assertThat(consultant.getExpensableAmountForPersonalHealthServices(),is(250.0));
    }

    @Test
    public void whenConsultantHasWorkedAtLeastSixMonthsThenExpensablePersonalHealthServicesIsFiveHundred() {
        Consultant consultant = new Consultant(Country.USA);
        consultant.hasWorkedAnotherMonth();
        consultant.hasWorkedAnotherMonth();
        consultant.hasWorkedAnotherMonth();
        consultant.hasWorkedAnotherMonth();
        consultant.hasWorkedAnotherMonth();
        consultant.hasWorkedAnotherMonth();
        assertThat(consultant.getExpensableAmountForPersonalHealthServices(), is(500.0));
    }

    @Test
    public void expensableAmountForBooksIsOneHundredFifty() {
        Consultant consultant = new Consultant(Country.USA);
        assertThat(consultant.getExpensableAmountForBooks(), is(150.0));
    }
}
