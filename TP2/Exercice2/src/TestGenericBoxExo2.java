import java.util.Arrays;
import java.util.Collection;

public class TestGenericBoxExo2 {

    public static void main (String[] args) {
        String a = "Java is cool"; //
        Integer b = 5 ;
        Collection<Double> c = Arrays.asList(1.0, 2.0);  //Notez l'utilisation de la méthode générique asList de classe Arrays
        // Notez bien que l'interface Collection hérite de l'interface Iterable

        MonTypeComparable d = new MonTypeComparable(); //Noez bien l'utilisation d'un type qui implemente l'interface Comparable.
        // Vous avez decouvert une limite des types génériques. T implements Comparable n'est pas possible.

        GenericBoxExo2 <String, Integer, Collection<Double>, MonTypeComparable> genericBox = new GenericBoxExo2<> (a, b, c, d) ;

        System.out.println ("Affichage") ;
        genericBox.affiche();
}
}