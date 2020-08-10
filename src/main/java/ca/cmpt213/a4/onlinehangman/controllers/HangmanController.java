package ca.cmpt213.a4.onlinehangman.controllers;

import ca.cmpt213.a4.onlinehangman.GetWord;
import ca.cmpt213.a4.onlinehangman.model.Game;
import ca.cmpt213.a4.onlinehangman.model.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class HangmanController {

    private Message promptMessage; //a resusable String object to display a prompt message at the screen
    private Message rulesMessage;
    private Message gameMessage = new Message();
    private AtomicLong gameID = new AtomicLong();
    private GetWord getWord = new GetWord();
    private List gameList = new ArrayList();

    //works like a constructor, but wait until dependency injection is done, so it's more like a setup
    @PostConstruct
    public void hangmanControllerInit() {
        promptMessage = new Message("Initializing...");
        rulesMessage = new Message("Initializing...");

    }

    @GetMapping("/welcome")
    public String showWelcomePage(Model model) {

        promptMessage.setMessage("Hello there! My name is Tanner Langan, my SFU email is tlangan@sfu.ca and my student ID is 301238727");
        model.addAttribute("promptMessage", promptMessage);
        rulesMessage.setMessage("The rules of the game are super easy! The basic jist of it is that there will be an unknown word from the english language. \n" +
                "You will have to guess this word letter by letter until you solve it. Don't worry, it will get easier the more letters you guess. \n" +
                "Lets see how few letters you can solve it in!");
        model.addAttribute("rulesMessage", rulesMessage);


        // take the user to helloworld.html
        return "welcome";
    }

    @RequestMapping( value="/newgame", method=RequestMethod.POST)
    public String startGame(@Valid Game newGame, Model model) throws IOException {


        int playerGuesses = 0;
        int incorrectGuesses = 0;
        int gameStatus = 3;

        newGame.setGameID(gameID.incrementAndGet());
        newGame.setWord(getWord.returnRandomWord());
        newGame.setIncorrectGuesses(incorrectGuesses);
        newGame.setPlayerGuesses(playerGuesses);
        newGame.setStatus(gameStatus);

        gameMessage.setMessage("Game ID:" + newGame.getGameID().toString() +
                "\nGame Word: " + newGame.getWord());
        model.addAttribute("gameMessage", gameMessage);




        gameList.add(newGame);
        // take the user to newGame.html
        return "newgame";
    }


}