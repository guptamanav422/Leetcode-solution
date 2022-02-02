// { Driver Code Starts
import java.util.*;

class Maxsum_Among_All_Rotations_Array
{
	public  static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
			
			System.out.println(new GfG().max_sum(arr,n));
			
		t--;
		}
	}
	
}
// } Driver Code Ends


class GfG
{
    int max_sum(int A[], int n)
    {
        int sum=0,mod=1000000007;
        long ans=0;
        for(int i=0;i<n;i++){
            sum+=A[i];
            ans+=A[i]*i;
        }
        ans%=mod;
        long temp=ans;
        for(int i=n-1;i>0;i--){
            long temp1=(temp+sum-n*(A[i]))%mod;
            
            ans=Math.max(ans,temp1);
            temp=temp1;
        }
        return (int)ans;
    }	
}
