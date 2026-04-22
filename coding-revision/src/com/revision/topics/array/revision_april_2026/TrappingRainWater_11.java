package com.revision.topics.array.revision_april_2026;

public class TrappingRainWater_11 {

    private static int trap(int[] height) {
        int[] lMax = new int[height.length];
        int[] rMax = new int[height.length];
        
        lMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            lMax[i] = Math.max(height[i], lMax[i-1]);
        }
        
        rMax[height.length - 1] = height[height.length-1];
        for (int i = height.length - 2; i >= 0 ; i--) {
            rMax[i] = Math.max(height[i], rMax[i+1]);
        }

        int res = 0;
        for (int i = 0; i < height.length; i++) {
            res = res + (Math.min(lMax[i], rMax[i]) - height[i]);
        }
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(trap(new int[]{3, 0, 1, 0, 4, 0, 2}));
        System.out.println(trap(new int[]{3, 0, 2, 0, 4}));
        System.out.println(trap(new int[]{1, 2, 3, 4}));
        System.out.println(trap(new int[]{2, 1, 5, 3, 1, 0, 4}));
    }
}
