package Views;

import SplitFile.SplitFile;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Chương trình cắt file theo số lượng");
        System.out.println("Xin mời nhập đường dẫn file gốc (Source File) : ");
        String source = sc.nextLine();
        System.out.println("Xin mời nhập thư mục chứa file đích : ");
        String dest = sc.nextLine();
        System.out.println("Xin mời nhập số lượng file muốn cắt : ");
        int numberFile = sc.nextInt();
        SplitFile.splitFile(source, dest, numberFile);
    }
}
