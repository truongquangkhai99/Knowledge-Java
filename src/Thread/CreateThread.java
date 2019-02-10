package Thread;

public class CreateThread {
    public static void main(String[] args) {
        System.out.println("Cách tạo Thread - 1 class cài đè Runnable override run() --> đóng vài trò như class còn của Runnable \n " +
                "Class Thread có trách nhiệm start p.thức Run() của Runnable được truyền instance của Runnable thông qua hàm tạo của Thread");
        Thread thread1 = new Thread(new Thread1("Thread 1"));
        thread1.start();
        Thread thread1_2 = new Thread(new Thread1("Thread 2"));
        thread1_2.start();
        System.out.println("Cải tiến việc tạo luồng bằng cách đưa 1 Instance của Thread vào con của Runnable để start luôn khi tạo");
        Thread2 thread2 = new Thread2("#2");
        Thread3 thread3 = new Thread3("#3");
        Thread threadJava8 = new Thread(() -> {
            System.out.println("Thread Java 8 bắt đầu chạy");
            for (int i = 0; i < 9; i++) {
                try {
                    System.out.println("Thread Java 8 đang đếm đến " + i);
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    System.out.println("Thread đã bị ngắt");
                    e.printStackTrace();
                }
            }
            System.out.println("Thread Java 8 đã đếm xong");
        });
        threadJava8.start();
        System.out.print("Thread chính bắt đầu");
        long before = System.currentTimeMillis();
        for (int i = 0; i < 50; i++) {
            try {
                System.out.println(".");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long after = System.currentTimeMillis();
        System.out.println("Thread chính đã kết thúc - " + (after - before));
    }
}
