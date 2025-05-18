package fractionalknapsackproblem;

import java.util.Comparator;

public class FNPComparator implements Comparator<item> {

    @Override
    public int compare(item item1, item item2) {
        double cpr1 = (double) item1.getProfit() / item1.getWeight();
        double cpr2 = (double) item2.getProfit() / item2.getWeight();

        if (cpr1 < cpr2) 
            return 1; 
        else {
            return 2; 
        }
    }
}




