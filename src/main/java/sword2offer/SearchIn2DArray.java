package sword2offer;

public class SearchIn2DArray {
    public boolean Find(int target, int [][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        int lineLength,rowLength;
        rowLength = array.length;
        lineLength = array[0].length;
        int i = 0, j = lineLength-1;
        int temp;
        while (i < rowLength && j >= 0) {
            temp = array[i][j];
            if (temp > target) {
                j--;
            } else if (temp < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;

    }
}
