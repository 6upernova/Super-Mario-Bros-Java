package factories;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

<<<<<<< HEAD
=======

>>>>>>> 06024c24969dc462abcafd52aeaffc7625ed1f42

public class Parser{
    protected LinkedList<Vector<Integer>> levelContent;    
    protected String path;    

    public Parser(int numberLevel){
        this.path = "src\\levels\\level"+numberLevel+".txt";
        levelContent = new LinkedList<>();
        levelContent = getLevelContent();
        //printContent();
    }
    
    private LinkedList<Vector<Integer>> getLevelContent(){        
        LinkedList<Vector<Integer>> levelContent = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {            
            Vector<Integer> numbersTrio;
            String currentRow;
            int cycle = 1;
            while ((currentRow = reader.readLine()) != null) {         
                numbersTrio = new Vector<Integer>();
                cycle = 1;
                String[] curretRowReading = currentRow.split(","); 
                for (String element : curretRowReading) {                    
                    Integer number = Integer.parseInt(element);
                    addInListByCycle(cycle,number,numbersTrio);
                    cycle++; 
                }  
                levelContent.addLast(numbersTrio);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }      
        //printContent(); 
        return levelContent;
    }
    
    private void addInListByCycle(int cycle, Integer number, Vector<Integer> numbersTrio) {
        if(cycle == 1) 
        	numbersTrio.setRepresentation(number);
        if(cycle == 2) 
        	numbersTrio.setX(number);
        if(cycle == 3) 
        	numbersTrio.setY(number);
    }
   
    
    public int getType(){
        int type= levelContent.peekFirst().getRepresentacion();
        checkRemove();
        return type;
    }
    
    public int getPositionX(){
        int position = levelContent.peekFirst().getPositionX();
        checkRemove();
        return  position;
    }
   
    public int getPositionY(){
        int position = levelContent.peekFirst().getPositionY();
        checkRemove();
        return  position;
    }
    
    private void checkRemove(){
        if(levelContent.peek().isEmpty())
            levelContent.removeFirst();
    }

     public boolean hasToRead(){
        return !levelContent.isEmpty();
    }
    /*
    private void printContent(){
        for(Vector<Integer> vector:levelContent)
            vector.printVector();
    }
            
    public static void main(String args[]){
        Parser p = new Parser(1); 
        p.printContent();
        int x,y,z;
        x = p.getPositionX();
        y = p.getPositionY();
        z = p.getType();
        System.out.println("------------------");
        System.out.println(x+" "+y+" "+z);
        System.out.println("------------------");
        p.printContent();    
    }  
     */
         
}