package state;

import com.google.gson.JsonObject;

public class CurrentState {
    private static CurrentState instance = null;
    private JsonObject state;

    private  CurrentState(){
        state = new JsonObject();
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

    public JsonObject getCurrentStateObject(){
        return state;
    }
}
