public class MajorityElement {
	public static <E> E majorityElement(final E[] array) {
		if(array == null || array.length == 0){
			return null;
		}
		int index = findMajorityElementIndex(array, 0, array.length - 1);
		return index == -1 ? null : array[index];
	}

	private static <E> int findMajorityElementIndex(E[] array, int start, int end){
		//base case
		if(start == end){
			return start;
		}

		//find prevalent elements in subarrays
		int mid = (start + end) / 2;
		int prevalent1 = findMajorityElementIndex(array, start, mid);
		int prevalent2 = findMajorityElementIndex(array, mid + 1, end);

		//determine if either element is also prevalent in combined array, if yes, return that element
		if(isMajority(array, start, end, prevalent1)){
			return prevalent1;
		}
		if(isMajority(array, start, end, prevalent2)){
			return prevalent2;
		}
		return -1;
	}

	private static <E> boolean isMajority(E[] array, int start, int end, int elementIndex){
		if(elementIndex == -1){
			return false;
		}
		E element = array[elementIndex];
		int majorityThreshold = ((end - start + 1) / 2) + 1;
		int count = 0;
		for(int i = start; i <= end; i++){
			if(element.equals(array[i])){
				count++;
			}
		}
		return count >= majorityThreshold;
	}

	public static void main(String[] args) {
		Integer[] array = {1, 30, 30, 30, 0, 1, 2, 30};
		System.out.println(majorityElement(array));
	}

}