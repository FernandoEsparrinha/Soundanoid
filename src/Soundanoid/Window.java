/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Soundanoid;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author fernando
 */
public class Window extends JFrame{
    BufferedImage icon;
    
    
    public Window() throws IOException{
        super();
        
        this.icon = ImageIO.read(Soundanoid.class.getResourceAsStream("pic/icon.png"));
        this.setIconImage(icon);

        setLayout(new BorderLayout());
        
        setResizable(false);
        setSize(400, 580);
        setLocationRelativeTo(null);
        setTitle("Soundanoid");
        setIconImage(icon);
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        setVisible(true);
    }
    
}
