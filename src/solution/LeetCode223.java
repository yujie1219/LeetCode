package solution;

public class LeetCode223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int ALeftBottomX = Math.min(A, C);
        int ALeftBottomY = Math.min(B, D);

        int ARightTopX = Math.max(A, C);
        int ARightTopY = Math.max(B, D);

        int BLeftBottomX = Math.min(E, G);
        int BLeftBottomY = Math.min(F, H);

        int BRightTopX = Math.max(E, G);
        int BRightTopY = Math.max(F, H);

        int total = (ARightTopX - ALeftBottomX) * (ARightTopY - ALeftBottomY) + (BRightTopX - BLeftBottomX) * (BRightTopY - BLeftBottomY);
        if (ALeftBottomY >= BRightTopY || ARightTopY <= BLeftBottomY || ALeftBottomX >= BRightTopX || ARightTopX <= BLeftBottomX) {
            return total;
        }

        int mergedLeftBottomX = Math.max(ALeftBottomX, BLeftBottomX);
        int mergedLeftBottomY = Math.max(ALeftBottomY, BLeftBottomY);

        int mergedRightTopX = Math.min(ARightTopX, BRightTopX);
        int mergedRightTopY = Math.min(ARightTopY, BRightTopY);

        return total - (mergedRightTopX - mergedLeftBottomX) * (mergedRightTopY - mergedLeftBottomY);
    }
}
