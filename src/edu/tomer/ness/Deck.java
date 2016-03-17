package edu.tomer.ness;

import java.util.Random;

/**
 * Created by Dev on 17/03/2016.
 */
public class Deck {

   //Properties
   Card[] deck;

   //Constructor - It's Purpose is to set the properties
   public Deck(){
       String[] suits = {"♥", "♦", "♣", "♠"};
       String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7",
               "8", "9", "10", "Jack", "Queen", "King"};
       int[] values = {11, 2, 3, 4, 5, 6, 7,
               8, 9, 10, 10, 10, 10};

       this.deck = new Card[13*4/*52*/];

       //Build a deck of cards;
       int counter = 0;
       for (int s = 0; s < 4; s++) {
           for (int r = 0; r < 13; r++) {
               Card c = new Card(ranks[r], suits[s], values[r]);
               deck[counter++] = c;
           }
       }
   }

  void shuffle(){
      Random randGen = new Random();
      for (int numOfSorts = 0; numOfSorts < 10; numOfSorts++) {
          for (int i = 0; i < deck.length; i++) {
              for (int j = 0; j < deck.length - i - 1; j++) {
                  //if(deck[j].value > deck[j+1].value)
                    if (randGen.nextBoolean()){
                        //swap
                        Card temp = deck[j];
                        deck[j] = deck[j+1];
                        deck[j+1] = temp;
                    }
              }
          }
      }
  }

    void disp(){
/**
        for (int i = 0; i < deck.length; i++) {
            Card c = deck[i];
            c.dispCard();
        }
**/
        for (Card c : deck) {
            c.dispCard();
        }
    }
}
