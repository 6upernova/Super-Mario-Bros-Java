package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import character.CharacterEntity;
import game.LogicalEntity;

public class LevelScreen extends JPanel {
    
    protected ViewController viewController;
    protected JPanel contentPanel;
    protected JLabel backgroundImageLabel;
    protected JScrollPane scrollPanel;


    public LevelScreen (ViewController viewController){
        this.viewController = viewController;
        setPreferredSize(new Dimension(ViewConstants.WIN_WIDTH, ViewConstants.WIN_HEIGHT));
        setLayout(new BorderLayout());
        setBackgroundAndScroll();
    }

    //Constructor operations

    protected void setBackgroundAndScroll() {
        
        configureBackgroundLabel();
        configureContentPanel();
        configureScrollLabel();
    }

    private void configureBackgroundLabel(){
        //To do: Reemplazar el path del background con la funcionalidad de registrar silueta
        ImageIcon backgroundIcon = getBackgroundIcon("/assets/backgrounds/background-lvl1.png");
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
    }


    private void configureScrollLabel(){

        scrollPanel = new JScrollPane(contentPanel); 
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPanel.setBounds(0, 0, ViewConstants.PANEL_WITDH, ViewConstants.PANEL_HEIGHT);
        this.add(scrollPanel, BorderLayout.CENTER);
    }
   
    
   

    private ImageIcon getBackgroundIcon(String path){

        ImageIcon backgroundIcon = new ImageIcon(getClass().getResource(path));
        backgroundIcon = GraphicTools.scaleImage(backgroundIcon.getIconHeight(), ViewConstants.PANEL_HEIGHT, backgroundIcon);
        return backgroundIcon;
    }

    //Observer operation

<<<<<<< HEAD
    public void updateScrollRight(CharacterEntity character) {
        JScrollBar horizontalBar = scrollPanel.getHorizontalScrollBar();
        int currentScrollPos = horizontalBar.getValue();
        int targetScrollPos = GraphicTools.getScreenPositionX(character.getX() - ViewConstants.LEFT_CHARACTER_SPACE);
        
        if (GraphicTools.getScreenPositionX(character.getX()) > getScrollbarXPos() + ViewConstants.CELL_SIZE * ViewConstants.LEFT_CHARACTER_SPACE) {
            int smoothScrollPos = (int) (currentScrollPos + 0.1 * (targetScrollPos - currentScrollPos));
            horizontalBar.setValue(smoothScrollPos);
=======
    public void updateScrollRight(CharacterEntity character){
        if(GraphicTools.getScreenPositionX(character.getX()) > getScrollbarXPos() + ViewConstants.CELL_SIZE * ViewConstants.LEFT_CHARACTER_SPACE){
            JScrollBar horizontalBar = scrollPanel.getHorizontalScrollBar();
            horizontalBar.setValue(GraphicTools.getScreenPositionX(character.getX()- ViewConstants.LEFT_CHARACTER_SPACE));
>>>>>>> 8c17c93968f713b2fedf58b18d8dcf015cd9b00c
        }
    }

    public int getScrollbarXPos(){
        return scrollPanel.getHorizontalScrollBar().getValue();
    }


    //View Controller and draw operations

    public Observer drawEntityCharacter( CharacterEntity characterEntity){
        CharacterObserver characterObserver = new CharacterObserver(this, characterEntity);
        backgroundImageLabel.add(characterObserver);
        
        return characterObserver;
    }

    public Observer drawLogicalEntity(LogicalEntity entity) {
        EntityObserver entityObserver = new EntityObserver(entity);
        backgroundImageLabel.add(entityObserver);

        return entityObserver;
        
    }

}   
    


    

    




