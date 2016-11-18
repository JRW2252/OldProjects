package mouseonanisland;

// Program Name:      MouseOnAnIsland.java
// Course:            CSE 1302J
// Student Name:      James Ryan Williams
// Assignment Number: Project 3 
// Due Date:          28/09/2013
// Purpose:           Program mimics a mouse trying to escape an island. 
// The mouse has three different possible outcomes; drowning, starving, and 
// eacaping. The mouse has 20 moves to escape or it will starve. 


/* *                             ***Algorithm is as follows***
 * -----------------------------------------------------------------------------------------------------
 * The array is initialized to a random size between being 5x5 and 10x10.
 * The array is cleaned out with no containing values, and then the border is set with  water only at first. 
 * The two bridges are randomly chosen with their locations on a border. (not on any corners!!!)
 * Then the mouses origin location is randomly chosen and set. 
 * The mouse then is given one of four directions to move. (up, down, left, right). 
 * It takes a step, leaves it's mark where it came from, and then a check is run to see if it's location is 
 * either a border(water or bridge). 
 * If water, it drowns and game over. If bridge, it escapes and game over. 
 * If neither happens then the process repeats until it dies, or escapes.
 * The final array is printed out and then the entire process repeats 4 more time. 
 * -----------------------------------------------------------------------------------------------------
 * */

import java.util.Random;

public class MouseOnAnIsland 
{
    public static void main(String[] args) 
    {
        // Initialize and set counter variables and mouse killing variables. 
        int runs = 0, escaped = 0, drowned = 0, starved = 0;
        String water = "-1", bridges = "99"; 
        Random random = new Random();
        
        do // do while loop for # of times to run the mouse escape game. START.
        {
            // create the random size for the island between 5x5 and 10x10
            int rowColNums = random.nextInt(11-5) + 5;
            String [][] island = new String [rowColNums][rowColNums];

            //Create random numbers for mouse x, y start location.
            int mouseRow = random.nextInt(rowColNums-2)+1;
            int mouseCol = random.nextInt(rowColNums-2)+1;
            

            //Display the Islands size and the start location of the mouse on the island. 
            System.out.println("\n\nIsland size is "+rowColNums+"x"+rowColNums);
            System.out.println("Mouse beginning at row: "+(mouseRow+1)
                    +", Col: "+(mouseCol+1));

            for(int i = 0; i < island.length; i++)
            {
                for(int j = 0; j < island[0].length; j++)
                {
                    // Initialize the arrays values with char"*"`
                    island[i][j]=" *";
                    if(i == 0 || j == 0 ||i == island.length-1 
                            || j == island.length-1) // Locate the borders of the array. 
                    {
                        island [i][j] = water;// Initialize all borders as water.
                    }
                }
            }

             //Create two locations for the bridges and assign into array.
            for(int i = 0; i < 2; i++)
            {
                int borderChooser = random.nextInt(4);
                {
                    if(borderChooser == 0)// Border will be on top row
                    {
                        int bridgeTop = random.nextInt(rowColNums-2)+1;
                        island [0][bridgeTop] = "99";
                    }
                    if(borderChooser == 1)// Border will be on right col
                    {
                        int bridgeRight = random.nextInt(rowColNums-2)+1;
                        island [rowColNums-1][bridgeRight] = "99";
                    }
                    if(borderChooser == 2)// Border will be on bottom row
                    {
                        int bridgeBottom = random.nextInt(rowColNums-2)+1;
                        island [bridgeBottom][rowColNums-1] = "99";
                    }
                    if(borderChooser == 3)// Border will be on left col
                    {
                        int bridgeLeft = random.nextInt(rowColNums-2)+1;
                        island [bridgeLeft][0] = "99";
                    }
                }
            }

            //Mouse begins on the map at x,y coordinates
            int count = 1;
            String temp = Integer.toString(count);
            island[mouseRow][mouseCol]=temp;
            
            // variable assignment to end the run
            boolean gameOver = false; 
            do //Begin moving mouse in search of a way out!!!
            {
                int moveDirection = random.nextInt(4); 
                {
                    if(moveDirection == 0)// Mouse will move up one row
                    {
                        if(island[mouseRow][mouseCol] != water ||
                                island[mouseRow][mouseCol] != bridges) // Check to see if the mouse is not dead yet
                        {
                            temp = Integer.toString(count); // Set the integer int a string for entering it into the array
                            island[mouseRow][mouseCol] = temp; // Assign the count into the array
                            mouseRow++;
                            count++;
                        }
                    
                        if(island[mouseRow][mouseCol] == water) 
                        {
                            System.out.println("The mouse drowned at row "+(mouseRow+1)+", column "+(mouseCol+1));
                            drowned++;
                            gameOver = true; 
                        }
                        if(island[mouseRow][mouseCol] == bridges)
                        {
                            System.out.println("The mouse escaped at row "+(mouseRow+1)+", column "+(mouseCol+1));
                            escaped++; 
                            gameOver = true; 
                        }
                        if(count == 20)
                        {
                            System.out.println("The mouse escaped at row "+(mouseRow+1)+", column "+(mouseCol+1));
                            starved++;
                            gameOver = true; 
                        }
                    }
                    if(moveDirection == 1)// Mouse will move right one col
                    {
                        if(island[mouseRow][mouseCol] != water ||
                                island[mouseRow][mouseCol] != bridges) // Check to see if the mouse is not dead yet
                        {
                            temp = Integer.toString(count);
                            island[mouseRow][mouseCol] = temp;
                            mouseRow++;
                            count++;
                        }
                        if(island[mouseRow][mouseCol] == water)
                        {
                            System.out.println("The mouse drowned at row "+(mouseRow+1)+", column "+(mouseCol+1));
                            drowned++;
                            gameOver = true; 
                        }
                        if(island[mouseRow][mouseCol] == bridges)
                        {
                            System.out.println("The mouse escaped at row "+(mouseRow+1)+", column "+(mouseCol+1));
                            escaped++; 
                            gameOver = true; 
                        }
                        if(count == 20)
                        {
                            System.out.println("The mouse starved at row "+(mouseRow+1)+", column "+(mouseCol+1));
                            starved++;
                            gameOver = true; 
                        }
                    }
                    if(moveDirection == 2)// Mouse will move down one row
                    {
                        if(island[mouseRow][mouseCol] != water ||
                                island[mouseRow][mouseCol] != bridges) // Check to see if the mouse is not dead yet
                        {
                            temp = Integer.toString(count);
                            island[mouseRow][mouseCol] = temp;
                            mouseRow--;
                            count++;
                        }
                        if(island[mouseRow][mouseCol] == water)
                        {
                            System.out.println("The mouse drowned at row "+(mouseRow+1)+", column "+(mouseCol+1));
                            drowned++;
                            gameOver = true; 
                        }
                        if(island[mouseRow][mouseCol] == bridges)
                        {
                            System.out.println("The mouse escaped at row "+(mouseRow+1)+", column "+(mouseCol+1));
                            escaped++; 
                            gameOver = true; 
                        }
                        if(count == 20)
                        {
                            System.out.println("The mouse starved at row "+(mouseRow+1)+", column "+(mouseCol+1));
                            starved++;
                            gameOver = true; 
                        }
                    }
                    if(moveDirection == 3)// Mouse will move left one col 
                    {
                        if(island[mouseRow][mouseCol] != water ||
                                island[mouseRow][mouseCol] != bridges) // Check to see if the mouse is not dead yet
                        {
                            temp = Integer.toString(count);
                            island[mouseRow][mouseCol] = temp;
                            mouseRow--;
                            count++;
                        }
                        if(island[mouseRow][mouseCol] == water)
                        {
                            System.out.println("The mouse drowned at row "+(mouseRow+1)+", column "+(mouseCol+1));
                            drowned++;
                            gameOver = true; 
                        }
                        if(island[mouseRow][mouseCol] == bridges)
                        {
                            System.out.println("The mouse escaped at row "+(mouseRow+1)+", column "+(mouseCol+1));
                            escaped++; 
                            gameOver = true; 
                        }
                        if(count == 20)
                        {
                            System.out.println("The mouse starved at row "+(mouseRow+1)+", column "+(mouseCol+1));
                            starved++;
                            gameOver = true; 
                        }
                    } 
                }
            //Ending the moves of the mouse for this run
            } while(gameOver == false);
            for(int i = 0; i < island.length; i++)
            {
                for(int j = 0; j < island[0].length; j++)
                {
                    System.out.print(island[i][j]+"\t|");
                }
                System.out.println();
            }
            //increment runs count
            runs++;
        // While limiter for the number of desired runs. ENDS
        }while (runs < 20);
        // Print out the count of escapes, starvations, and drownings.
        System.out.println("\n\nEscapes: "+escaped+"\nDrowned: "+drowned+
                    "\nStarved: "+starved);
    }

}
