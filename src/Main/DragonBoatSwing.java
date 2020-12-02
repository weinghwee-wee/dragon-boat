package Main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ganze
 */
import Bird.Articuno;
import Bird.Bird;
import Bird.FlyingBird;
import Bird.Penguin;
import Bird.RestingBird;
import Bird.SwimmingBird;
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
import javax.swing.border.EmptyBorder;

public class DragonBoatSwing extends JFrame implements ActionListener {
    //Buttons

    //share among class as global
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private JButton lightButton;
    private JButton presentButton;
    private JButton ornamentButton;
    private JButton addAllButton;
    private JButton articunoFlyButton;
    private JButton articunoRestButton;
    private JButton penguinSwimButton;
    private JButton penguinRestButton;
    private JButton exitButton;

    //Panels
    private JPanel titlePanel, imagePanel, buttonPanel, infoPanel;

    //Labels
    private JLabel title, imageLabel, buttonLabel;

    //Image
    private ImageIcon image;

    //To determine whether to display 
    private boolean presents = false;
    private boolean ornaments = false;
    private boolean lights = false;
    private boolean checkArticuno = false;
    private boolean checkPenguin = false;

    private SimpleLightFactory simpleLightFactory;
    private Bird articuno;
    private Bird penguin;

    public DragonBoatSwing() {
        simpleLightFactory = new SimpleLightFactory();

        //init the birds
        articuno = new Articuno();
        penguin = new Penguin();

        //Set title
        setTitle("Decorate the Dragon Boat!");

        setLayout(new BorderLayout());

        //Setting the title of the JLabel
        title = new JLabel("Click on the button to add the adornment to the event.");

        //Setting the font
        title.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 15));

        //Setting the text colour to red and positioning it to the centre
        title.setForeground(Color.red);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        //Creating a new JPanel and adding the title label to it
        titlePanel = new JPanel();

        //empty border for bird to fly
        titlePanel.setBorder(new EmptyBorder(0, 0, screenSize.height * 10 / 100, 0));
        titlePanel.add(title);

        //Setting colour of title panel
        titlePanel.setBackground(Color.white);

        //Creating a new JPanel for the image to go
        imagePanel = new JPanel();

        //Retrieving image from the file
        image = new ImageIcon(getClass().getResource("/resources/dragon_boat.png"));
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
//         buttonLabel = new JLabel("Click on the button to add the item to the tree.");
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
        articunoFlyButton = new JButton("Articuno Flying");
        articunoRestButton = new JButton("Articuno Resting");
        penguinSwimButton = new JButton("Penguin Swimming");
        penguinRestButton = new JButton("Penguin Resting");
        exitButton = new JButton("Exit");

        //Setting colour of buttons
        lightButton.setBackground(Color.red);
        ornamentButton.setBackground(Color.red);
        presentButton.setBackground(Color.red);
        addAllButton.setBackground(Color.red);
        articunoFlyButton.setBackground(Color.red);
        articunoRestButton.setBackground(Color.red);
        penguinSwimButton.setBackground(Color.red);
        penguinRestButton.setBackground(Color.red);
        exitButton.setBackground(Color.red);

        //Setting font on buttons
        lightButton.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));
        ornamentButton.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));
        presentButton.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));
        addAllButton.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));
        articunoFlyButton.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));
        articunoRestButton.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));
        penguinSwimButton.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));
        penguinRestButton.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));
        exitButton.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));

        //Setting font colour on buttons
        lightButton.setForeground(Color.white);
        ornamentButton.setForeground(Color.white);
        presentButton.setForeground(Color.white);
        addAllButton.setForeground(Color.white);
        articunoFlyButton.setForeground(Color.white);
        articunoRestButton.setForeground(Color.white);
        penguinSwimButton.setForeground(Color.white);
        penguinRestButton.setForeground(Color.white);
        exitButton.setForeground(Color.white);

        //Add the buttons to the buttonPanel
        buttonPanel.add(lightButton);
        buttonPanel.add(ornamentButton);
        buttonPanel.add(presentButton);
        buttonPanel.add(addAllButton);
        buttonPanel.add(articunoFlyButton);
        buttonPanel.add(articunoRestButton);
        buttonPanel.add(penguinSwimButton);
        buttonPanel.add(penguinRestButton);
        buttonPanel.add(exitButton);

        //Enable buttons to listen for a mouse-click
        lightButton.addActionListener(this);
        ornamentButton.addActionListener(this);
        presentButton.addActionListener(this);
        addAllButton.addActionListener(this);
        articunoFlyButton.addActionListener(this);
        articunoRestButton.addActionListener(this);
        penguinSwimButton.addActionListener(this);
        penguinRestButton.addActionListener(this);
        exitButton.addActionListener(this);

        //Positioning Panels
        add(titlePanel, BorderLayout.NORTH);
        add(imagePanel, BorderLayout.CENTER);
        imagePanel.add(infoPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        //Configure the frame
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set around 70% of the screen size
        setSize(screenSize.width * 70 / 100, screenSize.height * 80 / 100);
        setLocation(300, 40);
        setVisible(true);
        setResizable(false);

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
            g.fillRect(320, 400, 60, 60);
            g.fillRect(140, 380, 30, 30);

            g.setColor(Color.orange);
            g.fillRect(180, 430, 40, 40);

            g.setColor(Color.blue);
            g.fillRect(120, 400, 60, 60);
            g.fillRect(360, 440, 30, 30);

        }//if presents

        if (checkArticuno) {
            articuno.performBirdBehavior(g);
        }

        if (checkPenguin) {
            penguin.performBirdBehavior(g);
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
        else if (event.getSource() == articunoFlyButton) {
            checkArticuno = true;
            articuno.setBirdBehavior(new FlyingBird("articuno"));
            repaint();
        } else if (event.getSource() == articunoRestButton) {
            checkArticuno = true;
            articuno.setBirdBehavior(new RestingBird("articuno"));
            repaint();
        } else if (event.getSource() == penguinSwimButton) {
            checkPenguin = true;
            penguin.setBirdBehavior(new SwimmingBird("penguin"));
            repaint();
        } else if (event.getSource() == penguinRestButton) {
            checkPenguin = true;
            penguin.setBirdBehavior(new RestingBird("penguin"));
            repaint();
        } else {
            System.exit(0);

        }//else exit

    } //actionPerformed

    public static void main(String[] args) {
        DragonBoatSwing gui = new DragonBoatSwing();

    }//main

}//class
