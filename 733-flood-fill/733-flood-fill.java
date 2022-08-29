class Solution {
    int dir[][]={{-1,0},{1,0},{0,1},{0,-1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        if(image[sr][sc]==newColor) return image;
        find(image,sr,sc,newColor,image[sr][sc]);
        return image;
    }
    void find(int arr[][],int sr,int sc,int newColor,int color){
        if(sr==arr.length || sc==arr[0].length || sr<0 || sc<0 || arr[sr][sc]!=color) return;
        
        arr[sr][sc]=newColor;
        for(int i=0;i<4;i++){
            find(arr,sr+dir[i][0],sc+dir[i][1],newColor,color);
        }
    }
}