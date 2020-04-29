import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

class Index {
    public Index() {
        index = new TreeMap<>();
    }

    public void add(String entree, int numero) {
        TreeSet<Integer> numerosExistants = index.get(entree);
        if (numerosExistants == null) {
            TreeSet<Integer> numeroNouveauNom = new TreeSet<>();
            numeroNouveauNom.add(numero);
            index.put(entree, numeroNouveauNom);
        } else {
            numerosExistants.add(numero);
            index.put(entree, numerosExistants); // remplace l'entree
        }
    }

    public Set<Integer> remove(String entree) {
        return index.remove(entree);
    }

    public Set<Integer> search(String entree) {
        return index.get(entree);
    }

    public void displayIndex() {
        Set<Map.Entry<String, TreeSet<Integer>>> elementsIndex = index.entrySet();
        for (Map.Entry<String, TreeSet<Integer>> elementCourant : elementsIndex) {
            String entreeCourante = elementCourant.getKey();
            TreeSet<Integer> numeros = elementCourant.getValue();
            System.out.print(entreeCourante + " : ");
            for (int num : numeros) System.out.print(num + " ");
            System.out.println();
        }
    }

    protected TreeMap<String, TreeSet<Integer>> index;
}