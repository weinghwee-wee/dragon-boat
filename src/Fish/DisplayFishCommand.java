/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fish;

import java.awt.Graphics;

public class DisplayFishCommand implements Command {

    private Fish fish;
    Graphics g;

    public DisplayFishCommand(Fish fish, Graphics g) {
        this.fish = fish;
        this.g = g;
    }

    @Override
    public void execute() {
        this.fish.display(this.g);
    }

}
