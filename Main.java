//Author: Kyle Winkler
package cards;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kbrd = new Scanner(System.in);

//Upload game text file (cod.txt only current active)
        System.out.println("What game would you like to play? ");
        String gameChoice = kbrd.next();
//calls the readCards method and creates object array of the Main class with the .txt information
//essentially just creates a name and description for each card.
        CardReader[] game = readCards(gameChoice);

//choose how many players, currently set to 8 max but feel free to do whatever you want to it
        System.out.println("How many players: ");
        int playerCount = Integer.parseInt(kbrd.next());
        if (playerCount > 8) {
            System.out.println("You may only have up to 8 players.");
            System.out.println("");
            System.out.println("How many players: ");
//Converts input number to an integer and stores as player count
            playerCount = Integer.parseInt(kbrd.next());
        }

//Creates an array and opens the readPlayers method in this class, outside of the main method. 
//Click "readPlayers" to highlight all occruences to find it easier.
        Player[] player = readPlayers(playerCount);

//begin an infinite loop unless broken
        for (;;) {
//variable initialized to later test the loop to see if it should be broken or continue (4EVA!)
            String temp = null;
//begin loop to cycle through players for turn taking
            for (int i = 0; i < playerCount; i++) {
//calls the "random" method which outside of main. Gives a random card from the Card array                
                int rand = randInt(0, 51);
//                for (int u = 0; u < 51; u++) {
//                    if (game[rand].getCard() == pulleCard[i]) {
//                        
//                    }
//                }
//print the player whose turn it is, the card they receive, and the summary description
                System.out.println("");
                System.out.println(player[i].getName() + " your card is " + game[rand].getCard());
                System.out.println(game[rand].getDescription());

                System.out.println("type \"ok\" to continue or anything else to end game: ");
                temp = kbrd.next();

//break the loop before all players have gone at least once
                if (!temp.equals("ok")) {
                    break;
                }
//type anything besides "ok" to end the game                 
            }
            if (!temp.equals("ok")) {
                break;
            }
        }
    }

    private static CardReader[] readCards(String game) {
//creates array from the imported .txt file storing a card object with each card name and dsecription

        Scanner fileIn = null;
        try {
            fileIn = new Scanner(new File(game));
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            System.exit(1);
        }
//number of cards initialized at beginning of .txt document
        int count = fileIn.nextInt();
        CardReader[] cardReader = new CardReader[count];
        fileIn.nextLine();
        CardReader[] pulledCards = new CardReader[count];

//gathers information for each card
        for (int i = 0; i < count; i++) {
            String card;
            String description;
            card = fileIn.nextLine();
            description = fileIn.nextLine();

//stores information for each card
            cardReader[i] = new CardReader(card, description);

        }

        return cardReader;
    }

    private static Player[] readPlayers(int playerCount) {

        Scanner kbrd = new Scanner(System.in);

//createst the object array the size of the player count    
        Player[] player = new Player[playerCount];

//stores each position in the array with a name and id number in the Player class
        for (int i = 0; i < playerCount; i++) {
            System.out.println("Player " + (i + 1) + " name: ");
            String playerName = kbrd.next();
            player[i] = new Player(playerName, i);

        }

        return player;
    }

    public static int randInt(int min, int max) {
//method generates a random number in the range
        int randomNum = min + (int) (Math.random() * ((max - min) + 1));
        return randomNum;
    }

}
