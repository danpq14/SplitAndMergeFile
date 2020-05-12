package SplitFile;

import java.io.*;

public class SplitFile {
    public static boolean splitFile (String source, String dest, int numberFile) throws IOException {

        File sourceFile = new File(source);
        if (sourceFile.exists() && sourceFile.isFile()) {

            //Lấy size file nguồn
            long sizeSource = sourceFile.length();
            long sizeDest = sizeSource/numberFile;

            //Mở luồng đọc và ghi file
            InputStream is = new FileInputStream(sourceFile);
            byte[] arr = new byte[1024];

            //số lần cắt file = số file người dùng muốn cắt
            for (int i=0; i<numberFile; i++) {
                int j = 0;
                long currentSize = 0;
                String name = sourceFile.getName();
                int indexOfDot = name.indexOf(".");
                name = name.substring(0,indexOfDot) +"00"+ (i+1) + name.substring(indexOfDot, name.length());
                OutputStream os = new FileOutputStream(dest + "\\" + name) ;
                System.out.println("File cắt được : " +sourceFile.getName()+"."+i);
                while ((j=is.read(arr))!= -1) {
                    os.write(arr,0,j);
                    currentSize += j ;
                    if (currentSize >= sizeDest) {
                        break;
                    }
                }
                os.flush();
                os.close();
            }
            is.close();
            return true;
        }
        else {
            System.out.println("Ko tồn tại file");
            return false;
        }
    }
}
