import java.util.stream.*;

class Solution {
    public int solution(int[] num_list) {
        String evenNumbers = IntStream.range(0, num_list.length)
            .filter(i -> num_list[i] % 2 == 0)
            .mapToObj(i -> String.valueOf(num_list[i]))
            .collect(Collectors.joining());

        String oddNumbers = IntStream.range(0, num_list.length)
            .filter(i -> num_list[i] % 2 != 0)
            .mapToObj(i -> String.valueOf(num_list[i]))
            .collect(Collectors.joining());

        int evenSum = evenNumbers.isEmpty() ? 0 : Integer.parseInt(evenNumbers);
        int oddSum = oddNumbers.isEmpty() ? 0 : Integer.parseInt(oddNumbers);

        return evenSum + oddSum;
    }
}