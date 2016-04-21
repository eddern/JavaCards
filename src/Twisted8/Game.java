package Twisted8;


import Deck.Deck;
import Deck.Card;
import Deck.Suit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Eirik Kaldahl on 19.04.2016.
 */
public class Game {

    private ArrayList<Player> players;
    private Player currentPlayer;
    // TODO: Above

    private Deck deck;
    private ArrayList<Card> board;

    public Game(int players){
        if(10 > 52-(players*5)){
            throw new IllegalArgumentException("Too many Players.");
        }
        this.deck = new Deck();
        this.players = getPlayers(players);
        shufflePlayers();
        this.board = new ArrayList<>();
        placeCard(deck.getTopOfDeck());
        currentPlayer = this.players.get(0);
    }

    public ArrayList<Player> getPlayers(int players){
        ArrayList<Player> ppl = new ArrayList<>();
        for(int i = 0; i < players; i++){
            ppl.add(new Player("Player "+String.valueOf(i+1)));
        }
        return ppl;
    }


    public boolean placeCard(Card card){
        if(isValid(card)) {
            board.add(0, card);
            if (card.getValue() == 8) twist();
            return true;
        }
        return false;

    }

    public void twist(){
        System.out.println("What suit do you want to twist to?\n\t[C]lubs, [D]iamond, [S]pade, [H]eart.");
        Scanner sc = new Scanner(System.in);
        char twistTo = (char)sc.nextByte();
        switch (twistTo){
            case 'C':
                getTopOfBoard().setSuit(Suit.CLUBS);
            case 'D':
                getTopOfBoard().setSuit(Suit.DIAMOND);
            case 'S':
                getTopOfBoard().setSuit(Suit.SPADE);
            case 'H':
                getTopOfBoard().setSuit(Suit.HEART);
            default:
                System.out.println("Wrong input!");
                twist();
        }
    }

    public boolean isValid(Card card){
        if(card.getSuit() == getTopOfBoard().getSuit()) return true;
        if(card.getValue() == getTopOfBoard().getValue()) return true;
        if(card.getValue() == 8) return true;
        return false;
    }
    public Card getTopOfBoard(){
        return board.get(0);
    }

    public void dealCards(int amount) {
        for (int i = 0; i < players.size(); i++) {
            players.get(i).addToHand(deck.draw(amount));
        }
    }
    public void shufflePlayers(){
        Collections.shuffle(this.players);
    }

    public static void main(String[] args) {
        Game game = new Game(3);
        this.players.add(currentPlayer);
        currentPlayer = this.players.get(0);
        game.players.remove(0);
        System.out.println(game.currentPlayer);
        Scanner scanner = new Scanner(System.in);
        }
    }
}
