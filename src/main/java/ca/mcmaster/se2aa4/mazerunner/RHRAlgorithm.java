package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class RHRAlgorithm extends Algorithm {
    //public boolean doneMaze = false;
    
    public RHRAlgorithm(Maze maze, int startDirection) {
        super(maze, startDirection);
    }

    @Override
    public ArrayList<String> findPath() {
        ArrayList<String> path = new ArrayList<>();

        while (!MazeUtils.isSolved(maze,currentX, currentY)) {
            
            //System.out.println("Position: (" + currentX + ", " + currentY + "), Direction: " + currentDirection);
            //visited[currentY][currentX] = true;
            
            int rightDirection = (currentDirection + 1) % 4;
            int rightX = currentX + dx[rightDirection];
            int rightY = currentY + dy[rightDirection];

            if (MazeUtils.isValidMove(maze,rightX, rightY)) {
                currentDirection = rightDirection;
                currentX = rightX;
                currentY = rightY;
                path.add(" ");
                path.add("R");
                path.add(" ");
                path.add("F");

            } else {
                int straightX = currentX + dx[currentDirection];
                int straightY = currentY + dy[currentDirection];

                if (MazeUtils.isValidMove(maze,straightX, straightY)) {
                    currentX = straightX;
                    currentY = straightY;
                    path.add("F");
                } else {

                    int leftDirection = (currentDirection + 3) % 4;
                    int leftX = currentX + dx[leftDirection];
                    int leftY = currentY + dy[leftDirection];

                    if (MazeUtils.isValidMove(maze,leftX, leftY)){
                        currentDirection = leftDirection;
                        currentX = leftX;
                        currentY = leftY;
                        path.add(" ");
                        path.add("L");
                        path.add(" ");
                        path.add("F");
                    } else{
                        int backDirection = (currentDirection + 2) % 4;
                        int backX = currentX + dx[backDirection];
                        int backY = currentY + dy[backDirection];
                        //visited[currentY][currentX] = false;
                        currentDirection = backDirection;
                        currentX = backX;
                        currentY = backY;
                        path.add(" ");
                        path.add("B");
                        path.add(" ");
                        path.add("F");
                    }

                }
            }
        }
        return path;
    }
}
