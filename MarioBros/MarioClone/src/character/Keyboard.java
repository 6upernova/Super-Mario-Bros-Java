package character;

import java.awt.event.KeyEvent;

public class Keyboard extends java.awt.event.KeyAdapter {

    private String playerDirection;
    private String previousDirection;
    private boolean jumping;
    private boolean pressingKey;
    
    public Keyboard(){
        playerDirection="None";
        previousDirection="Right";
        jumping = false;
        pressingKey = false;
    }
    
    public void keyTyped(KeyEvent typedKey) {
    	if (typedKey.getKeyCode()==KeyEvent.VK_W) {
    		jumping=true;
    	}
    }
    
    
    public void keyPressed(KeyEvent pressedKey) {
        if(!pressingKey){
            switch(pressedKey.getKeyCode()) {
                case KeyEvent.VK_D:
                    pressingKey = true;
                    playerDirection="Right";
                    break;
                case KeyEvent.VK_A:
                    pressingKey = true;
                    playerDirection="Left";
                    break;
            }
        }
    }

    public void keyReleased(KeyEvent releasedKey) {
        if(pressingKey){
            switch(releasedKey.getKeyCode()) {
                case KeyEvent.VK_D:
                    previousDirection = playerDirection;
                    playerDirection = "None";
                    pressingKey = false;
                    break;
                case KeyEvent.VK_A:
                    previousDirection = playerDirection;
                    playerDirection = "None";
                    pressingKey = false;
                    break;
            }
        }
    }
    
    public String getPlayerDirection() {
        return playerDirection;
    }

    public String getPreviousDirection() {
        return previousDirection;
    }
    
    public boolean isJumping() {
    	return jumping;
    }
}
