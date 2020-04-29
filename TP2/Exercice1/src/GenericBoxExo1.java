
class GenericBoxExo1<T>
{   private T x, y, z ; // les trois éléments, notre triplet

    public GenericBoxExo1(T first, T second, T third) {
        x = first ; y = second ; z = third ;
    }

    public T getPremier() {
        return x ;
    }

    public T getSecond() {
        return y ;
    }

    public T getTroisieme() {
        return z ;
    }

    public void affiche() {
        //Exemple d'affichage. Utiliser Log4J si c'est possible. :)
        System.out.println ("Premiere valeur : " + x + " - Deuxieme valeur : " +  y + " - Troisieme valeur : " + z) ;
    }
}