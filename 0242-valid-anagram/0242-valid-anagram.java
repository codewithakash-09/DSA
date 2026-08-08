class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int [] freq=new int[26];
        int [] fre=new int [26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            freq[ch-'a']++;
        }
        for(int j=0;j<t.length();j++){
            char ch=t.charAt(j);
            fre[ch-'a']++;
        }
        for(int k=0;k<26;k++){
        if(freq[k]!=fre[k]){
            return false;
        }
         
    }return true;
}
}