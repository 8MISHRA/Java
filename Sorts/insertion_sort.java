import java.util.ArrayList;


public class insertion_sort {
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
        System.out.println("Sorted array is: "+sort(arr));
    }
    
    static ArrayList<Integer> sort(ArrayList<Integer> arr){
        int len = arr.size();
        int i;
        for(i = 1; i<len; i++){
            int j = i-1;
            while(j>=0 && (arr.get(j)>arr.get(j+1))){
                swap(arr, j, j+1);
                j--;
            }                
        }
        return arr;
    }

    static void swap(ArrayList<Integer> arr, int i, int j){
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}