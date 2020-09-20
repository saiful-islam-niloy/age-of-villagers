package utility;

import state.CurrentState;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FileSaver {
    private File file;
    private CurrentState currentState;

    public FileSaver(File file) {
        this.file = file;
        currentState = CurrentState.getInstance();
    }

    public boolean saveFile(){
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(currentState.getCurrentStateObject());
            writer.close();
        } catch (IOException ex) {
            return false;
        }
        return true;
    }
}
