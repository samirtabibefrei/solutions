class NamedPoint extends Pair<Integer> {
    private String name;

    public NamedPoint(Integer first, Integer second, String name) {
        super(first, second);
        this.name = name;
    }

    public void display() {
        System.out.print("nom = " + name + " - ");
        super.display();
    }
}