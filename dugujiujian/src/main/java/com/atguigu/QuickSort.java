package com.atguigu;

public class QuickSort {
    public static void main(String[] args) {
        //int[] data={70,30,40,10,80,20,90,100,75,60,45};
        //int[] data={10,20,30,40,45,60,70,75,80,90,100};
        int[] data={100,90,80,70,60,50,40,35,20,10,0};
        System.out.println("排序前：");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]+",");
        }
        System.out.println();
        System.out.println("------------------------");

        sortByQuick(data);

        System.out.println("排序后：");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]+",");
        }
    }

    public static void sortByQuick(int[] data){
        if (data.length==0) {
            return;
        }
        quickSort(data, 0, data.length-1);
//		RandomQuickSort.randomQuickSort(data, 0, data.length-1);
    }

    public static int[] quickSort(int[] data,int low,int high){
        if (low>=high) {
            return null;
        }
        int pivot = data[low];//将数组的第一个元素设为“基准点”
        int i = low; //i从第1个元素开始
        int j = high;//j从最后一个元素开始
        //分别从数组两端循环判断数组元素与“基准点”的大小关系
        while (i<j) {//i=j时，跳出循环
            while ((i<j) && (pivot <= data[j])) {//向左寻找第一个小于pivot的数
                j--;
            }
            if(i<j){
                data[i++]=data[j];//将data[j]填入data[i]，并将i向右移动
            }
            while ((i<j) && (pivot > data[i])) {//向右寻找第一个大于index的数
                i++;
            }
            if (i<j) {
                data[j--]=data[i];//将data[i]填入data[j]，并将j向左移动
            }
        }

        data[i]=pivot;//将“基准点”填入最后的坑

        quickSort(data,low,j-1);//递归调用，分治
        quickSort(data,j+1,high);//递归调用，分治
        return data;
    }
}
