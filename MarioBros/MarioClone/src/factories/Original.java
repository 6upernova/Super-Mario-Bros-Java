package factories;

import java.io.File;

public class Original extends SpriteFactory {
    protected String path;
    protected Original(String path) {
        super("/assets"+File.separator+"sprites"+File.separator+"original");
    }
    
}
