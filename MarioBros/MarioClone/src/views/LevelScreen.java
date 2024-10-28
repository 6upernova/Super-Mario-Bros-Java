package views;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import HitboxDebug.HitboxPanel;
import character.CharacterEntity;
import game.BoundingBox;
import game.LogicalEntity;
import tools.GraphicTools;

public class LevelScreen extends JPanel {
	
    protected ViewController viewController;
    protected JPanel contentPanel;
    protected JScrollPane scrollPanel;
    protected JLabel backgroundImageLabel;
    protected InformationPanel informationPanel;

    public LevelScreen (ViewController viewController){
        this.viewController = viewController;
        setPreferredSize(new Dimension(ViewConstants.WIN_WIDTH, ViewConstants.WIN_HEIGHT));
        setLayout(new BorderLayout());
        setBackgroundAndScroll();
        addInformationPanel(); 
    }

    //Constructor operations
    protected void setBackgroundAndScroll() {
        configureBackgroundLabel();
        configureContentPanel();
        configureScrollLabel();
    }

    private void configureBackgroundLabel(){
        //To do: Reemplazar el path del background con la funcionalidad de registrar silueta
        ImageIcon backgroundIcon = getBackgroundIcon("/assets/backgrounds/backgroundCustom-lvl1.png");
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
    public void updateScrollRight(CharacterEntity character) {
        JScrollBar horizontalBar = scrollPanel.getHorizontalScrollBar();
        int currentScrollPosition = horizontalBar.getValue();
        int targetScrollPosition = GraphicTools.getScreenPositionX(character.getX() - ViewConstants.LEFT_CHARACTER_SPACE);        
        if (GraphicTools.getScreenPositionX(character.getX()) > getScrollbarXPosition() + ViewConstants.CELL_SIZE * ViewConstants.LEFT_CHARACTER_SPACE) {
            int smoothScrollPosition = Math.round(currentScrollPosition + 0.5f * (targetScrollPosition - currentScrollPosition));
            horizontalBar.setValue(smoothScrollPosition);
        }
    }

    public int getScrollbarXPosition(){
        return scrollPanel.getHorizontalScrollBar().getValue();
    }

    public void resetScrollbar() {
        JScrollBar horizontalBar = scrollPanel.getHorizontalScrollBar();
        horizontalBar.setValue(horizontalBar.getMinimum());
    }


    //View Controller and draw operations
    public CharacterObserver drawEntityCharacter(CharacterEntity characterEntity){
        CharacterObserver characterObserver = new CharacterObserver(this, characterEntity);
        backgroundImageLabel.add(characterObserver);
        return characterObserver;
    }

    public GraphicObserver drawLogicalEntity(LogicalEntity entity) {
        EntityObserver entityObserver = new EntityObserver(entity);
        backgroundImageLabel.add(entityObserver);
        return entityObserver;   
    }
    
    public void remove(LogicalEntity g){
        backgroundImageLabel.remove(g.getGraphicObserver());
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
    

    
}   