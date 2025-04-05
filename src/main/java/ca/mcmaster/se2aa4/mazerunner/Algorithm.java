package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public abstract class Algorithm { //abstarct class 
    protected Maze maze;
    protected Coordinate CurrentCoord;
    protected Compass compass;
    private ArrayList<Observer> observers = new ArrayList<>(); //list of observers


    public Algorithm(Maze maze, Compass compass) { //initialized with maze and starting direction
        this.maze = maze; //set start coordinates
        this.compass = compass;
        this.attach(compass);
    }
   
    public Coordinate getCurrentCoord() { //get current coordinates
        return CurrentCoord;
    }
    public Coordinate getEndCoord() { //get end coordinates
        return maze.getEnd(); 
    }
   
    public void attach(Observer observer) { //attach observer
        observers.add(observer);
    }
    public void detach(Observer observer) { //detach observer
        observers.remove(observer);
    }
    public void notifyObserversRight() { //notify observers for Right move
        for (Observer observer : observers) {
            observer.updateMoveRight(); 
        }
    }
    public void notifyObserversLeft() { //notify observers for Left move
        for (Observer observer : observers) {
            observer.updateMoveLeft(); 
        }
    }
    public void notifyObserversForward() { //notify observers Forward move
    
        for (Observer observer : observers) {
            observer.updateMoveForward(); 
        }
    }
    public void notifyObserversBackward() { //notify observers for Back move
        for (Observer observer : observers) {
            observer.updateMoveBackward(); 
        }
    }
    public Compass getCompass() { //get compass
        return compass;
    }

    public abstract void findPath(); //abstract method to find path

}
