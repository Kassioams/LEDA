package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	@Override
	public void insertFirst(T element) {
		if(!isEmpty()) {
			T aux  = this.data;
			this.data = element;
			((RecursiveDoubleLinkedListImpl<T>) this.next).insertFirst(aux);
		} else {
			this.data = element;
			RecursiveDoubleLinkedListImpl<T> aux = new RecursiveDoubleLinkedListImpl<>();
			aux.setPrevious(this);
			this.setNext(aux);
		}
	}

	@Override
	public void removeFirst() {
		if(this.next.isEmpty()) {
			this.next = null;
			this.data = null;
		} else {
			this.data = this.next.getData();
			((RecursiveDoubleLinkedListImpl<T>) this.next).removeFirst();
		}
	}

	@Override
	public void removeLast() {
		if(!isEmpty()) {
			if(this.next.isEmpty()) {
				this.data = null;
				this.next = null;
			} else {
				((RecursiveDoubleLinkedListImpl<T>) this.next).removeLast();
			}
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
