package f.niosecond;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;


public class WatcherSample extends Thread{
    String dirName;

    public static void main(String[] args) throws Exception{
        //String dir = File.separator +"Users"+File.separator+"kimjongwon"+File.separator + "GodOfJavaFileTest" + File.separator + "nio"+File.separator+"nio2";
        String dirName = File.separator +"Users"+File.separator+"kimjongwon"+File.separator + "GodOfJavaFileTest";
        String fileName = "WatcherSample.txt";
        WatcherSample sample = new WatcherSample(dirName);
        sample.setDaemon(true);
        sample.start();
        Thread.sleep(1000);

        for(int loop = 0; loop < 10; loop++) {
            sample.fileWriteDelete(dirName, fileName+loop);
        }
    }

    public WatcherSample(String dirName) {
        this.dirName = dirName;
    }

    @Override
    public void run() {
        System.out.println("### Watcher thread is Started###");
        System.out.format("Dir=%s\n", dirName);

        addWatcher();
    }

    public void addWatcher() {

        try {
            Path dir = Paths.get(dirName);

            WatchService watcher = FileSystems.getDefault().newWatchService();
            WatchKey key;
            dir.register(watcher, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);


            while(true) {
                key = watcher.take();
                List<WatchEvent<?>>  eventList = key.pollEvents();
                for(WatchEvent<?>  event : eventList) {
                    Path name = (Path) event.context();
                    if(event.kind() == ENTRY_CREATE) {
                        System.out.format("%s created%n", name);
                    } else if(event.kind() == ENTRY_DELETE) {
                        System.out.format("%s deleted%n", name);
                    } else if(event.kind() == ENTRY_MODIFY) {
                        System.out.format("%s modified%n", name);
                    }
                }
                key.reset();
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void fileWriteDelete(String dirName, String fileName) {
        Path path = Paths.get(dirName, fileName);
        String contents = "Watcher Sample";

        StandardOpenOption openOption = StandardOpenOption.CREATE;

        try {
            System.out.println("Write " + fileName);
            Files.write(path, contents.getBytes(), openOption);
            Files.delete(path);
            Thread.sleep(100);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
