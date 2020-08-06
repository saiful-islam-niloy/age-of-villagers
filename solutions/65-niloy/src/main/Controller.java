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


    @FXML
    void createVillage(ActionEvent event) {
        villageName.setText(inputVillageName.getText());
        nationName.setText(inputNationName.getValue());
        currentState.setVillageName(inputVillageName.getText());
        infoLayout.setVisible(false);
        initialize();
    }

    @FXML
    void newVillage(ActionEvent event) {
        inputNationName.setItems(FXCollections.observableArrayList(nation));
        infoLayout.setVisible(true);
    }

    private void initialize() {
        CanvasSingleton canvasSingleton = CanvasSingleton.getInstance();
        canvas = canvasSingleton.getCanvas();
        drawingSpace.getChildren().add(canvas);

        nationManager = new NationManager(inputNationName.getValue());
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
        nationManager.getHouse().draw();
    }

    @FXML
    void selectTree(ActionEvent event) {
        nationManager.getTree().draw();
    }

    @FXML
    void selectWaterSource(ActionEvent event) {
        Canvas canvas = new Canvas(600, 400);
        drawingSpace.getChildren().add(canvas);
        WaterSource waterSource = new WaterSource(canvas);
        waterSource.draw();
    }
}
