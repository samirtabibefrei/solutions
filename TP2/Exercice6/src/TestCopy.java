import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestCopy {
    public static void main (String[] args) {

        List<? extends Integer> source = Arrays.asList(10, 20, 30);
        List<? super Integer> dest = Arrays.asList(-30, -20, -10);
        List<?> initialdest = new ArrayList(dest);
        Tools.copier(dest, source);
        System.out.println ("Copie :"+source + "->vers->" + initialdest + " = " + dest) ;

        List<Integer> source1 = Arrays.asList(10, 20, 30);
        List<Integer> dest1 = Arrays.asList(-50, -40, -30, -20, -10);
        List<Integer> initialdest1 = new ArrayList<>(dest1);
        Tools.copier(dest1, source1);
        System.out.println ("Copie :"+source1 + "->vers->" + initialdest1 + " = " + dest1) ;

        List<String> source2 = Arrays.asList("Java", "is", "best");
        List<String> dest2 = Arrays.asList("C++", "is", "good", "programming", "language");
        List<String> initialdest2 = new ArrayList<>(dest2);
        Tools.copier(dest2, source2);
        System.out.println ("Copie :"+source2 + "->vers->" + initialdest2 + " = " + dest2) ;
    }
}
