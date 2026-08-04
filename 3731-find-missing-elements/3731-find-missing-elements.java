class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int max=nums[0];
        int min=nums[0];
        List<Integer> list=new ArrayList<>();
        for(int num:nums){
            if(num>max){
                max=num;
            }
            if(num<min){
                min=num;
            }
        }
        int n=max-min+1;
        boolean[] demo = new boolean[n];
        for(int curr:nums){
            demo[curr-min]=true;
        }
        for(int i=0;i<n;i++){
            if(demo[i]==false){
                list.add(i+min);
            }
        }
        return list;
    }
}