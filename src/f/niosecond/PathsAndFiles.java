package f.niosecond;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathsAndFiles {
    public static void main(String[] args) {
        PathsAndFiles sample = new PathsAndFiles();
        //경로가 존재하지 않음. 그럼에도 생성이 가능함
        String dir = File.separator +"Users"+File.separator+"kimjongwon"+File.separator + "GodOfJavaFileTest" + File.separator + "nio"+File.separator+"nio2";
        //sample.checkPath(dir);

        String dir2 = File.separator +"Users"+File.separator+"kimjongwon"+File.separator+"relativizetest";
        sample.checkPath2(dir, dir2);
    }

    public void checkPath(String dir) {
        Path path = Paths.get(dir);

        System.out.println(path.toString());
        System.out.println("GetFileName() : " + path.getFileName());
        System.out.println("GetNameCount() : " +path.getNameCount());
        System.out.println("GetParent() : " + path.getParent());
        System.out.println("GetRoot() : " +path.getRoot());
    }

    public void checkPath2(String dir1, String dir2) {
        Path path = Paths.get(dir1);
        Path path2 = Paths.get(dir2);
        Path relativized = path.relativize(path2);

        System.out.println("relativized paht="+relativized);

        Path absolute = relativized.toAbsolutePath();
        System.out.println("toAbsolutePath path="+absolute);

        Path normalized=absolute.normalize();
        System.out.println("normalized path=" + normalized);

        Path resolved = path.resolve("GodOfJavaFileTest");
        System.out.println("resolved path="+resolved);
    }
}
