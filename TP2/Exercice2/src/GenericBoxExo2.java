import java.util.Comparator;

class GenericBoxExo2<T extends String, U extends Number, V extends Iterable, W extends MonTypeComparable>
{   private T x;
    private U y;
    private V z; // les trois éléments, notre triplet
    private W w;

    public GenericBoxExo2(T first, U second, V third, W quatrieme) {
        x = first ; y = second ; z = third ;
    }

    public T getPremier() {
        return x ;
    }

    public U getSecond() {
        return y ;
    }

    public V getTroisieme() {
        return z ;
    }

    public W getQuatrieme() {
        return w ;
    }

    public void affiche() {
        //Exemple d'affichage. Utiliser Log4J si c'est possible. :)
        System.out.println ("Premiere valeur : " + x + " - Deuxieme valeur : " +  y + " - Troisieme valeur : " + z + " - Quatrieme valeur : " + w) ;
    }
}