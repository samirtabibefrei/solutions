import java.util.*;

public class TestRandomChoice {
    public static void main (String[] args) {

        Integer i1 = 3 ;
        Integer i2 = 5 ;
        String s1 = "Hello" ;
        String s2 = "Bonjour" ;
        System.out.println ("ChooseRandomly d'un element de l'un des deux String (+"+s1+", "+s2+") = " + Tools.chooseRandomly(s1, s2)) ;
        System.out.println ("ChooseRandomly d'un element de l'un des deux elemnts (+"+i1+", "+s1+") = " + Tools.chooseRandomly(i1, s1)) ;
        System.out.println ("ChooseRandomly d'un element de l'un de plusieurs elements (+"+i1+", "+i2+","+s1+", "+s2+") = " + Tools.chooseRandomly(i1, s1, i2, s2)) ;

        //List
        List<String> list1 = Arrays.asList(s1, s2, "Holà") ;
        List<String> list2 = Collections.singletonList("Guten Tag") ;
        List<Integer> list3 = Arrays.asList(i1, i2) ;
        List<Double> list4 = Arrays.asList(0.1, 2.2, 4.5) ;
        System.out.println ("ChooseRandomly d'un element de l'un des deux listes (+"+list1+", "+list2+")= " + Tools.chooseRandomly(list1, list2)) ;
        //La ligne ci-dessous choisit entre deux listes, mais ne retorune pas un élement précis car tout simplement les types sont différents
        System.out.println ("ChooseRandomly entre listes de type d'éléments différents (+"+list1+", "+list4+") ="+Tools.chooseRandomly(list1, list4, list3)) ; // It works ?? :)

        //Set
        Set<Integer> set1 = new TreeSet<>();
        set1.addAll(Arrays.asList(0, 2, 4, 6));
        Set<Integer> set2 = new HashSet<>(list3);
        System.out.println ("ChooseRandomly d'un element de l'un des deux sets (+"+set1+", "+set2+")= " + Tools.chooseRandomly(set1, set2)) ;

        //Queues
        Queue<Double> queue1 = new PriorityQueue<>();
        queue1.addAll(list4) ;
        Queue<Double> queue2 = new ArrayDeque<>();
        queue2.offer(10.0) ;
        System.out.println ("ChooseRandomly d'un element de l'un deux files (+"+queue1+", "+queue2+")= " + Tools.chooseRandomly(queue1, queue2)) ;

    }
}
