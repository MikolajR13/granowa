package Model;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Music {
    Clip clip;
    AudioInputStream sound;
    public void setFile(String soundFileName) {
        try {
            File file = new File(soundFileName);
            sound = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(sound);
        } catch (Exception e) {
        }
    }
    public void play() {
        clip.start();
    }
    public void stop() throws IOException {
        sound.close();
        clip.close();
        clip.stop();
    }
}