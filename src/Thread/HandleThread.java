package Thread;

class MyThread implements Runnable {

    Thread thread;
    boolean suspended;
    boolean stop;

    public MyThread(String threadName) {
        this.thread = new Thread(this, threadName);
        suspended = false;
        stop = false;
        this.thread.start();

    }

    @Override
    public void run() {
        System.out.println(this.thread.getName() + " bắt đầu chạy");
        try {
            for (int i = 1; i < 1000; i++) {
                System.out.print(i + " ");
                if (i % 10 == 0) {
                    System.out.println();
                    Thread.sleep(250);
                }
                synchronized (this) {
                    while (suspended) {
                        wait();
                    }
                    if (stop) {
                        break;
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Luồng " + this.thread.getName() + " bị ngắt");
            e.printStackTrace();
        }
        System.out.println("Luồng " + this.thread.getName() + " kết thúc");
    }

    synchronized void stopThread() {
        System.out.println("Dừng hẳn luồng");
        this.stop = true;
        this.suspended = false;
        notify();
    }

    synchronized void suspendedThread() {
        System.out.println("Tạm dừng luồng");
        this.suspended = true;
    }

    synchronized void resumeThread() {
        System.out.println("Khôi phục luồng");
        this.suspended = false;
        notify();
    }
}

public class HandleThread {
    public static void main(String[] args) {
        MyThread myThread = new MyThread("MyThread");
        try {
            Thread.sleep(1000);
            myThread.suspendedThread();
            Thread.sleep(1000);
            myThread.resumeThread();
            Thread.sleep(1000);
            myThread.suspendedThread();
            Thread.sleep(1000);
            myThread.resumeThread();
            Thread.sleep(1000);
            myThread.stopThread();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
