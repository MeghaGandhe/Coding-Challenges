package dsProblems;

import java.util.*;

public class LRUCache {

    private int capacity;
    private int currentCapacity;
    private ListNode<String> root;
    private ListNode<String> end;
    private Map<String,ListNode<String>> cacheMap = new HashMap<>();
    

    public LRUCache(int capacity) {
        // your code goes here
    	this.capacity = capacity;
        this.root = null;
        this.end = null;
        this.currentCapacity = 0;
    }

    //@SuppressWarnings("unchecked")
	public String get(String key) {
        // your code goes here
        ListNode<String> node;
        if(cacheMap.containsKey(key)){
            node = cacheMap.get(key);
            if(node.prev != null) {
            	node.prev.next = node.next;
	            node.prev = null;
	            node.next = root;
	            root.prev = node;
	            root = node;
            }
            return node.getValue();
        }
        return null;  
    }

    public void set(String key, String value) {
        // your code goes here
        ListNode<String> node = new ListNode<>(key,value);
        if(end == null){
            end = node;
            root = node;
        } else{
            if(currentCapacity == capacity){
            	cacheMap.remove(end.key);
                end = end.prev;
                currentCapacity--;
            }
            node.next = root;
            node.prev = null;
            root.prev = node;
            root = node;
        }
        currentCapacity++;
        cacheMap.put(key,end);
    }

    static class ListNode<T>{
        private T key;
        private T value;
        ListNode<T> next;
        ListNode<T> prev;
        public ListNode(){

        }
        public ListNode(T key,T value){
            this.key = key;
            this.value = value;
        }
        public T getValue(){
            return this.value;
        }
    }
    
    public static void main(String[] args) {
        // debug your code below
        LRUCache cache = new LRUCache(2);
        cache.set("user1", "Alex");
        System.out.println(cache.get("user1"));
    }
}