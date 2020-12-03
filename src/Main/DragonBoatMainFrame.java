/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author Wah
 */

// temporary not use.. except want chg to this approach
public class DragonBoatMainFrame extends JFrame{
    
    public DragonBoatMainFrame(){
        initLayout();
    }
    
    private void initLayout() {
        add(new DragonBoat());
        setTitle("Decorate the Dragon Boat");
        

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    
    
    public static void main(String[] args) {
        EventQueue.invokeLater( () -> {
            new DragonBoatMainFrame();
        });
    }
    
}
