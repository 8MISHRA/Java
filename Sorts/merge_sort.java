import java.util.ArrayList;


public class merge_sort {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        // int arr1[] = {1,2,3,4,5};

        arr.add(3);
        arr.add(-9);
        arr.add(188);
        arr.add(1);
        arr.add(-1);
        arr.add(6);
        arr.add(-10);
        arr.add(-2);

        System.out.println("Given array is: "+arr);
        System.out.println("Sorted array is: "+ sort(arr, 0, arr.size()));
    }
    // public static ArrayList<Integer> combined;

    static ArrayList<Integer> sort(ArrayList<Integer> arr, int start, int end){
        
        return arr;
    }

    static void swap(ArrayList<Integer> arr, int i, int j){
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}