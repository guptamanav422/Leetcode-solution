class Solution {
    public int snakesAndLadders(int[][] board) {
        
        Queue<Integer> q=new LinkedList<>();
        
        q.add(1);
        int n=board.length,step=0;
        
        boolean visit[]=new boolean[n*n+1];
        while(!q.isEmpty()){
            
            int size=q.size();
            while(size-->0){
                
                int num=q.remove();
                if(visit[num]) continue;
                visit[num]=true;
                if(num==n*n) return step;
                
                for(int k=1;k<=6 && (num+k)<=n*n;k++){
                    
                    int num1=num+k;
                    int i=(num1-1)/n, j=(i%2==0)?(num1-1)%n:(n-(num1-n*i));
                    i=n-i-1;
                    
                    if(board[i][j]!=-1) num1=board[i][j];
                    
                    if(!visit[num1]) q.add(num1);
                    
                }
                // System.out.print(num+" ");
            }
            // System.out.println();
            step++;
        }
        return -1;
    }
}

// class Solution{
//     public int snakesAndLadders(int[][] board) {
//         int n = board.length;
//         Queue<Integer> queue = new LinkedList<>();
//         queue.offer(1);
//         boolean[] visited = new boolean[n * n + 1];
//         for (int move = 0; !queue.isEmpty(); move++) {
//             for (int size = queue.size(); size > 0; size--) {
//                 int num = queue.poll();
//                 if (visited[num]) continue;
//                 visited[num] = true;
//                 if (num == n * n) return move;
//                 for (int i = 1; i <= 6 && num + i <= n * n; i++) {
//                     int next = num + i;
//                     int value = getBoardValue(board, next);
//                     if (value > 0) next = value;
//                     if (!visited[next]) queue.offer(next);
//                 }
//             }
//         }
//         return -1;
//     }

//     private int getBoardValue(int[][] board, int num) {
//         int n = board.length;
//         int oldRow = (num - 1) / n;
//         int row = n-1 -oldRow;
//         int oldCol = (num-1) % n;
//         int col = oldRow % 2 == 0 ? oldCol : n - 1 - oldCol;
        
//         return board[row][col];
//     }
// }