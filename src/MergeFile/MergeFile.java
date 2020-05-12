package MergeFile;

import java.io.*;
import java.util.ArrayList;

public class MergeFile {
    public static void mergeFile(String dest,String nameDest, ArrayList<String> source) throws IOException {
        OutputStream os = new FileOutputStream(dest + "\\" + nameDest, true);
        for(int i=0; i<source.size(); i++) {
            File file = new File(source.get(i));
            if (file.exists()&&file.isFile()) {
                System.out.println("Đã copy file " + (i+1));
                InputStream is = new FileInputStream(file);
                byte[] arr = new byte[1024];
                int j = 0;
                while ((j = is.read(arr))!= -1) {
                    os.write(arr, 0, j);
                }
                is.close();
            }
            else {
                System.out.println("File bị lỗi hoặc ko tồn tại");
                break;
            }
        }
        os.flush();
        os.close();
    }
}