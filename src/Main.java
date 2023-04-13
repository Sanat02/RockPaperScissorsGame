import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        int draw=0;
        int userWin=0;
        int lose=0;
        int totalGame=0;
        int winPercentage=0;
        int contGame=1;
        while (contGame==1)
        {
            String answer=game();
            if(answer.equals("draw"))
            {
                draw++;
            }
            else if(answer.equals("user"))
            {
                userWin++;
            }
            else
            {
                lose++;
            }
            contGame=continueGame();
            totalGame++;
        }
        printFinalTab(userWin,lose,draw,totalGame);


        System.out.println("--------------------End Game--------------------");

    }


    public static int getRandomNumber(int min,int max)
    {
        Random random=new Random();
        return random.nextInt(max-min)+min;
    }
    public static String getElement( Elements[] element,int num)
    {

        String answer="";
        switch (num)
        {
            case 0:
                answer= String.valueOf(element[0]);
                break;
            case 1:
                answer= String.valueOf(element[1]);
                break;
            case 2:
                answer= String.valueOf(element[2]);
                break;
            default:
                System.out.println("Some error happened!");
        }
        return answer;
    }
    public static boolean isValidNumber(int num)
    {
        if(num>=0&&num<=2)
        {
           return true;
        }
        return false;
    }
    public static String getWinner(String compElement,String userElement)
    {
        if(compElement.equals(userElement))
        {
            return "draw"; //ничья
        }
        else if(userElement.equals("ROCK"))
        {
            if(compElement.equals("PAPER"))
            {
                return "computer";
            }
            else
            {
                return "user";
            }
        }
        else if(userElement.equals("PAPER"))
        {
            if(compElement.equals("ROCK"))
            {
                return "user";
            }
            else
            {
                return "computer";
            }
        }
        else
        {
            if(compElement.equals("ROCK"))
            {
                return "computer";
            }
            else
            {
                return "user";
            }
        }
    }
    public static String game()
    {
        System.out.println("------------------Start Game------------------");
        Scanner in=new Scanner(System.in);
        Elements[] element=Elements.values();

        int randNum = getRandomNumber(0, element.length);
        String compElement = getElement(element, randNum);
        System.out.println("computer element is:" + compElement);
        System.out.println("Enter your element number(0-ROCK,1-PAPER,2-SCISSORS):");
        int num = in.nextInt();
        boolean isValid=isValidNumber(num);
        while (isValid==false)
        {
            System.out.println("ERROR VALUE,ENTER AGAIN!");
            System.out.println("Enter your element number(0-ROCK,1-PAPER,2-SCISSORS):");
            num = in.nextInt();
            isValid=isValidNumber(num);
        }
        String userElement = getElement(element, num);
        System.out.println("user:" + userElement);
        System.out.println("The winner is:"+getWinner(compElement,userElement));

        return getWinner(compElement,userElement);

    }
    public static int continueGame()
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
    public static void printFinalTab(int wins,int losses,int ties,int totalgame)
    {
        System.out.printf("| %-25s |%-25s | %-25s| %-25s | %-25s%n","WINS","LOSSES","TIES","TOTAL","PERCENTAGE WON");
        System.out.printf("| %-25s |%-25s | %-25s| %-25s | %-25s%n",wins,losses,ties,totalgame,(100/(double)totalgame));
    }
}
