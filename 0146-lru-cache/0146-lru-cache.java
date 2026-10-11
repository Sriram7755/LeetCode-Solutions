class LRUCache {

    class Node{
        Node prev;
        int key;
        int value;
        Node next;

        Node(int key ,int value)
        {
            this.key = key;
            this.value = value;
        }

    }
    private final HashMap<Integer,Node> map = new HashMap<>();
    private final int capacity;
    private final Node head = new Node(-1,-1);
    private final Node tail = new Node(-1,-1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public void remove(Node node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addtoTail(Node node)
    {
        node.prev = tail.prev;
        node.next = tail;

        tail.prev.next = node;
        tail.prev = node;
    }
    
    public int get(int key) {
        
        if(!map.containsKey(key))return -1;

        Node node = map.get(key);
        remove(node);
        addtoTail(node);
        return node.value;

    }
    
    public void put(int key, int value) {

        if(capacity == 0)return;

        if(map.containsKey(key))
        {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            addtoTail(node);
            return;
        }

        if(capacity == map.size())
        {
            Node lru = head.next;
            remove(lru);
            map.remove(lru.key);
        }
        Node node = new Node(key,value);
        addtoTail(node);
        map.put(key,node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */