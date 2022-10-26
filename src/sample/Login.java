package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login {

    @FXML
    private TextField usernamefeild;

    @FXML
    private PasswordField passwordfeild;

    @FXML
    private Label messagelable;

    private Stage stage;
    private Scene scene;
    private Parent root;


    public void loginbuttonAction(){

        if (usernamefeild.getText().isBlank() == false && passwordfeild.getText().isBlank() == false) {
            //messagelable.setText("You are try to login");//
            validatelogin();
        } else {
            messagelable.setText("Please Enter username or password");
        }
    }


    public void cancelbuttonAction(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void validatelogin(){
        DatabaseConnection connectnow = new DatabaseConnection();
        Connection connectivity = connectnow.getConnection();
        String varifylogin = "SELECT count(1) FROM usertable WHERE username ='" + usernamefeild.getText() + "' AND password = '" + passwordfeild.getText() + "';";

        try {
            Statement statement = connectivity.createStatement();
            ResultSet queryResult = statement.executeQuery(varifylogin);

            while (queryResult.next()) {

                if (queryResult.getInt(1) == 1) {
                   // messagelable.setText("Welcome");
                    homepage();

                } else {
                    messagelable.setText("Invalid login plz try again");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public void homepage(){
         try{

             Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
             Stage homestage = new Stage();
             homestage.initStyle(StageStyle.UNDECORATED);
             //primaryStage.setTitle("Hello World");//
             homestage.setScene(new Scene(root, 800,550));
             homestage.show();

         }catch(Exception e){
              e.printStackTrace();
              e.getCause();
            }

        }

}

