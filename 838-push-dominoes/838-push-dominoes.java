class Solution {
    public String pushDominoes(String str) {
        
        int n=str.length();
        int left[]=new int[n],right[]=new int[n];
        int prev1=-1,prev2=-1;
        for(int i=0;i<n;i++){
            int j=n-1-i;
            
            if(str.charAt(i)=='L') prev1=-1;
            if(str.charAt(j)=='R') prev2=-1;
            
            if(str.charAt(i)=='R') prev1=i;
            if(str.charAt(j)=='L') prev2=j;
            left[i]=prev1;
            right[j]=prev2;
        }
        // for(int a:left){
        //     System.out.print(a+" ");
        // }
        // System.out.println();
        // for(int a:right){
        //     System.out.print(a+" ");
        // }
        // System.out.println();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<n;i++){
            
            if(str.charAt(i)!='.' || (left[i]==-1 && right[i]==-1)){
                sb.append(str.charAt(i));
            }
            else if(left[i]==-1 || right[i]==-1){
                sb.append(left[i]==-1?"L":"R");
            }
            else{
                
                int diff1=i-left[i],diff2=right[i]-i;
                if(diff1==diff2){
                    sb.append(".");
                }
                else sb.append(diff1<diff2?"R":"L");
            }
        }
        return sb.toString();
        
    }
}