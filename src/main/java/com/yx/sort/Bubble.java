package com.yx.sort;

import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        int[] array = new int[]{2,3,4,5,6,7,1,8};
        sort(array);
        System.out.println("1");
        System.out.println(Arrays.toString(array));
    }

    /**
     *
     * 鸡尾酒排序 左右左右
     * @param array
     */
    private static void sort(int[] array) {
        int temp=0;
        for (int i = 0; i< array.length/2; i++){
            boolean isSort=true;
            for (int j = 0; j< array.length-1-i; j++){
                if(array[j]> array[j+1]){
                    temp= array[j];
                    array[j]= array[j+1];
                    array[j+1]=temp;
                    isSort=false;
                }
            }
            if(isSort) return;
            for (int j = array.length-i-2; j>i; j--){
                if(array[j]< array[j-1]){
                    temp= array[j];
                    array[j]= array[j-1];
                    array[j-1]=temp;
                    isSort=false;
                }
            }
            if(isSort) return;
        }
    }

    private static void commonSort(int[] array) {
        //无序数列边界
        int sortBorder = array.length-1;
        for (int i = 0; i< array.length-1; i++){
            //是否以有序
            boolean isSort = true;
            int t=0;
            for (int j=0;j<sortBorder;j++){
                if(array[j]> array[j+1]){
                    int temp = array[j];
                    array[j]= array[j+1];
                    array[j+1] = temp;
                    isSort=false;
                    t=j;
                }
            }
            if(isSort==true)break;
            sortBorder=t;
        }
    }
}
