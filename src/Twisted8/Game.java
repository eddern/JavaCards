package Twisted8;


import Deck.Deck;
import Deck.Card;
import java.util.ArrayList;

/**
 * Created by Eirik Kaldahl on 19.04.2016.
 */
public class Game {

    private ArrayList<Player> players;
    private Deck deck;
    private boolean gameIsStarted;
    private ArrayList<Card> board;

    public Game(int players){
        this.gameIsStarted = false;
        this.deck = new Deck();
        this.players = getPlayers(players);
        this.board = new ArrayList<>();

        placeCard(deck.getTopOfDeck());
        
    }

    public ArrayList<Player> getPlayers(int players){

        ArrayList<Player> ppl = new ArrayList<>();
        for(int i = 0; i < players; i++){
            ppl.add(new Player("Player "+String.valueOf(i+1)));
        }

        return ppl;
    }

    public void placeCard(Card card){
        // TODO: make isValid() func
        board.add(0,card);
    }

    public Card getTopOfBoard(){
        return board.get(0);
    }

    public void addPlayer(Player player){
        if(gameIsStarted){
            throw new IllegalArgumentException("Can't add player after game is started.");
        }
        this.players.add(player);
    }

    public void dealCards(int amount){
        this.gameIsStarted = true;
        for(int i = 0; i < players.size(); i++){
            players.get(i).addToHand(deck.draw(amount));
        }
    }

    public void run(){

    }

    public static void main(String[] args) {
        Game game = new Game(3);

    }




}
