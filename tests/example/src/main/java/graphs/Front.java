/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package graphs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author rash4
 */
public class Front {
    public Front(String title){
        this.list = Shelf.SHELF.array();
        System.out.println("Array is constructed.");
        System.out.println("Array length = " + Shelf.SHELF.len());
        this.panel = new JPanel(){
            @Override protected void paintComponent(java.awt.Graphics g){
                super.paintComponent(g);
                Front.this.render((Graphics2D)g);
            }
        };
        this.frame = new JFrame(title);
    }
    
    public Front initialize(int width, int height){
        this.panel.setPreferredSize(new Dimension(width, height));
        this.panel.setLayout(null);
        this.panel.addKeyListener(new KeyAdapter(){
            @Override public void keyPressed(KeyEvent ke){
                switch(ke.getKeyCode()){
                    case KeyEvent.VK_ESCAPE->System.exit(0);
                }
            }
        });
        this.panel.addMouseWheelListener((MouseWheelEvent e) -> {
            Front.this.delta += (e.getPreciseWheelRotation() * Front.this.scrlSpeed);
            Front.this.panel.repaint();
            
        });
        this.frame.setContentPane(this.panel);
        this.frame.pack();
        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(2);
        this.frame.addWindowFocusListener(new WindowFocusListener(){
            @Override public void windowGainedFocus(WindowEvent e) {
                Front.this.panel.requestFocusInWindow();
            }
            @Override public void windowLostFocus(WindowEvent e) {}
        });
        
        this.frame.setVisible(true);
        return this;
    }
    private void render(Graphics2D grr){
        final int len = list.length, zis = 64;
        final var siz = this.panel.getSize();
        final int cols = Math.floorDiv(siz.width, zis);
        // doesn't need the rows anymore!
//                , rows = Math.floorDiv(siz.height, zis) + 1;
        final int firstRow = (int)(this.delta / zis);
        final int lastRow  = (int)((this.delta + siz.height) / zis);

        final int first = Math.max(0, firstRow * cols);
        final int last  = Math.min(len, (lastRow + 1) * cols);
            if(-this.delta >= siz.height) {
                System.out.println("Vanished XD");
                this.delta += this.scrlSpeed;
                return;
            }
            else if((last/cols * zis) - this.delta <= -zis) {
                System.out.println("Vanished XD");
                this.delta -= this.scrlSpeed;
                return;
            }else System.out.println("Drawing.");
        for(int i = first; i < last; i++){
            final int   xx = (i%cols) * zis,
                        yy = (i/cols) * zis;
            grr.drawImage(this.list[i], xx, (int)(yy - this.delta), zis, zis, null);
        }
        final int scrz = 12, scrc = scrz/2, scrx = siz.width - scrz, scry = -(int)Math.floor(this.delta);
        grr.setColor(Color.BLACK);
        grr.fillRect(scrx, 0, scrz, siz.height);
        grr.setColor(Color.WHITE);
        grr.fillRect(scrx + 1, +1, scrz - 2, siz.height - 2);
        grr.setColor(Color.LIGHT_GRAY);
        grr.fillRoundRect(scrx, scry, scrz, scrz, scrc, scrc);
    }
    private final int scrlSpeed = 10;
    private double delta = 0;
    private BufferedImage[] list;
    private JFrame frame;
    private JPanel panel;
}