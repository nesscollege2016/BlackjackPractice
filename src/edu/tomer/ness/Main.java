package edu.tomer.ness;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] suits = {"♥", "♦", "♣", "♠"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7",
                "8", "9", "10", "Jack", "Queen", "King"};
        int[] values = {11, 2, 3, 4, 5, 6, 7,
                8, 9, 10, 10, 10, 10};

        Card[] deck = new Card[13*4/*52*/];

        //Build a deck of cards;
        int counter = 0;
        for (int s = 0; s < 4; s++) {
            for (int r = 0; r < 13; r++) {
                Card c = new Card(ranks[r], suits[s], values[r]);
                deck[counter++] = c;
            }
        }

        Random r = new Random();

        Card c1 = deck[r.nextInt(52)];
        Card c2 = deck[r.nextInt(52)];


        int sum = 0;
        c1.dispCard();
        c2.dispCard();

        int aces = 0;
        sum+= c1.value;
        if (c1.value==11)
            aces++;

        sum+= c2.value;
        if (c2.value==11)
            aces++;

        while (true) {
            System.out.printf("sum: %d. Hit or Stand? 0 - 1\n", sum);
            int userResponse = scanner.nextInt();
            if (userResponse == 1)break;
            Card c = deck[r.nextInt(52)];
            if (c.value==11)aces++;
            c.dispCard();
            sum+=c.value;

            while (aces>0 && sum > 21){
                sum-=10;
                aces-=1;
            }
            if (sum > 21) {
                System.out.println("You loose");
                break;
            }
        }

        int userSum = sum;
        boolean isUserBusted = sum > 21;

        if (!isUserBusted) {
            //Computer play:

            //Reset the values
            c1 = deck[r.nextInt(52)];
            c2 = deck[r.nextInt(52)];
            aces = 0;
            sum = 0;

            sum += c1.value;
            if (c1.value == 11)
                aces++;
            c1.dispCard();

            sum += c2.value;
            if (c2.value == 11)
                aces++;
            c2.dispCard();

            while (true) {
                if (sum >= 17) {
                    System.out.println(sum);break;}
                Card c = deck[r.nextInt(52)];
                if (c.value == 11) aces++;
                c.dispCard();
                sum += c.value;

                while (aces > 0 && sum > 21) {
                    sum -= 10;
                    aces -= 1;
                }
            }

            boolean isComputerBuster = sum > 21;
            if (isComputerBuster){
                System.out.println("user wins");
            }
            else if(sum > userSum)
                System.out.println("Computer wins");
            else {
                System.out.println("user wins");
            }
        }
    }
}
