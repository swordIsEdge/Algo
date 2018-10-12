package sword2offer;

/**
 * Author:kasumi
 * Date:2018/8/12
 */
public class VerifySquenceOfBST {
    int[] sequence;

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        if (sequence.length <= 2) {
            return true;
        }
        this.sequence = sequence;
        return VerifySquenceOfBST(0, sequence.length - 1);


    }

    public boolean VerifySquenceOfBST(int start, int end) {
        if (end - start <= 1) {
            return true;
        }
        int flag = sequence[end];
        int i;
        for (i = start; i < end; i++) {
            if (sequence[i] >= flag) {
                break;
            }
        }
        for (int j = i; j < end; j++) {
            if (sequence[j] < flag) {
                return false;
            }
        }
        return VerifySquenceOfBST(start, i - 1) && VerifySquenceOfBST(i, end - 1);
    }


}
