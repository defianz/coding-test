import java.util.List;

public class festival {

    public static void main(String[] args) {
        Double solution1 = solution(6, 3, new Integer[]{1, 2, 3, 1, 2, 3});
        System.out.println("solution1 = " + solution1);

        Double solution2 = solution(6, 2, new Integer[]{1, 2, 3, 1, 2, 3});
        System.out.println("solution2 = " + solution2);
    }

    public static Double solution(int n, int l, Integer[] fare) {
        List<Integer> fareList = List.of(fare);
        double answer = Integer.MAX_VALUE;

        for (int startIdx = 0; startIdx < n; startIdx++) {
            for (int endIdx = n - 1; endIdx > startIdx; endIdx--) {
                if (endIdx - startIdx < l) break;
                List<Integer> subList = fareList.subList(startIdx, endIdx);
                double totalSum = subList
                        .stream()
                        .reduce(Integer::sum)
                        .get();
                double totalDay = subList.size();
                answer = Math.min(answer, (totalSum / totalDay));
            }
        }
        return answer;
    }
}