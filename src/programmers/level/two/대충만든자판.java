package programmers.level.two;

public class 대충만든자판 {
    public int[] solution(String[] keymap, String[] targets) {

        int[] posArr = new int[26];

        for(String s : keymap){
            for(int i=1;i<=s.length();i++){
                int c = s.charAt(i-1)-'A';
                if(posArr[c]==0 || posArr[c]>i){
                    posArr[c]=i;
                }
            }
        }
        int[] answer = new int[targets.length];
        SEARCH:for(int i=0;i<targets.length;i++){
            String next = targets[i];
            int sum=0;
            for(char c : next.toCharArray()){
                int pos = c-'A';
                if(posArr[pos]==0){
                    answer[i]=-1;
                    continue SEARCH;
                }
                sum+=posArr[pos];
            }
            answer[i]=sum;
        }

        return answer;
    }
}
