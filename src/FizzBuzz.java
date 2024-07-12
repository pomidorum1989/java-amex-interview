import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    //https://leetcode.com/problems/fizz-buzz/description/
    public static List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean isThree = i % 3 == 0;
            boolean isFive = i % 5 == 0;
            boolean isThreeFive = isThree && isFive;

            if (isThreeFive) {
                answer.add("FizzBuzz");
            } else if (isThree) {
                answer.add("Fizz");
            } else if (isFive) {
                answer.add("Buzz");
            } else {
                answer.add(String.valueOf(i));
            }
        }
        System.out.println(answer);
        return answer;
    }

    public static List<String> fizzBuzz1(int n) {
        List<String> answer = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean isThree = i % 3 == 0;
            boolean isFive = i % 5 == 0;

            switch ((isThree ? 1 : 0) + (isFive ? 2 : 0)) {
                case 3:
                    answer.add("FizzBuzz");
                    break;
                case 1:
                    answer.add("Fizz");
                    break;
                case 2:
                    answer.add("Buzz");
                    break;
                default:
                    answer.add(String.valueOf(i));
            }
        }
        System.out.println(answer);
        return answer;
    }
}
