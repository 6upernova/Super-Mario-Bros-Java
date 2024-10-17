package character;

import java.awt.event.KeyEvent;

public class Keyboard extends java.awt.event.KeyAdapter {

    private String playerDirection="none";

    public void keyPressed(KeyEvent pressedKey) {
            switch(pressedKey.getKeyCode()) {
                case KeyEvent.VK_D:
                    playerDirection="right";
                    break;
                case KeyEvent.VK_A:
                    playerDirection="left";
                    break;
            }
    }

    public void keyReleased(KeyEvent releasedKey) {
        switch(releasedKey.getKeyCode()) {
            case KeyEvent.VK_D:
                playerDirection = "none";
                break;
            case KeyEvent.VK_A:
                playerDirection = "none";
                break;
        }
    }
    public String getPlayerDirection() {
        return playerDirection;
    }
    
}
