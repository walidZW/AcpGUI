package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class controller1 {

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
















}
