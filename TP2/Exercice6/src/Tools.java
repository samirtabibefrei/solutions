import java.util.List;
import java.util.ListIterator;

public class Tools {
    public static <T> void copier(List<? super T> destination, List<? extends T> source) {
        int srcSize = source.size();
        if (srcSize > destination.size())
            throw new IndexOutOfBoundsException("La liste source est plus grande que la liste de destination");

        ListIterator<? super T> destIterator = destination.listIterator();
        ListIterator<? extends T> srcIterator = source.listIterator();
        for (int i=0; i<srcSize; i++) {
            destIterator.next();
            destIterator.set(srcIterator.next());
        }
    }
}
