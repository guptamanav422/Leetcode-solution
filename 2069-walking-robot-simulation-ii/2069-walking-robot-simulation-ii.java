class Robot {
    
    int arr[][];
    int x=0,y=0,h=0,w=0;
    String dir="East";
    public Robot(int width, int height) {
        arr=new int[height][width];
        h=height;
        w=width;
        // System.out.println(width+" "+height);
    }
    
    public void step(int num) {
        
        long temp=(h-1)*2 +(w-1)*2;
        num=(int)((long)num%(temp));
        if (x == 0 && y == 0){
            dir="South";
        }
        while(num-->0){
            if(dir.equals("East")){
                if(y==w-1){
                    x++;
                    dir="North";
                }
                else y++;
            }
            else if(dir.equals("North")){
                if(x==h-1){
                    y--;
                    dir="West";
                }
                else x++;
            }
            else if(dir.equals("West")){
                if(y==0){
                    x--;
                    dir="South";
                }
                else y--;
            }
            else if(dir.equals("South")){
                if(x==0){
                    y++;
                    dir="East";
                }
                else x--;
            }
        }
        
    }
    
    public int[] getPos() {
        return new int[]{y,x};
    }
    
    public String getDir() {
        return dir;
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */