public class GreedKataTest {
    
    public static void main(String args[]) {
        if (testBestScoreExample1()) {
            System.out.println("Passed test 'testBestScoreExample1'");
        } else {
            System.out.println("Failed test 'testBestScoreExample1'");
        }

        if (testBestScoreExample2()) {
            System.out.println("Passed test 'testBestScoreExample2'");
        } else {
            System.out.println("Failed test 'testBestScoreExample2'");
        }

        if (testBestScoreExample3()) {
            System.out.println("Passed test 'testBestScoreExample3'");
        } else {
            System.out.println("Failed test 'testBestScoreExample3'");
        }

        if (testBestScoreExample4()) {
            System.out.println("Passed test 'testBestScoreExample4'");
        } else {
            System.out.println("Failed test 'testBestScoreExample4'");
        }

        if (testBestScoreExample5()) {
            System.out.println("Passed test 'testBestScoreExample5'");
        } else {
            System.out.println("Failed test 'testBestScoreExample5'");
        }

        if (testBestScoreDifferentOrder()) {
            System.out.println("Passed test 'testBestScoreDifferentOrder'");
        } else {
            System.out.println("Failed test 'testBestScoreDifferentOrder'");
        }
    }

    //Tests bestScore method on example 1 from spec
    public static boolean testBestScoreExample1() {
        int[] rolls = new int[]{1, 1, 1, 5, 1};
        int score = GreedKata.bestScore(rolls);
        return score == 1150;
    }

    //Tests bestScore method on example 2 from spec
    public static boolean testBestScoreExample2() {
        int[] rolls = new int[]{2, 3, 4, 6, 2};
        int score = GreedKata.bestScore(rolls);
        return score == 0;
    }

    //Tests bestScore method on example 3 from spec
    public static boolean testBestScoreExample3() {
        int[] rolls = new int[]{3, 4, 5, 3, 3};
        int score = GreedKata.bestScore(rolls);
        return score == 350;
    }

    //Tests bestScore method on example 4 from spec
    public static boolean testBestScoreExample4() {
        int[] rolls = new int[]{1, 5, 1, 2, 4};
        int score = GreedKata.bestScore(rolls);
        return score == 250;
    }

    //Tests bestScore method on example 5 from spec
    public static boolean testBestScoreExample5() {
        int[] rolls = new int[]{5, 5, 5, 5, 5};
        int score = GreedKata.bestScore(rolls);
        return score == 600;
    }

    //Tests bestScore method on the same set of dice with different orderings
    public static boolean testBestScoreDifferentOrder() {
        int[] roll1 = new int[]{1, 1, 1, 5, 4};
        int[] roll2 = new int[]{4, 1, 5, 1, 1};
        return GreedKata.bestScore(roll1) == GreedKata.bestScore(roll2);
    }

    
}
