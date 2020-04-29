package org.efrei.l3.model;

import org.efrei.l3.exception.InvalidGradeException;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Grade<T extends Number> implements  Comparable<Grade<T>> {

    public static final Integer MAX_NOTE = 20;
    T value;

    public Grade(T value) {
        this.value = value;
    }

    void setValue(final T note) throws InvalidGradeException {
        if (note.intValue() < 0 || note.intValue() > MAX_NOTE)
            throw new InvalidGradeException("org.efrei.l3.model.Note non valide");
        this.value = note;
    }

    public T getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Grade)) return false;
        Grade<?> grade = (Grade<?>) o;
        return value.equals(grade.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Note{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(@NotNull Grade<T> anotherNote) {
        return Double.compare(this.value.doubleValue(), anotherNote.getValue().doubleValue());
    }
}
