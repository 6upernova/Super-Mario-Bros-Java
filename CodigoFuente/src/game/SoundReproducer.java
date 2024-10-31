package game;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundReproducer {

	private Clip audioLevelMusic;
	private Clip auxialiarAudio;
	private HashMap<String, File> hashSounds;
	
	public SoundReproducer(SoundGenerator generator) {
		hashSounds= generator.getFileOfSounds();
	}
	
	public void setAuxiliarSound(String path) {
		try {
			auxialiarAudio= AudioSystem.getClip();
			auxialiarAudio.open(getSound(path));
		} catch (LineUnavailableException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setMusicSound(String path) {
		try {
			audioLevelMusic= AudioSystem.getClip();
			audioLevelMusic.open(getSound(path));
		} catch (LineUnavailableException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void start() {
		   auxialiarAudio.start();
	}
	
	public void loop() {		
		audioLevelMusic.loop(audioLevelMusic.LOOP_CONTINUOUSLY);
	}
	
	public void stopMusic() {
		audioLevelMusic.stop();
	}
	
	public void stopSoundAuxiliar() {
		auxialiarAudio.stop();
	}
	
	private AudioInputStream getSound(String path)  {
		AudioInputStream toRet=null;
		try {
		     toRet=AudioSystem.getAudioInputStream(hashSounds.get(path));
	    } catch (UnsupportedAudioFileException | IOException e) {
				e.printStackTrace();
		}
		return toRet;
	}
}