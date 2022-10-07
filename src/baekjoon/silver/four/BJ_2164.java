package baekjoon.silver.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_2164 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    Queue<Integer> cardQueue = new LinkedList<Integer>();
    for(int i=1;i<=n;i++){
      cardQueue.add(i);
    }
    while(cardQueue.size()>1){
      cardQueue.remove();
      cardQueue.add(cardQueue.remove());
    }
    System.out.println(cardQueue.remove());
  }
}
