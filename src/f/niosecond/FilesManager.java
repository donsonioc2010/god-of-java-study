package f.niosecond;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FilesManager {
    public static void main(String[] args) {
        FilesManager sample = new FilesManager();
        String fileName = "AboutThisBook.txt";
        Path fromPath = sample.writeAndRead(fileName);
        sample.copyMoveDelete(fromPath, fileName);
    }

    public List<String> getContent() {
        List<String> contents = new ArrayList<>();

        contents.add("이 책은 저자의 6번째 책입니다");
        contents.add("2345");
        contents.add("ㄱㄴㄷㄹㅁㅂㅅ");
        contents.add("abcdef");
        contents.add("testFileManager");
        contents.add("Current Date = "+new Date());

        return contents;
    }

    public Path writeFile(Path path) throws Exception {
        Charset charset = Charset.forName("EUC-KR");
        List<String> contents = getContent();
        StandardOpenOption openOption = StandardOpenOption.CREATE;
        return Files.write(path, contents, charset, openOption);
    }

    public void readFile(Path path) throws Exception {
        Charset charset = Charset.forName("EUC-KR");
        System.out.println("Path = " + path);
        List<String> fileContents = Files.readAllLines(path, charset);
        for(String tempContents : fileContents) {
            System.out.println(tempContents);
        }
        System.out.println();
    }

    public Path writeAndRead(String fileName) {
        Path returnPath = null;
        try {
            Path path = Paths.get(fileName);

            //Write text File
            returnPath = writeFile(path);

            //Read text File
            System.out.println("**Created file Contents");
            readFile(returnPath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return returnPath;
    }

    public void copyMoveDelete(Path fromPath, String fileName) {
        try {
            Path toPath = fromPath.toAbsolutePath().getParent();

            //Make Directory
            Path copyPath = toPath.resolve("copied");
            if(!Files.exists(copyPath)) {
                Files.createDirectories(copyPath);
            }

            // Copy File
            Path copiedFilePath = copyPath.resolve(fileName);
            StandardCopyOption copyOption = StandardCopyOption.REPLACE_EXISTING;
            Files.copy(fromPath, copiedFilePath, copyOption);

            // Read Copied File
            System.out.println("**** Copied File Contents****");
            readFile(copiedFilePath);

            // Move File
            Path movedFilePath = Files.move(copiedFilePath, copyPath.resolve("moved.txt"), copyOption);

            //Delete Files
            Files.delete(movedFilePath);
            Files.delete(copyPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    long lastModified = -1;
    // Java 6 이전의 방식으로 lastModified를 사용해서 최근에 변경된 파일의 시간을 가져와서 기존에 저장된
    //시간과 비교하는 방법, 문제는 해당 메소드가 연계된 메소드가 많아 성능에 영향이 많이 가는 편이었슴.
    public boolean fileChangeCheck(String fileName) {
        File file = new File(fileName);
        long modifiedTime = file.lastModified();
        if(lastModified == -1) {
            lastModified = modifiedTime;
        } else {
            if(modifiedTime != lastModified) {
                return true;
            }
        }
        return false;
    }

}
