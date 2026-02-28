/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package graphs;

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
            Front.this.delta += (e.getPreciseWheelRotation() * 10D);
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
        final int cols = Math.floorDiv(siz.width, zis),
                rows = Math.floorDiv(siz.height, zis) + 1;
        if(-this.delta >= siz.height || this.delta - zis >= 0) {
            System.out.println("Vanished XD");
            return;
        }
        for(int i = 0; i < len; i++){
            final int xx = (i%cols) * zis,
                    yy = ((i/cols)%rows) * zis;
            // skip any image outside panel bounds
            if (xx + zis >= siz.width || yy + zis >= siz.height) continue;
            grr.drawImage(this.list[i], xx, (int)(yy - this.delta), zis, zis, null);
        }
    }
    private double delta = 0;
    private BufferedImage[] list;
    private JFrame frame;
    private JPanel panel;
}