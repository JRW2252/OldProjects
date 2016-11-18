package fileio;

/**
 *
 * @author jameswilliams
 */
public class MonteCarloData {
    /*
    Monte Carlo data consists of five attributes
    1. Number of darts thrown
    2. Number of threads used
    3. Number of dart hits
    4. Evaluation of Pi from hits
    5. Time elapsed during processing 
    */
    
    public String darts, threads, hits, pi, time;
    
    // default constructor
    public MonteCarloData(){
        darts = ""; 
        threads = ""; 
        hits = ""; 
        pi = ""; 
        time = ""; 
    }
    public MonteCarloData(String d, String t, String h, String p, String s){
        darts = d; 
        threads = t; 
        hits = h; 
        pi = p; 
        time = s; 
    }
    
    public void setDarts(String d){
        darts = d; 
    }
    
    public void setThreads(String t){
        threads = t; 
    }
    
    public void setHits(String h){
        hits = h; 
    }
    
    public void setPi(String p){
        pi = p; 
    }
    
    public void setTime(String s){
        time = s;
    }
    
    public void emptyData(){
        darts = ""; 
        threads = ""; 
        hits = ""; 
        pi = ""; 
        time = "";
    }
    
    @Override
    public String toString(){
        return darts + "," 
                + threads + "," 
                + hits + ","
                + pi + ","
                + time + "\n";
    }
}
