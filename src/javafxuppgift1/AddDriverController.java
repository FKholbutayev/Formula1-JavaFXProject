/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxuppgift1;

import java.io.IOException;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ULTRA
 */
public class AddDriverController implements Initializable {

    @FXML
    private TextField txtrank;
    @FXML
    private TextField txtname;
    @FXML
    private TextField txtcountry;
    @FXML
    private TextField txtcar;
    @FXML
    private Button register;
    @FXML
    private ImageView imageview;
    @FXML
    private Label warning;
    @FXML
    private Button back;
    Drivers a;
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void handleregister(ActionEvent event) throws IOException {
       
        String rank = (txtrank.getText().toUpperCase());
        Integer ranky = Integer.parseInt(rank);
        
        String  name = txtname.getText().toUpperCase(); 
        String country = txtcountry.getText().toUpperCase(); 
        String car = txtcar.getText().toUpperCase();
        
        System.out.println(FXMLDocumentController.stats.size());
        
        try {
        
        if(txtcountry.getText().isEmpty() || txtcar.getText().isEmpty() || txtname.getText().isEmpty() || txtrank.getText().isEmpty()) {
            warning.setText("FILL THE FIELDS");
        }
         
        else if(ranky == 0) {
                warning.setText("NO ZERO RANK");
        }
              
        
        
        else{
        
            a = new Drivers(ranky,name,country,car);
            FXMLDocumentController.stats.add(a);
            warning.setText("DRIVER REGISTERED");
        }
        
        } catch(NumberFormatException e) {
            System.out.println("Input mismatch");
        }
        
        
//        try { 
//                   
//            
//        } catch(NumberFormatException e) {
//        System.out.println("Lady lady lady");
//        }
            
        
         
       
        
        
        //a = new Drivers(rank,name,country,car);
        
        
        
        
        
        System.out.println(FXMLDocumentController.stats.size());
        
        
        
        
    }

    @FXML
    private void goback(ActionEvent event) throws IOException {
        
        Parent root1 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));        
        Scene scene = new Scene(root1);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        FXMLDocumentController.stats.add(a);
    }
    
}
