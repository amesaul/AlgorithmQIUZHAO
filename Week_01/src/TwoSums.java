public class TwoSums {

    public int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int l = 0;
        int r = height.length - 1;
        int result = (r - l) * Math.min(height[l], height[r]);
        while (l < r) {
            if (height[l] <= height[r]) {
                while (height[l] >= height[++l]) {
                    if (l == r) break;
                }
            } else {
                while (height[r] >= height[--r]) {
                    if (l == r) break;
                }
            }
            result = Math.max(result, (r - l) * Math.min(height[l], height[r]));
        }
        return result;
    }

}
