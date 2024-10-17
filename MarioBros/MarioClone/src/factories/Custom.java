package factories;
import java.io.File;

public class Custom extends SpriteFactory{
    public Custom(String path){
        super("/assets"+File.separator+"sprites"+File.separator+"custom");
    }
}