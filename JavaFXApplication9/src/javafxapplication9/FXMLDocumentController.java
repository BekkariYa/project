/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package javafxapplication9;

import com.mysql.jdbc.PreparedStatement;
import com.sun.jdi.connect.spi.Connection;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;


/**
 *
 * @author bekkari
 */
public class FXMLDocumentController implements Initializable {
    
  
    @FXML
    private AnchorPane side_form;
    @FXML
    private Button side_btn;
    @FXML
    private AnchorPane si_loginform;
    @FXML
    private TextField si_uesrname;
    @FXML
    private PasswordField si_password;
    @FXML
    private Button si_login_btn;
    @FXML
    private Hyperlink si_forgot;
    @FXML
    private AnchorPane su_signupform;
    @FXML
    private TextField su_ansewer;
    @FXML
    private TextField su_uesrname;
    @FXML
    private PasswordField su_password;
    @FXML
    private Button su_signUpbtn;
    @FXML
    private ComboBox<?> su_question;
    @FXML
    private Button side_Already;
    
    private Connection connect;
    private PreparedStatement prepare ;
    private ResultSet result;
    private Alert alert;
    public void regbtn(){
        if(su_uesrname.getText().isEmpty() || su_password.getText().isEmpty()|| su_question.getSelectionModel().getSelectedItem()== null
                ||su_ansewer.getText().isEmpty()){
            alert =new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error  Message ");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        }else{
            String regData = "INSERT INTO doctor_cicritaria(uesrname, password, question, ansewer)"
                    +"VALUES(?,?,?,?)";
            connect = databases.connectDB();
            try {
                prepare =connect.prepareStatement(regData);
                prepare.setString(1, su_uesrname.getText());
                prepare.setString(2, su_password.getText());
                prepare.setString(3, (String)su_question.getSelectionModel().getSelectedItem());
                prepare.setString(4, su_ansewer.getText());
                
                prepare.executeUpdate();
                
            alert =new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("INFORMATION  Message ");
            alert.setHeaderText(null);
            alert.setContentText("Successfully registered Account !");
            alert.showAndWait();
                
                
            } catch (Exception e) { e.printStackTrace();
            }
        }
    }
        //////////////////Function to display questions in combox qusetion /////////////
    ////////////////lkef,lkezjfmlkjzfemlker
    /////////////////flkrjfelmkjrfzejmlrfkjmkjpoaeifjerlnfkekj
     private String[] quesStionList ={
        "Are you a Doctor ?","Are you an Employee?"
    };
    public void reqLquestionList(){
        List<String> ListQ = new ArrayList<>();
        for(String data:quesStionList ){
            ListQ.add(data);
        }
        ObservableList ListData = FXCollections.observableArrayList(ListQ);
        su_question.setItems(ListData);
    }
    ///////////////////////////////////////
    @Override
   
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
    }    

    @FXML
    private void switchForm(ActionEvent event) {
        TranslateTransition slider = new TranslateTransition();
        if(event.getSource() == side_btn){
            slider.setNode(side_form);
            slider.setToX(400);
            slider.setDuration(Duration.seconds(.5));
            slider.setOnFinished((ActionEvent e)->{
            side_Already.setVisible(true);
            side_btn.setVisible(false);
            reqLquestionList();  //Call the question function
            });
            slider.play();
            }else if (event.getSource() == side_Already){
                slider.setNode(side_form);
                slider.setToX(0);
                slider.setDuration(Duration.seconds(.5));
            slider.setOnFinished((ActionEvent e)->{
            side_Already.setVisible(false);
            side_btn.setVisible(true);
            });
            slider.play();
            }
            }
       
  
    
}
    

