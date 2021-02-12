 package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {
  
	private Stack<T> stack1;
	private Stack<T> stack2;
	private int top;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
		this.top = -1;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (!stack1.isEmpty()) {
	        while (!stack1.isEmpty()) {  
	            try {
					stack2.push(stack1.pop());
				} catch (StackOverflowException | StackUnderflowException e) {
					throw new QueueOverflowException();
				} 
	        }
		}
	}
	    


	@Override
	public T dequeue() throws QueueUnderflowException {
		if (!stack2.isEmpty()) {
			try {
				return this.stack2.pop();
			} catch (StackUnderflowException e) {
				throw new QueueUnderflowException();
			}
		}
		while (!stack1.isEmpty()) {
		      try {
				this.stack2.push(this.stack1.pop());
			} catch (StackOverflowException | StackUnderflowException e) {
				throw new QueueUnderflowException();
			}
		  }
		try {
			return this.stack2.pop();
		} catch (StackUnderflowException e) {
			throw new QueueUnderflowException();
			}
		}
	

	@Override
	public T head() {
		if (!isEmpty()) {
			return (T) this.stack2;
		}else {
			return null;
		}
	}

	@Override
	public boolean isEmpty() {
		return this.stack1.isEmpty() && this.stack2.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.stack1.isFull() && this.stack2.isFull();
	}

}
