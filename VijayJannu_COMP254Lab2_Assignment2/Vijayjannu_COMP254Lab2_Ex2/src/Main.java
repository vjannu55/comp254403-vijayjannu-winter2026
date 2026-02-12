public class Main {
    public static void main(String[] args) {

        int startN = 500;   // starting size
        int trials = 10;    // how many times to double n

        // Run Exercise 2 experiment
        PrefixAverageExperiment.runExperiment(startN, trials);
    }
}
