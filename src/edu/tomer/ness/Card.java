package edu.tomer.ness;

/**
 * Created by Dev on 17/03/2016.
 */
public class Card {
    //Properties
    String suit;
    String rank;
    int value;

    //Constructor
    public Card(String rank, String suit, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    //Methods/Action
    void dispCard(){
        //Ace of Clubs
        //8 of hearts
        System.out.printf("%s of %s\n", rank, suit);
    }
}
