package dz2;

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
        int contGame=1;
        while(contGame==1) {
            computer=new Computer();
            computerChoice=computer.getElement();
            user=new User();
            userChoice=user.getElement();
            winState= WinState.values();
            System.out.println("Computer choice is:" + computerChoice);
            System.out.println("User choice is:" + userChoice);
            WinState state = getWinner();
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
        if(computerChoice.equals(userChoice))
        {
            return winState[2]; //ничья
        }
        else if(userChoice.equals("ROCK"))
        {
            if(computerChoice.equals("PAPER"))
            {
                return winState[1];
            }
            else
            {
                return winState[0];
            }
        }
        else if(userChoice.equals("PAPER"))
        {
            if(computerChoice.equals("ROCK"))
            {
                return winState[0];
            }
            else
            {
                return winState[1];
            }
        }
        else
        {
            if(computerChoice.equals("ROCK"))
            {
                return winState[1];
            }
            else
            {
                return winState[0];
            }
        }
    }
    private void printFinalTab()
    {
        System.out.println("_____________________________________________________________________________________________________________________________________________");
        System.out.printf("| %-25s |%-25s | %-25s| %-25s | %-25s   |%n","WINS","LOSSES","TIES","TOTAL","PERCENTAGE WON");
        System.out.printf("| %-25s |%-25s | %-25s| %-25s | %-25s   |%n",wins,loss,ties,totalGames,(100/(double)totalGames));
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
