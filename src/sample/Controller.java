package sample;


import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXSpinner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import kernel.Acp;
import kernel.Result;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    Acp pca = new Acp(3000);
    boolean trained = false;
    Result recognition_result;

    @FXML
    private ImageView faceImage;

    @FXML
    private Button trainBtn;

    @FXML
    private TextField facePath;

    @FXML
    private Button loadBtn;

    @FXML
    private Button recognizeBtn;

    @FXML
    private Label result;

    @FXML
    private JFXSlider thresholdSlider;

    @FXML
    private Button saveTrainBtn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}


    @FXML
    void loadFace(ActionEvent event) {
        try{
            faceImage.setImage(new Image(facePath.getText()));
        }catch (IllegalArgumentException e){
            alertMsg("Input path must not be empty", Alert.AlertType.ERROR);
        }
    }

    @FXML
    void recognize(ActionEvent event) {
        try{
            if (trained){
                String path_to_orl = "src/"+facePath.getText();
                pca.setThreshold(thresholdSlider.getValue());
                recognition_result = pca.recognize(path_to_orl);
                result.setText(recognition_result.name());
            }

            else {
                alertMsg("Model must be trained before recognizing", Alert.AlertType.WARNING);
            }
        }catch (IllegalArgumentException e){
            alertMsg("You must specify a correct path to the input image\n or image " +
                    "must have size of 92 x 112", Alert.AlertType.WARNING);
        }
    }

    @FXML
    void trainModel(ActionEvent event){
        pca.trainModel();
        trained = true;
        trainBtn.setDisable(true);

        alertMsg("model is now trained you can enter face path and recognize it", Alert.AlertType.CONFIRMATION);

    }

    public void alertMsg(String msg, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setTitle("Message");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }


    /// PCA serialization
    @FXML
    public void saveTrainState(ActionEvent event){
        if (!trained){
            alertMsg("You must train the model first", Alert.AlertType.ERROR);
            return;
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("pca.ser");
            ObjectOutputStream pcaOut = new ObjectOutputStream(fileOutputStream);
            pcaOut.writeObject(pca);
            pcaOut.close();
            fileOutputStream.close();
            alertMsg("your training is now saved\n second time you open this app just click on load button", Alert.AlertType.INFORMATION);
            trainBtn.setDisable(true);
            saveTrainBtn.setDisable(true);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void loadTrainState(ActionEvent event){

        try {
            FileInputStream fileInputStream = new FileInputStream("pca.ser");
            ObjectInputStream pcaIn = new ObjectInputStream(fileInputStream);
            pca = (Acp) pcaIn.readObject();
            pcaIn.close();
            fileInputStream.close();
            trained = true;
            trainBtn.setDisable(true);
            saveTrainBtn.setDisable(true);
            alertMsg("model is now trained you can enter face path and recognize it", Alert.AlertType.CONFIRMATION);
        }catch (Exception e){
            alertMsg("An error occurred while loading train model", Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

}