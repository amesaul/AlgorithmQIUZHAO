import javax.sound.midi.Soundbank;

class Solution {
	public void BubbleSort(int[] arr) {
		for (int i = 0;i<arr.length;++i){
			for (int j = 1; j<arr.length-i;++j){
				if (arr[j]<arr[j-1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}

			}
		}
	}

	public static void main(String[] args) {
		Solution so = new Solution();
		int[] t ={1,3,2,8,9,22,11,8,20};
		so.BubbleSort(t);
		for (int i : t){
			System.out.print(i+" ");
		}
	}
}