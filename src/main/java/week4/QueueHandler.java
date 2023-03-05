package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QueueHandler {
    public static void main(String[] args) throws IOException {
        Queue q = new Queue();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int operations = Integer.parseInt(in.readLine());
        for (int i = 0; i < operations; i++) {
            String nextOpp = in.readLine();
            String[] split = nextOpp.split(" ");
            switch(split[0].trim()){
                case("E") -> q.enqueue(Integer.parseInt(split[1]));
                case("D") -> q.deque();
            }
        }

    }
}
class Queue {

    ListNode sentinel = new ListNode();
    ListNode end = sentinel;

    public void enqueue(int parseInt) {
        if(sentinel.next==null){
            end = sentinel;
            end.next = new ListNode(parseInt);
            end = end.next;
        }
        else{
            ListNode newEnd = new ListNode(parseInt);
            end.next = newEnd;
            end = newEnd;
        }
    }

    public void deque() {
        System.out.println(sentinel.next.val);
        sentinel.next = sentinel.next.next;
    }
}
class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}