import java.util.HashMap;
import java.util.Map;

public class GreedKata {
    private static int NUM_DICE = 5; //number of dice for a game of Greed Kata
    private static int DICE_SIDES = 6; //number of sides of dice used for the game

    /**
     * Returns the best (highest) possible score given the dice roll
     * based on the rules of Greed Kata.
     * 
     * @param roll an array of the 5 dice-roll results
     * @return an integer that represents the best score given the dice roll
     * @throws IllegalArgumentException if roll is null or not of NUM_DICE length
     */
    public static int bestScore(int[] roll) {
        if (roll == null) {
            throw new IllegalArgumentException("'roll' cannot be null.");
        }
        if (roll.length != NUM_DICE) {
            throw new IllegalArgumentException("'roll' must be of length " + NUM_DICE + ".");
        }
        int best = 0;
        Map<Integer, Integer> counts = arrayToMap(roll);
        if (counts.containsKey(1)) {
            if (counts.get(1) >= 3) {
                best += 1000 + (100 * (counts.get(1) - 3)); //1000 for triple 1s plus 100 for each of the remaining 1s
                return best + (counts.get(5) * 50); //Can return here because only other points come from 5s
            }
            best += counts.get(1) * 100;
        } 
        for (int i = 2; i <= DICE_SIDES; i++) {
            if (counts.containsKey(i)) {
                if (i == 5) {
                    best += (counts.get(5) % 3) * 50;
                }
                if (counts.get(i) >= 3) {
                    best += i * 100;
                }
            }
        }
        return best;
    }

    /**
     * Returns a map of integers and their respective counts in the input array.
     * 
     * @param array an input array of ints to be transformmed into a Hash Map
     * @return a Hash Map of counts of integers from the input array
     * @throws IllegalArgumentException if any array element is not a valid dice value 
     */
    private static Map<Integer, Integer> arrayToMap(int[] array) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            if (num < 1 || num > DICE_SIDES) {
                throw new IllegalArgumentException("Dice roll values must be between 1 and " + DICE_SIDES + " inclusive.");
            }
            if (result.containsKey(num)) {
                result.put(num, result.get(num) + 1);
            } else {
                result.put(num, 1);
            }
        }
        return result;
    }
}