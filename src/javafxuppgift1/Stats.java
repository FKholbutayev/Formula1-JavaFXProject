/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxuppgift1;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author ULTRA
 */
public class Stats {
    
    private IntegerProperty podiums; 
    private IntegerProperty points; 
    private IntegerProperty gpentered; 
    
    
    public Stats(){
    }
    
    public Stats(int podiums, int points, int gpentered){
        
        this.podiums = new SimpleIntegerProperty(podiums);
        this.points = new SimpleIntegerProperty(points); 
        this.gpentered = new SimpleIntegerProperty(gpentered); 
        
        
    }
    
    
     public final int getPodiums(){
     return podiums.get(); 
     }
     
     public final int getPoints(){
     return points.get(); 
     }
     
     public final int getGpentered(){
     return gpentered.get();
     }
     
          
     public final void setPodiums(Integer podiums) {
     this.podiums.set(podiums);
     }
     
     public final void setPoints(Integer points){
     this.points.set(points);
     }
     
     public final void setGpentered(Integer gpentered){
     this.gpentered.set(gpentered);
     }
     
    
    
}
