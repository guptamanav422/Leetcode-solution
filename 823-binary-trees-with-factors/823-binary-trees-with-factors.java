class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        
        int tot=1,n=arr.length;
        long mod=1000000007;
        int ans[]=new int[n];
        ans[0]=1;
        
        Map<Integer,Integer> map=new HashMap<>();
        map.put(arr[0],1);
        for(int i=1;i<n;i++){
            int temp=1;
            for(int j=0;j<i;j++){
                if(map.containsKey(arr[i]/arr[j]) && (arr[i]%arr[j])==0){
                    temp=(int)(((long)temp+(long)ans[j]*(long)map.get(arr[i]/arr[j]))%mod);
                }
            }
            // System.out.println(temp);
            ans[i]=temp;
            map.put(arr[i],temp);
            tot=(tot+temp)%(int)mod;
        }
        return tot;
    }
}