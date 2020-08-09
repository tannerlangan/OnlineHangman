package ca.cmpt213.a4.onlinehangman.controllers;

import ca.cmpt213.a4.onlinehangman.model.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@Controller
public class HangmanController {
    private Message promptMessage; //a resusable String object to display a prompt message at the screen
    private Message rulesMessage;
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
    public String startGame(Model model) {



        // take the user to newGame.html
        return "newgame";
    }
}