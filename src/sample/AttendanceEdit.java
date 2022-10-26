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

public class AttendanceEdit {

    @FXML
    private TextField AstudentTxt;

    @FXML
    private TextField week1Txt;

    @FXML
    private TextField week2Txt;

    @FXML
    private TextField week3Txt;

    @FXML
    private TextField week4Txt;

    @FXML
    private TextField paymentTxt;

    @FXML
    private Button AttInsertbutton;

    @FXML
    private Button Aupdatebutton;

    @FXML
    private Button Adeletebutton;

    @FXML
    private Button AEditBack;

    @FXML
    private Label AttmsgLable;

    public void  AttendaceEditBack(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("attendance.fxml"));
        Stage stage =(Stage) AEditBack.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void AttInsertButtonAction(){
        InsertAttendance();
        AttmsgLable.setText("Data Entering is Successful");
    }

    public void AttUpdateButtonAction(){
        UpdateAttendance();
        AttmsgLable.setText("Data Updating is Successful");
    }

    public void AttDeleteButtonAction(){
        DeleteAttendance();
        AttmsgLable.setText("Data Deleting is Successful");
    }





    public void InsertAttendance(){

        DatabaseConnection connectnow3 = new DatabaseConnection();
        Connection connectivity3 = connectnow3.getConnection();
        String insertQuery2 ="INSERT INTO attendance_payment (attendances_id,week1,week2,week3,week4,payment) VALUES ("+"'" +AstudentTxt.getText()+"',"+"'"+week1Txt.getText()+"',"
                +"'"+week2Txt.getText()+"',"+"'"+week3Txt.getText()+"',"+"'"+week4Txt.getText()+"',"+"'"+ paymentTxt.getText()+"');";

        try{
            Statement studentstatement = connectivity3.createStatement();
            studentstatement.executeUpdate(insertQuery2);

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void UpdateAttendance(){

        DatabaseConnection connectnow3 = new DatabaseConnection();
        Connection connectivity3 = connectnow3.getConnection();
        String insertQuery2 ="Update attendance_payment SET attendances_id =" +"'"+AstudentTxt.getText()+"',"
                +"week1=" +"'"+week1Txt.getText()+"', week2 = "+"'"+week2Txt.getText()+"',week3 = '"+week3Txt.getText()+"',"+
                "week4 = '"+week4Txt.getText()+"', payment = '"+paymentTxt.getText()+"' WHERE attendances_id ="+"'"+AstudentTxt.getText()+"'  ;";

        try{
            Statement studentstatement = connectivity3.createStatement();
            studentstatement.executeUpdate(insertQuery2);

        }catch(Exception e){
            e.printStackTrace();
        }

    }


   public void DeleteAttendance(){

       DatabaseConnection connectnow3 = new DatabaseConnection();
       Connection connectivity3 = connectnow3.getConnection();
       String insertQuery2 ="DELETE FROM attendance_payment WHERE attendances_id = '"+AstudentTxt.getText()+"';";

       try{
           Statement studentstatement = connectivity3.createStatement();
           studentstatement.executeUpdate(insertQuery2);

       }catch(Exception e){
           e.printStackTrace();
       }
   }
}

