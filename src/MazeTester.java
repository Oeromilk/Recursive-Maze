import java.util.*;
import java.io.*;

/**
 * AJ McComb
 * 11/11/2019
 * Dr Tisha Gaines
 * Maze Program
 * I pledge that the work submitted here is that of my own and I did not receive help or plagiarize any work
 * in order to complete this program.
 *
 * MazeTester is our main function that creates our maze class and passes that to the
 * MazeSolver class.
 */
public class MazeTester
{
    /**
     * Main method will take in the file name create a new maze and then use the
     * recursive method to try and find the solution.
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        // create the scanner and then collect the file name.
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the name of the file containing the maze: ");
        String filename = scan.nextLine();

        Maze labyrinth = new Maze(filename);

        // Used for testing without having to paste in the path every time.
        // Maze labyrinth = new Maze("/home/oeromccomb/IdeaProjects/MazeProject/maze1.txt");

        // Print out the maze.
        System.out.println(labyrinth);

        // Pass the maze to maze solver.
        MazeSolver solver = new MazeSolver(labyrinth);

        // start the maze with the rats starting cordinates and start the counter for times called to 1
        if (solver.traverse(labyrinth.ratRow, labyrinth.ratCol, 1)) {
            System.out.println("The maze was successfully traversed!");
            System.out.println("There are " + labyrinth.breadCrumbs + " breadcrumbs.");
            System.out.println("traverse was called " + solver.timesCalled + " times.");
            System.out.println("Solution:");
            System.out.println(labyrinth);
        } else {
            System.out.println("There is no possible path.");
        }
    }
}