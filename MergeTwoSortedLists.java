package CrackYourPlacementDay9;

class lnode {
    int data;
    lnode next;

    lnode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MergeTwoSortedLists {
    public static lnode mergeTwoLists(lnode list1, lnode list2) {
        lnode dummy = new lnode(0);
        lnode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Attach the remaining nodes of list1 or list2
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummy.next;
    }

    // Helper function to print the list
    public static void printList(lnode head) {
        lnode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        lnode list1 = new lnode(1);
        list1.next = new lnode(2);
        list1.next.next = new lnode(4);

        lnode list2 = new lnode(1);
        list2.next = new lnode(3);
        list2.next.next = new lnode(4);

        System.out.println("List 1:");
        printList(list1);

        System.out.println("List 2:");
        printList(list2);

        lnode mergedList = mergeTwoLists(list1, list2);

        System.out.println("Merged List:");
        printList(mergedList);
    }
}
