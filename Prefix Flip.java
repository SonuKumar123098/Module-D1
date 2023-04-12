//https://course.acciojob.com/idle?question=30864598-6a6b-4ec9-afae-a30ab4a78e0e
//accepted on codforces but not on acciojob
class Solution{
static void solve(String a,String b,int n)
{
// your code here
    char[]a1=a.toCharArray();
    char b1[]=b.toCharArray();
    ArrayList<Integer>operation=new ArrayList<>();
    int flip=0;
    int start=0; int end=n-1;
    for(int i=n-1;i>=0;i--){
       if(flip%2==0){
          if(b1[i]==a1[end]) end--;
          else{
             if(b1[i]==a1[start])
                 operation.add(1);
             operation.add(i+1);
             flip++;
             int temp=end;
             end=start+1;
             start=temp;
         }
      }else{
         if(b1[i]!=a1[end]) end++;
         else{
             if(b1[i]!=a1[start])
                 operation.add(1);
             operation.add(i+1);
             flip++;
             int temp=end;
             end=start-1;
             start=temp;
        }
      }
    }
    System.out.print(operation.size()+" ");
    for(int k:operation){
        System.out.print(k+" ");
    }
    System.out.println();
  }
}
//brute force approach
class Solution{
    static void reverse(char[]a1, int ind){
		int i=0;
		while(i<=ind){
			char left=a1[i]=='0'?'1':'0';
			char right=a1[ind]=='0'?'1':'0';
			a1[i]=right;
			a1[ind]=left;
			i++;
			ind--;
		}
	}
    static void solve(String a,String b,int n)
    {
        // your code here
		char[]a1=a.toCharArray();
		char b1[]=b.toCharArray();
		ArrayList<Integer>ans=new ArrayList<>();
		int i=n-1;
		while(i>=0){
			if(a1[i]==b1[i]) i--;
			else{
				if(a1[0]==b1[i]){
					a1[0]=a1[0]=='1'?'0':'1';
					ans.add(1);
				}
				reverse(a1,i);
				ans.add(i+1);
			}
		}
		System.out.print(ans.size()+" ");
		for(int k:ans){
			System.out.print(k+" ");
		}
		System.out.println();
    }
}
//optimal approach
// static void solve(String a,String b,int n)
 //    {
 //        char[] first = a.toCharArray();
 //        char[] second = b.toCharArray();

        
 //        char[] rand = first;
 //        first = second;
 //        second = rand;

 //        int cindex = n - 1;
 //        int st = 0;
 //        int end = n-1;

 //        ArrayList<Integer> operation = new ArrayList<>();
 //        int bit = 0;
 //        while(cindex >= 0){
            
 //            if(bit%2 == 0){
 //                if(second[st] == first[cindex]){
 //                    operation.add(1);
 //                }
 //            }else{
 //                if(second[st] != first[cindex]){
 //                    operation.add(1);
 //                }
 //            }
            

 //            operation.add(cindex + 1);
            
 //            if(bit%2 == 0){
 //                int temp = st;
 //                st = end;
 //                end = temp + 1;
 //            }else{
 //                int temp = st;
 //                st = end;
 //                end = temp - 1;
 //            }

 //            bit++;
 //            cindex--;
 //        }

        
 //        System.out.print(operation.size() + " ");
 //        for(int i : operation){
 //            System.out.print(i + " ");
 //        }
 //        System.out.println();

 //    }
