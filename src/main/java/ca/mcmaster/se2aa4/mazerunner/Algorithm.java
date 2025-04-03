package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public abstract class Algorithm { //abstarct class 
    protected Maze maze;
    protected Coordinate CurrentCoord; // Assuming Coordinate is a class with a getX() method
    protected Coordinate EndCoord;
    protected Compass compass;
    private ArrayList<Observer> observers = new ArrayList<>(); //list of observers


    public Algorithm(Maze maze, Compass compass) { //initialized with maze and starting direction
        this.maze = maze;
        this.compass = compass;//pre set direction
    }

    private void setEndCoord(Coordinate endCoord) { //set end coordinates
        this.EndCoord = endCoord;
    }
    private void setCurrentCoord(Coordinate currentCoord) { //set current coordinates
        this.CurrentCoord = currentCoord;
    }
    public Coordinate getEndCoord() { //get end coordinates
        return EndCoord;
    }
    public Coordinate getCurrentCoord() { //get current coordinates
        return CurrentCoord;
    }
    public int getCurrentX() { //get current x coordinates
        return CurrentCoord.getX();
    }

    public int getCurrentY() { //get current y coordinates
        return CurrentCoord.getY();
    }
    public int getEndX() { //get end x coordinates
        return maze.getEndX();
    }
    public int getEndY() { //get end y coordinates
        return maze.getEndY();
    }
    public void attach(Observer observer) { //attach observer
        observers.add(observer);
    }
    public void detach(Observer observer) { //detach observer
        observers.remove(observer);
    }
    public void notifyObserversRight() { //notify observers
        for (Observer observer : observers) {
            observer.updateMoveRight(); //update observers
        }
    }
    public void notifyObserversLeft() { //notify observers
        for (Observer observer : observers) {
            observer.updateMoveLeft(); //update observers
        }
    }
    public void notifyObserversForward() { //notify observers
        System.out.println(observers);
        for (Observer observer : observers) {
            System.out.print("notifying ");
            System.out.println(observer);
            observer.updateMoveForward(); //update observers
        }
    }
    public void notifyObserversBackward() { //notify observers
        for (Observer observer : observers) {
            observer.updateMoveBackward(); //update observers
        }
    }

    public abstract void findPath(int startDirection);

}
