package com;

/*
class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i:nums){
            if(set.contains(i)) return i;
            set.add(i);
        }
        return -1;
    }
}
*/

/*
class Solution {
    public int findRepeatNumber(int[] nums) {
       Arrays.sort(nums);
       for(int i=1;i<nums.length;i++){
           if(nums[i]==nums[i-1]) return nums[i];
       }
       return -1;
    }
}
*/

/*
class Solution {
    public int findRepeatNumber(int[] nums) {
        int[] cnt = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(cnt[nums[i]]==1) return nums[i];
            else cnt[nums[i]]=1;
        }
        return -1;
    }
}
*/
class Solution {
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while(i<nums.length){
            if(nums[i]==i) {
                i++;
                continue;
            }
            if(nums[nums[i]]==nums[i]) return nums[i];
            else{
                int temp=nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }


        return -1;
    }

    public static void main(String[] args) {
        //冒泡排序
        int[] nums = new int[]
    }
}


