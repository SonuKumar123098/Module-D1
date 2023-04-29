//https://course.acciojob.com/idle?question=07b30403-d04c-42f7-b610-8d5d3cac4b15
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	private static int gcd(int a,int b){
		if(b==0)return a;
		return gcd(b,a%b);
	}
    public static int cpFact(int A, int B) {
        // your code here
		while(gcd(A,B)!=1){
			A/=gcd(A,B);
		}
		return A;
    }
  public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
	    int A = sc.nextInt();
        int B = sc.nextInt();
        System.out.print(cpFact(A, B));
	}
}
