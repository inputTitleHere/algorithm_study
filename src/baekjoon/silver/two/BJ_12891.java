package baekjoon.silver.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_12891 {
  // 실제 각 뉴클레오타이드의 개수를 파악
  private static int A=0;
  private static int C=0;
  private static int G=0;
  private static int T=0;
  private static int COUNT=0;
  private static int ORI_LENGTH=0;
  private static int PWD_LENGTH=0;
  private static int[] OBJ_ACGT=new int[4];
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stk = new StringTokenizer(br.readLine());
    ORI_LENGTH = Integer.parseInt(stk.nextToken());
    PWD_LENGTH = Integer.parseInt(stk.nextToken());

    char[] dnaSeq = br.readLine().toCharArray();

    stk=new StringTokenizer(br.readLine());
    for(int i=0;i<4;i++){
      OBJ_ACGT[i]=Integer.parseInt(stk.nextToken());
    }

    for(int i=0;i<PWD_LENGTH;i++){
      addACGT(dnaSeq[i]);
    }
    checkPwd();

    for(int i=PWD_LENGTH;i<ORI_LENGTH;i++){
      addACGT(dnaSeq[i]);
      removeACGT(dnaSeq[i-PWD_LENGTH]);
      checkPwd();
    }
    System.out.println(COUNT);
  }  
  public static void addACGT(char c){
    switch(c){
      case 'A':A++;break;
      case 'C':C++;break;
      case 'G':G++;break;
      case 'T':T++;break;
    }
  }
  public static void removeACGT(char c){
    switch(c){
      case 'A':A--;break;
      case 'C':C--;break;
      case 'G':G--;break;
      case 'T':T--;break;
    }
  }
  public static void checkPwd(){
    if(A>=OBJ_ACGT[0]&&C>=OBJ_ACGT[1]&&G>=OBJ_ACGT[2]&&T>=OBJ_ACGT[3]){
      COUNT++;
    }
  }
}
