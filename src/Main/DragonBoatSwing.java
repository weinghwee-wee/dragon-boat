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
import Fish.DisplayFishCommand;
import Fish.Fish;
import Fish.FishInvoker;
import Common.CommonButton;
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
    private JButton lightImageButton;
    private JButton addAllButton;
    private JButton articunoFlyButton;
    private JButton articunoRestButton;
    private JButton penguinSwimButton;
    private JButton penguinRestButton;
    private JButton fishDisplayButton;
    private JButton exitButton;

    //Panels
    private JPanel titlePanel, imagePanel, buttonPanel, infoPanel;

    //Labels
    private JLabel title, imageLabel, buttonLabel;

    //Image
    private ImageIcon image;

    //To determine whether to display 
    private boolean lights = false;
    private boolean imageLights = false;
    private boolean checkArticuno = false;
    private boolean checkPenguin = false;
    private boolean checkFish = false;

    private SimpleLightFactory simpleLightFactory;
    private Bird articuno;
    private Bird penguin;
    private FishInvoker fishInvoker;
    private Fish fish;
    
    public DragonBoatSwing() {
        simpleLightFactory = new SimpleLightFactory();
        fishInvoker = new FishInvoker();

        //init the birds
        articuno = new Articuno();
        penguin = new Penguin();

        //init fish
        fish = new Fish();
        
        //Set title
        setTitle("Decorate the Dragon Boat!");
        setLayout(new BorderLayout());

        //Setting the title of the JLabel
        title = new JLabel("Click the buttons below to decorate your Dragon Boat!");


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

        

        //Retrieving image from the file
        image = new ImageIcon(getClass().getResource("/resources/dragon_boat.png"));
        Image i = image.getImage();
        Image resizedImage = i.getScaledInstance(screenSize.width * 70 / 100, screenSize.height * 70 / 100, Image.SCALE_SMOOTH);
        image = new ImageIcon(resizedImage);
        imageLabel = new JLabel(image);
        imagePanel = new JPanel();
        imagePanel.add(imageLabel);
        imagePanel.setBackground(Color.white);
        
        

        //Creating a new JPanel for the buttons to go
        buttonPanel = new JPanel();

        //Setting colour of button panel
        buttonPanel.setBackground(Color.white);

        //Button Label
        buttonLabel = new JLabel("Click on the button to add the item to the tree.");
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
        lightButton = new CommonButton("Lights", this);
        lightImageButton = new CommonButton("Image Lights", this);
        addAllButton = new CommonButton("Add All", this);
        articunoFlyButton = new CommonButton("Articuno Fly", this);
        articunoRestButton = new CommonButton("Articuno Rest", this);
        penguinSwimButton = new CommonButton("Penguin Swim", this);
        penguinRestButton = new CommonButton("Penguin Rest", this);
        fishDisplayButton = new CommonButton("Fish", this);
        exitButton = new CommonButton("Exit", this);

        //Add the buttons to the buttonPanel
        buttonPanel.add(lightImageButton);
        buttonPanel.add(lightButton);
        buttonPanel.add(articunoFlyButton);
        buttonPanel.add(articunoRestButton);
        buttonPanel.add(penguinSwimButton);
        buttonPanel.add(penguinRestButton);
        buttonPanel.add(fishDisplayButton);
        buttonPanel.add(addAllButton);
        buttonPanel.add(exitButton);

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
            light.render(g);

        }
        
        if (imageLights) {
            Light light = simpleLightFactory.getLight("image");
            light.render(g);
        }

        if (checkArticuno) {
            articuno.performBirdBehavior(g);
        }

        if (checkPenguin) {
            penguin.performBirdBehavior(g);
        }
        
        if (checkFish) {
            DisplayFishCommand display = new DisplayFishCommand(fish, g);
            fishInvoker.setCommand(display);
            fishInvoker.buttonWasPressed();
        }

    } //paint

    //Coding the event-handling routine
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == lightButton) {
            lights = true;
            repaint();

        }//if light
        else if (event.getSource() == lightImageButton) {
            imageLights = true;
            repaint();
        }
        else if (event.getSource() == addAllButton) {
            lights = true;
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
        } else if (event.getSource() == fishDisplayButton) {
            checkFish = true;
            repaint();
        } else {
            System.exit(0);

        }//else exit

    } //actionPerformed

    public static void main(String[] args) {
        DragonBoatSwing gui = new DragonBoatSwing();

    }//main

}//class
