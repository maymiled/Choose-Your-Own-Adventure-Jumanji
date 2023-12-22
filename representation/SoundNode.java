package representation;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundNode extends NodeDecorator {

    private final String soundPath;

    public SoundNode(InnerNode decoratedNode, String soundPath) {
        super(decoratedNode);
        this.soundPath = soundPath;
    }

    @Override
    public void display() {
        playSound(soundPath);
        super.display();
    }
    
    
    
    public static void playSound(String soundPath) {
    	try {
    		File soundFile = new File(soundPath);
    		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
    		Clip clip = AudioSystem.getClip();
    		clip.open(audioInputStream);
    		clip.start();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
}


