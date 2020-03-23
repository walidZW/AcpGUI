package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class controller3 implements Initializable {
    @FXML
    WebView view;
    @FXML
    WebEngine engine;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        engine=view.getEngine();
        engine.setJavaScriptEnabled(true);

        File f=new File("C:\\GitHub\\AcpGUI\\src\\sample\\acp documentation\\index.html");
        engine.load(f.toURI().toString());


       /* final URL urldoc = getClass().getResource("acp documentation/index.html");
        engine.load(urldoc.toExternalForm());
        engine.setJavaScriptEnabled(true);*/


    }
}
