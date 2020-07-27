import java.util.Random;

public class CoinTossTest {

    public static void main(String[] args) {

        /*
            Application to simply test an old HackerRank coding question
            Flip a coin 50 times and record longest streaks for heads/tails
            Steps:
            > Simulate coin toss and record results in int array
            > 0 = Heads, 1 = Tails
            > Record longest streak results (can do this while simulating)
        */

        int headStreak = 0;
        int tailStreak = 0;
        int curStreak = 0;
        int result = 0;
        int lastResult = 2; // make arbitrary number 2 so we know when it's our first iteration

        Random rand = new Random();

        // for 50 iterations
        for(int i = 0; i < 50; i++) 
        {
            // 1st iteration
            if(lastResult == 2)
            {
                // toss, save result, update curStreak
                result = rand.nextInt(2);
                System.out.println(result);
                curStreak += 1;
            } 
            // not 1st iteration
            else
            {
                result = rand.nextInt(2);
                System.out.println(result);
                // if it is a streak
                if (lastResult == result) {
                    // incremement current streak
                    if(curStreak == 0) 
                    {
                        curStreak += 2; // two in a row
                    }
                    else
                    {
                        curStreak += 1; // already mid streak, inc by 1
                    }
                    // if its greater than our headsstreak, update
                    if (result == 0 && curStreak > headStreak)
                    {
                        headStreak = curStreak;
                    }
                    else if (result == 1 && curStreak > tailStreak)
                    {
                        tailStreak = curStreak;
                    }
                } 
                // if it is NOT a streak
                else 
                {
                    curStreak = 0;
                }
            }
            
            lastResult = result;
        }
        // Print Results
        System.out.println("Longest Streak of Heads: " + headStreak);
        System.out.println("Longest Streak of Tails: " + tailStreak);
    }
}