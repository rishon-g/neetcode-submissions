class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

}

class LinkedList {
    private ListNode head;
    private ListNode tail;
    
    public LinkedList() {
        head = new ListNode(-1);
        tail = head;

    }

    public int get(int index) {
        ListNode curr = head.next;
        int i = 0;
        while (curr != null) {
            if (i == index) {
                return curr.val;
            }

            i++;
            curr = curr.next;
        }

        return -1;
        
    }

    public void insertHead(int val) {
        ListNode node = new ListNode(val);
        // start: dummy (head) -> null 
        node.next = head.next;
        head.next = node;
   
        // we now have dummy (head) -> new node -> null
        
        // if we have an empty list, meaning tail = head, then we set
        // tail to be the new node. 
        // now we have dummy (head) -> new node (tail) -> null
        if (tail == head) {
            tail = node;  
        }
        
    }

    public void insertTail(int val) {
        tail.next = new ListNode(val);
        tail = tail.next; 

    }

    public boolean remove(int index) {
        ListNode curr = head;
        int i = 0;
        while (i < index && curr != null) {
            curr = curr.next;
            i++;
        }

        if (curr == null || curr.next == null) {
            return false;
        }
        
        if (curr.next == tail) {
            tail = curr;
        }

        curr.next = curr.next.next;
        return true;

    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> res = new ArrayList<>();
        ListNode curr = head.next;
        while (curr != null) {
            res.add(curr.val);
            curr = curr.next;
        }

        return res;

    }
}
