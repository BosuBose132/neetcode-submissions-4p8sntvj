class Node{
    Node next;
    Node prev;
    int key, value;
    public Node(int key, int value){
        this.key=key;
        this.value=value;
    }//we created a Node
}
class LRUCache{
    Node head;
    Node tail;
    int cap;
    HashMap<Integer,Node> cache;

    public LRUCache(int capacity){
        this.cap=capacity;
        this.head= new Node(0,0);
        this.tail= new Node(0,0);
        head.next=tail;
        tail.prev=head;
        this.cache= new HashMap<>();
    }
    public void remove(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    public void insert(Node node){
        node.prev=tail.prev;
        node.next=tail;

        node.prev.next=node;
        tail.prev=node;
    }
    public int get(int key){
        if(cache.containsKey(key)){
            Node node= cache.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }
    public void put(int key, int value){
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);

        if (cache.size() > cap) {
            Node lru = this.head.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}
