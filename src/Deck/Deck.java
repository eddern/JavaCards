package Deck;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by eddern on 19/04/16.
 */
public class Deck {

    private ArrayList<Card> deck;

    public Deck(){
        deck = generateDeck();
        shuffleDeck();
    }

    public Card draw(){
        Card card = deck.get(0);
        deck.remove(0);
        return card;
    }

    public ArrayList<Card> draw(int amount){
        if(amount > deck.size()){
            throw new IllegalArgumentException("Not enough cards in deck for a "+amount+" draw.");
        }
        ArrayList<Card> cards = new ArrayList<>();
        for(int i = 0; i < amount; i++){
            cards.add(deck.get(0));
            deck.remove(0);
        }
        return cards;
    }

    public void shuffleDeck(){
        Collections.shuffle(this.deck);
    }

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
