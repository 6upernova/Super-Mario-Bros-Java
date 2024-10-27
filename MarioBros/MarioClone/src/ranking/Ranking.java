package ranking;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.LinkedList;
import java.util.Collection;

public class Ranking{
    protected VectorRanking<String,Integer>[] ranking;    
    private int size;
    protected String path;    
    private static final int maxCapacity = 5;

    @SuppressWarnings("unchecked")
    public Ranking(){
        this.path = "src/ranking/ranking.txt";
        this.size = 0;
        this.ranking = new VectorRanking[maxCapacity] ; 
        getRanking();
    }
    private boolean isFull(){
        return maxCapacity == size;
    }
    private boolean isEmpty(){
        return size == 0;
    }

    public void getRanking(){        
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String linea;
            String name;
            int score;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");                 
                name = partes[0];
                score = Integer.parseInt(partes[1]);
                addToRank(name,score);            
            }
        } catch (IOException e) {
            System.err.println("Error trying read the textfile: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Format error: " + e.getMessage());
        }
    }     
        
    public void addToRank(String name, int score) {
        System.out.println("estoy añadiendo");
        int lastRankTop = size;
        if(entersInRanking(score)){  
            if(isFull())
                lastRankTop = 4;          
            ranking[lastRankTop] =  new VectorRanking<>(name ,lastRankTop+1 , score);  
            reorder();
        }        
      
        if(!isFull())
            size++;  
            updateRanking();             
    }

    private void reorder(){
        //ordena de mayor a menor
        VectorRanking<String,Integer> temp;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (ranking[j].getScore() < ranking[j + 1].getScore()) {
                    temp = ranking[j];
                    ranking[j] = ranking[j + 1];
                    ranking[j + 1] = temp;
                }
            }
        }
        orderTop();
        
    }
   
    private void orderTop(){
        for(int i=0; i<size ;i++)
            ranking[i].setTop(i+1);
    }
    private void updateRanking()  {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
                String line = null;
                for (int i = 0; i < size; i++) {
                    line = ranking[i].toString();
                    writer.write(line);
                    if(i<size-1)    
                        writer.newLine();
                }       
            } catch (IOException e) {
                System.err.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
        }
    }
    private boolean entersInRanking(int score){
        boolean find = false;
        if(isEmpty())
            find = true;
        else{
            if(!isFull())
                find = true;
            else{
                    for(int i = 0; i<size && !find;i++){
                        if(ranking[i].getScore() < score){
                            find = true;
                            System.out.println("encontre");
                        }
                    }
                }
        }
        return find;
    }

    public void printContent(){
        System.out.println("xxxxxxx");
        for(int i = 0; i<size ;i++)
            ranking[i].printVector();
        System.out.println("xxxxxxx");
    }
    public Collection<String> getPlayers() {
        List<String> players = new LinkedList<>();
        for(int i = 0;i<size;i++){
            String player = ranking[i].getTop()+"   "+ranking[i].getName().toUpperCase()+"  "+ranking[i].getScore(); 
            players.add(player);   
        }
        return players;
    }
}
