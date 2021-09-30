import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Leonardo Framba
 */
public class IceCreams {
    public static void main(String[] args) {
        //test your code here
        int[] costs = {10, 6, 8, 7, 7, 8};
        IceCreams iceCreams = new IceCreams();
        iceCreams.maxIceCreams(costs, 6);
    }

    /**
     * find the maximum ice cream bars you can buy
     *
     * @param costs   array of costs of all ice cream bars, unsorted
     * @param dollars the total amount of dollars you can use to buy the ice cream
     *                return how many ice cream can buy with the money
     */
    public void maxIceCreams(int[] costs, int dollars) {
        ArrayList<Integer> costList = Arrays.stream(costs).boxed().collect(Collectors.toCollection(ArrayList::new));
        System.out.println(costList.toString());
        split(costList);
        System.out.println(costList.toString());
        int currentCost = 0;
        int barCount = 0;
        for (int i = 0; currentCost < dollars && i < costList.size(); i++) {
            currentCost = currentCost + costList.get(i);
            if (currentCost <= dollars) barCount++;
        }
        System.out.println(barCount);

    }

    //Merge Sort
    public void split(ArrayList<Integer> list) {
        if (list.size() > 1) {
            ArrayList<Integer> firstHalf = new ArrayList<>(list.subList(0, list.size() / 2));
            split(firstHalf);

            ArrayList<Integer> secondHalf = new ArrayList<>(list.subList(list.size() / 2,
                    list.size()));
            split(secondHalf);

            merge(firstHalf, secondHalf, list);
        }
    }

    private void merge(ArrayList<Integer> firstHalf, ArrayList<Integer> secondHalf,
                       ArrayList<Integer> list) {
        int listIndex = 0;
        int indexFirstHalf = 0;
        int indexSecondHalf = 0;

        while (indexFirstHalf < firstHalf.size() && indexSecondHalf < secondHalf.size()) {
            if (firstHalf.get(indexFirstHalf) < secondHalf.get(indexSecondHalf)) {
                list.set(listIndex++, firstHalf.get(indexFirstHalf++));
            } else list.set(listIndex++, secondHalf.get(indexSecondHalf++));
        }

        while (indexFirstHalf < firstHalf.size()) {
            list.set(listIndex++, firstHalf.get(indexFirstHalf++));
        }

        while (indexSecondHalf < secondHalf.size()) {
            list.set(listIndex++, secondHalf.get(indexSecondHalf++));
        }
    }
}
