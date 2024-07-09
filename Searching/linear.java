// import java.lang.reflect.Array;
import java.util.*;



public class linear{
    public static void main(String[] args) {
        search s = new search();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the target value: ");
        int target = sc.nextInt();
        

        if (args.length == 0) {
            System.out.println("No command-line array provided.");
        } else {
            for (int i = 0; i < args.length; i++) {
                int value = Integer.valueOf(args[i]);
                arr.add(value);
            }
        
        s.LinearSearch(arr, target);
        s.BinarySearch(arr, target);
        sc.close();
    }
}
}

class search{
    int LinearSearch(ArrayList<Integer> arr, int target){
        int len = arr.size();
        int i;
        int count = 0;
        for (i=0;i<len;++i){
            count++;
            if (arr.get(i) == target){
                System.out.println("The number of comaprisons using linear search are: "+ count);
                return i;
            }
        }
        return -1;
    }

    int BinarySearch(ArrayList<Integer> arr, int target){
        int i=0;
        int left = 0;
        int right = arr.size();
        int count = 0;
        boolean var = true;

        while (var){
            count++;
            int mid = (int)(left+right)/2;
            if (target == arr.get(mid)){
                System.out.println("The number of comaprisons using binary search are: "+ count);
                var = false;
                return i;
            }else if(target < arr.get(mid)){
                right = mid - 1;
            }else if(target > arr.get(mid)){
                left = mid + 1;
            }
        }
        return -1;
    }
}