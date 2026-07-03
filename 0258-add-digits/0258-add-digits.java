class Solution {
    public int addDigits(int num) {
    int rem=0;
    while (num >= 10) {      // keep going until one digit remains
    int sum = 0;
    while (num != 0) {   // sum the digits
        rem=num%10;
        sum+=rem;
        num=num/10;
        }
        num = sum;
        }
        if(num>0&&num<10) return num;
        else return 0;
    }
}