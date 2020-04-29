public class TestGenericBoxExo1 {

    public static void main (String[] args) {

        Integer oi1 = 3 ; // équivalent à : Integer oi1 = new Integer(3) . Notez l'autoboxing
        Integer oi2 = 5 ;
        Integer oi3 = 12 ;
        GenericBoxExo1 <Integer> genericBoxInteger = new GenericBoxExo1<Integer> (oi1, oi2, oi3) ;
        //Ou encore en profitant du : déduction de type et diamond syntax
        GenericBoxExo1 <Integer> genericBoxInteger2 = new GenericBoxExo1<> (3, 5, oi3) ;
        genericBoxInteger.affiche () ;
        genericBoxInteger2.affiche () ;
        Integer thirdElement = genericBoxInteger.getTroisieme() ;
        System.out.println("Troisieme element du GenericBoxExo1 genericBoxInteger = " + thirdElement ) ;


        GenericBoxExo1 <Double> genericBoxDouble = new GenericBoxExo1 <Double> (2.0, 12.0, 2.5) ;
        GenericBoxExo1 <Double> genericBoxDouble2 = new GenericBoxExo1<> (2.0, 12.0, 2.5) ;
        // on peut fournir des arguments de type double qui seront
        // convertis automatiquement en Double
        genericBoxDouble.affiche() ;
        genericBoxDouble2.affiche() ;

        Double firstElement = genericBoxDouble2.getPremier () ;
        System.out.println ("Premier element du GenericBoxExo1 genericBoxInteger = " + firstElement ) ;
}
}