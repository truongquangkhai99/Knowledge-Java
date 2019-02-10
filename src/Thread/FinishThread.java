package Thread;

public class FinishThread {
    public static void main(String[] args) {
        Thread2 thread2 = new Thread2("#1");
        thread2.thrd.setPriority(Thread.NORM_PRIORITY);
        Thread2 thread21 = new Thread2("#2");
        thread21.thrd.setPriority(Thread.MIN_PRIORITY + 2);
        Thread2 thread22 = new Thread2("#3");
        thread22.thrd.setPriority(Thread.MAX_PRIORITY);
        do {
            try {
                System.out.println("Các thread kia còn chạy thì tôi vẫn chạy");
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        } while (thread2.thrd.isAlive() && thread21.thrd.isAlive() && thread22.thrd.isAlive());
        if (!thread2.thrd.isAlive()) {
            System.out.println("Thread " + thread2.thrd.getName() +" nó out rồi");
        }
        if (!thread21.thrd.isAlive()) {
            System.out.println("Thread " + thread21.thrd.getName() +" nó out rồi");
        }
        if (!thread22.thrd.isAlive()) {
            System.out.println("Thread " + thread22.thrd.getName() +" nó out rồi");
        }
        // Hoặc cách khác kiểm tra luồng đã bị out
        try {
            thread2.thrd.join();
            System.out.println("--> Thread " + thread2.thrd.getName() +" nó out rồi");
            thread21.thrd.join();
            System.out.println("--> Thread " + thread21.thrd.getName() +" nó out rồi");
            thread22.thrd.join();
            System.out.println("--> Thread " + thread22.thrd.getName() +" nó out rồi");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Wow! Tụi nó chạy xong rồi, Thread #main tôi cũng out thôi");

    }
}
