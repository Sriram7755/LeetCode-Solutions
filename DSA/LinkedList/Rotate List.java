class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;

        // Step 1: Find length and tail
        ListNode temp = head;
        int length = 1;
        while(temp.next != null) {
            temp = temp.next;
            length++;
        }
        ListNode tail = temp;

        // Step 2: Make circular
        tail.next = head;

        // Step 3: Compute rotations
        int rotate = k % length;
        int stepsToNewTail = length - rotate;

        // Step 4: Find new tail
        temp = head;
        for(int i = 1; i < stepsToNewTail; i++) {
            temp = temp.next;
        }

        // Step 5: Set new head and break
        head = temp.next;
        temp.next = null;

        return head;
    }
}