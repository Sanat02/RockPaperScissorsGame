package dz3;

import java.util.Locale;
import java.util.Scanner;

public class Game {
    private Computer computer;
    private User user;
    private Elements computerChoice;
    private Elements userChoice;
    private WinState[] winState;
    private int wins;
    private int loss;
    private int ties;
    private int totalGames;
    public Game()
    {
        System.out.println("------------------Start Game------------------");

    }
    public void startGame()
    {
        Scanner in=new Scanner(System.in);
        int contGame=1;
        while(contGame==1) {
        System.out.println("Choose category:1-EASY,2-DIFFICULT");
        String anwser=in.nextLine();
        while (!anwser.equals("1")&&!anwser.equals("2"))
        {
            System.out.println("INVALID VALUE!");
            System.out.println("Choose category:1-EASY,2-DIFFICULT");
            anwser=in.nextLine();
        }
        if(anwser.equals("1")) {
            computer = new Computer(3);
            user = new User(3);
        }
        else
        {
            computer = new Computer(5);
            user = new User(5);
        }
            computerChoice = computer.getElement();
            userChoice = user.getElement();
            winState = WinState.values();

            System.out.println("Computer choice is:" + computerChoice);
            System.out.println("User choice is:" + userChoice);
            WinState state = getWinner();
            System.out.println(state);
            if (state.equals(WinState.WIN)) {
                System.out.printf("%s beats %s %nUSER WINS!%n", userChoice, computerChoice);
                wins++;
            } else if (state.equals(WinState.LOSS)) {
                System.out.printf("%s beats %s %nCOMPUTER WINS!%n", computerChoice, userChoice);
                loss++;
            } else {
                System.out.printf("%s equals %s %nIT IS A TIE!%n", computerChoice, userChoice);
                ties++;
            }
            totalGames++;
            contGame = continueGame();
        }


        printFinalTab();
        System.out.println("--------------------End Game--------------------");

    }
    private WinState getWinner()
    {
        if(userChoice==computerChoice)
        {
            return WinState.TIE; //ничья
        }
        else if(userChoice== Elements.ROCK)
        {
            if(computerChoice== Elements.PAPER||computerChoice== Elements.SPOCK)
            {
                return WinState.LOSS;
            }
            else
            {
                return WinState.WIN;
            }
        }
        else if(userChoice== Elements.PAPER)
        {
            if(computerChoice== Elements.ROCK||computerChoice== Elements.SPOCK)
            {
                return WinState.WIN;
            }
            else
            {
                return WinState.LOSS;
            }
        }
        else if(userChoice== Elements.SCISSORS)
        {
            if(computerChoice== Elements.ROCK||computerChoice== Elements.SPOCK)
            {
                return WinState.LOSS;
            }
            else
            {
                return WinState.WIN;
            }
        }
        else if(userChoice== Elements.LIZARD)
        {
            if(computerChoice== Elements.ROCK||computerChoice== Elements.SCISSORS)
            {
                return WinState.LOSS;
            }
            else
            {
                return WinState.WIN;
            }
        }
        else
        {
            if(computerChoice== Elements.SCISSORS||computerChoice== Elements.ROCK)
            {
                return WinState.WIN;
            }
            else
            {
                return WinState.LOSS;
            }
        }

    }

    private void printFinalTab()
    {
        System.out.println("_____________________________________________________________________________________________________________________________________________");
        System.out.printf("| %-25s |%-25s | %-25s| %-25s | %-25s   |%n","WINS","LOSSES","TIES","TOTAL","PERCENTAGE WON");
        System.out.printf("| %-25s |%-25s | %-25s| %-25s | %-25s   |%n",wins,loss,ties,totalGames,((((double)wins+(double)(ties/2))/totalGames)*100));
        System.out.println("_____________________________________________________________________________________________________________________________________________");
    }
    private   int continueGame()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Would you like to continue?(Press y or n)");
        String answer=in.nextLine();
        answer.toLowerCase(Locale.ROOT);
        while(!answer.equals("y")&&!answer.equals("n"))
        {
            System.out.println("Enter Valid value!(Press y or n)");
            answer=in.nextLine();
            answer.toLowerCase(Locale.ROOT);
        }
        if(answer.equals("y"))
        {
            return 1;
        }
        return -1;
    }

}
