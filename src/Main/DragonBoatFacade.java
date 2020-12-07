/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Bird.Bird;
import Bird.FlyingBird;
import Bird.RestingBird;
import Bird.SwimmingBird;
import Common.ButtonContainer;
import Common.CommonButton;
import Fish.DisplayFishCommand;
import Fish.Fish;
import Fish.FishInvoker;
import Light.Light;
import Light.SimpleLightFactory;
import Music.Music;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Chor Choon Heng 17174711/1
 */
public class DragonBoatFacade extends JFrame implements ActionListener {

    //Buttons
    //share among class as global
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private CommonButton circleLightButton;
    private CommonButton squareLightButton;
    private CommonButton lightImageButton;
    private CommonButton addAllButton;
    private CommonButton articunoFlyButton;
    private CommonButton articunoRestButton;
    private CommonButton penguinSwimButton;
    private CommonButton penguinRestButton;
    private CommonButton fishDisplayButton;
    private CommonButton exitButton;
    private CommonButton playStopButton;
    private CommonButton pauseResumeButton;

    //Panels
    private JPanel titlePanel, imagePanel, buttonPanel, infoPanel;

    //Labels
    private JLabel title, imageLabel, buttonLabel;

    //Image
    private ImageIcon image;

    //To determine whether to display 
    private boolean circleLights = false;
    private boolean squareLights = false;
    private boolean imageLights = false;
    private boolean checkArticunoFly = false;
    private boolean checkArticunoRest = false;
    private boolean checkPenguinSwim = false;
    private boolean checkPenguinRest = false;
    private boolean checkFish = false;
    private boolean isMusicPlay = false;
    private boolean isMusicPause = false;

    private SimpleLightFactory simpleLightFactory;
    private Bird articuno;
    private Bird penguin;
    private FishInvoker fishInvoker;
    private Fish fish;
    private Music music;

    public DragonBoatFacade(SimpleLightFactory simpleLightFactory, FishInvoker fishInvoker, Bird articuno, Bird penguin, Fish fish, Music music) {
        this.simpleLightFactory = simpleLightFactory;
        this.fishInvoker = fishInvoker;
        this.articuno = articuno;
        articuno.setBirdBehavior(new FlyingBird("articuno"));
        this.penguin = penguin;
        penguin.setBirdBehavior(new SwimmingBird("penguin"));
        this.fish = fish;
        this.music = music;

    }//Constructor

    public void createDragonBoatGui() {
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
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

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

        circleLightButton = new CommonButton("Circle Lights", this);
        squareLightButton = new CommonButton("Square Lights", this);
        lightImageButton = new CommonButton("Image Lights", this);
        CommonButton[] lights = {circleLightButton, squareLightButton, lightImageButton};
        buttonPanel.add(new ButtonContainer("Lights:   ", lights));

        articunoFlyButton = new CommonButton("Articuno Fly", this);
        articunoRestButton = new CommonButton("Articuno Rest", this);
        penguinSwimButton = new CommonButton("Penguin Swim", this);
        penguinRestButton = new CommonButton("Penguin Rest", this);
        CommonButton[] birds = {articunoFlyButton, articunoRestButton, penguinSwimButton, penguinRestButton};
        buttonPanel.add(new ButtonContainer("Birds:   ", birds));

        fishDisplayButton = new CommonButton("Fish", this);
        CommonButton[] fishes = {fishDisplayButton};
        buttonPanel.add(new ButtonContainer("Fishes:   ", fishes));

        playStopButton = new CommonButton("Play Music", this);
        pauseResumeButton = new CommonButton("Pause", this);
        if(!isMusicPlay){
            pauseResumeButton.setEnabled(false);
        }
        CommonButton[] musics = {playStopButton, pauseResumeButton};
        buttonPanel.add(new ButtonContainer("Music", musics));

        addAllButton = new CommonButton("Add All", this);
        exitButton = new CommonButton("Exit", this);
        CommonButton[] others = {addAllButton, exitButton};
        buttonPanel.add(new ButtonContainer("Others:   ", others));

        //Positioning Panels
        add(titlePanel, BorderLayout.NORTH);
        add(imagePanel, BorderLayout.CENTER);
        imagePanel.add(infoPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        //Configure the frame
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set around 70% of the screen size
        setSize(screenSize.width * 70 / 100, screenSize.height * 90 / 100);
        setLocation(300, 40);
        setVisible(true);
        setResizable(false);
    }

    public void paint(Graphics g) {

        //Call the paint method of the superclass
        super.paint(g);
        if (circleLights) {
            Light light = simpleLightFactory.getLight("circle");
            light.render(g);
        }

        if (squareLights) {
            Light light = simpleLightFactory.getLight("square");
            light.render(g);
        }
        
        if (imageLights) {
            Light light = simpleLightFactory.getLight("image");
            light.render(g);
        }

        if (checkArticunoFly || checkArticunoRest) {
            articuno.performBirdBehavior(g);
        }

        if (checkPenguinSwim || checkPenguinRest) {
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

        if (event.getSource() == circleLightButton) {
            circleLights = !circleLights;
            repaint();
        }//if light
        else if (event.getSource() == squareLightButton) {
            squareLights = !squareLights;
            repaint();
        }
        else if (event.getSource() == lightImageButton) {
            imageLights = !imageLights;
            repaint();
        } else if (event.getSource() == articunoFlyButton) {
            if (checkArticunoFly) {
                checkArticunoFly = false;
                checkArticunoRest = false;
            } else {
                articuno.setBirdBehavior(new FlyingBird("articuno"));
                checkArticunoFly = true;
                checkArticunoRest = false;
            }
            repaint();
        } else if (event.getSource() == articunoRestButton) {
            if (checkArticunoRest) {
                checkArticunoFly = false;
                checkArticunoRest = false;
            } else {
                articuno.setBirdBehavior(new RestingBird("articuno"));
                checkArticunoRest = true;
                checkArticunoFly = false;
            }
            repaint();
        } else if (event.getSource() == penguinSwimButton) {
            if (checkPenguinSwim) {
                checkPenguinSwim = false;
                checkPenguinRest = false;
            } else {
                penguin.setBirdBehavior(new SwimmingBird("penguin"));
                checkPenguinSwim = true;
                checkPenguinRest = false;
            }
            repaint();
        } else if (event.getSource() == penguinRestButton) {
            if (checkPenguinRest) {
                checkPenguinSwim = false;
                checkPenguinRest = false;
            } else {
                penguin.setBirdBehavior(new RestingBird("penguin"));
                checkPenguinRest = true;
                checkPenguinSwim = false;
            }
            repaint();
        } else if (event.getSource() == fishDisplayButton) {
            checkFish = !checkFish;
            repaint();
        } else if (event.getSource() == playStopButton) {
            if(!isMusicPlay){
                playStopButton.setText("Stop Music");
                music.playMusic();
                pauseResumeButton.setEnabled(true);
                isMusicPlay = !isMusicPlay;
            } else if (isMusicPlay) {
                playStopButton.setText("Play Music");
                music.stopMusic();
                pauseResumeButton.setEnabled(false);
                pauseResumeButton.setText("Pause");
                isMusicPlay = !isMusicPlay;
            }

        } else if (event.getSource() == pauseResumeButton) {
          if(!isMusicPause){
              pauseResumeButton.setText("Resume");
              music.pauseMusic();
              isMusicPause = !isMusicPause;
          } else if (isMusicPause) {
              pauseResumeButton.setText("Pause");
              music.resumeMusic();
              isMusicPause = !isMusicPause;
          }
        } else if (event.getSource() == addAllButton) {
            circleLights = true;
            squareLights = true;
            imageLights = true;
            checkArticunoFly = true;
            checkPenguinSwim = true;
            checkFish = true;
            repaint();
        } else {
            System.exit(0);

        }//else exit

    } //actionPerformed

}
