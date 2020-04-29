package org.efrei.l3.model;

import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;
import java.util.Objects;

public class Student {//implements Comparable<Student> {

    private static final int COEFFICIENT_NOTE_DE = 2;
    private static final int COEFFICIENT_NOTE_TP = 2;
    private static final int COEFFICIENT_NOTE_PROJET = 3;

    //Champs optionnels
    private String firstName;
    private String lastName;

    //Champs obligatoires
    private Integer  numeroInscription;
    private Grade<Number> noteDE;
    private Grade<Number> noteTP;
    private Grade<Number> noteProjet;

    public Student(Integer numeroInscription, Grade<Number> noteDE, Grade<Number> noteTP, Grade<Number> noteProjet) {
        this.numeroInscription = numeroInscription;
        this.noteDE = noteDE;
        this.noteTP = noteTP;
        this.noteProjet = noteProjet;
    }

    public Student(String firstName, String lastName, Integer numeroInscription, Grade<Number> noteDE, Grade<Number> noteTP, Grade<Number> noteProjet) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numeroInscription = numeroInscription;
        this.noteDE = noteDE;
        this.noteTP = noteTP;
        this.noteProjet = noteProjet;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getNumeroInscription() {
        return numeroInscription;
    }

    public void setNumeroInscription(Integer numeroInscription) {
        this.numeroInscription = numeroInscription;
    }

    public Grade<Number> getNoteDE() {
        return noteDE;
    }

    public void setNoteDE(Grade<Number> noteDE) {
        this.noteDE = noteDE;
    }

    public Grade<Number> getNoteTP() {
        return noteTP;
    }

    public void setNoteTP(Grade<Number> noteTP) {
        this.noteTP = noteTP;
    }

    public Grade<Number> getNoteProjet() {
        return noteProjet;
    }

    public void setNoteProjet(Grade<Number> noteProjet) {
        this.noteProjet = noteProjet;
    }

    public Double calculateAverage() {
        return (this.noteDE.getValue().doubleValue()*COEFFICIENT_NOTE_DE
                + this.noteProjet.getValue().doubleValue()*COEFFICIENT_NOTE_PROJET
                + this.noteTP.getValue().doubleValue()*COEFFICIENT_NOTE_TP)
                / (COEFFICIENT_NOTE_DE + COEFFICIENT_NOTE_PROJET + COEFFICIENT_NOTE_TP);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(numeroInscription, student.numeroInscription) &&
                Objects.equals(noteDE, student.noteDE) &&
                Objects.equals(noteTP, student.noteTP) &&
                Objects.equals(noteProjet, student.noteProjet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, numeroInscription, noteDE, noteTP, noteProjet);
    }

    @Override
    public String toString() {
        return "Student{" +
                "numeroInscription=" + numeroInscription +
                ", noteDE=" + noteDE +
                ", noteTP=" + noteTP +
                ", noteProjet=" + noteProjet +
                '}';
    }

    /*@Override
    public int compareTo(@NotNull Student anotherStudent) {
        //Comparaison par la moyenne puis par le numéro d'inscription
        //  2 cas (moyenne supérieure à l'autre moyenne, moyenne inferieure à l'autre moyenne)
        //  + 3 en cas d'égalité de Moyenne --> là on se base sur la comparison des numéros d'inscription
        int comparingResult = this.calculateAverage().compareTo(anotherStudent.calculateAverage());
        if (comparingResult == 0) {
            comparingResult = this.numeroInscription.compareTo(numeroInscription);
        }

        return comparingResult;
    }*/
}
