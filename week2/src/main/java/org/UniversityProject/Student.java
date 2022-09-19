package org.UniversityProject;

import java.time.LocalDate;

public class Student extends User{
    private String group;
    private int JavaMark;
    private int CSharpMark;
    private int PythonMark;
    private int PHPMark;

    public Student(String firstName, String lastName, LocalDate dateOfBirth, String password, String group) {
        super(firstName, lastName, dateOfBirth, password);
        this.group = group;
    }

    public Student(String firstName, String lastName, LocalDate dateOfBirth, String password, String group, int JavaMark, int CSharpMark, int PythonMark, int PHPMark) {
        super(firstName, lastName, dateOfBirth, password);
        this.group = group;
        this.JavaMark = JavaMark;
        this.CSharpMark = CSharpMark;
        this.PythonMark = PythonMark;
        this.PHPMark = PHPMark;
    }

    //getters
    public boolean getResult(){
        if (JavaMark >= 55 && CSharpMark >= 55 && PythonMark >= 55 && PHPMark >= 55){
            return true;
        }
        return false;
    }
    public int getRetakes(){
        int retakes = 0;
        if (JavaMark < 55){
            retakes++;
        }
        if (CSharpMark < 55){
            retakes++;
        }
        if (PythonMark < 55){
            retakes++;
        }
        if (PHPMark < 55){
            retakes++;
        }
        return retakes;
    }
    public String getGroup() {
        return group;
    }

    public int getJavaMark() {
        return JavaMark;
    }

    public int getCSharpMark() {
        return CSharpMark;
    }

    public int getPythonMark() {
        return PythonMark;
    }

    public int getPHPMark() {
        return PHPMark;
    }

    //setters
    public void setJavaMark(int JavaMark) {
        this.JavaMark = JavaMark;
    }

    public void setCSharpMark(int CSharpMark) {
        this.CSharpMark = CSharpMark;
    }

    public void setPythonMark(int PythonMark) {
        this.PythonMark = PythonMark;
    }

    public void setPHPMark(int PHPMark) {
        this.PHPMark = PHPMark;
    }
}
