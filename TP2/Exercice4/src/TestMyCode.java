public class TestMyCode {
    public static void main(String[] args) {
        Pair<Double> cd1 = new Pair<>(5.0, 2.5);
        cd1.display();

        Pair<Double> cd2 = new Pair<>(7.0, 2.5);
        cd2.display();

        NamedPair<String> cns
                = new NamedPair<>("hello", "bonjour", "salut");
        cns.display();

        NamedPair<Pair<Double>> cnd
                = new NamedPair<>(cd1, cd2, "cf1");
        cnd.display();

        NamedPoint p1 = new NamedPoint(2, 5, "Point1");
        p1.display();
    }
}