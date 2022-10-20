class Solution
{
    public String intToRoman(int num)
    {
        StringBuffer sb=new StringBuffer();
        String arr1[]=new String[]
            {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int arr2[]=new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        int i=0;
        while(num>0)
        {
            while(num>=arr2[i])
            {
                num-=arr2[i];
                sb.append(arr1[i]);
            }
            i++;
        }
        return sb.toString();
    }
}