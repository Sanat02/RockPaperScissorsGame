package dz1;

import java.util.Random;

public class Computer {
    private Random random;
    public Computer()
    {
        random=new Random();
    }
    private  int getRandomNumber()
    {
        Random random=new Random();
        return random.nextInt(3);

    }
    public  Elements getElement()
    {
        int num=getRandomNumber();
        Elements element1=Elements.PAPER; //пока что просто проинициализируем
        switch (num)
        {
            case 0:
               element1=Elements.ROCK;
                break;
            case 1:
                element1=Elements.PAPER;
                break;
            case 2:
                element1=Elements.SCISSORS;
                break;
            default:
                System.out.println("Some error happened!");
        }
        return element1;
    }
}
