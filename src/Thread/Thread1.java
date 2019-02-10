package Thread;

public class Thread1 implements Runnable {
    String threadName;

    public Thread1(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println(threadName + " bắt đầu chạy");
        for (int i = 0; i < 9; i++) {
            try {
                System.out.println(threadName + " đang đếm đến " + i);
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.out.println("Thread đã bị ngắt");
                e.printStackTrace();
            }
        }
        System.out.println(threadName + " đã đếm xong");
    }
}

class Thread2 implements Runnable {
    Thread thrd;

    Thread2(String threadName) {
        thrd = new Thread(this, threadName);
        thrd.start();
    }

    @Override
    public void run() {
        System.out.println(thrd.getName() + " bắt đầu chạy");
        for (int i = 0; i < 11; i++) {
            try {
                System.out.println(thrd.getName() + " đang đếm đến " + i);
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.out.println("Thread đã bị ngắt");
                e.printStackTrace();
            }
        }
        System.out.println(thrd.getName() + " đã đếm xong - PRIORITY : " + thrd.getPriority());
    }
}

class Thread3 extends Thread {

    public Thread3(String threadName) {
        super(threadName);
        start();
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " bắt đầu chạy");
        for (int i = 0; i < 9; i++) {
            try {
                System.out.println(this.getName() + " đang đếm đến " + i);
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.out.println("Thread đã bị ngắt");
                e.printStackTrace();
            }
        }
        System.out.println(this.getName() + " đã đếm xong");
    }
}

class SumArray {
    int sumOfArray = 0;

    synchronized int sumArr_Synch(int nums[], String name) {
        sumOfArray = 0;
        for (int i = 0; i < nums.length; i++) {
            try {
                sumOfArray += nums[i];
                System.out.println("Tổng hiện tại của " + Thread.currentThread().getName() + " trong sumArr_Synch là " + sumOfArray + "(" + name +")");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return sumOfArray;
    }

    int sumArr(int nums[], String name) {
        sumOfArray = 0;
        for (int i = 0; i < nums.length; i++) {
            try {
                sumOfArray += nums[i];
                System.out.println("Tổng hiện tại của " + Thread.currentThread().getName() + " trong sumArr là " + sumOfArray + "(" + name +")");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return sumOfArray;
    }
}

class ThreadSumArr_Synch implements Runnable {
    Thread thrd;
    int[] nums;
    static SumArray sumArray = new SumArray();

    public ThreadSumArr_Synch(String threadName, int[] nums, int priority) {
        this.thrd = new Thread(this, threadName);
        this.nums = nums;
        this.thrd.setPriority(priority);
        this.thrd.start();
    }

    @Override
    public void run() {
        System.out.println("Tổng kết quả của " + this.thrd.getName() + " : " + this.sumArray.sumArr_Synch(this.nums, "B"));
        System.out.println("---------------------");
    }
}

class ThreadSumArr_SynchBlock implements Runnable {
    Thread thrd;
    int[] nums;
    static SumArray sumArray = new SumArray();
    int answer;

    public ThreadSumArr_SynchBlock(String threadName, int[] nums, int priority) {
        this.thrd = new Thread(this, threadName);
        this.nums = nums;
        this.thrd.setPriority(priority);
        this.thrd.start();
    }

    @Override
    public void run() {
        synchronized (sumArray) {
            // p.thức sumArr không có từ khóa synchronized ở phía trước nên nó có thể sử dụng bất đồng bộ được
            // nhưng nếu nó được gọi và bao bọc bởi 1 khối synchronized thì sẽ đc đồng bộ gọi đến sử dụng
            answer = this.sumArray.sumArr(this.nums, "Block");
        }
        System.out.println("Tổng kết quả của " + this.thrd.getName() + " : " + answer);
        System.out.println("---------------------");
    }
}