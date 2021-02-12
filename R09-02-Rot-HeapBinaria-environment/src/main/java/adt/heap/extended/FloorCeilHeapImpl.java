package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {
	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		buildHeap(array);
		Integer floor = null;
		if(isMinHeap()){
			floor = floorMinHeap(numero);
			if(floor == Integer.MIN_VALUE)
				floor = null;
		}else{
			floor = floorMaxHeap(numero);
		}
		return floor;
	}

	private Integer floorMaxHeap(double numero){
		Integer floor = null;
		if(comparator.compare((int) numero, rootElement()) <= 0){
			floor = rootElement();
		}else{
			while(comparator.compare((int) numero, rootElement()) > 0){
				extractRootElement();
				if(isEmpty())
					break;
			}
			floor = rootElement();
		}
		return floor;
	}

	private Integer floorMinHeap(double numero){
		Integer floor = Integer.MIN_VALUE;
		while(comparator.compare((int) numero, rootElement()) >= 0 && comparator.compare(rootElement(), floor) >= 0) {
			floor = rootElement();
			extractRootElement();
			if(isEmpty())
				break;
		}
		return floor;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		buildHeap(array);
		Integer ceil = null;
		if(isMinHeap()){
			ceil = ceilMinHeap(numero);
		}else{
			ceil = ceilMaxHeap(numero);
			if(ceil == Integer.MAX_VALUE)
				return null;
		}
		return ceil;
	}

	private Integer ceilMaxHeap(double numero){
		Integer ceil = Integer.MAX_VALUE;
		while(comparator.compare((int) numero, rootElement()) >= 0 && comparator.compare(rootElement(), ceil) >= 0) {
			ceil = rootElement();
			extractRootElement();
			if(isEmpty())
				break;
		}
		return ceil;
	}

	private Integer ceilMinHeap(double numero){
		Integer ceil = null;
		if(comparator.compare((int) numero, rootElement()) <=  0){
			ceil = rootElement();
		}else{
			while(comparator.compare((int) numero, rootElement()) > 0){
				extractRootElement();
				if(isEmpty())
					break;
			}
			ceil = rootElement();
		}
		return ceil;
	}
}