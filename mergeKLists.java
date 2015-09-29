
// * Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
public class mergeKLists {
    private ListNode Heap[];
    private int size;
    public mergeKLists() {
        size = 0;
    }
    public ListNode mergeKList(ListNode[] lists) {
        ListNode resultListNode = new ListNode(1);
        ListNode head = resultListNode;
        int listSize = lists.length;
        for(int i = 0; i < listSize; i++) {
            insert(lists[i]);
        }
        while(size > 0) {
            ListNode pNode = delete();
            head.next = new ListNode(pNode.val);
            head = head.next;
            if(pNode.next != null) {
                insert(pNode.next);
            }
        }
        return resultListNode.next;

    }
    public void insert(ListNode x) {
        Heap[size] = x;
        int tempPosition = size;
        size ++;
        while(Heap[tempPosition].val < Heap[(tempPosition-1)/2].val && tempPosition != 0) {
            ListNode tempValue = Heap[tempPosition];
            Heap[tempPosition] = Heap[(tempPosition-1)/2];
            Heap[(tempPosition-1)/2] = tempValue;
            tempPosition = (tempPosition-1)/2;
        }
    }
    public ListNode delete() {
        ListNode result = Heap[0];
        if(size == 0)
            return null;
        Heap[0] = Heap[--size];
        int tempPosition = 0;
        while(tempPosition != -1 && Heap[tempPosition].val > Heap[getMin(tempPosition)].val) {
            ListNode tempValue = Heap[getMin(tempPosition)];
            Heap[getMin(tempPosition)] = Heap[tempPosition];
            Heap[tempPosition] = tempValue;
            tempPosition = getMin(tempPosition);
        }
        return result;
    }
    public int getMin(int i) {
        int j = 2*i+1;
        if(j >= size) {
            return -1;
        }
        if(j+1 >= size) {
            return j;
        }
        return Heap[j].val < Heap[j+1].val ? j : j+1;
    }
}
