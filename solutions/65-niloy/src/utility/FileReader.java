package utility;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;

public class FileReader {
    private File file;
    private JsonObject jsonObject;

    public FileReader(File file) {
        this.file = file;
        loadJson();
    }

    private void loadJson(){
        JsonParser parser = new JsonParser();

        try {
            Object obj = parser.parse(new java.io.FileReader(file));
            jsonObject = (JsonObject) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getVillageName(){
       return jsonObject.get("villageName").getAsString();
    }

    public JsonArray getTreeX(){
        return jsonObject.getAsJsonArray("treeX");
    }

    public JsonArray getTreeY(){
        return jsonObject.getAsJsonArray("treeY");
    }

    public JsonArray getHouseX(){
        return jsonObject.getAsJsonArray("houseX");
    }

    public JsonArray getHouseY(){
        return jsonObject.getAsJsonArray("houseY");
    }

    public JsonArray getWaterResourceX(){
        return jsonObject.getAsJsonArray("waterResourceX");
    }

    public JsonArray getWaterResourceY(){
        return jsonObject.getAsJsonArray("waterResourceY");
    }
}
