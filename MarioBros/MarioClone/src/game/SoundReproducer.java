package game;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundReproducer {

	protected final String folderPath= "src"+ File.separator+"assets"+ File.separator+ "sounds" ;
	protected Clip audioLevelMusic;
	protected Clip auxialiarAudio;
	
	public SoundReproducer(String path) {
		try {
			File file= new File(folderPath + File.separator + path + ".mp3");
			audioLevelMusic= AudioSystem.getClip();
		    audioLevelMusic.open(AudioSystem.getAudioInputStream(file));
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	public void setAuxiliarAudio(String path) {
		File file= new File(folderPath + File.separator + path + ".wav");
		try {
	        auxialiarAudio= AudioSystem.getClip();
			auxialiarAudio.open(AudioSystem.getAudioInputStream(file));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void start() {
		if(!auxialiarAudio.isRunning()) {
		   auxialiarAudio.setFramePosition(0);
		   auxialiarAudio.start();
		}
	}
	
	public void loop() {		
		audioLevelMusic.setFramePosition(0);
		audioLevelMusic.loop(audioLevelMusic.LOOP_CONTINUOUSLY);
	}
	
	public void stop() {
		audioLevelMusic.stop();
	}
}
