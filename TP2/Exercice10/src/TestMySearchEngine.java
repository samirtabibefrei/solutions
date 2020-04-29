public class TestMySearchEngine {
    public static void main(String[] args) {

        ReverseIndex monIndex = new ReverseIndex () ;
        monIndex.add ("Java", 25) ;
        monIndex.add ("generics", 45) ;
        monIndex.add ("wildcards", 12) ;
        monIndex.add ("simpsons", 12) ;
        monIndex.add ("collection", 15) ;
        monIndex.add("are", 45) ;
        monIndex.add ("cool", 45) ;
        monIndex.add ("langage", 25) ;
        monIndex.add ("simpsons", 10) ;

        monIndex.createReverseIndex() ;
        monIndex.displayReverseIndex() ;
    }
}