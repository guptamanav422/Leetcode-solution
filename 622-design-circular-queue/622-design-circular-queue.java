class MyCircularQueue {
    
    int arr[],f=0,s=0;
    public MyCircularQueue(int k) {
        arr=new int[k];
        Arrays.fill(arr,-1);
    }
    
    public boolean enQueue(int value) {
        if(arr[s]!=-1) return false;
        
        arr[s++]=value;
        s%=arr.length;
        return true;
    }
    
    public boolean deQueue() {
        if(arr[f]==-1) return false;
        
        arr[f++]=-1;
        f%=arr.length;
        return true;
    }
    
    public int Front() {
        return arr[f];
    }
    
    public int Rear() {
        return arr[(s-1+arr.length)%arr.length];
    }
    
    public boolean isEmpty() {
        return arr[f]==-1;
    }
    
    public boolean isFull() {
        return s==f && arr[s]!=-1;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */