package sample;

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

public class TeacherEdit {

    @FXML
    private TextField teacherIdTxt;

    @FXML
    private TextField tfnameText;

    @FXML
    private TextField tGenderTxt;

    @FXML
    private TextField taddressTxt;

    @FXML
    private TextField tcontactTxt;

    @FXML
    private TextField temaiTxt;

    @FXML
    private TextField TsubjectTxt;

    @FXML
    private Label teacherMgslable;

    @FXML
    private Button tInsert;

    @FXML
    private Button tUpdate;

    @FXML
    private Button tDelet;

    @FXML
    private Button teachereditBack;

    public void TeacherEditBackButtonAction() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("teacher.fxml"));
        Stage stage =(Stage) teachereditBack.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void tInsertButtonAction(){
        insertTeacherData();
        teacherMgslable.setText("Data Entering is Successful");
    }

    public void tUpdateButtonAction(){
        updteTeacherData();
        teacherMgslable.setText("Data Updating is Successful");
    }

    public void tDeleteButtonAction(){
        DeleteTeacherData();
        teacherMgslable.setText("Data Deleting is Successful");
    }




    public void insertTeacherData(){
        DatabaseConnection connectnow2 = new DatabaseConnection();
        Connection connectivity2 = connectnow2.getConnection();
        String insertQuery1 ="INSERT INTO teachertable (teacher_id,teacher_name, teacher_gender,teacher_address,teacher_tp, email, teacher_subject) VALUES ("+"'"+teacherIdTxt.getText()+"','"
                +tfnameText.getText()+"','"+tGenderTxt.getText()+"','"+taddressTxt.getText()+"','"+tcontactTxt.getText()+"','"+temaiTxt.getText()+"','"+TsubjectTxt.getText()+"');";

        try{
            Statement studentstatement = connectivity2.createStatement();
            studentstatement.executeUpdate(insertQuery1);

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void updteTeacherData(){

        DatabaseConnection connectnow2 = new DatabaseConnection();
        Connection connectivity2 = connectnow2.getConnection();
        String insertQuery1 = "Update teachertable  SET teacher_id = '"+teacherIdTxt.getText()+"',teacher_name = '"+tfnameText.getText()+"',teacher_gender ='"+tGenderTxt.getText()+
                "',teacher_address ='"+taddressTxt.getText()+"',teacher_tp = '"+tcontactTxt.getText()+"',email = '"+temaiTxt.getText()+"', teacher_subject = '"+TsubjectTxt.getText()+"'WHERE teacher_id ='"+teacherIdTxt.getText()+"'  ;";

        try{
            Statement studentstatement = connectivity2.createStatement();
            studentstatement.executeUpdate(insertQuery1);

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void  DeleteTeacherData(){
        DatabaseConnection connectnow2 = new DatabaseConnection();
        Connection connectivity2 = connectnow2.getConnection();
        String insertQuery1 ="DELETE FROM teachertable WHERE teacher_id = '"+teacherIdTxt.getText()+"';";

        try{
            Statement studentstatement = connectivity2.createStatement();
            studentstatement.executeUpdate(insertQuery1);

        }catch(Exception e){
            e.printStackTrace();
        }

    }



}
