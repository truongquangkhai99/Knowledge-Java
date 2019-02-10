package IO;

import java.io.*;

public class IO_Lession {
    public static void main(String args[]) {
        System.out.println("Demo sử dụng luồng byte");
        String data = "This is data - Đây là data nha";
        try (FileOutputStream fileOutputStream = new FileOutputStream("example1.txt")) {
            fileOutputStream.write(data.getBytes());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try (FileInputStream fileInputStream = new FileInputStream("example1.txt")) {
            int i;
            do {
                i = fileInputStream.read();
                if (i != -1)
                System.out.print((char) i);
            } while(i != -1);
            System.out.println("\nLuồng byte không hõ trợ chuỗi Unicode UTF-8, nên dùng luồng ký tự gói luồng byte để xuất ra được Unicode UTF-8");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Data Stream xử lý với dữ liệu kiểu nguyên thủy");
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("example2.dat"))) {
            dataOutputStream.writeUTF("This is a string");
            dataOutputStream.writeInt(22);
            dataOutputStream.writeBoolean(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("example2.dat"))) {
            System.out.println(dataInputStream.readUTF());
            System.out.println(dataInputStream.readInt());
            System.out.println(dataInputStream.readBoolean());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Demo sử dùng luồng ký tự");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("example3.txt")))) {
            bufferedWriter.write("Tôi yêu Java");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("example3.txt")))) {
            System.out.println(bufferedReader.readLine());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try (FileWriter fileWriter = new FileWriter("example4.txt")) {
            fileWriter.write("Tôi muốn lương trên 1000$");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try (FileReader fileReader = new FileReader("example4.txt")) {
            int i;
            do {
                i = fileReader.read();
                if (i != -1) System.out.print((char) i);
            } while(i != -1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("example4.txt"))) {
            System.out.println(bufferedReader.readLine());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
