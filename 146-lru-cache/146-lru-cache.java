class LRUCache {

    class Node{
        int key,val;
        Node next,prev;
        Node(int a,int b){
            key=a;
            val=b;
        }
    }
    Map<Integer,Node> map=new HashMap<>();
    int cap=0,count=0;
    Node head=null,tail=null;
    public LRUCache(int capacity) {
        cap=capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        
        Node node=map.get(key);
        if(node!=head){
            node.prev.next=node.next;
            if(node.next!=null) node.next.prev=node.prev;
            else tail=node.prev;
            node.next=head;
            head.prev=node;
            node.prev=null;
            head=node;
        }
        return node.val;
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key)){
            map.get(key).val=value;
            get(key);
        }
        else{
            Node temp=new Node(key,value);
            if(head==null){
                head=tail=temp;
            }
            else{
                temp.next=head;
                head.prev=temp;
                head=temp;
            }
            if(count==cap){
                
                map.remove(tail.key);
                tail=tail.prev;
                tail.next=null;
            }
            else count++;
            
            map.put(key,temp);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */