package org.efrei.l3.comparator.impl;

import org.efrei.l3.comparator.StudentComparator;
import org.efrei.l3.model.Student;
import org.jetbrains.annotations.NotNull;

public class StudentComparatorByNoteTP implements StudentComparator {

    @Override
    public int compare(@NotNull Student o1, @NotNull Student o2) {
        return o1.getNoteTP().compareTo(o2.getNoteTP());
    }
}
