import java.util.*;
import java.io.*;

public class Main{
    
    static char[][] map;
    static int n;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for(int i=0;i<n;i++){
            map[i]=br.readLine().toCharArray();
        }
        
        int count = 0;
        
        int[][] dir = {
            {-1,0},
            {0,1},
            {1,0},
            {0,-1}
        };
        PriorityQueue<Integer> sizes = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j]=='1'){
                    count++;
                    // do bfs
                    Queue<Pos> que = new ArrayDeque<>();
                    map[i][j]='0';
                    que.add(new Pos(j,i));
                    int size =1;
                    while(!que.isEmpty()){
                        Pos p = que.poll();
                        for(int d=0;d<4;d++){
                            int nx = p.x+dir[d][1];
                            int ny = p.y+dir[d][0];
                            if(nx>-1 && nx<n && ny>-1 && ny<n && map[ny][nx]=='1'){
                                size++;
                                map[ny][nx]='0';
                                que.add(new Pos(nx,ny));
                            }
                        }
                    }
                    sizes.add(size);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n");
        while(!sizes.isEmpty()){
            sb.append(sizes.poll()).append("\n");
        }
        System.out.println(sb.toString());
    }
    static class Pos{
        int x;
        int y;
        Pos(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}