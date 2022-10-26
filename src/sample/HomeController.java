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

public class HomeController {

    @FXML
    private Button homeback;
    private Stage stage;
    private Scene scene;
    private Parent root;


    public void homebackbuttonAction(ActionEvent e){

        stage =(Stage) homeback.getScene().getWindow();
        stage.close();
    }

  public void studentbuttonAction(ActionEvent e) throws IOException {
      root = FXMLLoader.load(getClass().getResource("Student.fxml"));
      stage = (Stage)((Node)e.getSource()).getScene().getWindow();
      scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
  }

   public void teacherbuttonAction(ActionEvent e) throws IOException {
       root = FXMLLoader.load(getClass().getResource("teacher.fxml"));
       stage = (Stage)((Node)e.getSource()).getScene().getWindow();
       scene = new Scene(root);
       stage.setScene(scene);
       stage.show();
   }

   public void AttendancebuttonAction(ActionEvent e) throws IOException {
       root = FXMLLoader.load(getClass().getResource("attendance.fxml"));
       stage = (Stage)((Node)e.getSource()).getScene().getWindow();
       scene = new Scene(root);
       stage.setScene(scene);
       stage.show();
   }

   public void ClassbuttonAction(ActionEvent e) throws IOException {
       root = FXMLLoader.load(getClass().getResource("class.fxml"));
       stage = (Stage)((Node)e.getSource()).getScene().getWindow();
       scene = new Scene(root);
       stage.setScene(scene);
       stage.show();
   }


}
