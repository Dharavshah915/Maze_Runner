package ca.mcmaster.se2aa4.mazerunner;

public class Player implements  Observer {
    private Path path; 
    private Algorithm stratagy; //algorithum to develop path 
    public static Player instance;
    private Player(Algorithm algorithm) { //initialize player with empty path
        this.path = Path.getInstance(); //initialize path
 
    }
    public static Player getInstance(Algorithm algorithm) { //get instance of player
        if(instance == null){ //if instance is not initialized
            instance = new Player(algorithm); //initialize instance
            
        }
        instance.get_Stratagy(algorithm);
        algorithm.attach(instance);
        return instance; //return instance
    }

    public void get_Stratagy(Algorithm algorithm){ //get algorithum
        this.stratagy = algorithm;
    }

    public void calculate_path(){ //calculate path using algorithum
        stratagy.findPath();
    }

    public void setPath(String path){ // set the path
        this.path.pathway = path;
    }

    public Path getPath(){ //get the path
        return this.path;
    }
    //update path
    @Override
    public void updateMoveRight() { 
      
        this.path.MoveRight();
    }
    @Override
    public void updateMoveLeft() {
       
        this.path.MoveLeft();
    }
    @Override
    public void updateMoveForward() {
       
        this.path.MoveForward();
      
    }
    @Override
    public void updateMoveBackward() {
     
        this.path.MoveBackward();
    }
    //reset path
    public void reset(){
        this.path.reset();
    }
}