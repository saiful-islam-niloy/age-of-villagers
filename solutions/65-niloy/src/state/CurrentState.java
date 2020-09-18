package state;

import com.google.gson.*;
import shape.Point;
import java.util.ArrayList;

public class CurrentState {
    private static CurrentState instance = null;
    private JsonObject state;
    private JsonArray pointX;
    private JsonArray pointY;
    private ArrayList<Point> tree;
    private ArrayList<Point> house;
    private ArrayList<Point> waterResource;

    private  CurrentState(){
        state = new JsonObject();
        tree = new ArrayList<>();
        house = new ArrayList<>();
        waterResource = new ArrayList<>();
        pointX = new JsonArray();
        pointY = new JsonArray();
    }

    public static CurrentState getInstance(){
        if(instance == null)
            instance = new CurrentState();
        return instance;
    }

    public void setVillageName(String village){
        state.addProperty("villageName", village);
        System.out.println(state);
    }

    public void addTree(Point point){
        tree.add(point);
    }

    public void addHouse(Point point){
        house.add(point);
    }

    public void addWaterResource(Point point){
        waterResource.add(point);
    }

    private void addTreeData(){
        pointX = new JsonArray();
        pointY = new JsonArray();
        for (int i = 0; i< tree.size(); i++)
            pointX.add(tree.get(i).x);
        for (int i = 0; i< tree.size(); i++)
            pointY.add(tree.get(i).y);

        state.add("treeX", pointX);
        state.add("treeY", pointY);
    }

    private void addHouseData(){
        pointX = new JsonArray();
        pointY = new JsonArray();
        for (int i = 0; i< house.size(); i++)
            pointX.add(house.get(i).x);
        for (int i = 0; i< tree.size(); i++)
            pointY.add(house.get(i).y);

        state.add("houseX", pointX);
        state.add("houseY", pointY);
    }

    private void addWaterResourceData(){
        pointX = new JsonArray();
        pointY = new JsonArray();
        for (int i = 0; i< waterResource.size(); i++)
            pointX.add(waterResource.get(i).x);
        for (int i = 0; i< waterResource.size(); i++)
            pointY.add(waterResource.get(i).y);

        state.add("waterResourceX", pointX);
        state.add("waterResourceY", pointY);
    }


    public JsonObject getCurrentStateObject(){
        addHouseData();
        addTreeData();
        addWaterResourceData();
        return state;
    }
}
