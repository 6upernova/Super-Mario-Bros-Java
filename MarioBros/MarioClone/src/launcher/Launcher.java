package launcher;

import views.ViewController;

public class Launcher {
    public static void main(String arg[]){
        ViewController controlador_vistas = new ViewController();
        controlador_vistas.showLevelScreen();
        controlador_vistas.refresh();
    }
}
