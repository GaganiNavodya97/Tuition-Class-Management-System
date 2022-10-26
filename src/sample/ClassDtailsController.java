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

public class ClassDtailsController implements Initializable {

    @FXML
    private TextField searchclasstable1;

    @FXML
    private TableView<ClassSearchModule> classtableview1;

    @FXML
    private TableColumn<ClassSearchModule, String> clzidcol1;

    @FXML
    private TableColumn<ClassSearchModule, String> csbjectcol1;

    @FXML
    private TableColumn<ClassSearchModule, String> roomcol1;

    @FXML
    private TableColumn<ClassSearchModule, String> timecol1;

    @FXML
    private Button clzaddedit;

    @FXML
    private Button clzback;



    public void classbackbuttonAction (ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Stage stage =(Stage) clzback.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void ClassEditAddButtonAction(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("classEdit.fxml"));
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    ObservableList<ClassSearchModule>classSearchModuleObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        DatabaseConnection connection4 = new DatabaseConnection();
        Connection connectDB4 = connection4.getConnection();

        String Classview = "SELECT class_id, subject, room_no, time FROM classtable;";

        try{

            Statement statement =connectDB4.createStatement();
            ResultSet QueryOutput4 = statement.executeQuery(Classview);

            while (QueryOutput4.next()){

                String Queryclass_id = QueryOutput4.getString("class_id");
                String Querysubject = QueryOutput4.getString("subject");
                String Queryroom_no = QueryOutput4.getString("room_no");
                String Querytime = QueryOutput4.getString("time");

                classSearchModuleObservableList.add(new ClassSearchModule(Queryclass_id,Querysubject,Queryroom_no,Querytime));
            }
            clzidcol1.setCellValueFactory(new PropertyValueFactory<>("class_id"));
            csbjectcol1.setCellValueFactory(new PropertyValueFactory<>("subject"));
            roomcol1.setCellValueFactory(new PropertyValueFactory<>("room_no"));
            timecol1.setCellValueFactory(new PropertyValueFactory<>("time"));


            classtableview1.setItems(classSearchModuleObservableList);


            FilteredList<ClassSearchModule> filteredclzdetails = new FilteredList<>(classSearchModuleObservableList, b -> true);

            searchclasstable1.textProperty().addListener((observable, oldValue3, newValue3) ->{

                filteredclzdetails.setPredicate(ClassSearchModule ->{

                    if (newValue3.isEmpty() || newValue3.isBlank()||newValue3 == null){
                        return true;
                    }
                    String lowerCaseFilter3 = newValue3.toLowerCase();

                    if(ClassSearchModule.getClass_id().toLowerCase().indexOf(lowerCaseFilter3) != -1){
                        return true;
                    }else if(ClassSearchModule.getSubject().toLowerCase().indexOf(lowerCaseFilter3) !=-1){
                        return true;
                    }else if(ClassSearchModule.getRoom_no().toLowerCase().indexOf(lowerCaseFilter3) != -1){
                        return true;
                    }else if(ClassSearchModule.getTime().toLowerCase().indexOf(lowerCaseFilter3) != -1){
                        return true;
                    }else
                        return false;
                });

            });

            SortedList<ClassSearchModule>  sortedClzdetails = new SortedList<>(filteredclzdetails);
            sortedClzdetails.comparatorProperty().bind(classtableview1.comparatorProperty());
            classtableview1.setItems(sortedClzdetails);


        }catch(SQLException e){
            Logger.getLogger(ClassDtailsController.class.getName()).log(Level.SEVERE,null, e);
            e.printStackTrace();
        }

    }
}
