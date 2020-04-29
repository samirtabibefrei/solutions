package org.efrei.l3.comparator.impl;

import org.efrei.l3.comparator.StudentComparator;
import org.efrei.l3.model.Student;
import org.jetbrains.annotations.NotNull;

public class StudentComparatorByAvgAndInscription implements StudentComparator {

    @Override
    public int compare(@NotNull Student o1, @NotNull Student o2) {
        int compraringResult = o1.calculateAverage().compareTo(o2.calculateAverage());
        if (compraringResult != 0) {
            return compraringResult;
        }

        return  o1.getNumeroInscription().compareTo(o2.getNumeroInscription());
    }


}
