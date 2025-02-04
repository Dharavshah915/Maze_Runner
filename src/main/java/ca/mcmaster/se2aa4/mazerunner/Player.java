package ca.mcmaster.se2aa4.mazerunner;

public class Player {
    private Path path; 
    private Algorithm stratagy; //algorithum to develop path 

    public Player() { //initialize player with empty path
        this.path = new Path();
 
    }
    //Overloading

    public Player(Path path){ //intialize with given Path object
        this.path = path;
    }

    public Player(String path){ //intialize with Path represented as String
        this.path = new Path(path);
    }


    public void get_Stratagy(Algorithm algorithm){ //get algorithum
        this.stratagy = algorithm;
    }

    public void calculate_path(){ //calculate path using algorithum
        this.path.pathway = String.join("", this.stratagy.findPath(stratagy.currentDirection)); //convertes array to string
    }

    public void setPath(String path){ // set the path
        this.path.pathway = path;
    }

    public Path getPath(){
        return this.path;
    }
}