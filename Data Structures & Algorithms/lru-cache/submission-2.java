class Node{
    Node prev, next;
    int key, value;
    private Node(int key, int value){
        this.key=key;
        this.value=value;
    }
}

class LRUCache{
    Node head, tail;
    int cap;
    Map<Integer,Node> cache;
    private LRUCache(int capacity){
        this.cap=capacity;
        this.cache= new HashMap<>();
        this.head= new Node(0,0);
        this.tail= new Node(0,0);
        head.next=tail;
        tail.prev=head;
    }
    private void remove(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    private void insertAtFront(Node node){
        node.next = head.next;
    node.prev = head;

    head.next.prev = node;
    head.next = node;
    }
    private int get(int key){
        if(cache.containsKey(key)){
            Node node= cache.get(key);
            remove(node);
            insertAtFront(node);
            return node.value;
        }
        return -1;
    }
    private void put(int key, int value){
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }//removes the node
        Node newNode= new Node(key,value);
        insertAtFront(newNode);
        cache.put(key,newNode);
        if(cache.size()>cap){
            Node lru= tail.prev;
            remove(lru);
            cache.remove(lru.key);
        }
    }
    
}
