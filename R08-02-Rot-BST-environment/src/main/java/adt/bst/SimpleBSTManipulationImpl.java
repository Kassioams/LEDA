package adt.bst;

import adt.bt.BTNode;

/**
 * - Esta eh a unica classe que pode ser modificada 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		if ((tree1.isEmpty()) && (tree2.isEmpty())) {
			return true;
		} else if ((!tree1.isEmpty()) && (!tree2.isEmpty())) {
			return equals(tree1.getRoot(), tree2.getRoot());
		} else {
			return false;
		}
	}

	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		if ((tree1.isEmpty()) && (tree2.isEmpty())) {
			return true;
		} else if ((!tree1.isEmpty()) && (!tree2.isEmpty())) {
			return isSimilar(tree1.getRoot(), tree2.getRoot());
		} else {
			return false;
		}
	}

	@Override
	public T orderStatistic(BST<T> tree, int k) {
		if (k < tree.size()) {
			return orderStatistic(tree.getRoot(), k - 1, 0);
		}
		return null;
	}

	private boolean equals(BTNode<T> node1, BTNode<T> node2) {
		boolean resultado = false; 
		if ((!node1.isEmpty()) && (!node2.isEmpty())) {
			if (node1.getData().equals(node2.getData())) {
				resultado = equals(node1.getLeft(), node2.getLeft()); 
				resultado = equals(node1.getRight(), node2.getRight());
				return resultado;
			} else {
				return false;
			}
		} else if ((node1.isEmpty()) && (node2.isEmpty())) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isSimilar(BTNode<T> node1, BTNode<T> node2) {
		boolean resultado = false;
		if ((!node1.isEmpty()) && (!node2.isEmpty())) {
			resultado = isSimilar(node1.getLeft(), node2.getLeft());
			resultado = isSimilar(node1.getRight(), node2.getRight());
			return resultado;
		} else if ((node1.isEmpty()) && (node2.isEmpty())) {
			return true;
		} else {
			return false;
		}
	}

	private T orderStatistic(BTNode<T> node, int k, int index) {
		T resultado = null;
		if (!node.isEmpty()) {
			if (k == index) {	
				return node.getData();	
			} else {
				resultado = orderStatistic(node.getLeft(), k, index);
				resultado = orderStatistic(node.getRight(), k, ++index);
				return resultado;
			}
		}
		return null;
	}
}
