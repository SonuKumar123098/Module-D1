// https://www.hackerrank.com/challenges/bomber-man/problem
// https://course.acciojob.com/idle?question=1b1fdc6c-da28-41f0-9c2e-7360810c490d
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'bomberMan' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY grid
     */

    public static List<String> bomberMan(int n, List<String> grid) {
    // Write your code here
        if(n>4){
            n=n%4;
            n+=4;
        }
        if(n==1)return grid;
        Queue<List<String>>q=new LinkedList<>();
        q.add(grid);
        int row=grid.size();
        int col=grid.get(0).length();
        for(int i=2;i<=n;i++){
            List<String>instance=new ArrayList<>();
            
            List<String>current=new ArrayList<>();
            if(q.size()>=2) current=q.remove();
            if(i%2==0){
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<col;j++){
                    sb.append('O');
                }
                for(int j=0;j<row;j++){
                    instance.add(sb.toString());
                }
                q.add(instance);
               if(n%2==0)return instance; 
            }else{
                
                int dirn[][]=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
                for(int r=0;r<row;r++){
                    StringBuilder sb=new StringBuilder();
                    for(int c=0;c<col;c++){
                        boolean flag=false;
                        if(current.get(r).charAt(c)=='O'){
                            flag=true;
                        }else{
                            for(int j=0;j<4;j++){
                                int x=dirn[j][0]+r;
                                int y=dirn[j][1]+c;
                                if(x>=0 && x<row && y>=0 && y<col){
                                    if(current.get(x).charAt(y)=='O'){
                                        flag=true;
                                        break;
                                    }
                                }
                            }
                            
                        }
                        if(flag){
                                sb.append('.');
                            }else sb.append('O');
                    }
                    instance.add(sb.toString());
                }
                System.out.println(instance);
                q.add(instance);
            }
        }
        while(q.size()>1){
            q.remove();
        }
        return q.remove();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r = Integer.parseInt(firstMultipleInput[0]);

        int c = Integer.parseInt(firstMultipleInput[1]);

        int n = Integer.parseInt(firstMultipleInput[2]);

        List<String> grid = IntStream.range(0, r).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<String> result = Result.bomberMan(n, grid);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
