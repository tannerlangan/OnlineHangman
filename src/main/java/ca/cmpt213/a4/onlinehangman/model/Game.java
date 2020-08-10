package ca.cmpt213.a4.onlinehangman.model;


public class Game {
    private Long gameID;
    private String word;
    private int playerGuesses = 0;
    private int incorrectGuesses = 0;
    private int status = 3; //win == 1, lose == 2, in progress == 3

    public Long getGameID() {
        return gameID;
    }

    public void setGameID(Long gameID) {
        this.gameID = gameID;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getPlayerGuesses() {
        return playerGuesses;
    }

    public void setPlayerGuesses(int playerGuesses) {
        this.playerGuesses = playerGuesses;
    }

    public int getIncorrectGuesses() {
        return incorrectGuesses;
    }

    public void setIncorrectGuesses(int incorrectGuesses) {
        this.incorrectGuesses = incorrectGuesses;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Game(){

    }

    public Game(Long gameID, String word, int incorrectGuesses, int playerGuesses, int status) {
        this.gameID = gameID;
        this.word = word;
        this.playerGuesses = playerGuesses;
        this.status = status;
        this.incorrectGuesses = incorrectGuesses;
    }
}
