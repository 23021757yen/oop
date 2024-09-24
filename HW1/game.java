import java.util.*;
public class game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int staywin =0;
        int changewin=0;
        for(int i=0;i<N;i++)
        {
            if(choose(true))// stay
            {
                staywin++;
            }
            else {
                changewin++;
            }
        }
        double xs_stay_win= (float)staywin/N;
        double xs_change_win= (float)changewin/N;
        System.out.println("xac suat o lai thang la:");
        System.out.println(xs_stay_win);
        System.out.println("xac suat thay doi thang la:");
        System.out.println(xs_change_win);
    }

    public static boolean choose(boolean flag )
    {
        int reveal_door;
        int choose_door;
        int prize_door;
        Random rand = new Random();
        choose_door = rand.nextInt(3);
        prize_door = rand.nextInt(3);
        do{
            reveal_door = rand.nextInt(3);
        }
        while(reveal_door==choose_door||reveal_door==prize_door);
        if(flag==false)//change
        {
            choose_door= 3-reveal_door-choose_door;
        }
        return choose_door==prize_door;
    }
}
