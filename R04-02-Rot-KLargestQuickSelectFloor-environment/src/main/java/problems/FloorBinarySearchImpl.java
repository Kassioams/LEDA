package problems;

public class FloorBinarySearchImpl implements Floor {

		@Override
		public Integer floor(Integer[] array, Integer x) {
			return floor(array, x, 0, array.length-1);
		}

		private Integer floor(Integer[] array, Integer x, int leftIndex, int rightIndex) {
			if(leftIndex == rightIndex){
				
				if(array[leftIndex] < x) {
					return array[leftIndex];
				}else if(array[leftIndex] == x){
					return array[leftIndex];
				}else {
					return null;
				}
			}
			
			if(leftIndex < rightIndex && leftIndex >= 0 && rightIndex < array.length) {
				int meio = (leftIndex + rightIndex) / 2;
				
				if(array[meio] == x) {
					return array[meio];
				}else if(array[meio] < x) {
					return floor(array, x, meio + 1, rightIndex, array[meio]);
				}else {
					return floor(array, x, leftIndex, meio -1);
				}
			}else {
				return null;
			}
		}

		private Integer floor(Integer[] array, Integer x, int leftIndex, int rightIndex, int menorAtual) {
			if(leftIndex == rightIndex) {
				
				if(array[leftIndex] < x) {
					return array[leftIndex];
				}else if(array[leftIndex] == x){
					return array[leftIndex];
				}else {
					return menorAtual;
				}
			}
			int meio = (leftIndex + rightIndex) / 2;			
			if(array[meio] == x) {
				return array[meio];
			}else if(array[meio] < x) {
				return floor(array, x, meio + 1, rightIndex, array[meio]);
			}else {
				return floor(array, x, leftIndex, meio-1, menorAtual);
			}
		}
	}
			
	



