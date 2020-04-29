import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

class ReverseIndex extends Index {

    public ReverseIndex() {
        super();
    }

    public void createReverseIndex() {
        reverseIndex = new TreeMap<>();
        Set<Map.Entry<String, TreeSet<Integer>>> elementsIndex = super.index.entrySet();

        for (Map.Entry<String, TreeSet<Integer>> elementCourant : elementsIndex) {
            String entreeCourante = elementCourant.getKey();
            TreeSet<Integer> pagesCourantes = elementCourant.getValue();
            for (Integer numero : pagesCourantes) {
                TreeSet<String> entreesExistantes = reverseIndex.get(numero);
                if (entreesExistantes == null) {
                    TreeSet<String> entreeNouveauNumero = new TreeSet<>();
                    entreeNouveauNumero.add(entreeCourante);
                    reverseIndex.put(numero, entreeNouveauNumero);
                } else {
                    entreesExistantes.add(entreeCourante);
                    reverseIndex.put(numero, entreesExistantes);
                }
            }
        }
    }

    public void displayReverseIndex() {
        if (reverseIndex == null) return;
        Set<Map.Entry<Integer, TreeSet<String>>> elementsIndexPage = reverseIndex.entrySet();
        for (Map.Entry<Integer, TreeSet<String>> numero :
                elementsIndexPage) {
            Integer numeroCourant = numero.getKey();
            TreeSet<String> entrees = numero.getValue();
            System.out.print(numeroCourant + " : ");
            for (String entree : entrees) System.out.print(entree + " ");
            System.out.println();
        }
    }

    public Set<String> search(Integer page) {
        return reverseIndex.get(page);
    }

    public Set<String> remove(Integer page) {
        return reverseIndex.remove(page);
    }

    private TreeMap<String, TreeSet<Integer>> index;
    private TreeMap<Integer, TreeSet<String>> reverseIndex;

}