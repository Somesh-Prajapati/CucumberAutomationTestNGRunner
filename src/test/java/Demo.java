import java.util.Arrays;
import java.util.TreeSet;

public class Demo {
	
	public void DemoMethod(int arr[]) {
		int n = 2;
		for (int i = 0; i < n; i++) {
			int a = arr[arr.length - 1];
			for (int j = arr.length - 1; j > 0; j--) {
				arr[j] = arr[j-1];
			}
			arr[0] = a;
		}
	}
	
	public static void main(String[] args) {
		Integer arr[] = { 1, 32,89, 45, 76 };
		TreeSet<Integer> list = new TreeSet<>(Arrays.asList(arr));
		for (int integer : arr) {
			list.add(integer);
		}
		System.out.println(list);
	}

}
