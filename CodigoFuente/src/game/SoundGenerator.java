package game;
import java.io.File;
import java.util.HashMap;

public class SoundGenerator {

	protected HashMap<String, File> sounds;
	protected final String folderPath= "src"+ File.separator+"assets"+ File.separator+ "sounds";
	
	public SoundGenerator() {
		sounds= new HashMap<String, File>();
		createSounds();
	}

	private void createSounds() {
		 sounds.put("stageClear", new File(folderPath+File.separator+ "stageClear.wav"));
		 sounds.put("gameOver",new File(folderPath+File.separator+ "gameOver.wav"));
		 sounds.put("jump",new File(folderPath+File.separator+ "jump.wav"));
		 sounds.put("marioDie", new File(folderPath+File.separator+ "marioDie.wav"));
		 sounds.put("coin", new File(folderPath+File.separator+ "coin.wav"));
		 sounds.put("1-up", new File(folderPath+File.separator+ "1-up.wav"));
		 sounds.put("powerUpAppears", new File(folderPath+File.separator+ "powerUpAppears.wav"));
		 sounds.put("mushroom", new File(folderPath+File.separator+ "mushroom.wav"));
		 sounds.put("kick", new File(folderPath+File.separator+ "kick.wav"));
		 sounds.put("fireball", new File(folderPath+File.separator+ "fireball.wav"));
		 sounds.put("stomp", new File(folderPath+File.separator+ "stomp.wav"));
		 sounds.put("breakBrick", new File(folderPath+File.separator+ "breakBrick.wav"));
		 sounds.put("musicLevel1",new File(folderPath+ File.separator+ "musicLevel1.wav"));
		 sounds.put("superMarioDamaged", new File(folderPath + File.separator + "superMarioDamaged.wav"));

	}
	
	public HashMap<String, File> getFileOfSounds(){
		return sounds;
	}
}
