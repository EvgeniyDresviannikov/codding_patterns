package challenge.yourself;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        System.out.println(containerWithMostWater(new int[] {8, 2, 6, 3, 5, 4, 7}));
    }

    public static int containerWithMostWater(int[] height) {

        int maxVolume = 0;
        int left = 0;
        int right = height.length-1;

        while (left < right) {
            int curVolume = Math.min(height[left], height[right]) * (right-left);
            maxVolume = Math.max(maxVolume, curVolume);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxVolume;
    }
}
