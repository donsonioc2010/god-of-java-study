package e.io.practice;

import java.io.File;
import java.text.DecimalFormat;

import static java.io.File.separator;

public class FileSizeSummary {
    private DecimalFormat formatter = null;
    public static void main(String[] args) {
        FileSizeSummary sample = new FileSizeSummary();
        String pathName = separator +"Users"+ separator+"kimjongwon"+ separator + "GodOfJavaFileTest";
        long sum = sample.printFileSize(pathName);
        System.out.println(pathName + "'s total size " + sample.convertFileLength(sum));

    }

    public FileSizeSummary() {
        String pattern = "#,##0.0#";
        formatter = new DecimalFormat(pattern);
    }
    private long printFileSize(String dirName) {
        File dir = new File(dirName);
        long sum = 0;

        if(dir.isDirectory()) {
            File [] fileList = dir.listFiles();
            for(File file : fileList) {
                if(file.isFile()) {
                    String tempFileName = file.getAbsolutePath();
                    long fileLength =file.length();
                    //System.out.println(tempFileName + " : " + convertFileLength(fileLength));
                    sum += fileLength;
                } else {
                    String tempDirName = file.getAbsolutePath();
                    long fileLength = printFileSize(tempDirName);
                    System.out.println("[" + tempDirName + "] :"+ convertFileLength(fileLength));
                    sum += fileLength;
                }
            }
        }

        return sum;
    }
    private final long KB = 1024;
    private final long MB = 1024 * 1024;
    private final long GB = 1024 * 1024 * 1024;
    private final long TB = 1024 * 1024 * 1024 * 1024;

    private String convertFileLength(long fileLength) {
        if(fileLength < KB) {
            return fileLength + "b";
        } else if (fileLength < MB) {
            return formatter.format(1.0 * fileLength / KB) + " kb";
        } else if (fileLength < GB) {
            return formatter.format(1.0 * fileLength / MB) + "mb";
        } else if (fileLength < TB) {
            return formatter.format(1.0 * fileLength / GB) + "gb";
        } else {
            return formatter.format(1.0 * fileLength / TB) + "tb";
        }
    }


}
