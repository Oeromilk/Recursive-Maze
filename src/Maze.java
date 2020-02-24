import java.util.*;
import java.io.*;

/**
 * The Maze class reads the file with the scanner class to create the 2 dimensional grid
 * has a set of variables that are used for local methods and or to be called from different classes
 */
public class Maze
{
    private static final char TRIED = 'x';
    private static final char PATH = 'o';

    private int numberRows, numberColumns;
    int ratRow, ratCol;
    int cheeseRow, cheeseCol;
    int breadCrumbs;
    private char[][] grid;


    /**
     * Constructor to use the file and for loops to poulate the grid 2d array.
     * @param filename the name of the file to load
     * @throws FileNotFoundException if the given file is not found
     */
    public Maze(String filename) throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File(filename));
        numberRows = scan.nextInt();
        numberColumns = scan.nextInt();

        grid = new char[numberRows][numberColumns];
        for (int i = 0; i < numberRows; i++) {
            for (int j = 0; j < numberColumns; j++) {
                if(scan.hasNext()){
                    grid[i][j] = scan.next().charAt(0);
                    // when R is found set it the cords to be used later
                    if(grid[i][j] == 'R'){
                        ratRow = i; ratCol = j;
                    }
                    // when C is found set the cords to be used later
                    if(grid[i][j] == 'C'){
                        cheeseRow = i; cheeseCol = j;
                    }
                }
            }
        }
    }

    /**
     * If it tries the cords it marks it with the tried variable.
     *
     * @param row the index of the row to try
     * @param col the index of the column to try
     */
    public void tryPosition(int row, int col)
    {
        grid[row][col] = TRIED;
    }

    /**
     * Return the number of rows in this maze
     *
     * @return the number of rows in this maze
     */

    public int getRows()
    {
        return grid.length;
    }

    /**
     * Return the number of columns in this maze
     *
     * @return the number of columns in this maze
     */
    public int getColumns()
    {
        return grid[0].length;
    }

    /**
     * Marks the cords as part of the path and adds a counter to the breadCrumbs variable.
     * @param row the index of the row to mark as part of the PATH
     * @param col the index of the column to mark as part of the PATH
     */
    public void markPath(int row, int col)
    {
        grid[row][col] = PATH;
        breadCrumbs++;
    }

    /**
     * Checks the position if it is an open path, start, or end of the maze
     * @param row the row to be checked
     * @param column the column to be checked
     * @return true if the location is valid
     */

    public boolean validPosition(int row, int column)
    {
        boolean result = false;

        // check if cell is in the bounds of the matrix
        if (row >= 0 && row < grid.length && column >= 0 && column < grid[row].length) {
            if (grid[row][column] == '.' || grid[row][column] == 'R' || grid[row][column] == 'C') {
                result = true;
            }
        }

        return result;
    }

    /**
     * Returns the maze as a string.
     *
     * @return a string representation of the maze
     */
    public String toString()
    {
        String result = "\n";

        for (int row=0; row < grid.length; row++)
        {
            for (int column=0; column < grid[row].length; column++) {
                result += grid[row][column] + "";
            }
            result += "\n";
        }

        return result;
    }
}

