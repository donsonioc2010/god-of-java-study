package e.io;

import java.io.File;

public class FileFilterSample {
    public static void main(String[] args) {
        FileFilterSample sample = new FileFilterSample();
        String pathName = File.separator +"Users"+File.separator+"kimjongwon"+File.separator + "GodOfJavaFileTest" + File.separator + "text";

        sample.checkList(pathName);
    }

    public void checkList(String pathName) {
        System.out.println(pathName);
        File file;
        try {
            file = new File(pathName);
            //File [] mainFileList = file.listFiles();
            //File [] mainFileList = file.listFiles(new JPGFilenameFilter());
            File [] mainFileList = file.listFiles(new JPGFileFilter());
            for(File tempFile : mainFileList) {
                System.out.println(tempFile.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
