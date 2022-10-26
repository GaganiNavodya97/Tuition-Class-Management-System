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

public class Attendance implements Initializable {

    @FXML
    private TextField searchattendance;

    @FXML
    private TableView<AttendanceSearchModule> Attendancetableview;

    @FXML
    private TableColumn<AttendanceSearchModule, String> attstudentcol;

    @FXML
    private TableColumn<AttendanceSearchModule, String> week1col;

    @FXML
    private TableColumn<AttendanceSearchModule, String> week2col;

    @FXML
    private TableColumn<AttendanceSearchModule, String> week3col;

    @FXML
    private TableColumn<AttendanceSearchModule, String> week4col;

    @FXML
    private TableColumn<AttendanceSearchModule, String> paymentcol;

    @FXML
    private Button attendanceedit;

    @FXML
    private Button attback;

    public void attendancebackbuttonAction(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Stage stage =(Stage) attback.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void AttendanceEditActionButton(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("attendanceEdit.fxml"));
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    ObservableList<AttendanceSearchModule> attendanceSearchModuleObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        DatabaseConnection connection3 = new DatabaseConnection();
        Connection connectDB3 =connection3.getConnection();

        String AttendanceView = "SELECT attendances_id,week1,week2,week3,week4,payment FROM  attendance_payment;";


        try{

            Statement statement =connectDB3.createStatement();
            ResultSet QueryOutput3 = statement.executeQuery(AttendanceView);

            while (QueryOutput3.next()){

                String Queryattendances_id = QueryOutput3.getString("attendances_id");
                String Queryweek1 = QueryOutput3.getString("week1");
                String Queryweek2 = QueryOutput3.getString("week2");
                String Queryweek3 = QueryOutput3.getString("week3");
                String Queryweek4 = QueryOutput3.getString("week4");
                String Querypayment = QueryOutput3.getString("payment");


                attendanceSearchModuleObservableList.add(new AttendanceSearchModule(Queryattendances_id,Queryweek1,Queryweek2,Queryweek3,Queryweek4,Querypayment));

            }

            attstudentcol.setCellValueFactory(new PropertyValueFactory<>("attendances_id"));
            week1col.setCellValueFactory(new PropertyValueFactory<>("week1"));
            week2col.setCellValueFactory(new PropertyValueFactory<>("week2"));
            week3col.setCellValueFactory(new PropertyValueFactory<>("week3"));
            week4col.setCellValueFactory(new PropertyValueFactory<>("week4"));
            paymentcol.setCellValueFactory(new PropertyValueFactory<>("payment"));


            Attendancetableview.setItems(attendanceSearchModuleObservableList);

            FilteredList<AttendanceSearchModule>filteredAttendance = new FilteredList<>(attendanceSearchModuleObservableList, b -> true);
            searchattendance.textProperty().addListener((observable, oldValue2, newValue2) ->{

                filteredAttendance.setPredicate(AttendanceSearchModule ->{

                    if (newValue2.isEmpty() || newValue2.isBlank()||newValue2 == null){
                        return true;
                    }
                    String lowerCaseFilter2 = newValue2.toLowerCase();
                    if(AttendanceSearchModule.getAttendances_id().toLowerCase().indexOf(lowerCaseFilter2) != -1){
                        return true;
                    }
                    else
                        return false;
                });
            });

            SortedList<AttendanceSearchModule>sortedAttendance = new SortedList<>(filteredAttendance);
            sortedAttendance.comparatorProperty().bind(Attendancetableview.comparatorProperty());
            Attendancetableview.setItems(sortedAttendance);

        }catch (SQLException e){
            Logger.getLogger(Attendance.class.getName()).log(Level.SEVERE,null, e);
            e.printStackTrace();


        }

    }
}
