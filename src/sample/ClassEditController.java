package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

public class ClassEditController {
    @FXML
    private TextField ClassIDTxt;

    @FXML
    private TextField SubjectTXt;

    @FXML
    private TextField RoomTxt;

    @FXML
    private TextField TimeTxt;

    @FXML
    private Button ClassInsert;

    @FXML
    private Button ClassUpdate;

    @FXML
    private Button ClassDelete;

    @FXML
    private Button ClassEditBack;

    @FXML
    private Label ClzmsgLable;

    public void ClassBackButtonAction(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("class.fxml"));
        Stage stage =(Stage) ClassEditBack.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void classInsertButtonAction(){
        insertclassdetails();
        ClzmsgLable.setText("Data Entering is Successful");
    }

    public void classUpdateButtonAction(){
        updateclass();
        ClzmsgLable.setText("Data Updating is Successful");
    }

    public void classDeleteButtonAction(){
        deleteclass();
        ClzmsgLable.setText("Data Deleting is Successful");
    }






   public void insertclassdetails(){
       DatabaseConnection connectnow4 = new DatabaseConnection();
       Connection connectivity4 = connectnow4.getConnection();
       String insertQuery3 = "INSERT INTO classtable (class_id, subject, room_no, time) VALUES ("+"'" +ClassIDTxt.getText()+"',"+"'"+SubjectTXt.getText()+"',"
               +"'"+RoomTxt.getText()+"',"+"'"+TimeTxt.getText()+"');";

       try{
           Statement studentstatement = connectivity4.createStatement();
           studentstatement.executeUpdate(insertQuery3);

       }catch(Exception e){
           e.printStackTrace();
       }

   }

   public void updateclass(){
       DatabaseConnection connectnow4 = new DatabaseConnection();
       Connection connectivity4 = connectnow4.getConnection();
       String insertQuery3 ="Update classtable SET class_id =" +"'"+ClassIDTxt.getText()+"',"
               +"subject=" +"'"+SubjectTXt.getText()+"', room_no= "+"'"+RoomTxt.getText()+"',time = '"+TimeTxt.getText()+"' WHERE class_id ="+"'"+ClassIDTxt.getText()+"'  ;";

       try{
           Statement studentstatement = connectivity4.createStatement();
           studentstatement.executeUpdate(insertQuery3);

       }catch(Exception e){
           e.printStackTrace();
       }


   }

   public void deleteclass(){

       DatabaseConnection connectnow4 = new DatabaseConnection();
       Connection connectivity4 = connectnow4.getConnection();
       String insertQuery3 ="DELETE FROM classtable WHERE class_id = '"+ClassIDTxt.getText()+"';";

       try{
           Statement studentstatement = connectivity4.createStatement();
           studentstatement.executeUpdate(insertQuery3);

       }catch(Exception e){
           e.printStackTrace(); 
       }
   }


}
 