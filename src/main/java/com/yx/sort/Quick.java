package com.yx.sort;

import java.util.Arrays;

public class Quick {
    public static void main(String[] args) {
        int[] array = new int[]{2,0,4,5,6,5,7,1,8};
        quicksorts(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    private static void quicksorts(int[] array, int start, int end) {
        if(start>=end)return;
        int pivotIndex = partitionNew(array,start,end);
        quicksorts(array,start,pivotIndex-1);
        quicksorts(array,pivotIndex+1,end);
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[start];
        int left=start+1;
        int right = end;
        int temp=0;
        while(left!=right){
            while(right>left&&array[right]>pivot)right--;
            while (left<right&&array[left]<=pivot)left++;
            if(left<right){
                temp=array[left];
                array[left]=array[right];
                array[right]=temp;
            }
        }
        array[start]=array[left];
        array[left]=pivot;
        return left;
    }

    private static int partitionNew(int[] array, int start, int end) {
        int pivot = array[start];
        int mark=start;
        int temp=0;
        for(int i=start+1;i<=end;i++){
            if(array[i]<pivot){
                temp=array[++mark];
                array[mark]=array[i];
                array[i]=temp;
            }
        }
        array[start]=array[mark];
        array[mark]=pivot;
       return mark;
    }
}
