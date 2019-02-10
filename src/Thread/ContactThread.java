package Thread;

public class ContactThread {
    public static void main(String[] args) {
        TickTock tickTock = new TickTock();
        ThreadTickTock tick = new ThreadTickTock("Tick", tickTock);
        ThreadTickTock tock = new ThreadTickTock("Tock", tickTock);
    }
}
