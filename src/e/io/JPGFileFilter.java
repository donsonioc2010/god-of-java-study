package e.io;

import java.io.File;
import java.io.FileFilter;

public class JPGFileFilter implements FileFilter {

    @Override
    public boolean accept(File file) {
        // Interface Override, Only jpg
        if (file.isFile()) {
            String fileNAme = file.getName();
            if (fileNAme.endsWith(".jpg")) return true;
        }
        return false;
    }


}
