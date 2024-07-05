//we have to minimise the ship capacity suchh that it can tranfer all weight in given days d
//let mx capacity ship can hold be sum of all weight sof the packages
//apply bs on capacity such that it is minimised
class Solution {
    public boolean isPossible(int c , int[] arr, int d){
        int n = arr.length;
        int load = 0;
        int days = 1;
        for(int i=0;i<n;i++){
            if(load+arr[i]<=c) {
                load+=arr[i];
            }
        else {
            load = arr[i];
            days++;
        }
        }
        if(days>d) return false;
        else return true;
    }
    public int shipWithinDays(int[] arr, int d) {
      int n = arr.length;
        int sum = 0;
        int mx = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            mx= Math.max(mx,arr[i]);
        }
        int l = mx; //mx ele in arr as the  min weight that shuip can transfer
        int h = sum; //mx capacity of weight ship can hold
        int minC = sum;
        while(l<=h){     // T.C -> O(n*log(sum-mx))
            int mid = l+(h-l)/2; 
            if(isPossible(mid,arr,d)==true){
                minC = mid;
                h =mid-1;
            }
            else l = mid+1;
        }
return minC;
    }
}