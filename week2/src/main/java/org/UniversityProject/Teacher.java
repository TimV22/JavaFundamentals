package org.UniversityProject;

import java.time.LocalDate;

public class Teacher extends User{

    public Teacher(String firstName, String lastName, LocalDate dateOfBirth, String password) {
        super(firstName, lastName, dateOfBirth, password);
    }

}
