class Solution {
    public void rotate(int[][] matrix) {
        //11=14,12=24,13=34,14=44
        //21=13,22=23,23=33,24=43
        //31=12,32=22,33=32,34=42
        //41=11,42=21,43=31,44=41
        //transepose+reverse each rows
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //reverse each rows after transpose
        for(int i=0;i<n;i++){
        int left=0;
        int right=n-1;
        while(left<right){
            int temp=matrix[i][left];
            matrix[i][left]=matrix[i][right];
            matrix[i][right]=temp;
            left++;
            right--;
        }
        }
    }
}