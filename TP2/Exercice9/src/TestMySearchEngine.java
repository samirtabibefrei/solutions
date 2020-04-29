import java.util.*;

public class TestMySearchEngine {
    public static final String HELP_MSG = "Moteur de recherche - Manuel d'utilisation:\n"
            +"-Entrer 'Ajouter' ou 'Add'pour ajouter un élement: \n"
            +"-Entrer 'Supprimer' ou 'Remove' pour supprimer un élement: \n"
            +"-Entrer 'Chercher' ou 'Search' pour chercher un élement: \n"
            +"-Entrer 'Afficher' ou 'Show' pour afficher l'ensemble des données: \n"
            +"-Entrer 'Fermer' ou 'Close' pour arreter le programme \n";

    public static void main(String[] args) {
        Index monIndex = new Index();

        monIndex.add ("Java", 25) ;
        monIndex.add ("generics", 45) ;
        monIndex.add ("wildcards", 12) ;
        monIndex.add ("simpsons", 12) ;
        monIndex.add ("collection", 15) ;
        monIndex.add("are", 45) ;
        monIndex.add ("cool", 45) ;
        monIndex.add ("langage", 25) ;
        monIndex.add ("simpsons", 10) ;

        System.out.println("Contenu initial de l'index ");
        monIndex.displayIndex();

        System.out.println(HELP_MSG);

        //Programme interactif
        Scanner input = new Scanner(System.in);
        String nextStr = "";
        while (!nextStr.equalsIgnoreCase("close") && !nextStr.equalsIgnoreCase("fermer")) {
            System.out.println("Entrer une commande. Entrer 'help' en cas de besoin");
        while(input.hasNext() ) {

            nextStr = input.next();
            if ("afficher".equalsIgnoreCase(nextStr) || "show".equalsIgnoreCase(nextStr) ) {
                System.out.println("Contenu actuel de l'index: ");
                monIndex.displayIndex();
                break;
            }
            else if ("chercher".equalsIgnoreCase(nextStr) || "search".equalsIgnoreCase(nextStr) ) {
                System.out.print("Enter un mot à chercher:");
                String word = input.next();
                System.out.println("Résultats de recherche:");
                System.out.println("Pages: " + monIndex.search(word));
                break;
            }
            else if ("supprimer".equalsIgnoreCase(nextStr) || "remove".equalsIgnoreCase(nextStr) ) {
                System.out.print("Enter le mot à supprimer:");
                String word = input.next();
                System.out.println(monIndex.remove(word));
                System.out.println("Mot supprimé avec succès.");
                break;
            }
            else if ("ajouter".equalsIgnoreCase(nextStr) || "add".equalsIgnoreCase(nextStr)) {
                System.out.print("Enter le mot à ajouter:");
                String word = input.next();
                System.out.print("Enter les pages où se trouve le mot (entrer 'end' dès que vous terminez la saisie des pages):");
                //non-integer to terminate
                Set<Integer> pages = new TreeSet<>();
                while(input.hasNextInt()){
                    int pageNumber  = input.nextInt();
                    monIndex.add(word, pageNumber);
                    pages.add(pageNumber);
                }
                System.out.println("Mot:"+word+" ajouté dans la(es) page(s) " + pages);
                System.out.println(monIndex.search(word));
                break;
            }
            else  if (!nextStr.equalsIgnoreCase("close") && !nextStr.equalsIgnoreCase("fermer")){
                System.out.println(HELP_MSG);
            }
        }}
    }
}