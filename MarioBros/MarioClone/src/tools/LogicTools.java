package tools;

import java.util.HashMap;
import java.util.List;
import platforms.Platform;
import views.ViewConstants;
import character.Character;
import game.Game;

public class LogicTools {
	
    public static float characterInMapEnd(Game game) {
        float scrollbarPos = (game.getViewController().getLevelScreen().getScrollbarXPosition());
        return scrollbarPos+0.5f;
        
    }
    //Metodo provisional hasta tener un level data
    public static HashMap<String,Platform> groupPlatformsByCoords(List<Platform> platforms){
        HashMap<String,Platform> toret = new HashMap<String,Platform>();
        for(Platform platform : platforms){
            toret.put((platform.getX()+","+platform.getY()), platform);
        }
        return toret;
    }

    public static String getKey(float x, float y){
        return (GraphicTools.roundInt(x)+","+GraphicTools.roundInt(y));
    }

    public static boolean isOnSolid(HashMap<String,Platform> platformsByCoords, Character character){
        return platformsByCoords.get(getKey(character.getX() , character.getY()-1)) != null;
    }

}
