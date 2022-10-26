package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Teacher implements Initializable {

    @FXML
    private TextField teachersearch;

    @FXML
    private TableView<TeacherSearchModule> teachertableview;

    @FXML
    private TableColumn<TeacherSearchModule, Integer> tidcol;

    @FXML
    private TableColumn<TeacherSearchModule, String> tnamecol;

    @FXML
    private TableColumn<TeacherSearchModule, String> tgendercol;

    @FXML
    private TableColumn<TeacherSearchModule, String> taddresscol;

    @FXML
    private TableColumn<TeacherSearchModule, String> ttpnocol;

    @FXML
    private TableColumn<TeacherSearchModule, String> temailcol;

    @FXML
    private TableColumn<TeacherSearchModule, String> tsubjectcol;

    @FXML
    private Button Taddedit;

    @FXML
    private Button tback;


    public void teacherbackbutton(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Stage stage =(Stage) tback.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void tEditAddButtonAction(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("teacheredit.fxml"));
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    ObservableList<TeacherSearchModule>teacherSearchModuleObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        DatabaseConnection connection2 = new DatabaseConnection();
        Connection connectDB2 =connection2.getConnection();

        String TeacherView ="SELECT teacher_id, teacher_name, teacher_gender,teacher_address,teacher_tp, email, teacher_subject FROM teachertable;";

        try{

            Statement statement =connectDB2.createStatement();
            ResultSet QueryOutput2 = statement.executeQuery(TeacherView);

            while (QueryOutput2.next()) {

                Integer Query1teacher_id = QueryOutput2.getInt("teacher_id");
                String Query1teacher_name = QueryOutput2.getString("teacher_name");
                String Query1teacher_gender = QueryOutput2.getString("teacher_gender");
                String Query1teacher_address = QueryOutput2.getString("teacher_address");
                String Query1teacher_tp = QueryOutput2.getString("teacher_tp");
                String Query1email = QueryOutput2.getString("email");
                String Query1teacher_subject = QueryOutput2.getString("teacher_subject");

                teacherSearchModuleObservableList.add(new TeacherSearchModule(Query1teacher_id, Query1teacher_name, Query1teacher_gender, Query1teacher_address, Query1teacher_tp, Query1email, Query1teacher_subject));
            }
                tidcol.setCellValueFactory(new PropertyValueFactory<>("teacher_id"));
                tnamecol.setCellValueFactory(new PropertyValueFactory<>("teacher_name"));
                tgendercol.setCellValueFactory(new PropertyValueFactory<>("teacher_gender"));
                taddresscol.setCellValueFactory(new PropertyValueFactory<>("teacher_address"));
                ttpnocol.setCellValueFactory(new PropertyValueFactory<>("teacher_tp"));
                temailcol.setCellValueFactory(new PropertyValueFactory<>("email"));
                tsubjectcol.setCellValueFactory(new PropertyValueFactory<>("teacher_subject"));

                teachertableview.setItems(teacherSearchModuleObservableList);

                  FilteredList<TeacherSearchModule>filteredList = new FilteredList<>(teacherSearchModuleObservableList, b -> true);

                  teachersearch.textProperty().addListener((observable, oldValue1, newValue1) ->{
                      filteredList.setPredicate(TeacherSearchModule ->{
                           if (newValue1.isEmpty() || newValue1.isBlank()||newValue1 == null){
                               return true;
                           }
                           String lowerCaseFilter1 = newValue1.toLowerCase();

                           if(TeacherSearchModule.getTeacher_id().toString().indexOf(lowerCaseFilter1) !=-1){
                               return true;
                           }else if(TeacherSearchModule.getTeacher_name().toLowerCase().indexOf(lowerCaseFilter1) != -1){
                               return true;
                           }else if(TeacherSearchModule.getTeacher_address().toLowerCase().indexOf(lowerCaseFilter1) != -1){
                               return true;
                           }else if(TeacherSearchModule.getEmail().toLowerCase().indexOf(lowerCaseFilter1) != -1){
                               return true;
                           }else if(TeacherSearchModule.getTeacher_tp().toLowerCase().indexOf(lowerCaseFilter1) != -1) {
                               return true;
                           }
                           else
                               return false;
                      });

                  });

            SortedList<TeacherSearchModule> sortedList= new SortedList<>(filteredList);
            sortedList.comparatorProperty().bind(teachertableview.comparatorProperty());
            teachertableview.setItems(sortedList);

        }catch(SQLException e){
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE,null, e);
            e.printStackTrace();
        }

    }
}
