/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Light;

/**
 *
 * @author WH
 */
public class SimpleLightFactory {
    public Light getLight(String lightType) {
        Light light = null;
        if (lightType == "shape") {
            light = new ShapeLight();
        } else if (lightType == "image") {
            light = new ImageLight();
        }
        
        return light;
    }
}
