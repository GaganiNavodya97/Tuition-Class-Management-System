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

public class StudentEdit {

    @FXML
    private TextField studentIdText;

    @FXML
    private TextField SclzTxt;

    @FXML
    private TextField sAddressTxt;

    @FXML
    private TextField sfullNameText;

    @FXML
    private TextField SdobText;

    @FXML
    private TextField sGenderText;

    @FXML
    private TextField ScontactTxt;

    @FXML
    private Button sInsert;

    @FXML
    private Button sUpdate;

    @FXML
    private Button sDelete;

    @FXML
    private Label sMassegeLabel;

    @FXML
    private Button studenteditBack;

    public void studenteditbackButtonAction(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Student.fxml"));
        Stage stage =(Stage) studenteditBack.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void sInsertButtonAction(){
        insertstudentData();
        sMassegeLabel.setText("Data Entering is Successful");
    }

    public void sUpdateButtonAction(){
        updateStdentData();
        sMassegeLabel.setText("Data Updating is Successful");
    }

    public void sDeleteButtonAction(){
        deleteStudentData();
        sMassegeLabel.setText("Data Deleting is Successful");
    }





    public void insertstudentData(){
        DatabaseConnection connectnow1 = new DatabaseConnection();
        Connection connectivity1 = connectnow1.getConnection();
        String insertQuery = "INSERT INTO studenttable (student_id, full_name, date_of_birth,gender,address,tp_no,class_id) VALUES ("+"'" +studentIdText.getText()+"',"+"'"+sfullNameText.getText()+"',"
                +"'"+SdobText.getText()+"',"+"'"+sGenderText.getText()+"',"+"'"+sAddressTxt.getText()+"',"+"'"+ScontactTxt.getText()+"',"+"'"+SclzTxt.getText()+"');";


        try{
            Statement studentstatement = connectivity1.createStatement();
            studentstatement.executeUpdate(insertQuery);

        }catch(Exception e){
            e.printStackTrace();
        }

    }


    public void updateStdentData(){
        DatabaseConnection connectnow1 = new DatabaseConnection();
        Connection connectivity1 = connectnow1.getConnection();
        String updateQrey = "Update studenttable SET student_id =" +"'"+studentIdText.getText()+"',"
        +"full_name=" +"'"+sfullNameText.getText()+"', date_of_birth = "+"'"+SdobText.getText()+"',gender = '"+sGenderText.getText()+"',"+
                "address = '"+sAddressTxt.getText()+"', tp_no = '"+ScontactTxt.getText()+"', class_id= '"+SclzTxt.getText()+"' WHERE student_id ="+"'"+studentIdText.getText()+"'  ;";

        try{
            Statement studentstatement = connectivity1.createStatement();
            studentstatement.executeUpdate(updateQrey);

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void deleteStudentData(){
        DatabaseConnection connectnow1 = new DatabaseConnection();
        Connection connectivity1 = connectnow1.getConnection();
        String deleteQuery = "DELETE FROM studenttable WHERE student_id = '"+studentIdText.getText()+"';";

        try{
            Statement studentstatement = connectivity1.createStatement();
            studentstatement.executeUpdate(deleteQuery);

        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
