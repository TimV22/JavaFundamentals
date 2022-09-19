package org.UniversityProject;

import java.time.*;

public abstract class User {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String password;

    public User(String firstName, String lastName, LocalDate dateOfBirth, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public boolean checkPassword(String password) {
        return password.equals(this.password);
    }

    public int getAge(){
        LocalDate currentDate = LocalDate.now();
        return Period.between(dateOfBirth, currentDate).getYears();
    }

}
