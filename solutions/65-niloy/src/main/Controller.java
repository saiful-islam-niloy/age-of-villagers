package main;

import canvas.CanvasSingleton;
import house.IHouse;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import nation.NationManager;
import river.IWaterSource;
import state.CurrentState;
import terrain.ITerrain;
import tree.ITree;
import utility.FileReader;
import utility.FileSaver;
import utility.VillageLoader;

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
            {"Bangladeshi Farmers", "Arab Bedouin", "Egyptian Kings", "Inuit Hunters"};

    @FXML
    private Button createVillage;


    @FXML
    private Label villageName;

    @FXML
    private Label nationName;

    @FXML
    private AnchorPane openLayout;

    @FXML
    private ComboBox<String> inputNationNameForOpen;

    @FXML
    private Button openVillageButton;

    private CurrentState currentState = CurrentState.getInstance();

    private Canvas canvas;
    private NationManager nationManager;
    private ITree iTree;
    private IHouse iHouse;
    private IWaterSource iWaterSource;
    private ITerrain iTerrain;

    private FileReader fileReader;


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
        iTerrain = nationManager.getTerrain();
        iTerrain.draw();
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
        fileReader = new FileReader(file);
        villageName.setText(fileReader.getVillageName());
        drawingSpace.getChildren().remove(canvas);
        inputNationNameForOpen.setItems(FXCollections.observableArrayList(nation));
        openLayout.setVisible(true);

    }

    @FXML
    void loadVillage(ActionEvent event) {
        CanvasSingleton canvasSingleton = CanvasSingleton.getInstance();
        canvas = canvasSingleton.getCanvas();
        drawingSpace.getChildren().add(canvas);
        openLayout.setVisible(false);
        nationManager = new NationManager(inputNationNameForOpen.getValue());
        VillageLoader villageLoader = new VillageLoader(nationManager);
        villageLoader.loadTerrain();
        villageLoader.loadTree(fileReader.getTreeX(), fileReader.getTreeY());
        villageLoader.loadHouse(fileReader.getHouseX(), fileReader.getHouseY());
        villageLoader.loadWaterResource(fileReader.getWaterResourceX(), fileReader.getWaterResourceY());
    }

    @FXML
    void saveVillage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Age of Villagers files (*.aov)", "*.aov");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showSaveDialog(null);


        if (file != null) {
            FileSaver fileSaver = new FileSaver(file);
            fileSaver.saveFile();
        }
    }

    @FXML
    void selectHouse(ActionEvent event) {
        if (house.isSelected()) {
            iHouse = nationManager.getHouse();
            iHouse.getCanvas();
            iHouse.draw();
        } else {
            iHouse.releaseCanvas();
        }
    }

    @FXML
    void selectTree(ActionEvent event) {
        if (tree.isSelected()) {
            iTree = nationManager.getTree();
            iTree.getCanvas();
            iTree.draw();
        } else {
            iTree.releaseCanvas();
        }
    }


    @FXML
    void selectWaterSource(ActionEvent event) {
        if (waterSource.isSelected()) {
            iWaterSource = nationManager.getWaterSource();
            iWaterSource.getCanvas();
            iWaterSource.draw();
        } else {
            iWaterSource.releaseCanvas();
        }
    }
}
