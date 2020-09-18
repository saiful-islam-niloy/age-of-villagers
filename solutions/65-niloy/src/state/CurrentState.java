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

    public JsonObject getCurrentStateObject(){
        for (int i = 0; i< tree.size(); i++)
            pointX.add(tree.get(i).x);
        for (int i = 0; i< tree.size(); i++)
            pointY.add(tree.get(i).y);

        state.add("treeX", pointX);
        state.add("treeY", pointY);
        return state;
    }
}
