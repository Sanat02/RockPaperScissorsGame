package dz1;

import java.util.Random;

public class Computer {
    private Random random;
    private Elements[] element;
    public Computer()
    {
        random=new Random();
        element= Elements.values();
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
               element1=element[0];
                break;
            case 1:
                element1=element[1];
                break;
            case 2:
                element1=element[2];
                break;
            default:
                System.out.println("Some error happened!");
        }
        return element1;
    }
}
