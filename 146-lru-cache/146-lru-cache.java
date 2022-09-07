class LRUCache {

    class Node{
        Node prev,next;
        int data;
        int key;
    }
    Node head,tail;
    Map<Integer,Node> map;
    int c;
    int count;
    public LRUCache(int capacity) {
        map=new HashMap<>();
        c=capacity;
        count=0;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node n=map.get(key);
        if(tail==n){
            return n.data;
        }
        else if(n==head){
            head=head.next;
            head.prev=null;
        }
        else{
            Node pre=n.prev;
            Node nex=n.next;
            pre.next=nex;
            nex.prev=pre;
        }
        n.next=null;
        tail.next=n;
        n.prev=tail;
        tail=n;
        return n.data;
    }
    
    public void put(int key, int value)
    {
        if(map.containsKey(key)){
            get(key);
            tail.data=value;
        }
        else if(count<c){
            Node n=new Node();
            n.data=value;
            n.key=key;
            if(head==null){
                head=tail=n;
            }
            else{
                tail.next=n;
                n.prev=tail;
                tail=n;
            }
            map.put(key,n);
            count++;
        }
        else{
            map.remove(head.key);
            if(head==tail){
                head=tail=null;
            }
            else{
                head=head.next;
                head.prev=null;
            }
            count--;
            put(key,value);
        }
        // if(key==4){
        //         System.out.println(head.data+" "+head.key);
        //     }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */