package filefilters;

import java.io.File;
import java.io.FilenameFilter;

public class Finder {
    public String list[];

    protected class FileFilter implements FilenameFilter {
        String extension = null;

        FileFilter(String extension) {
            this.extension = "." + extension;
        }
        public boolean accept(File d, String name) {
            return name.endsWith(extension);
        }
    }

    public Finder(String directory, String extension) {
        File dir = new File(directory);
        if (dir.exists()) {
            list = dir.list(new FileFilter(extension));
        }
    }

}
