package bero;

import bero.person.London;

public class Application {
    public static void main(String[] args) {
//        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
//        Main main = new Main(intList);
//        main.main();
//
//        StreamMain streamMain = new StreamMain(intList);
//        streamMain.main();

        London london = new London();
        System.out.println(london.countYounger18());
        london.filterRabotospasobnye();
        london.getPrizyvnikovSurnames();
    }
}