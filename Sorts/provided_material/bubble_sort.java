/* Online Java Compiler and Editor */

import java.util.Random;

public class bubble_sort {  
    static void print (int a[]) //function to print array elements  
{  
    int n = a.length;  
    int i;  
    for (i = 0; i < n; i++)  
    {  
        System.out.print(a[i] + " ");  
    }        
}  
static void bubbleSort (int a[])    // function to implement bubble sort  
{  
    int n = a.length;  
    int i, j, temp;  
    for (i = 0; i < n; i++)  
    {  
        for (j = i + 1; j < n; j++)  
        {  
            if (a[j] < a[i])  
            {  
                temp = a[i];  
                a[i] = a[j];  
                a[j] = temp;  
            }  
        }  
    }  
}  
public static void main(String[] args) {

    int count=0;
    for (int j=0;j<100;j++){
                Random rd = new Random();

            long start = System.currentTimeMillis();
            int a[] = new int[10000];
            for (int i=0; i<a.length;i++){
                a[i] = rd.nextInt(200);
            }    
            bubble_sort b1 = new bubble_sort();  
            // System.out.println("Before sorting array elements are - ");    
            // b1.print(a);  
            b1.bubbleSort(a);  
            // System.out.println();  
            // System.out.println("After sorting array elements are - ");    
            // b1.print(a);  
            long end = System.currentTimeMillis();
            // System.out.println("\nTotal runtime: "+(end-start)+" miliseconds");
            count += (end-start);

    }
    System.out.println("Avg time takes is: "+ count/100);
}    
}  
