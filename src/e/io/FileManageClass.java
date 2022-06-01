package e.io;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

public class FileManageClass {

    private final String FILEPATH = File.separator +"Users"+File.separator+"kimjongwon"+File.separator+"GodOfJavaFileTest"+File.separator+"text";

    public static void main(String[] args) {
        FileManageClass sample = new FileManageClass();
        String fileName = "test.txt";
        sample.checkFile(sample.FILEPATH, fileName);

    }

    //Directory가 있는지 여부 확인후 없으면 생성 및 존재하거나 제작에 성공하면 true, Directory가 아니거나 실패하면 false
    public boolean confirmDir(String pathName) {
        File file = new File(pathName);
        if(file.exists()) {
            //파일이 존재하는 경우
            return file.isDirectory();
        } else {
            //경로가 없는 경우 디렉토리 생성
            return file.mkdir();
        }
    }

    public void checkFile(String pathName, String fileName) {
        File file = new File(pathName, fileName);
        
        try {
            //디렉토리 여부부터 확인
            if(confirmDir(pathName)) {
                System.out.println("Create Result = " + file.createNewFile());
                getFileInfo(file);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getFileInfo(File file) throws IOException {
        System.out.println("Absolute path = " + file.getAbsolutePath()); //절대경로
        System.out.println("Absolute File = " + file.getAbsoluteFile());
        System.out.println("Canonical Path = " + file.getCanonicalPath()); //상대경로
        System.out.println("Canonical File = " + file.getCanonicalFile());

        System.out.println("Name = " + file.getName());
        System.out.println("Path = " + file.getPath());

        System.out.println("Parent = " + file.getParent());
    }
}
