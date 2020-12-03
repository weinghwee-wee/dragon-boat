/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Bird.Articuno;
import Bird.Bird;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Wah
 */

// temporary not use.. except want chg to this approach
public class DragonBoat extends JPanel {

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = screenSize.width * 70 / 100;
    int height = screenSize.height * 70 / 100;
    Image background;
    Bird articuno;
    private ImageIcon image;

    private JButton lightButton;
    private JButton fishButton;
    private JButton zongziButton;
    private JButton birdButton;
    private JButton musicButton;
    private JButton exitButton;

    //Panels
    private JPanel titlePanel, imagePanel, buttonPanel, infoPanel;

    //Labels
    private JLabel title, imageLabel, buttonLabel;

    public DragonBoat() {
        initLayout();

        //init background
        ImageIcon image = new ImageIcon(getClass().getResource("/resources/dragon_boat.png"));
        Image i = image.getImage();
        this.background = i.getScaledInstance(screenSize.width * 70 / 100, screenSize.height * 70 / 100, Image.SCALE_SMOOTH);

        //Setting the title of the JLabel
        title = new JLabel("Click on the button to add the adornment to the tree.");

        //Setting the font
        title.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 15));

        //Setting the text colour to red and positioning it to the centre
        title.setForeground(Color.red);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        //Creating a new JPanel and adding the title label to it
        titlePanel = new JPanel();
        titlePanel.add(title);

        //Setting colour of title panel
        titlePanel.setBackground(Color.white);

        articuno = new Articuno();

    }

    private void drawsomething(Graphics g) {
//        articuno.performBirdBehavior();
//        g.drawImage(articuno.getImage(), 15, 15, this);


        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/resources/articuno_fly.png"));
        Image flyingimage = imageIcon.getImage();
        Image resizedImage = flyingimage.getScaledInstance(screenSize.width * 20 / 100, screenSize.height * 20 / 100, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(resizedImage);
//                g.drawImage(resizedImage, 0, 0, null);

//         image = new ImageIcon(getClass().getResource("/resources/articuno_fly.png"));
//            Image birdImage = image.getImage();
//            Image resizedImage = birdImage.getScaledInstance(screenSize.width * 20 / 100, screenSize.height * 20 / 100, Image.SCALE_SMOOTH);
//            image = new ImageIcon(resizedImage);
        g.drawImage(resizedImage, screenSize.width * 40 / 100, screenSize.height * 5 / 100, this);

    }

    private void initLayout() {
        setPreferredSize(new Dimension(width, height));

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, this);
        drawsomething(g);
    }

}
