package utility;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import shape.Point;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadFile {
    private File file;
    private JsonObject jsonObject;

    public ReadFile(File file) {
        this.file = file;
        loadJson();
    }

    private void loadJson(){
        JsonParser parser = new JsonParser();

        try {
            Object obj = parser.parse(new FileReader(file));
            jsonObject = (JsonObject) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getVillageName(){
       return jsonObject.get("villageName").getAsString();
    }

}
