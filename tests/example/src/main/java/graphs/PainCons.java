/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package graphs;

import graphicker.MageCons;
import graphicker.Pixelator;

/**
 *
 * @author rash4
 */
public class PainCons {
    public final static PainCons PAINTER = new PainCons();
    private PainCons(){}
    
    public PainCons toMage(String name, Pixelator grinda){
        Shelf.SHELF.add(name, MageCons.toImage(grinda));
        return this;
    }
    /**Empty for now*/
    public PainCons toPixe(){
        
        return this;
    }
}