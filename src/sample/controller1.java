package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class controller1 {
    @FXML
    Button chooser;
    @FXML
    ImageView imagev;


    @FXML
    public void load(ActionEvent ev){

            FileChooser fc=new FileChooser();
            fc.setInitialDirectory(new File("src\\sample\\orl"));
            fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Images","*.bmp","*.jpg","*.jpeg","*.png"));
            File selectedfile=fc.showOpenDialog(null);
            if(selectedfile!=null){
                imagev.setImage(new Image(selectedfile.toURI().toString()));
            }else{
                alertMsg("there is an error",Alert.AlertType.ERROR);
            }


    }





  @FXML
    public void reconnaissance(ActionEvent ev){
      try {

          Parent root= FXMLLoader.load(getClass().getResource("sample.fxml"));
          Scene scene = new Scene(root);
          Stage window=(Stage)((Node)ev.getSource()).getScene().getWindow();
          window.setScene(scene);
          window.show();

      } catch(Exception e) {
          e.printStackTrace();
      }
  }

  @FXML
    public void debug(ActionEvent ev){
      try {

          Parent root= FXMLLoader.load(getClass().getResource("stage4.fxml"));
          Scene scene = new Scene(root);
          Stage window=(Stage)((Node)ev.getSource()).getScene().getWindow();
          window.setScene(scene);
          window.show();

      } catch(Exception e) {
          e.printStackTrace();
      }



  }


  @FXML
    public void documentation(ActionEvent ev){
      try {

          Parent root= FXMLLoader.load(getClass().getResource("stage3.fxml"));
          Scene scene = new Scene(root);
          Stage window=(Stage)((Node)ev.getSource()).getScene().getWindow();
          window.setScene(scene);
          window.show();

      } catch(Exception e) {
          e.printStackTrace();
      }



  }

  @FXML
    public void aide(ActionEvent ev){
      try {

          Parent root= FXMLLoader.load(getClass().getResource("stage5.fxml"));
          Scene scene = new Scene(root);
          Stage window=(Stage)((Node)ev.getSource()).getScene().getWindow();
          window.setScene(scene);
          window.show();

      } catch(Exception e) {
          e.printStackTrace();
      }



  }




    public void alertMsg(String msg, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setTitle("Message");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }


}
