package observer;

public class AppYoutube {
    public static void main(String[] args) {
        Youtuber prof = new Youtuber("Profssor Emerson");

        Subscriber andre = new Subscriber("André");
        Subscriber ana = new Subscriber("Ana");
        Subscriber lucas = new Subscriber("Lucas");

        prof.subscribe(andre);
        prof.subscribe(ana);
        prof.subscribe(lucas);

        prof.newVideo("Design Patterns");

        prof.unsubscribe(lucas);

        prof.online("Herança em POO");


    }
}
