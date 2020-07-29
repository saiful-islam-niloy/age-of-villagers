package utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    private File file;

    public ReadFile(File file) {
        this.file = file;
    }

    public String getText(){
        String output = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null){
                output += line;
                System.out.println(output);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("2: "+output);
        return output;
    }
}
