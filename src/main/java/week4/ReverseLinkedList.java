package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public  class  ReverseLinkedList<E> {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> linkedListArr = new ArrayList<>();
        linkedListArr = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        ListNode node = buildList(linkedListArr);
        System.out.println(linkedListArr);
        ListNode newNode = reverseList(node);
        while(newNode!=null){
            System.out.print(newNode.val+" ");
            newNode = newNode.next;
        }
    }

    private static ListNode reverseList(ListNode node) {
        return revI(node);
    }

    public static ListNode rev(ListNode head,ListNode prev){
        if (head==null)return prev;
        ListNode temp = head.next;
        head.next = prev;
        return rev(temp,head);
    }

    public static ListNode revI(ListNode head){
        ListNode prev = null;
        while (head.next != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        head.next = prev;
        return head;
    }

    public static ListNode buildList(List<Integer> list){
        ListNode sentinel = new ListNode();
        ListNode travel = sentinel;
        for(int val : list){
            travel.next = new ListNode(val,null);
            travel = travel.next;
        }
        return sentinel.next;
    }

}
class ListNode{
    public int val;
    public ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode() {

    }
}


