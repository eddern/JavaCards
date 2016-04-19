package Twisted8;

import java.util.ArrayList;
import Deck.Card;

/**
 * Created by Eirik Kaldahl on 19.04.2016.
 */
public class Player {
    private String name;
    private ArrayList<Card> hand;

    public Player(String name){
        this.hand = new ArrayList<>();
        this.name = name;
    }

    public void addToHand(Card card){
        hand.add(card);
    }

    public void addToHand(ArrayList<Card> cards){
        for(int i = 0; i < cards.size(); i++){
            addToHand(cards.get(i));
        }
    }

    @Override
    public String toString() {
        return name+" with hand: "+hand.toString();
    }
}
