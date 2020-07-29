package utility;

import com.sun.javafx.logging.PlatformLogger;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveFile {
    private String content;
    private File file;

    public SaveFile(String content, File file) {
        this.content = content;
        this.file = file;
    }

    public boolean saveFile(){
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(content);
            writer.close();
        } catch (IOException ex) {
            return false;
        }
        return true;
    }
}
