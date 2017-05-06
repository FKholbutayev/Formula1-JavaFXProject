/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxuppgift1;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author ULTRA
 */
public class Races {
    
    private StringProperty races;
    private StringProperty season; 
    
    public Races(){
    
    }
    
    public Races(String races, String season){
    
        this.races = new SimpleStringProperty(races); 
        this.season = new SimpleStringProperty(season);
    }
    
    public final String getRaces(){
    return this.races.get();
    }
    
    public final String getSeason(){
    return this.season.get();
    }
    
}
