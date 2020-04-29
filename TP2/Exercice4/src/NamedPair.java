class NamedPair<T> extends Pair<T> {
    private String name;

    public NamedPair(T first, T second, String name) {
        super(first, second);
        this.name = name;
    }

    public void display() {
        System.out.print("nom = " + name + " - ");
        super.display();
    }
}