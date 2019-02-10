package Thread;

public class SynchThreadObject {
    public static void main(String[] args) {
        try {

            int nums1[] = {1, 2, 3, 5, 6, 7};
            int nums2[] = {1, 2, 3, 5, 8, 11, 50};
            ThreadSumArr_SynchBlock threadSumArr_SynchBlock1 = new ThreadSumArr_SynchBlock("SynchBlock#1", nums1,10);
            ThreadSumArr_SynchBlock threadSumArr_SynchBlock2 = new ThreadSumArr_SynchBlock("SynchBlock#2", nums2,2);

            // Theo dõi xem Luồng nào đc ngắt trước
            threadSumArr_SynchBlock1.thrd.join();
            System.out.println("Xong " + threadSumArr_SynchBlock1.thrd.getName());
            threadSumArr_SynchBlock2.thrd.join();
            System.out.println("Xong " + threadSumArr_SynchBlock2.thrd.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
