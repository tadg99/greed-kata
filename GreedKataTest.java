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

    }

    public static boolean testBestScoreExample1() {
        int[] rolls = new int[]{1, 1, 1, 5, 1};
        int score = GreedKata.bestScore(rolls);
        return score == 1150;
    }

    public static boolean testBestScoreExample2() {
        int[] rolls = new int[]{2, 3, 4, 6, 2};
        int score = GreedKata.bestScore(rolls);
        return score == 0;
    }

    public static boolean testBestScoreExample3() {
        int[] rolls = new int[]{3, 4, 5, 3, 3};
        int score = GreedKata.bestScore(rolls);
        return score == 350;
    }

    public static boolean testBestScoreExample4() {
        int[] rolls = new int[]{1, 5, 1, 2, 4};
        int score = GreedKata.bestScore(rolls);
        return score == 250;
    }

    public static boolean testBestScoreExample5() {
        int[] rolls = new int[]{5, 5, 5, 5, 5};
        int score = GreedKata.bestScore(rolls);
        return score == 600;
    }


    
}
