package e.io;

import java.io.File;
import java.io.FilenameFilter;

public class JPGFilenameFilter implements FilenameFilter {

    @Override
    public boolean accept(File file, String fileName) {
        // Interface Override, Only Jpg
        if(fileName.endsWith(".jpg")) return true;
        return false;
    }


}
