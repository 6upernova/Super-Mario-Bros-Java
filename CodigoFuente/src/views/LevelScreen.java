package views;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import HitboxDebug.HitboxPanel;
import entities.BoundingBox;
import entities.LogicalEntity;
import entities.character.CharacterEntity;
import entities.enemies.EnemyEntity;
import observer.CharacterObserver;
import observer.EnemyObserver;
import observer.EntityObserver;
import observer.GraphicObserver;
import tools.GraphicTools;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelScreen extends JPanel {	
    protected ViewController viewController;
    protected JPanel contentPanel;
    protected JLabel backgroundImageLabel;
    protected InformationPanel informationPanel;
    private int backgroundX;

    public LevelScreen (ViewController viewController){
        this.viewController = viewController;
        setPreferredSize(new Dimension(ViewConstants.WIN_WIDTH, ViewConstants.WIN_HEIGHT));
        setLayout(new BorderLayout());
        //setBackgroundAndScroll();
        addInformationPanel();
        this.backgroundX = 0; 
    }

    //Constructor operations
    protected void setBackgroundAndScroll() {
        configureBackgroundLabel();
        configureContentPanel();
    }

    private void configureBackgroundLabel(){
        //To do: Reemplazar el path del background con la funcionalidad de registrar silueta
        String background = viewController.getLevelBrackground();
        //("/assets/backgrounds/levelBackground/original/background-lvl1.png"
        ImageIcon backgroundIcon = getBackgroundIcon(background);
        backgroundImageLabel = new JLabel();
        backgroundImageLabel.setIcon(backgroundIcon);
        backgroundImageLabel.setPreferredSize(new Dimension(backgroundImageLabel.getIcon().getIconWidth(), backgroundImageLabel.getIcon().getIconHeight()));
        backgroundImageLabel.setLayout(null);
		backgroundImageLabel.setBounds(0,0, backgroundImageLabel.getIcon().getIconWidth(), ViewConstants.PANEL_HEIGHT);
    }

    private void configureContentPanel(){
        contentPanel = new JPanel(null); 
        contentPanel.setPreferredSize(new Dimension(backgroundImageLabel.getIcon().getIconWidth(), ViewConstants.PANEL_HEIGHT));
        contentPanel.add(backgroundImageLabel);
        this.add(contentPanel);
    }

   
    private ImageIcon getBackgroundIcon(String path){
        ImageIcon backgroundIcon = new ImageIcon(getClass().getResource(path));
        backgroundIcon = GraphicTools.scaleImage(backgroundIcon.getIconHeight(), ViewConstants.PANEL_HEIGHT, backgroundIcon);
        return backgroundIcon;
    }

    //Observer operation

    public void updateScrollRight(CharacterEntity character) {
    
        float targetBackgroundPosition = -(character.getX() - ViewConstants.LEFT_CHARACTER_SPACE)*ViewConstants.CELL_SIZE;

        if (character.getX() >= getScrollbarXPosition() + ViewConstants.LEFT_CHARACTER_SPACE &&
            targetBackgroundPosition < 0 &&
            Math.abs(targetBackgroundPosition - backgroundX) > 1) {

            backgroundX += (targetBackgroundPosition - backgroundX) * 0.1f;
            backgroundImageLabel.setLocation(backgroundX, 0);
            repaint();
        }
    }

    public int getScrollbarXPosition(){
        
        return -backgroundX/ViewConstants.CELL_SIZE;
    }

    public void resetScrollbar() {
        backgroundX = 0;
        backgroundImageLabel.setLocation(backgroundX, 0);
    }

    public CharacterObserver drawEntityCharacter(CharacterEntity characterEntity){
        CharacterObserver characterObserver = new CharacterObserver(this, characterEntity);
        backgroundImageLabel.add(characterObserver);
        return characterObserver;
    }

    public GraphicObserver drawLogicalEntity(LogicalEntity entity, boolean isActive) {
        EntityObserver entityObserver = new EntityObserver(entity, isActive);
        backgroundImageLabel.add(entityObserver);
        return entityObserver;   
    }

    public GraphicObserver drawLogicalEntity(EnemyEntity entity) {
        EnemyObserver entityObserver = new EnemyObserver(this, entity);
        backgroundImageLabel.add(entityObserver);
        return entityObserver;   
    }
    
    public void removeEntity(LogicalEntity g){
        backgroundImageLabel.remove(g.getGraphicObserver());
        repaint();
    }

    private void addInformationPanel() {
        informationPanel = new InformationPanel();       
        this.add(informationPanel, BorderLayout.NORTH);
    }    

    public void updateInformationPanel(int newCoins, int newScore, int newTime, int newLives){
        informationPanel.updateCoins(newCoins);    
        informationPanel.updateScore(newScore);
        informationPanel.updateTime(newTime);
        informationPanel.updateLives(newLives);
        informationPanel.updateInformation();
    }

    public void drawHitbox(LogicalEntity entity) {
        BoundingBox hitbox = entity.getBoundingBox();
        HitboxPanel hitboxPanel = new HitboxPanel(hitbox);        
        backgroundImageLabel.add(hitboxPanel);
        backgroundImageLabel.repaint(); 
    }

    public void drawPoints(JLabel pointsLabel) {
        backgroundImageLabel.add(pointsLabel);
        backgroundImageLabel.repaint();
        pointsAnimation(pointsLabel);
    }

    public void pointsAnimation(JLabel pointsJLabel){
        Timer timer = new Timer(16, new ActionListener() {
        int steps = 0;
        public void actionPerformed(ActionEvent e) {
            pointsJLabel.setLocation(pointsJLabel.getX(), pointsJLabel.getY() - 1);
            steps++;
            if (steps >= 60) {
                ((Timer) e.getSource()).stop();
                backgroundImageLabel.remove(pointsJLabel);
                backgroundImageLabel.repaint();
            }
        }
        });
        timer.start();
    }
}   