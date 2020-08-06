package main;

import canvas.CanvasHelper;
import canvas.CanvasSingleton;
import house.BangladeshiFarmersHouse;
import house.IHouse;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import nation.BangladeshiFarmers;
import nation.NationManager;
import shape.House;
import shape.Tree;
import shape.WaterSource;
import state.CurrentState;
import tree.ITree;
import utility.ReadFile;
import utility.SaveFile;

import java.io.File;


public class Controller {
    @FXML
    private RadioButton tree;

    @FXML
    private RadioButton house;

    @FXML
    private RadioButton waterSource;

    @FXML
    private Button saveVillage;

    @FXML
    private Button newVillage;

    @FXML
    private Button openVillage;

    @FXML
    private AnchorPane drawingSpace;

    @FXML
    private AnchorPane infoLayout;

    @FXML
    private TextField inputVillageName;

    @FXML
    private ComboBox<String> inputNationName;

    private String nation[] =
            { "Bangladeshi Farmers"};

    @FXML
    private Button createVillage;


    @FXML
    private Label villageName;

    @FXML
    private Label nationName;

    private CurrentState currentState = CurrentState.getInstance();

    private Canvas canvas;
    private NationManager nationManager;
    private ITree iTree;
    private IHouse iHouse;


    @FXML
    void createVillage(ActionEvent event) {
        villageName.setText(inputVillageName.getText());
        nationName.setText(inputNationName.getValue());
        currentState.setVillageName(inputVillageName.getText());
        infoLayout.setVisible(false);
        initialize();
    }

    private void initialize() {
        CanvasSingleton canvasSingleton = CanvasSingleton.getInstance();
        canvas = canvasSingleton.getCanvas();
        drawingSpace.getChildren().add(canvas);

        nationManager = new NationManager(inputNationName.getValue());
    }


    @FXML
    void newVillage(ActionEvent event) {
        inputNationName.setItems(FXCollections.observableArrayList(nation));
        infoLayout.setVisible(true);
    }

    @FXML
    void openVillage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Age of Villagers files (*.aov)", "*.aov");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showOpenDialog(null);
        ReadFile readFile = new ReadFile(file);
        villageName.setText(readFile.getVillageName());
    }

    @FXML
    void saveVillage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Age of Villagers files (*.aov)", "*.aov");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showSaveDialog(null);


        if (file != null) {
            SaveFile saveFile = new SaveFile(file);
            saveFile.saveFile();
        }
    }

    @FXML
    void selectHouse(ActionEvent event) {
        if(house.isSelected()){
            iHouse = nationManager.getHouse();
            iHouse.getCanvas();
            iHouse.draw();
            System.out.println("House Selected");
        }else {
            iHouse.releaseCanvas();
        }
    }

    @FXML
    void selectTree(ActionEvent event) {
        if(tree.isSelected()){
            iTree = nationManager.getTree();
            iTree.getCanvas();
            iTree.draw();
            System.out.println("tree selected");
        }else{
            iTree.releaseCanvas();
            System.out.println("tree unchecked");
        }
    }


    @FXML
    void selectWaterSource(ActionEvent event) {
        Canvas canvas = new Canvas(600, 400);
        drawingSpace.getChildren().add(canvas);
        WaterSource waterSource = new WaterSource(canvas);
        waterSource.draw();
    }
}
