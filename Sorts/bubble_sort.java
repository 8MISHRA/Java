import java.util.ArrayList;
// import java.util.Arrays;
import java.util.Collections;

public class bubble_sort{
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        // int arr1[] = {1,2,3,4,5};

        arr.add(5);
        arr.add(9);
        arr.add(7);
        arr.add(0);
        arr.add(-1);
        arr.add(6);
        arr.add(10);
        arr.add(-2);

        System.out.println("Given array is: "+arr);
        System.out.println("Sorted array is: "+sort(arr));
    }


    static ArrayList<Integer> sort(ArrayList<Integer> arr){
        int len = arr.size();
        for(int i=0; i<len; i++){
            for (int j = 0; j<len-i-1; j++){
                if (arr.get(j) > arr.get(j+1)){
                    Collections.swap(arr, j+1, j);
                }
            }
        }
        return arr;
    }
}