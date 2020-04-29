package org.efrei.l3.util;

import org.efrei.l3.model.Student;

import java.text.DecimalFormat;
import java.util.List;

public class StudentUtil {

    public static void displyStudentsListByAverage(List<Student> studentList) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
        System.out.println("Liste triée d'étudiants par leurs moyennes: [");
        for (Student student : studentList) {
            System.out.println("{ Numéro d'inscription :"
                    + student.getNumeroInscription()+" , Moyenne : " + decimalFormat.format(student.calculateAverage()) + "}");
        }
        System.out.println("]");
    }
}
