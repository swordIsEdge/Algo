package org.zj.sword2offer;

/**
 * Author:kasumi
 * Date:2018/8/7
 */
public class ReOrderArray {
    public static void main(String... args){
        ReOrderArray roa = new ReOrderArray();
        int[] array = {1, 2, 3, 4, 5, 6};
        roa.reOrderArray(array);
        roa.printArray(array);

    }
    public void reOrderArray(int [] array) {
        for(int i= 0;i<array.length-1;i++){
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]%2==0&&array[j+1]%2==1){
                    int t = array[j];
                    array[j]=array[j+1];
                    array[j+1]=t;
                }
            }
        }
    }

    private void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i);
            System.out.print("  ");
        }
        System.out.println();
    }
}
