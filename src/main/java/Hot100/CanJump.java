package Hot100;

public class CanJump {

    public boolean canJump(int[] nums) {
        int length = nums.length;
        int maxLen = 0;
        for (int i = 0; i < length; i++) {
            if (i <= maxLen) {
                maxLen = Math.max(maxLen, i + nums[i]);
                // 最远可以到达的距离大于等于最后一个元素的位置的话，说明最后一个位置的元素是可以到达的
                if (maxLen >= length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        CanJump canJump = new CanJump();
        System.out.println(canJump.canJump(nums));
        nums = new int[]{3,2,1,1,0,4};
        System.out.println(canJump.canJump(nums));
    }
}
