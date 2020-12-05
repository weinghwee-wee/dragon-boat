package Music;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.InputStream;

public class Music {
    private static Music uniqueInstance;
    Clip clip;
    long clipTimePosition;

    private Music() {}

    public static synchronized Music getInstance() {
        if(uniqueInstance == null) {
            uniqueInstance = new Music();
        }
        return uniqueInstance;
    }

    public void stopMusic() {
        clip.stop();
    }

    public void pauseMusic() {
        clipTimePosition = clip.getMicrosecondPosition();
        clip.stop();
    }

    public void resumeMusic() {
        clip.setMicrosecondPosition(clipTimePosition);
        clip.start();
    }

    public void playMusic() {
        try{
            InputStream musicPath = this.getClass().getResourceAsStream("../resources/music.wav");
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            clip = AudioSystem.getClip();
            clip.open((audioInput));
            clip.start();
            clip.loop(clip.LOOP_CONTINUOUSLY);

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
