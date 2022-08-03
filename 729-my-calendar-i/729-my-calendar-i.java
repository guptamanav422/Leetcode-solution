class MyCalendar {

    TreeMap<Integer,Integer> map;
    public MyCalendar() {
        map=new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        if(map.containsKey(start)) return false;
        
        if(map.lowerKey(start)!=null && map.get(map.lowerKey(start))>start) return false;
        if(map.higherKey(start)!=null && map.higherKey(start)<end) return false;
        
        map.put(start,end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */