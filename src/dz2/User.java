package dz2;

import java.util.Scanner;

public class User {
    private Elements[] element;
    private Scanner in;

    public User()
    {
        element= Elements.values();
        in=new Scanner(System.in);
    }
    public  boolean isValidNumber(int num)
    {
        if(num>=0&&num<=4)
        {
            return true;
        }
        return false;
    }
    public Elements getElement()
    {
        System.out.println("Enter your element number(0-ROCK,1-PAPER,2-SCISSORS,3-LIZARD,4-SPOCK):");
        int num= in.nextInt();
        boolean isValid=isValidNumber(num);
        while (isValid==false)
        {
            System.out.println("ERROR VALUE,ENTER AGAIN!");
            System.out.println("Enter your element number(0-ROCK,1-PAPER,2-SCISSORS,3-LIZARD,4-SPOCK):");
            num = in.nextInt();
            isValid=isValidNumber(num);
        }

        Elements element1= Elements.PAPER; //пока что просто проинициализируем
        switch (num)
        {
            case 0:
                element1= Elements.ROCK;
                break;
            case 1:
                element1= Elements.PAPER;
                break;
            case 2:
                element1= Elements.SCISSORS;
                break;
            case 3:
                element1= Elements.LIZARD;
                break;
            case 4:
                element1= Elements.SPOCK;
                break;
            default:
                System.out.println("Some error happened!");
        }
        return element1;
    }

}
