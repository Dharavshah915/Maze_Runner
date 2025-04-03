package ca.mcmaster.se2aa4.mazerunner;

import java.time.chrono.ThaiBuddhistChronology;

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
            algorithm.attach(instance);
        }
        instance.get_Stratagy(algorithm);
        return instance; //return instance
    }

    public static Player getInstance() { //get instance of player
        if(instance == null){ //if instance is not initialized
            instance = new Player(null); //initialize instance
        }
        return instance; //return instance
    }
    //Overloading

    // public Player(Path path){ //intialize with given Path object
    //     this.path = path;
    // }

    // public Player(String path){ //intialize with Path represented as String
    //     this.path = new Path(path);
    // }


    public void get_Stratagy(Algorithm algorithm){ //get algorithum
        this.stratagy = algorithm;
    }

    public void calculate_path(){ //calculate path using algorithum
        stratagy.findPath(stratagy.compass.getCurrentDirection());
        //this.path.pathway = String.join("", this.stratagy.findPath(stratagy.compass.getCurrentDirection())); //convertes array to string
        System.out.println("THe path is " + this.path.pathway + this.getPath());
    }

    public void setPath(String path){ // set the path
        this.path.pathway = path;
    }

    public Path getPath(){
        return this.path;
    }
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
        System.out.println("In pLAYER");
        this.path.MoveForward();
        System.out.println(this.getPath());
        System.out.println(path.toString());
    }
    @Override
    public void updateMoveBackward() {
     
        this.path.MoveBackward();
    }
}