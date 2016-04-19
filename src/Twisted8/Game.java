package Twisted8;


import Deck.Deck;

import java.util.ArrayList;

/**
 * Created by Eirik Kaldahl on 19.04.2016.
 */
public class Game {

    private ArrayList<Player> players;
    private Deck deck;
    private boolean gameIsStarted;

    public Game(){
        this.gameIsStarted = false;
        this.deck = new Deck();
        this.players = new ArrayList<>();
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

    public static void main(String[] args) {
        Game game = new Game();
        Player eddern = new Player("Eddern");
        Player eirik = new Player("Aase");
        Player simen = new Player("SlimJim");
        game.addPlayer(eddern);
        game.addPlayer(eirik);
        game.addPlayer(simen);
        game.dealCards(5);
        System.out.println(simen);
        System.out.println(eddern);
        System.out.println(eirik);
    }




}
