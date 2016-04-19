package Deck;

/**
 * Created by eddern on 19/04/16.
 */
public class Card {
    private int value;
    private Suit suit;

    public Card(int value, Suit suit){
        this.value = value;
        this.suit = suit;
    }

    public int getValue(){
        return this.value;
    }

    public void setValue(int value){
        if(value < 1 || value > 13){
            throw new IllegalArgumentException("Value "+value+" is out of range.");
        }else{
            this.value = value;
        }
    }

    public Suit getSuit(){
        return this.suit;
    }

    public void setSuit(Suit suit){
        this.suit = suit;
    }

    @Override
    public String toString() {
        return value+" of "+suit;
    }
}
