package entities.character;

import java.util.HashMap;
import java.util.List;

import entities.enemies.Enemy;
import entities.platforms.*;
import entities.projectile.FireBallCollisionManager;
import entities.projectile.Projectile;
//import entities.projectile.FireBallCollisionManager;
import game.Game;
import tools.LogicTools;
import views.ViewConstants;

public class CharacterThread extends Thread {
    protected Game game;
    protected Character character;
    protected Keyboard keyboard;
    private CharacterCollisionManager characterCollisionManager;
    private FireBallCollisionManager fireBallCollisionManager;
    private int frameCount;
    private int spriteNumber;
    private boolean isRunning;
    private HashMap<String, Platform> platformsByCoords;
    private boolean spacebarWasPressed;

    public CharacterThread(Keyboard keyboard, Game game) {
        this.game = game;
        this.characterCollisionManager = new CharacterCollisionManager(game);
        this.character = game.getCurrentLevel().getCharacter();
        this.platformsByCoords = LogicTools.groupPlatformsByCoords(game.getCurrentLevel().getPlatforms());
        this.keyboard = keyboard;
        this.frameCount = 0;
        this.spriteNumber = 1;
        this.isRunning = false;
        this.fireBallCollisionManager = new FireBallCollisionManager(game);
        this.spacebarWasPressed = false;
    }

    public void run() {
        String horizontalDirection;
        String verticalDirection;
        String spacebar;
        int counter = 0;
        int timer = 400;
        int timeCounter = 0; 
        int spacebarCooldown = 0;
        setIsRunning(true);
        while (isRunning) {
            horizontalDirection = keyboard.getPlayerHorizontalDirection();
            verticalDirection = keyboard.getPlayerVerticalDirection();
            spacebar = keyboard.getSpacebar();
            frameCount++;
            if (character.isInEnd()) {
                isRunning = false;
                timer = 400;
                game.playNextLevel();
            } 
            else if (character.getLives() <= 0) {
                game.stop();                
                isRunning = false;
            } 
            else {
                if (spacebarWasPressed) {
                    spacebarCooldown += 16;
                    if (spacebarCooldown >= 1000) {
                        setSpacebarWasPressed(false);
                        spacebarCooldown = 0;
                    }
                }

                if (!character.isBusy()) {
                    moveCharacter(horizontalDirection, verticalDirection, spacebar, spacebarWasPressed);
                    characterCollisionManager.platformsCollisions(character);
                    characterCollisionManager.enemiesCollisions(character);
                    characterCollisionManager.powerUpsCollisions(character);
                    checkEnemiesInRange(game.getCurrentLevel().getEnemies());
                }

                for (Projectile projectile : game.getCurrentLevel().getProjectiles()) {                    
                    fireBallCollisionManager.moveProjectile(projectile);
                    fireBallCollisionManager.enemiesCollisions(projectile);
                }

                if (character.isInvincible()) {
                    if (counter > character.STAR_INVINCIBILITY_TIME) {
                        character.setInvencible(false);
                        counter = 0;
                    } 
                    else {
                        counter += 10;
                    }
                }
                if (character.isInvulnerable()) {
                    if (counter > character.HIT_INVINCIBILITY_TIME) {
                        character.setInvulnerable(false);
                        counter = 0;
                    } 
                    else {
                        counter += 10;
                    }
                }
                timeCounter++;
                if (timeCounter >= 60) {
                    timer--;
                    timeCounter = 0;
                }

                game.updateInformation(character.getScore(), character.getCoins(), timer, character.getLives());
            }

            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
            }
        }
    }

    private void checkEnemiesInRange(List<Enemy> enemyList) {
        for (Enemy enemy : enemyList)
            if (!enemy.isActive() && enemy.getX() <= Math.round(character.getX()) + 16) {
                enemy.activateEnemy();
            }
    }

    private void moveCharacter(String horizontalDirection, String verticalDirection, String spacebar,boolean spacebarWasPressed) {
        character.applyGravity();

        switch (spacebar) {
            case "Space":
                if (character.canThrowFireball() && !spacebarWasPressed) {
                    setSpacebarWasPressed(true);
                    System.out.println(Math.round(character.getX()));
                    game.createFireBall(Math.round(character.getX()), Math.round(character.getY()),keyboard.getPreviousDirection());
                }

                break;
        }
        switch (verticalDirection) {
            case "Up":
                if (!character.isInAir())
                    if (horizontalDirection == "None")
                        character.jump("Jumping" + keyboard.getPreviousDirection());
                    else
                        character.jump("Jumping" + horizontalDirection);
                break;
        }
        switch (horizontalDirection) {
            case "None":
                character.stayStill("Still" + keyboard.getPreviousDirection());
                break;
            case "Right":
                moveRight();
                break;
            case "Left":
                moveLeft();
                break;
        }
    }

    private void setSpacebarWasPressed(boolean pressed) {
        this.spacebarWasPressed = pressed;
    }

    private void moveRight() {
        character.setHorizontalSpeed(ViewConstants.CHARACTER_SPEED);

        if (!character.isInAir() && !LogicTools.isOnSolid(platformsByCoords, character)) {
            character.setIsInAir(true);
        }
        character.moveRight(spriteNumber);
        if(frameCount%4==0) 
            spriteNumber = spriteNumber == 3 ? 1 : spriteNumber + 1;
    }

    private void moveLeft() {
        float characterLeftLimit = LogicTools.characterInMapEnd(game);
        if (character.getX() <= characterLeftLimit) {
            character.setHorizontalSpeed(0);
        } else {
            character.setHorizontalSpeed(ViewConstants.CHARACTER_SPEED);
        }

        if (!character.isInAir() && !LogicTools.isOnSolid(platformsByCoords, character)) {
            character.setIsInAir(true);
        }
        character.moveLeft(spriteNumber);
            
        if(frameCount%4==0) 

            spriteNumber = spriteNumber == 3 ? 1 : spriteNumber + 1;

    }

    public void setIsRunning(boolean value) {
        this.isRunning = value;
    }

}