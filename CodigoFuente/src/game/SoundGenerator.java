package game;
import java.io.File;
import java.util.HashMap;

public class SoundGenerator {

	protected HashMap<String, File> soundHash;
	protected final String folderPath= "src"+ File.separator+"assets"+ File.separator+ "sounds";
	
	public SoundGenerator() {
		soundHash= new HashMap<String, File>();
		createSounds();
	}

	private void createSounds() {
		 soundHash.put("musicLevel1",new File(folderPath+ File.separator+ "musicLevel1.wav"));
		 soundHash.put("stageClear", new File(folderPath+File.separator+ "stageClear.wav"));
		 soundHash.put("gameOver",new File(folderPath+File.separator+ "gameOver.wav"));
		 soundHash.put("jump",new File(folderPath+File.separator+ "jump.wav"));
		 soundHash.put("marioDie", new File(folderPath+File.separator+ "marioDie.wav"));
		 soundHash.put("coin", new File(folderPath+File.separator+ "coin.wav"));
		 soundHash.put("1-up", new File(folderPath+File.separator+ "1-up.wav"));
		 soundHash.put("powerUpAppears", new File(folderPath+File.separator+ "powerUpAppears.wav"));
		 soundHash.put("mushroom", new File(folderPath+File.separator+ "mushroom.wav"));
		 soundHash.put("kick", new File(folderPath+File.separator+ "kick.wav"));
		 soundHash.put("fireball", new File(folderPath+File.separator+ "fireball.wav"));
	}
	
	public HashMap<String, File> getFileOfSounds(){
		return soundHash;
	}
}
