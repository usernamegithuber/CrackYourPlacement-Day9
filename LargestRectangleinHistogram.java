package CrackYourPlacementDay9;

import java.util.Stack;

public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];

        // Calculate left limits
        for (int i = 0; i < len; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                left[i] = 0;
            } else {
                left[i] = st.peek() + 1;
            }
            st.push(i);
        }

        // Clear the stack before calculating right limits
        st.clear();

        // Calculate right limits
        for (int i = len - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                right[i] = len - 1;
            } else {
                right[i] = st.peek() - 1;
            }
            st.push(i);
        }

        // Calculate the maximum area
        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, heights[i] * (right[i] - left[i] + 1));
        }

        return max;
    }

    public static void main(String[] args) {
        LargestRectangleinHistogram sol = new LargestRectangleinHistogram();
        int[] heights = {0, 9};
        System.out.println(sol.largestRectangleArea(heights)); // Expected output: 9
    }
}
