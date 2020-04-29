import org.efrei.l3.comparator.impl.StudentComparatorByAvgAndInscription;
import org.efrei.l3.comparator.impl.StudentComparatorByNoteTP;
import org.efrei.l3.model.Grade;
import org.efrei.l3.model.Grade;
import org.efrei.l3.model.Student;
import org.efrei.l3.util.StudentUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestMyCode {


    private static List<Student> initStudentsListExample() {
        List<Student> listeEtudiants = new ArrayList<>();
        listeEtudiants.add(new Student(1569000, new Grade<>(17), new Grade<>(16), new Grade<>(12)));
        listeEtudiants.add(new Student(1569001, new Grade<>(17), new Grade<>(13), new Grade<>(12)));
        listeEtudiants.add(new Student(1569003, new Grade<>(17), new Grade<>(18.5), new Grade<>(15)));
        listeEtudiants.add(new Student(1569002, new Grade<>(17), new Grade<>(18), new Grade<>(11)));
        listeEtudiants.add(new Student(1569005, new Grade<>(15), new Grade<>(18.0), new Grade<>(11)));

        return listeEtudiants;
    }

    private static void solution1(List<Student> listeEtudiants) {
        /*
         * Utilisation des comparateurs qui implémente l'interface Comparator<T> (méthode classique valable meme avant Java 8)
         */
        System.out.println("Méthode classique (avant Java 8)");
        listeEtudiants.sort(new StudentComparatorByAvgAndInscription()); //listeEtudiants is mutable
        //Affichage avec toString
        //System.out.println("Liste triée d'étudiants : " + listeEtudiants);
        //Affichge plus simple
        StudentUtil.displyStudentsListByAverage(listeEtudiants);

        Student meilleurEtudiantEnTP_1 = Collections.max(listeEtudiants, new StudentComparatorByNoteTP());
        System.out.println("L'étudiant qui a la meilleure note de TP ("+ meilleurEtudiantEnTP_1.getNoteTP()+") est " + meilleurEtudiantEnTP_1.getNumeroInscription());
        System.out.println();
    }

    private static void solution2(List<Student> listeEtudiants) {
        /*
         * 1. Utilisation des classes anonymes
         */

        listeEtudiants.sort(new Comparator<Student>() {
            public int compare(Student o1, Student o2) {
                int compraringResult = o1.calculateAverage().compareTo(o2.calculateAverage());
                if (compraringResult != 0) {
                    return compraringResult;
                }
                return  o1.getNumeroInscription().compareTo(o2.getNumeroInscription());
            }
        });
        //System.out.println("Liste triée d'étudiants par moyenne: " + listeEtudiants);
        //Affichge plus simple
        StudentUtil.displyStudentsListByAverage(listeEtudiants);

        Student meilleurEtudiantEnTP_2 = Collections.max(listeEtudiants, new Comparator<Student>() {
            public int compare(Student o1, Student o2) {
                return o1.getNoteTP().compareTo(o2.getNoteTP());
            }
        });
        System.out.println("Le numéro d'inscription de l'étudiant qui a la meilleure note de TP("+ meilleurEtudiantEnTP_2.getNoteTP()+") est " + meilleurEtudiantEnTP_2.getNumeroInscription());
        System.out.println();
    }

    private static void solution3(List<Student> listeEtudiants) {
        /*
         * 2. Comparer en Java 8 en utilisant les lambda expressions :) (chapitre 3)
         */
        System.out.println("Avec l'utilisation des expressions lambda ");
        //Creation d'un comparateur d'étudiants avec la moyenne
        Comparator<Student> comparerParMoyenne = Comparator.comparing( Student::calculateAverage );
        //Creation d'un comparateur d'étudiants avec le numéro d'inscription
        Comparator<Student> comparerParNumeroInscription = Comparator.comparing( Student::getNumeroInscription );
        //Comparer avec : la moyenne et le numéro d'inscription (plusieurs champs)
        Comparator<Student> compareByAvgAndNumInscription = comparerParMoyenne.thenComparing(comparerParNumeroInscription);
        //Tri en utilisant le comparateur
        listeEtudiants.sort(compareByAvgAndNumInscription);
        //System.out.println("Liste triée d'étudiants par leurs moyennes: " + listeEtudiants);
        //Affichge plus simple
        StudentUtil.displyStudentsListByAverage(listeEtudiants);

        Comparator<Student> comparerParNoteTP = Comparator.comparing( Student::getNoteTP );
        Student meilleurEtudiantEnTP_3 = Collections.max(listeEtudiants, comparerParNoteTP);
        System.out.println("Le numéro d'inscription de l'étudiant qui a la meilleure note de TP ("+ meilleurEtudiantEnTP_3.getNoteTP()+") est " + meilleurEtudiantEnTP_3.getNumeroInscription());
        System.out.println();
    }

    private static void solution4(List<Student> listeEtudiants) {
        /*
         * 3. Encore du java 8 avec l'utilisation des streams ;)  (Chapitre 4)
         */
        System.out.println("Avec Stream API");
        Comparator<Student> compareByAvgAndNumInscription2 = Comparator
                .comparing(Student::calculateAverage)
                .thenComparing(Student::getNumeroInscription);
        //System.out.println("Liste triée d'étudiants par moyenne: " + listeEtudiants.stream().sorted( compareByAvgAndNumInscription2 ).collect(Collectors.toList()));
        //Affichge plus simple
        StudentUtil.displyStudentsListByAverage(listeEtudiants.stream().sorted( compareByAvgAndNumInscription2 ).collect(Collectors.toList()));

        Student meilleurEtudiantEnTP_4 = (Student)listeEtudiants.stream().max(Comparator.comparing(Student::getNoteTP)).get();
        System.out.println("Le numéro d'inscription de l'étudiant qui a la meilleure note de TP ("+ meilleurEtudiantEnTP_4.getNoteTP()+") est " + meilleurEtudiantEnTP_4.getNumeroInscription());
        System.out.println();
    }

    public static void main(String[] args) {

        List<Student> listeEtudiants = initStudentsListExample();
        System.out.println("Liste initiale d'étudiants : " + listeEtudiants);

        solution1(listeEtudiants);

        //Autres solutions
        solution2(listeEtudiants);
        solution3(listeEtudiants);
        solution4(listeEtudiants);
        //on pourrait avoir encore d'autres façons différentes de celles mentionnées ci-dessus..
    }


}
