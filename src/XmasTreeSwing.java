/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ganze
 */
import Light.Light;
import Light.SimpleLightFactory;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class XmasTreeSwing extends JFrame implements ActionListener {
    //Buttons

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private JButton lightButton;
    private JButton presentButton;
    private JButton ornamentButton;
    private JButton addAllButton;
    private JButton exitButton;
    private JButton birdButton;

    //Panels
    private JPanel titlePanel, imagePanel, buttonPanel, infoPanel;

    //Labels
    private JLabel title, imageLabel, buttonLabel;

    //Image
    private ImageIcon image;

    //Boolean
//   private boolean presents = true;
//   private boolean ornaments = true;
//   private boolean lights = true;
    private boolean presents = false;
    private boolean ornaments = false;
    private boolean lights = false;
    private boolean bird = false;
    
    private SimpleLightFactory simpleLightFactory;

    public XmasTreeSwing() {
        simpleLightFactory = new SimpleLightFactory();
        //get screen size

        //Set title
        setTitle("Decorate the Dragon Boat!");

        setLayout(new BorderLayout());

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

        //Creating a new JPanel for the image to go
        imagePanel = new JPanel();

        //Retrieving image from the file
        image = new ImageIcon(getClass().getResource("resources/dragon_boat.png"));
        Image i = image.getImage();
        Image resizedImage = i.getScaledInstance(screenSize.width * 70 / 100, screenSize.height * 70 / 100, Image.SCALE_SMOOTH);
        image = new ImageIcon(resizedImage);

        //Adding the image to a label
        imageLabel = new JLabel(image);

        //Adding image label to the image panel
        imagePanel.add(imageLabel);

        //Setting colour of image panel
        imagePanel.setBackground(Color.white);

        //Creating a new JPanel for the buttons to go
        buttonPanel = new JPanel();

        //Setting colour of button panel
        buttonPanel.setBackground(Color.white);

        //Button Label
        // buttonLabel = new JLabel("Click on the button to add the item to the tree.");
        buttonLabel = new JLabel("");
        buttonLabel.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));
        buttonLabel.setForeground(Color.red);
        buttonLabel.setHorizontalAlignment(SwingConstants.CENTER);
        buttonLabel.setBackground(Color.white);

        //Info panel
        infoPanel = new JPanel();
        infoPanel.add(buttonLabel);
        infoPanel.setBackground(Color.white);

        //Naming buttons
        lightButton = new JButton("Lights");
        presentButton = new JButton("Presents");
        ornamentButton = new JButton("Ornaments");
        addAllButton = new JButton("Add All");
        exitButton = new JButton("Exit");
        birdButton = new JButton("FlyingBird");

        //Setting colour of buttons
        lightButton.setBackground(Color.red);
        ornamentButton.setBackground(Color.red);
        presentButton.setBackground(Color.red);
        addAllButton.setBackground(Color.red);
        exitButton.setBackground(Color.red);
        birdButton.setBackground(Color.red);

        //Setting font on buttons
        lightButton.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));
        ornamentButton.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));
        presentButton.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));
        addAllButton.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));
        exitButton.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));
        birdButton.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));

        //Setting font colour on buttons
        lightButton.setForeground(Color.white);
        ornamentButton.setForeground(Color.white);
        presentButton.setForeground(Color.white);
        addAllButton.setForeground(Color.white);
        exitButton.setForeground(Color.white);
        birdButton.setForeground(Color.white);

        //Add the buttons to the buttonPanel
        buttonPanel.add(lightButton);
        buttonPanel.add(ornamentButton);
        buttonPanel.add(presentButton);
        buttonPanel.add(addAllButton);
        buttonPanel.add(exitButton);
        buttonPanel.add(birdButton);

        //Enable buttons to listen for a mouse-click
        lightButton.addActionListener(this);
        ornamentButton.addActionListener(this);
        presentButton.addActionListener(this);
        addAllButton.addActionListener(this);
        exitButton.addActionListener(this);
        birdButton.addActionListener(this);

        //Positioning Panels
        add(titlePanel, BorderLayout.NORTH);
        add(imagePanel, BorderLayout.CENTER);
        imagePanel.add(infoPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        //Configure the frame
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set around 70% of the screen size
        setSize(screenSize.width * 70 / 100, screenSize.height * 70 / 100);
        setLocation(300, 40);
        setVisible(true);

    }//Constructor

    public void paint(Graphics g) {
        //Call the paint method of the superclass
        super.paint(g);

        if (lights) {
            Light light = simpleLightFactory.getLight("shape");
            light.setGraphic(g);
            light.render();
            //draw lights
            g.setColor(Color.white);

            //middle lights
            g.fillOval(250, 190, 10, 10);
            g.fillOval(250, 260, 10, 10);
            g.fillOval(250, 350, 10, 10);
            g.fillOval(250, 430, 10, 10);

            //left lights
            g.fillOval(200, 260, 10, 10);
            g.fillOval(180, 350, 10, 10);
            g.fillOval(160, 430, 10, 10);

            //right lights
            g.fillOval(300, 260, 10, 10);
            g.fillOval(330, 350, 10, 10);
            g.fillOval(340, 430, 10, 10);

        }//if lights

        if (ornaments) {
            //draw ornaments
            g.setColor(Color.red);
            g.fillOval(220, 220, 15, 15);
            g.fillOval(280, 220, 15, 15);
            g.setColor(Color.blue);
            g.fillOval(320, 380, 15, 15);
            g.fillOval(180, 380, 15, 15);
            g.setColor(Color.cyan);
            g.fillOval(200, 300, 15, 15);
            g.fillOval(300, 300, 15, 15);

        }//if ornaments

        if (presents) {
            //draw presents
            g.setColor(Color.red);
            //   g.fillRect(320,500,60,60);
            //    g.fillRect(140,480,30,30);
            g.fillRect(320, 400, 60, 60);
            g.fillRect(140, 380, 30, 30);

            g.setColor(Color.orange);
            //   g.fillRect(180,530,40,40);
            g.fillRect(180, 430, 40, 40);

            g.setColor(Color.blue);
            //     g.fillRect(120,500,60,60);
            //   g.fillRect(360,540,30,30);

            g.fillRect(120, 400, 60, 60);
            g.fillRect(360, 440, 30, 30);

        }//if presents

        if (bird) {

            image = new ImageIcon(getClass().getResource("resources/articuno_fly.png"));
            Image birdImage = image.getImage();
            Image resizedImage = birdImage.getScaledInstance(screenSize.width * 20 / 100, screenSize.height * 20 / 100, Image.SCALE_SMOOTH);
            image = new ImageIcon(resizedImage);
            g.drawImage(resizedImage, screenSize.width *40/100, screenSize.height*5/100, this);
        }

    } //paint

    //Coding the event-handling routine
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == lightButton) {
            ornaments = false;
            presents = false;
            lights = true;
            repaint();

        }//if light
        else if (event.getSource() == ornamentButton) {
            lights = false;
            presents = false;
            ornaments = true;
            repaint();

        }//if ornament
        else if (event.getSource() == presentButton) {
            lights = false;
            ornaments = false;
            presents = true;
            repaint();

        }//if present
        else if (event.getSource() == addAllButton) {
            lights = true;
            ornaments = true;
            presents = true;
            repaint();
        }//if add all
        else if (event.getSource() == birdButton) {
            bird = true;
            repaint();
        } else {
            System.exit(0);

        }//else exit

    } //actionPerformed

    public static void main(String[] args) {
        XmasTreeSwing gui = new XmasTreeSwing();

    }//main

}//class
