package Thread;

public class TickTock {
    String state;

    synchronized void tick(boolean running) {
        if (!running) {
            state = "ticked";
            notify();
            return;
        }
        System.out.println("Tick");
        state = "ticked";
        notify();
        try {
            while(!state.equals("tocked")) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void tock(boolean running) {
        if (!running) {
            state = "tocked";
            notify();
            return;
        }
        System.out.println("Tock");
        state = "tocked";
        notify();
        try {
            while(!state.equals("ticked")) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadTickTock implements Runnable {
    TickTock tickTock;
    Thread thread;

    ThreadTickTock(String threadName, TickTock tickTock) {
        this.thread = new Thread(this, threadName);
        this.tickTock = tickTock;
        this.thread.start();
    }

    @Override
    public void run() {
        if (this.thread.getName().equals("Tick")) {
            for (int i = 0; i < 5; i++) {
                this.tickTock.tick(true);
            }
            this.tickTock.tick(false);
        } else if (this.thread.getName().equals("Tock")){
            for (int i = 0; i < 5; i++) {
                this.tickTock.tock(true);
            }
            this.tickTock.tock(false);
        }
        return;
    }
}
