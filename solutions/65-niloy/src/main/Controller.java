package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;



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
    private TextField inputNationName;

    @FXML
    private Button createVillage;


    @FXML
    private Label villageName;

    @FXML
    private Label nationName;

    @FXML
    void createVillage(ActionEvent event) {
        villageName.setText(inputVillageName.getText());
        nationName.setText(inputNationName.getText());
        infoLayout.setVisible(false);
    }

    @FXML
    void newVillage(ActionEvent event) {
        infoLayout.setVisible(true);
    }

    @FXML
    void openVillage(ActionEvent event) {
    }

    @FXML
    void saveVillage(ActionEvent event) {

    }

    @FXML
    void selectHouse(ActionEvent event) {

    }

    @FXML
    void selectTree(ActionEvent event) {

    }

    @FXML
    void selectWaterSource(ActionEvent event) {

    }
}
