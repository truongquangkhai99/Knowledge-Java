package Thread;

public class SynchThreadMethod {
    static SumArray sumArray1 = new SumArray();

    public static void main(String[] args) {
        try {
            Thread threadSynch1 = new Thread(() -> {
                int nums[] = {1, 2, 3, 5, 6, 7};
                System.out.println("Tổng kết quả của Synch#1 : " + sumArray1.sumArr_Synch(nums, "A"));
                System.out.println("---------------------");
            }, "Synch#1");

            Thread threadSynch2 = new Thread(() -> {
                int nums[] = {1, 2, 3, 5, 8, 11, 50};
                System.out.println("Tổng kết quả của Synch#2 : " + sumArray1.sumArr_Synch(nums, "A"));
                System.out.println("---------------------");
            }, "Synch#2");

            threadSynch2.start();
            threadSynch1.start();

            // cách khác
            int nums1[] = {1, 2, 3, 5, 6, 7};
            int nums2[] = {1, 2, 3, 5, 8, 11, 50};
            ThreadSumArr_Synch threadSumArr_Synch3 = new ThreadSumArr_Synch("Synch#3", nums1, 10);
            ThreadSumArr_Synch threadSumArr_Synch4 = new ThreadSumArr_Synch("Synch#4", nums2, 2);

            // Theo dõi xem Luồng nào đc ngắt trước
            threadSumArr_Synch4.thrd.join();
            System.out.println("Xong " + threadSumArr_Synch4.thrd.getName());
            threadSumArr_Synch3.thrd.join();
            System.out.println("Xong " + threadSumArr_Synch3.thrd.getName());

            // --------- Sử dụng tài nguyên bất đồng bộ --> Tính tổng bị sai (lúc lấy của Synch#5 để sum lúc thì lấy Synch#6 cho nên sum SAI
            Thread threadSynch5 = new Thread(() -> {
                int nums[] = {1, 2, 3, 5, 6, 7};
                System.out.println("Tổng kết quả của Synch#5 : " + sumArray1.sumArr(nums1, "C"));
                System.out.println("---------------------");
            }, "Synch#5");
            threadSynch5.start();
            Thread threadSynch6 = new Thread(() -> {
                int nums[] = {1, 2, 3, 5, 8, 11, 50};
                System.out.println("Tổng kết quả của Synch#6 : " + sumArray1.sumArr(nums2, "C"));
                System.out.println("---------------------");
            }, "Synch#6");
            threadSynch6.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
