import java.util.*;

public class Tools {

    public static <T> T chooseRandomly(Collection<T> x, Collection<T> y) {
        return chooseRandomly(chooseRandomly(x), chooseRandomly(y));
    }

    public static <T> T chooseRandomly(T x, T y) {
        double v = Math.random();
        if (v < 0.5)
            return x;
        else
            return y;
    }

    //Non demandée dans l'exercice, mais seulement les bons étudiants pensent à varargs au lieu de deux élements
    public static <T> T chooseRandomly(T... array) {
        int randomIndex = new Random().nextInt(array.length);
        return array[randomIndex];
    }

    public static <T> T chooseRandomly(Collection<T> collection) {
        int randomIndex = new Random().nextInt(collection.size());
        int index = -1;
        for(T element: collection) if (++index == randomIndex) return element;
        return null;
    }
}
