package CrackYourPlacementDay9;

class LNode {
    int data;
    LNode next;

    LNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SortLinkedList {
    public static void sortList(LNode head) {
        int count0 = 0, count1 = 0, count2 = 0;
        LNode temp = head;

        // Count the number of 0s, 1s, and 2s
        while (temp != null) {
            if (temp.data == 0) {
                count0++;
            } else if (temp.data == 1) {
                count1++;
            } else if (temp.data == 2) {
                count2++;
            }
            temp = temp.next;
        }

        // Update the list based on the counts
        temp = head;
        while (temp != null) {
            if (count0 > 0) {
                temp.data = 0;
                count0--;
            } else if (count1 > 0) {
                temp.data = 1;
                count1--;
            } else if (count2 > 0) {
                temp.data = 2;
                count2--;
            }
            temp = temp.next;
        }
    }

    // Helper function to print the list
    public static void printList(LNode head) {
        LNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LNode head = new LNode(1);
        head.next = new LNode(2);
        head.next.next = new LNode(0);
        head.next.next.next = new LNode(1);
        head.next.next.next.next = new LNode(2);
        head.next.next.next.next.next = new LNode(0);

        System.out.println("Original list:");
        printList(head);

        sortList(head);

        System.out.println("Sorted list:");
        printList(head);
    }
}
