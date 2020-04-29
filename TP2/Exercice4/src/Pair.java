class Pair<T> {
    private T x, y ;
    public Pair(T first, T second) {
        x = first ; y = second ;
    }
    public void display() {
        System.out.println ("Paire : (" + x + "," + y + ")") ;
    }
}
