/*
 * Remove duplicates from an unsorted linked list.
 * Follow Up: Temporary buffer is not allowed.
*/
package CTCI;

import java.util.HashSet;

public class LL21Custom {

	public static void main(String[] args) {
		MyLinkedList myl = new MyLinkedList();
		myGenerateRandomList(myl);
		myPrint(myl);
		// myRemoveDuplicatesBuffer(myl);
		MyLinkedList myl2 = new MyLinkedList();
		myl2 = myRemoveDuplicatesNoBuffer(myl,myl2);
		myPrint(myl);
	}

	private static void myGenerateRandomList(MyLinkedList myl) {
		for (int i = 0; i < 15; i++) {
			myl.add((int) (Math.random() * 10));
		}
	}

	private static void myPrint(MyLinkedList myl) {
		System.out.println("Printing the elements in the My Linked List:");
		for (int i = 0; i < myl.size(); i++) {
			System.out.print(myl.get(i) + "\t");
		}
		System.out.println();
	}

	// No Buffer Allowed.
	private static void myRemoveDuplicatesBuffer(MyLinkedList myl) {
		System.out.println("Removing Duplicates...");
		for (int i = 0; i < myl.size() - 1; i++) {
			for (int j = i + 1; j < myl.size(); j++) {
				if (myl.get(i) == myl.get(j))
					myl.remove(j);
			}
		}
	}

	// Buffer Allowed.
	private static MyLinkedList myRemoveDuplicatesNoBuffer(MyLinkedList myl, MyLinkedList myl2) {
		System.out.println("Removing Duplicates...");
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i = 0; i < myl.size(); i++) {
			hs.add((Integer) myl.get(i));
		}
		for (Integer x : hs) {
			myl2.add(x);
		}
		return myl2;
	}
}
