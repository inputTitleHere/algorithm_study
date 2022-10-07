package programmers.coding.practice;

public class 평균구하기 {
    public double solution(int[] arr) {
        int sum=0;
        for(int i : arr){
            sum+=i;
        }
        double answer = (double)sum/arr.length;
        return answer;
    }
}
