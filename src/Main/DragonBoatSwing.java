package Main;

import Bird.Articuno;
import Bird.Bird;
import Bird.Penguin;
import Fish.Fish;
import Fish.FishInvoker;
import Light.SimpleLightFactory;
import Music.Music;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ganze
 */
public class DragonBoatSwing {

    public DragonBoatSwing() {
        SimpleLightFactory simpleLightFactory = new SimpleLightFactory();
        FishInvoker fishInvoker = new FishInvoker();

        //init the birds
        Bird articuno = new Articuno();
        Bird penguin = new Penguin();

        //init fish
        Fish fish = new Fish();

        //init music
        Music music = Music.getInstance();

        DragonBoatFacade dragonBoadFacade = new DragonBoatFacade(simpleLightFactory, fishInvoker, articuno, penguin, fish, music);
        dragonBoadFacade.createDragonBoatGui();

    }//Constructor

    public static void main(String[] args) {

        new DragonBoatSwing();

    }//main

}//class
