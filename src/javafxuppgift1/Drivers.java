/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxuppgift1;

import java.util.ArrayList;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author ULTRA
 */
public class Drivers {
    
    private IntegerProperty rank;
    private StringProperty name; 
    private StringProperty country; 
    private StringProperty car; 
    private ArrayList<Stats> statistics;
    private ArrayList<Races> races;
    
    
    public Drivers(int rank, String name, String country, String car) {
    
        this.rank = new SimpleIntegerProperty(rank);
        this.name = new SimpleStringProperty(name); 
        this.country = new SimpleStringProperty(country); 
        this.car = new SimpleStringProperty(car);
        this.statistics = new ArrayList<>();
        this.races = new ArrayList<>();
    }
    
    public void addStats(Stats driverstats){
    this.statistics.add(driverstats);
    }
    
    public ArrayList<Stats> getStatsArrayList(){
    return statistics;
    }
    
    public void addRaces(Races driverraces){
    this.races.add(driverraces);
    }
    
    public ArrayList<Races> getRacesArrayList(){
    return races;
    }
    
        
    
    public IntegerProperty rankProperty(){
    return rank;
    }
    
    public StringProperty nameProperty(){
    return name;
    }
    
    public StringProperty countryProperty(){
    return country;
    }
    
    public StringProperty carProperty(){
    return car;
    }
    
//    public Stats getStatistics() {
//        return statistics;
//    }
//
//    public void setStatistics(Stats statistics) {
//        this.statistics = statistics;
//    }
    
    
    public final int getRank(){
    return rank.get(); 
    }
    
    public final String getName(){
    return name.get();
    }
       
    public final String getCountry(){
    return country.get();
    }
    
    public final String getCar(){
    return car.get(); 
    }
    
    public final void setRank(Integer rank) {
    this.rank.set(rank);
    }
    
    public final void setName(String name){
    this.name.set(name);
    }
    
    public final void setCountry(String country){
    this.country.set(country);
    }
    
    public final void setCar(String car){
    this.car.set(car);
    }
   
    
    
    
}
