//https://course.acciojob.com/idle?question=4f933ef9-bfa1-4337-8c11-98c928b4dd05
#include <bits/stdc++.h>
using namespace std;

int findMinXor(int arr[], int n)
{
  // write code here
	sort(arr,arr+n);
	int ans=INT_MAX;
	for(int i=0;i<n-1;i++){
		if((arr[i]^arr[i+1])<ans) ans=arr[i]^arr[i+1];
	}
	return ans;
}

int main() {
    int n;
    cin>>n;
    int arr[n];
    for(int i=0; i<n; i++)
    {
      cin>>arr[i];
    }
    cout<<findMinXor(arr, n);
}
