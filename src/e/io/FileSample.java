package e.io;

import java.io.File;
import java.util.Date;

public class FileSample {
    public static void main(String[] args) {
        FileSample sample = new FileSample();
        String pathName = sample.getProjectPath() + File.separator + "text";
        //sample.checkPath(pathName);
        //sample.makeDir(pathName);
        sample.checkFileMethods(pathName);
        sample.canFileMethods(pathName);
        sample.lastModified(pathName);
        sample.deleteFile(pathName);
    }

    public void checkPath(String pathName) {
        File file = new File(pathName);
        System.out.println(pathName + " is Exists? = " + file.exists());
    }

    public String getProjectPath() {
        return File.separator +"Users"+File.separator+"kimjongwon"+File.separator+"GodOfJavaFileTest";
    }

    public void makeDir(String pathName) {
        File file = new File(pathName);
        System.out.println("Make " + pathName + " result = " + file.mkdir());
    }

    public void checkFileMethods(String pathName) {
        File file = new File(pathName);
        System.out.println(pathName + "is Directory? = " + file.isDirectory());
        System.out.println(pathName + "is File? = " + file.isFile());
        System.out.println(pathName + "is hidden? = " + file.isHidden());
    }
    public void canFileMethods(String pathName) {
        //권한 관련
        File file = new File(pathName);
        System.out.println(pathName + "can Read? = " + file.canRead());
        System.out.println(pathName + "can Write? = " + file.canWrite());
        System.out.println(pathName + "can Execute? = " + file.canExecute());
    }

    public void lastModified(String pathName) {
        //파일 생성일 확인, return 이 long타입임
        File file = new File(pathName);
        System.out.println(pathName + " last modified = " + new Date(file.lastModified()));
    }
    public void deleteFile(String pathName) {
        //File Delete, Delete Success Result = true
        File file = new File(pathName);
        System.out.println(pathName + " Remove Result = " + file.delete());
    }

}
