package fractionalknapsackproblem;
import java.util.*;


public class FNPCMain {
    private static double getMaxValue(ArrayList<item> itemValues, int capacity) {
        double totalValue = 0.0;

        for (item item : itemValues) {
            int curWt = item.getWeight();
            int curVal = item.getProfit();

            if (capacity >= curWt) {
                capacity -= curWt;
                totalValue += curVal;
            } else {
                double fraction = ((double) capacity / curWt);
                totalValue += curVal * fraction;
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        ArrayList<item> itemValues = new ArrayList<>();

        item itemValue1 = new item(); itemValue1.setObject(2); itemValue1.setProfit(5); itemValue1.setWeight(1);
        item itemValue2 = new item(); itemValue2.setObject(1); itemValue2.setProfit(12); itemValue2.setWeight(3);
        item itemValue3 = new item(); itemValue3.setObject(3); itemValue3.setProfit(16); itemValue3.setWeight(4);
        item itemValue4 = new item(); itemValue4.setObject(4); itemValue4.setProfit(7); itemValue4.setWeight(2);
        item itemValue5 = new item(); itemValue5.setObject(6); itemValue5.setProfit(11); itemValue5.setWeight(4);
        item itemValue6 = new item(); itemValue6.setObject(7); itemValue6.setProfit(6); itemValue6.setWeight(3);
        item itemValue7 = new item(); itemValue7.setObject(5); itemValue7.setProfit(9); itemValue7.setWeight(9);

        itemValues.add(itemValue1);
        itemValues.add(itemValue2);
        itemValues.add(itemValue3);
        itemValues.add(itemValue4);
        itemValues.add(itemValue5);
        itemValues.add(itemValue6);
        itemValues.add(itemValue7);

        Collections.sort(itemValues, new FNPComparator());

        int capacity = 15;
        double maxValue = getMaxValue(itemValues, capacity);
        System.out.println("Maximum profit achievable: " + maxValue);
    }
}
