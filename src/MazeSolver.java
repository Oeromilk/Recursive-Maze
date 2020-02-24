/**
 * MazeSolver class is where the recurisve function lives in this program.
 * we have a local variable that keeps track of the times the recursive function is called
 */
public class MazeSolver
{
    private Maze maze;
    int timesCalled;

    /**
     * Constructor for the MazeSolver class.
     */
    public MazeSolver(Maze maze)
    {
        this.maze = maze;
    }
    /**
     * @param row row index of current location
     * @param column column index of current location
     * @return true if the maze has been solved
     */
    public boolean traverse(int row, int column, int counter)
    {
        boolean done = false;

        if(maze.validPosition(row, column)) {
            System.out.println("The rat is at " + row + ", " + column + ".");
            maze.tryPosition(row, column);   // mark this cell as tried
            if (row == maze.cheeseRow && column == maze.cheeseCol)
                done = true;  // the maze is solved
            else {
                done = traverse(row - 1, column, counter++);  // up
                if (!done)
                    done = traverse(row + 1, column, counter++);      // down
                if (!done)
                    done = traverse(row, column + 1, counter++);  // right
                if (!done)
                    done = traverse(row, column - 1, counter++);  // left
            }

            if (done)  // this location is part of the final path
                maze.markPath(row, column);
        }
        timesCalled = counter;
        return done;
    }
}
