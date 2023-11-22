import java.util.Random;
import java.util.Scanner;
    public class guess_number
    {

     public static void main (String[] args)
        {
    final int MAX = 100;
    int answer, guess;
    int c=0;
    String again;
    Scanner scan = new Scanner(System.in);
    System.out.print ("I'm thinking of a number between 1 and "
    + MAX + ". Guess what it is: (or enter 0 to quit) ");
    guess = scan.nextInt();

    Random generator = new Random(); //Random generator. 1 to 100.
    answer = generator.nextInt(MAX) +1;

        //if (guess == answer){ //If guess equals answer
            //System.out.println ("You got it! Good guessing!");

        //}
        //else if (guess == 0){ //Game ends
            //System.out.println ("You have ended your game. Goodbye.");

        //}

            while (guess != answer && guess != 0){ //If guess and 0 is not answer, continue.

                if (guess > answer && guess != 0){ //If guess is higher than answer
                    System.out.println ("You guessed too high!");
                    c=c+1;
                    guess = scan.nextInt();

                }
                else{
                    if (guess < answer && guess != 0){ //If guess is lower than answer
                        System.out.println ("You guessed too low!");
                        c=c+1;
                        guess = scan.nextInt();
                    }

                    else if (guess == answer){ //If guess equals answer
                        c=c+1;
                        System.out.println ("You got it! Good guessing!");
                    }
                    else if (guess == 0){ //Game ends
                        System.out.println ("You have ended your game. Goodbye.");
                    }
                        }
    }
            if (guess == answer){
                System.out.println ("You got it! Good guessing!");
               System.out.println ("You guessed " + c + " times");
            }
    }
}