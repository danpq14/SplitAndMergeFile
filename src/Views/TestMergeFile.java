package Views;

import MergeFile.MergeFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestMergeFile {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Chương trình ghép file ");
        System.out.println("Nhập thư mục file đích : ");
        String dest = sc.nextLine();
        System.out.println("Nhập tên file đích : ");
        String nameDest = sc.nextLine();
        ArrayList<String> source = new ArrayList<String>();
        boolean flag = true;
        while (flag) {
            System.out.println("Nhập đường dẫn file gốc (Nhập end khi đã hết các file) : ");
            String currentFile = sc.nextLine();
            String end = "end";
            if (!currentFile.equals(end)){
                source.add(currentFile);
            }
            else {
                flag = false;
                break;
            }
        }
        System.out.println("Đã nhập xong, Bắt đầu copy file !");
        try{
            MergeFile.mergeFile(dest, nameDest, source);
        }catch (IOException e) {
            System.out.println("Nhập sai");
        }
    }
}
