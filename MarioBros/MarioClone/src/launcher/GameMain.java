package launcher;
import views.*;



public class GameMain extends Thread {
    public static void main(String arg[]){
        try {
            ViewController controlador_vistas = new ViewController();
            controlador_vistas.showLevelScreen();
            controlador_vistas.refresh();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run(){

    }
}


