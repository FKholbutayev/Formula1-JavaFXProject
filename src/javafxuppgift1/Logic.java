/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxuppgift1;

import java.util.ArrayList;

/**
 *
 * @author ULTRA
 */
public class Logic {
    
    private ArrayList<Stats> stats; 
    private ArrayList<Drivers> drivers; 
    private ArrayList<Races> races; 
    
    public Logic(){
    this.drivers = new ArrayList<>(); 
    this.races = new ArrayList<>(); 
    this.stats = new ArrayList<>();
    }
    
    
    public void addDrivers (Drivers driverstats){
        this.drivers.add(driverstats);
    }
    
}
