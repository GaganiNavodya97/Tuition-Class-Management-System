package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    private Button clickmelog;

    @FXML
    private Button clickmeexit;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void ExitbuttonAction(ActionEvent e){
        Stage stage =(Stage) clickmeexit.getScene().getWindow();
        stage.close();
    }

    public void clikmeLogbuttonAction(ActionEvent e) throws IOException {
         root = FXMLLoader.load(getClass().getResource("login.fxml"));
         stage = (Stage)((Node)e.getSource()).getScene().getWindow();
         scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }


}
