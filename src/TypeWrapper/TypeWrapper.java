package TypeWrapper;

import static java.lang.System.out;
import static java.lang.Math.pow;

public class TypeWrapper {
    public static void main(String[] args) {
        System.out.println("Đóng hộp (boxing) thủ công - đưa 1 giá trị nguyên thủy vào hàm tạo của Class bảo kiểu");
        Integer integer = new Integer(100);
        System.out.println("Mở hộp (unboxing) thủ công - gọi p.thức init");
        int intNguyenThuy = integer.intValue();
        System.out.println("Auto Boxing (Đóng hộp tự động)");
        System.out.println(integer + " - " + intNguyenThuy);
        Integer integerAuto = 100; // tự động đóng gói giá trị số nguyên thủy 100 vào 1 đối tượng Integer
        System.out.println("Mở hộp tự động");
        int intAuto = integerAuto; // tự động mở hộp 1 đối tượng Integer lấy giá trị nguyên thủy ra để gán cho 1 biến nguyên thủy
        System.out.println("Có bằng nhau : " + (integerAuto == intAuto)); // đối tượng integerAuto tự động mở hợp lấy giá trị nguyên thủy ra so sánh với intAuto
        Integer intObj = 100;
        System.out.println("++intObj sẽ mở hộp cộng giá trị lên 101 rồi đóng hộp lại\nBan đầu : " + intObj);
        ++intObj;
        intObj += 10;
        System.out.println("Sau đó : " + intObj);
        // tránh lạm dũng auto box như thế này
        Integer int1,int2,int3;
        int1 = 10;
        int2 = 20;
        int3 = 30;
        Integer avgInt = (int1 + int2 + int3) / 3;
        System.out.println("Chạy được với Avg Int là " + avgInt);
        // vì nếu đóng mở hộp nhiều quá làm tốn kém tài nguyên trong lúc chạy chương trình,
        // chỉ áp dụng khi cần thao tác với đối tượng vs các p.thức của Object cung cấp

        // ## Tính năng import tính, import static tức là chúng ta có thể gọi các p.thức static mà không cần thông qua tên lớp
        // Thường thì muốn in ra màn hình thì
        System.out.println("Print Screen");
        // qua import static thì
        out.println("Pring Screen");
        out.println("5^2 = " + pow(5,2));
    }
}
