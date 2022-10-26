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

public class Student implements Initializable {

    @FXML
    private TableView<StudentSearchModule> studenttableview;

    @FXML
    private TableColumn<StudentSearchModule, String> studentidcol;

    @FXML
    private TableColumn<StudentSearchModule, String> sfnamecol;

    @FXML
    private TableColumn<StudentSearchModule, String> sdobcol;

    @FXML
    private TableColumn<StudentSearchModule, String> sgendercol;

    @FXML
    private TableColumn<StudentSearchModule, String> saddresscol;

    @FXML
    private TableColumn<StudentSearchModule, String> stpcol;

    @FXML
    private TableColumn<StudentSearchModule, String> sclassidcol;

    @FXML
    private TextField searchtestfeild;

    @FXML
    private Button addoreditstudent;

    @FXML
    private Button studentback;


    public void studentBackbutton(ActionEvent e) throws IOException {
       Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
       Stage stage =(Stage) studentback .getScene().getWindow();
       Scene scene = new Scene(root);
       stage.setScene(scene);
       stage.show();
   }

   public void sEditUpdateButtonAction(ActionEvent e) throws IOException {
       Parent root = FXMLLoader.load(getClass().getResource("studentedit.fxml"));
       Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
       Scene scene = new Scene(root);
       stage.setScene(scene);
       stage.show();
   }

    ObservableList<StudentSearchModule> studentSearchModuleObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        DatabaseConnection connection1 = new DatabaseConnection();
        Connection connectDB1 =connection1.getConnection();

        String StudentView = "SELECT student_id,full_name,date_of_birth,gender,address,tp_no,class_id FROM studenttable;";

        try{
            Statement statement =connectDB1.createStatement();
            ResultSet QueryOutput1 = statement.executeQuery(StudentView);

            while (QueryOutput1.next()){

                String Querystudent_id = QueryOutput1.getString("student_id");
                String Queryfull_name = QueryOutput1.getString("full_name");
                String Querydate_of_birth = QueryOutput1.getString("date_of_birth");
                String Querygender = QueryOutput1.getString("gender");
                String Queryaddress = QueryOutput1.getString("address");
                String Querytp_no = QueryOutput1.getString("tp_no");
                String Queryclass_id = QueryOutput1.getString("class_id");

               studentSearchModuleObservableList.add(new StudentSearchModule(Querystudent_id,Queryfull_name,Querydate_of_birth,Querygender,Queryaddress,Querytp_no,Queryclass_id) );

            }

            studentidcol.setCellValueFactory(new PropertyValueFactory<>("student_id"));
            sfnamecol.setCellValueFactory(new PropertyValueFactory<>("full_name"));
            sdobcol.setCellValueFactory(new PropertyValueFactory<>("date_of_birth"));
            sgendercol.setCellValueFactory(new PropertyValueFactory<>("gender"));
            saddresscol.setCellValueFactory(new PropertyValueFactory<>("address"));
            stpcol.setCellValueFactory(new PropertyValueFactory<>("tp_no"));
            sclassidcol.setCellValueFactory(new PropertyValueFactory<>("class_id"));

            studenttableview.setItems(studentSearchModuleObservableList);

            FilteredList<StudentSearchModule> filteredData = new FilteredList<>(studentSearchModuleObservableList, b -> true);

            searchtestfeild.textProperty().addListener((observable, oldValue, newValue) ->{
                filteredData.setPredicate(StudentSearchModule ->{

                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null ){
                        return true;
                    }
                    String lowerCaseFilter  = newValue.toLowerCase();
                    if(StudentSearchModule.getStudent_id().toLowerCase().indexOf(lowerCaseFilter) != -1){
                        return true;
                    }
                    else if(StudentSearchModule.getFull_name().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                        return true;
                    }
                    else if(StudentSearchModule.getDate_of_birth().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                        return true;
                    }
                    else if(StudentSearchModule.getAddress().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                        return true;
                    }
                    else if(StudentSearchModule.getTp_no().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                        return true;
                    }
                    else if(StudentSearchModule.getClass_id().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                        return true;
                    }
                    else
                        return false;

                });


            });

            SortedList<StudentSearchModule> sortedData = new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(studenttableview.comparatorProperty());
            studenttableview.setItems(sortedData);

        }catch(SQLException e){
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE,null, e);
            e.printStackTrace();

        }

    }


    }



