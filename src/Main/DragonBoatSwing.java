package Main;

import Bird.Articuno;
import Bird.Penguin;
import Fish.Fish;
import Fish.FishInvoker;
import Light.SimpleLightFactory;

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
        Articuno articuno = new Articuno();
        Penguin penguin = new Penguin();

        //init fish
        Fish fish = new Fish();

        DragonBoatFacade dragonBoadFacade = new DragonBoatFacade(simpleLightFactory, fishInvoker, articuno, penguin, fish);
        dragonBoadFacade.createDragonBoatGui();

    }//Constructor

    public static void main(String[] args) {

        new DragonBoatSwing();

    }//main

}//class
