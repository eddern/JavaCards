package Deck;

import java.util.ArrayList;

/**
 * Created by eddern on 19/04/16.
 */
public class Deck {

    private ArrayList<Card> deck;

    public Deck(){
        deck = generateDeck();
        //deck.shuffleDeck();
    }

    //public void shuffleDeck(){

    //}

    public ArrayList<Card> generateDeck(){
        ArrayList<Card> deck = new ArrayList<>();
        Suit[] faces = {Suit.DIAMOND,Suit.HEART,Suit.SPADE,Suit.CLUBS};

        for(int i = 0; i < 4; i++){
            for(int x = 1; x < 14; x++){
                deck.add(new Card(x,faces[i]));
            }
        }
        return deck;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "deck=" + deck +
                '}';
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println(deck.getDeck().size());

    }
}
