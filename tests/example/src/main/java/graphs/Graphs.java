/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package graphs;

import graphicker.Kolor;
import javax.swing.SwingUtilities;

/**
 *
 * @author rash4
 */
public class Graphs {
//    final static Front GUI = new Front();
    final static int SID = 256;
    public static void main(String[] args) {
        System.out.println("Hello World!");
        SwingUtilities.invokeLater(()->{
            paints();
        });
        SwingUtilities.invokeLater(()->{
            new Front("Graphicker -> Test").initialize(820, 760);
        });
    }
    static void paints(){
        final var con = PainCons.PAINTER;
        con.toMage("Wala", ()->{
            final var grit = new int[SID][SID];
            for(int row = 0; row < SID; row++){
                for(int col = 0; col < SID; col++){
                    grit[row][col] = Kolor.getInt(65, 120, 88);
                }
            }
            System.out.println("Wala is constructed");
            return grit;
        }).toMage("baha", ()->{
            final var grit = new int[SID][SID];
            for(int row = 0; row < SID; row++){
                for(int col = 0; col < SID; col++){
                    grit[row][col] = Kolor.getInt(165, 220, 188);
                }
            }
            return grit;
        }).toMage("kaka", ()->{
            final var grit = new int[SID][SID];
            for(int row = 0; row < SID; row++){
                for(int col = 0; col < SID; col++){
                    grit[row][col] = Kolor.getInt(165, 220, 248);
                }
            }
            return grit;
        }).toMage("tata", ()->{
            final var grit = new int[SID][SID];
            for(int row = 0; row < SID; row++){
                for(int col = 0; col < SID; col++){
                    grit[row][col] = Kolor.getInt(215, 220, 188);
                }
            }
            return grit;
        }).toMage("rara", ()->{
            final var grit = new int[SID][SID];
            for(int row = 0; row < SID; row++){
                for(int col = 0; col < SID; col++){
                    grit[row][col] = Kolor.getInt(165, 120, 188);
                }
            }
            return grit;
        })
        ;
    }
}