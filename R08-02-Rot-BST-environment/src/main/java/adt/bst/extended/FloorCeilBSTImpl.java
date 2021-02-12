package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	@Override
	public Integer floor(Integer[] array, double numero) {
		for(Integer number: array){
			this.insert(number);
		}
		return recursiveFloor(this.root, numero);
	}

	private Integer recursiveFloor(BSTNode<Integer> node, double num) {
		if(node.isEmpty()) { 
			return Integer.MAX_VALUE;
		}
		if(node.getData().compareTo((int) num) == 0) {
			return node.getData();
		}
		if(node.getData().compareTo((int) num) > 0) {
			return recursiveFloor((BSTNode<Integer>) node.getLeft(), num);
		}
		Integer floor = recursiveFloor((BSTNode<Integer>) node.getRight(), num);
		return (floor <= (int) num) ? floor : node.getData();
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		for(Integer number: array){
			this.insert(number);
		}
		return recursiveCeil(this.root, numero);
	}

	private Integer recursiveCeil(BSTNode<Integer> node, double num) {
		if(node.isEmpty()) {
			return Integer.MIN_VALUE;
		}
		if(node.getData().compareTo((int) num) == 0) {
			return node.getData();
		}
		if(node.getData().compareTo((int) num) < 0) {

			return recursiveCeil((BSTNode<Integer>) node.getRight(), num);
		}
		Integer ceil = recursiveCeil((BSTNode<Integer>) node.getLeft(), num);
		return (ceil >= (int) num) ? ceil : node.getData();
	}
}

