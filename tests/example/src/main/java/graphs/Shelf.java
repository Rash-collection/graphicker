/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package graphs;

import java.awt.image.BufferedImage;
import java.util.HashMap;

/**
 *
 * @author rash4
 */
public class Shelf {
    public final static Shelf SHELF = new Shelf();
    public int len(){return this.canvases.values().size();}
    private Shelf(){
        this.canvases = new HashMap<>();
    }
    public BufferedImage[] array(){
        return this.canvases.values().toArray(BufferedImage[]::new);
    }
    public Shelf add(String name, BufferedImage img){
        // never null or empty names and never null image.
        if(name == null || name.isBlank() || img == null)return this;
        this.canvases.put(name, img);
        return this;
    }
    public BufferedImage getImage(String name){
        return this.canvases.get(name);
    }
    private final HashMap<String, BufferedImage> canvases;
}