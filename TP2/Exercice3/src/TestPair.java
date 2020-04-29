import java.util.HashMap;

public class TestPair {

    public static void main (String[] args) {

        HashMap<Pair<String, String>, String> map = new HashMap<Pair<String, String>, String>();

        map.put(new Pair<String, String>("jean-paul","sartre"),"mort");
        map.put(new Pair<String, String>("elvis","presley"),"vivant");
        map.remove(new Pair<String, String>("elvis","presley"));

        System.out.println(map);

        //Pourquoi le code ci-dessous n'affiche pas ce qu'il faut ?
        // l'unicité d'un objet de classe Pair<String, String> n'est pas claire ici.
        // C'est pour celà l'entrée (("elvis","presley") , "vivant")  n'a pas été supprimée de notre map.

        //Que doit-on faire pour résoudre le problème ?
        //Il faut faire l'override des méthodes de la calsse Object : hashCode et equals pour poivoir comparer les pairs entre eux.
        //Plusieurs IDE proposes une façon d'implémenter ces deux méthodes (comme intellij).
    }
}
