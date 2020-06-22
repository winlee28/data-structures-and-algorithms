package com.win.data.sort;

import org.omg.CORBA.Object;

public class Sort {

    public static void main(String[] args) {

        int[] arr = new int[]{33, 55, 2, 1, 5, 7, 4, 32, 89, 43};

//        fastSort(arr, arr.length);
        insertionSort(arr, arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }


    /**
     * 快速排序 因为使用了双重for循环所以时间复杂度为 O(n^2)
     * <p>
     * 遍历数组，每次找出后续数组中最小元素和头部元素进行交换
     * eg:
     * [4,6,8,1]
     * <p>
     * 第一轮遍历   找出最小的元素 1 和首部元素 4 进行交换 [1,6,8,4]
     * 第二轮遍历   接着找出后续数组中找出最小的元素 4 和首部元素 6 进行交换 [1,4,8,6]
     * 第三轮遍历   接着找出后续数组中找出最小的元素 6 和首部元素 8 进行交换 [1,4,6,8]
     *
     * @param arr
     * @param count
     */
    public static void fastSort(int[] arr, int count) {

        for (int i = 0; i < count; i++) {

            int minIndex = i;
            for (int j = i + 1; j < count; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            //替换 i 和 minindex 的位置
            swap(arr, i, minIndex);

        }
    }

    /**
     * 插入排序
     * 处理近乎有序的数据 很有优势
     * 每次比较都向前不停比较 一旦小于 就将其插入到这个数据之前 直到遇到比它小的数据
     *
     * @param arr
     * @param count
     */
    public static void insertionSort(int[] arr, int count) {

//        for (int i = 1; i < count; i++) {
//            for (int j = i; j > 0; j--) {
//                if (arr[j] < arr[j - 1]) {
//                    swap(arr, j, j - 1);
//                }
//            }
//        }


        //大的数据往后移动 直到遇到小于的数据  就停止移动
        for (int i = 1; i < count; i++) {

            int temp = arr[i];
            int j;
            for (j = i; j > 0 && arr[j - 1] > temp; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;

        }


    }

    /**
     * 交换数组中 i 和 minIndex 的位置
     *
     * @param arr
     * @param i
     * @param minIndex
     */
    private static void swap(int[] arr, int i, int minIndex) {
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }


}
