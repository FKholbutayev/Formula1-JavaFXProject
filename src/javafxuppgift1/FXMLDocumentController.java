/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxuppgift1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.application.Platform;
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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

/**
 *
 * @author ULTRA
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TableView<Drivers> tableview;
    @FXML
    private TableColumn<Drivers, Integer> colrank;
    @FXML
    private TableColumn<Drivers, String> colname;
    @FXML
    private TableColumn<Drivers, String> colcountry;
    @FXML
    private TableColumn<Drivers, String> colcar;
    @FXML
    private ImageView driverimage;
    public static ObservableList<Drivers> stats;
    @FXML
    private TextField search;
    @FXML
    private AnchorPane root;
    @FXML
    private Button buttonplus;
    @FXML
    private Button buttonminus;
    @FXML
    private Button buttonx;
    @FXML
    private TableColumn<Stats, Integer> colpod;
    @FXML
    private TableColumn<Stats, Integer> colpoints;
    @FXML
    private TableColumn<Stats, Integer> colgp;
    @FXML
    private TableView<Stats> tableviewstats;
    public static ObservableList<Stats> driverStats;
    @FXML
    private TableView<Races> tableraces;
    @FXML
    private TableColumn<Races, String> colraces;
    @FXML
    private TableColumn<Races, String> colseason;
    public static ObservableList<Races> races;
    
    
    
      
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            
          
            Stats f = new Stats(1,9,4);
            Stats g = new Stats(2,27,5);
            Stats j = new Stats(4,5,6);
            Stats t = new Stats(6,6,5); 
            Stats r = new Stats(8,9,12);
            
            Races ab = new Races("AUSTRALIA GP","SUMMER");
            Races bc = new Races("BAHRAIN GP","SUMMER");
            Races cd = new Races("RUSSIA GP","FALL");
            Races ef = new Races("MONTE CARLO GP","FALL");
            Races fg = new Races("BAKU GP","SPRING");
            Races gh = new Races("CHINA GP","SPRING");
                    
            Drivers a = new Drivers(1,"SEBASTIAN VETTEL", "GER", "FERRARI");
            a.addStats(f);
            a.addRaces(ab);
            a.addRaces(ef);
            a.addRaces(fg);
            a.addRaces(bc);
            a.addRaces(cd);
            
            Drivers b = new Drivers(2,"LEWIS HAMILTON", "GBR", "MERCEDES");
            b.addStats(g);
            b.addRaces(ef);
            b.addRaces(gh);
            b.addRaces(ab);
            b.addRaces(bc);
            b.addRaces(fg);
            
            Drivers c = new Drivers(3,"VALTTERI BOTTAS", "FIN", "MERCEDES");
            c.addStats(j);
            c.addRaces(ef);
            c.addRaces(ab);
            c.addRaces(gh);
            c.addRaces(fg);
            c.addRaces(bc);
            
            
            Drivers d = new Drivers(4,"KIMI RÄIKKÖNEN", "FIN", "FERRARI");
            d.addStats(t);
            
            d.addRaces(gh);
            d.addRaces(ef);
            d.addRaces(bc);
            d.addRaces(fg);
            d.addRaces(ab);
            
            Drivers e = new Drivers(5,"MAX VERSTAPPEN", "NED", "RED BULL"); 
            e.addStats(r);
            e.addRaces(ef);
            e.addRaces(gh);
            e.addRaces(ab);
            e.addRaces(bc);
            e.addRaces(fg);
            
            stats = FXCollections.observableArrayList(a,b,c,d,e);
            driverStats =FXCollections.observableArrayList(f,g,j,t,r);
            races = FXCollections.observableArrayList(ab,bc,ef,fg);
            
            
        colpod.setCellValueFactory(new PropertyValueFactory<Stats, Integer>("podiums"));
        colpoints.setCellValueFactory(new PropertyValueFactory<Stats, Integer>("points"));
        colgp.setCellValueFactory(new PropertyValueFactory<Stats,Integer>("gpentered"));
            
        
        colrank.setCellValueFactory(new PropertyValueFactory<Drivers, Integer>("rank"));
        colname.setCellValueFactory(new PropertyValueFactory<Drivers, String>("name"));
        colcountry.setCellValueFactory(new PropertyValueFactory<Drivers,String>("country"));
        colcar.setCellValueFactory(new PropertyValueFactory<Drivers, String>("car"));
        
        colraces.setCellValueFactory(new PropertyValueFactory<Races, String>("races"));
        colseason.setCellValueFactory(new PropertyValueFactory<Races, String>("season"));
        //here goues again 
        
        FilteredList<Drivers> filteredData = new FilteredList<>(stats);              ;
        search.textProperty().addListener((observable, oldValue, newValue)->{
            filteredData.setPredicate((Predicate<? super Drivers>) new Predicate<Drivers>() {
                @Override
                public boolean test(Drivers drivers) {
                    if(newValue == null || newValue.isEmpty()){
                        return true;
                    }
                    String lowerCaseF = newValue.toLowerCase();
                    if(drivers.getCountry().toLowerCase().contains(lowerCaseF)) {
                        return true;
                    }
                    
                    else if(drivers.getCar().toLowerCase().contains(lowerCaseF)){
                        return true;
                    }
                    
                    else if(drivers.getName().toLowerCase().contains(lowerCaseF)){
                        return true;
                    }
                    
                    
                    return false;
                }
            });
        });
        
        SortedList<Drivers> sortedList = new SortedList<>(filteredData);
        sortedList.comparatorProperty().bind(tableview.comparatorProperty());
        tableview.setItems(sortedList);
        tableviewstats.setItems(driverStats);
        tableraces.setItems(races);
        
    
            
       System.out.println(stats.size());
//        tableview.refresh();
        colrank.setCellFactory((TextFieldTableCell.forTableColumn(new IntegerStringConverter())));
//        tableview.setItems(stats);
        
        
        System.out.println(stats.size());
        buttonplus.getStyleClass().add("button");
        driverStats.clear();
        races.clear();
        
    }              
        
    

    @FXML
    private void mouseclickedontable(MouseEvent event) {
        
        System.out.println(tableview.getSelectionModel().getSelectedItem().getName());
        String selectedItem = tableview.getSelectionModel().getSelectedItem().getName();
        driverStats.clear();
        races.clear();
        
         
       // tableview.getSelectionModel().selectedItemProperty().addListener(((observable, OldValue, newValue)-> {
        for(Drivers c : stats){
            for(Stats d: c.getStatsArrayList()){
                if(c.getName().equals(selectedItem)){
                System.out.println(d.getPoints());
                driverStats.addAll(c.getStatsArrayList());
                }
                
            for(Races r: c.getRacesArrayList()){
                if(c.getName().equals(selectedItem)){
                System.out.println(r.getRaces());
                races.clear();
                races.addAll(c.getRacesArrayList());
                System.out.println(c.getRacesArrayList());
            }    
                       
        }
                
              
            
                   
        switch(selectedItem) {
            case "SEBASTIAN VETTEL": 
            Image image1 = new Image(getClass().getResourceAsStream("images/1.jpg"));
            driverimage.setImage(image1);
            break;
            
            case "LEWIS HAMILTON": 
            Image image2 = new Image(getClass().getResourceAsStream("images/2.jpg")); 
            driverimage.setImage(image2);
            break;
            
            case "VALTTERI BOTTAS": 
            Image image3 = new Image(getClass().getResourceAsStream("images/3.jpg")); 
            driverimage.setImage(image3);
            break;
            
            case "KIMI RÄIKKÖNEN": 
            Image image4 = new Image(getClass().getResourceAsStream("images/4.jpg")); 
            driverimage.setImage(image4);
            break;
            
            case "MAX VERSTAPPEN": 
            Image image5 = new Image(getClass().getResourceAsStream("images/5.jpg")); 
            driverimage.setImage(image5);
            break;
        }
        
        }
        
        //}));
        
        
        }
    }
                
   

   
    @FXML
    private void plusdriver(ActionEvent event) throws IOException {
        
        Parent root1 = FXMLLoader.load(getClass().getResource("addDriver.fxml"));        
        Scene scene = new Scene(root1);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

  

    @FXML
    private void minusdriver(ActionEvent event) {
        
         stats.remove(tableview.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void driverx(ActionEvent event) {
        Platform.exit();
    }

    private void driverstats(ActionEvent event) {
        System.out.println("load stats");
        
        
    }
    //addLine for editing here for Integer with String converter.
   

    @FXML
    private void mouseclickedontable(ContextMenuEvent event) {
    }

    @FXML
    private void editrank(TableColumn.CellEditEvent<Drivers, Integer> event) {
    }

    

    
    
    }

   

    
    

    

   

    
    

   
    

