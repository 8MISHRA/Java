import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class selection {
    public static void main(String[] args) throws IOException {
        String path = "array.txt";
        File file = new File(path);
        Scanner sc = new Scanner(file);
        ArrayList<Integer> arr = new ArrayList<>();

        while (sc.hasNext()){
            String w = sc.next();
            int value = Integer.valueOf(w);
            arr.add(value);
        }
        System.out.println(arr);
        System.out.println(sort(arr));
        sc.close();


    }

    static ArrayList<Integer> sort(ArrayList<Integer> arr){
        int len = arr.size();
        // int min = arr.get(0);

        for(int i=0; i<len; i++){
            for (int j = i; j<len; j++){
                if (arr.get(j) < arr.get(i)){
                    Collections.swap(arr, i, j);
                }
            }
        }
        return arr;
    }
}