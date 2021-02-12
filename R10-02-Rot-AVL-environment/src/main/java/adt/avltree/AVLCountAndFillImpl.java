package adt.avltree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import adt.bst.BSTNode;
import adt.bt.Util;

public class AVLCountAndFillImpl<T extends Comparable<T>> extends
AVLTreeImpl<T> implements AVLCountAndFill<T> {

	private int LLcounter;
	private int LRcounter;
	private int RRcounter;
	private int RLcounter;

	public AVLCountAndFillImpl() {

	}

	@Override
	public int LLcount() {
		return LLcounter;
	}

	@Override
	public int LRcount() {
		return LRcounter;
	}

	@Override
	public int RRcount() {
		return RRcounter;
	}

	@Override
	public int RLcount() {
		return RLcounter;
	}

	@Override
	public void fillWithoutRebalance(T[] array) {
		if(array != null) {
			Arrays.sort(array);
			HashMap<Integer, ArrayList<T>> map = new HashMap<>();
			aux(array, map, 0, array.length-1, 0);
			int index = 0;
			while(!map.isEmpty()){
				for (int i = 0; i < map.get(index).size(); i++) {
					this.insert(map.get(index).get(i));
				}
				map.remove(index);
				index++;
			}
		}
	}

	private void aux(T[] array, HashMap<Integer, ArrayList<T>> map, int left, int right, int level) {
		if(left <= right) {
			int mid = (left + right) / 2;

			if (map.containsKey(level)) {
				map.get(level).add(array[mid]);
			} else {
				ArrayList<T> arr = new ArrayList<>();
				arr.add(array[mid]);
				map.put(level, arr);
			}
			aux(array, map, left, mid-1, level+1);
			aux(array, map,mid+1, right, level+1);
		}
	}

	@Override
	protected void rebalance(BSTNode<T> node) {
		int balance = super.calculateBalance(node);

		if (balance > 1) {
			this.heavierLeft(node);
		} else if (balance < -1) {
			this.heavierRight(node);
		}
	}

	private void heavierLeft(BSTNode<T> node) {
		BSTNode<T> aux;

		if (this.calculateBalance((BSTNode<T>) node.getLeft()) > 0) {
			aux = Util.rightRotation(node);
			this.LLcounter++;
		} else {
			Util.leftRotation((BSTNode<T>) node.getLeft());
			aux = Util.rightRotation(node);
			this.LRcounter++;
		}
		if (aux.getParent() == null) {
			super.root = aux;
		}
	}

	private void heavierRight(BSTNode<T> node) {
		BSTNode<T> aux;

		if (this.calculateBalance((BSTNode<T>) node.getRight()) < 0) {
			aux = Util.leftRotation(node);
			this.RRcounter++;
		} else {
			Util.rightRotation((BSTNode<T>) node.getRight());
			aux = Util.leftRotation(node);
			this.RLcounter++;
		}
		if (aux.getParent() == null) {
			super.root = aux;
		}
	}
}
