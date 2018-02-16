package com.sgcharts.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class Heapsort {
	private static final Logger log = LoggerFactory.getLogger(Heapsort.class);

	private Heapsort() {
		// Not meant to be instantiated
	}

	public static <T extends Comparable<? super T>> void sort(ArrayList<T> a) {
		// The following loop maintains the invariants that a[0:end] is a heap
		// and every element beyond end is greater than everything before it, so
		// a[end:len - 1] is in sorted order.
		heapify(a);
		int end = a.size() - 1;
		while (end > 0) {
			Collections.swap(a, 0, end);
			// the heap size is reduced by one
			end--;
			// the swap ruined the heap property, so restore it
			siftDown(a, 0, end);
		}
	}

	/**
	 * Put array elements in max heap order, in-place
	 * 
	 * @param a
	 */
	private static <T extends Comparable<? super T>> void heapify(ArrayList<T> a) {
		// Begin from the last parent node.
		// the last element in a 0-based array is at index count-1; find the
		// parent of that element
		int len = a.size();
		int begin = indexOfParent(len - 1);
		while (begin >= 0) {
			// Sift down the node at index 'begin' to the proper place such
			// that all nodes below
			// the begin index are in heap order.
			siftDown(a, begin, len - 1);
			// go to the next parent node
			begin--;
		}
		// after sifting down the root all nodes are in heap order
		log.debug("heapify: {}", a);
	}

	/**
	 * Repair the heap whose root element is at index 'begin', assuming the
	 * heaps rooted at its children are valid.
	 * 
	 * @param a
	 * @param begin
	 *            begin index inclusive
	 * @param end
	 *            end index inclusive
	 */
	private static <T extends Comparable<? super T>> void siftDown(ArrayList<T> a, int begin, int end) {
		int root = begin;
		int child = indexOfLeftChild(root);
		// Keeps track of child to swap with
		int target = root;
		while (child <= end) {
			log.debug("a[root]={}, a[child]={}", a.get(root), a.get(child));
			if (a.get(target).compareTo(a.get(child)) < 0) {
				target = child;
			}
			// If there is a right child and that child is greater
			child++;
			if (child <= end && a.get(target).compareTo(a.get(child)) < 0) {
				target = child;
			}
			// The root holds the largest element. Since we assume the heaps
			// rooted at the children are valid, this means that we are done.
			if (target == root) {
				log.debug("siftDown: {}", a);
				return;
			}
			// repeat to continue sifting down the child now
			Collections.swap(a, target, root);
			root = target;
			child = indexOfLeftChild(root);
		}
	}

	private static int indexOfParent(int i) {
		return (i - 1) / 2;
	}

	private static int indexOfLeftChild(int i) {
		return 2 * i + 1;
	}

	private static String toString(int[] in) {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < in.length; i++) {
			sb.append(in[i]);
			if (i != in.length - 1) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}

}
