public class Main {
    public static void main(String[] args) {

        Deck d = new Deck();

        for (int i = 0; i < 30; i++) {
            System.out.println(d.getCard(i));
        }
    }
}