import java.util.List;

public class MyClass <T> {
    T x ;  //OK
    T[] table1 ; //OK
    T[] table2 ; //OK

    public static T aField ; // Erreur de compilation! Interdit d'avoir un  champs statique d'un type générique
    public static int account ;

    void myMethod() {
        x = new T() ; //Erreur de compilation! L'instanciation d'un type générique est impossible.
        table2 = table1 ; // OK
        table2 = new T[5] ; // Erreur de compilation! L'instanciation d'un tableau d'un type générique est impossible
    }
    <V> void setMyField(V x) {
        this.x = x; //Erreur de compilation! Le type requis est T et non pas V
    }

    <U> void setMyField(T... x) {
        this.table1 = x; //OK vargs T... forment un tableau de type T[] , le type U est déclaré mais pas utilisé.
    }

    <V> MyClass(V x, V[] table1, T[] table2) {
        this.x = x; //Erreur de compilation! Le type requis est T et non pas V (meme si il est declaré par la méthode générique). Ils sont deux types différents.
        this.table1 = table1; //Erreur de compilation! Le type requis est T[] et non pas V
        this.table2 = table2; //OK !
    }



}