class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();//key is String(sorted value) and value is 
                                                     //value is like("eat","tea","ate")
        for(String word:strs){   //for each loop that iterates on each word in string
            char[] chars=word.toCharArray();
            Arrays.sort(chars);
            String key=new String(chars);
            map.putIfAbsent(key,new ArrayList<>());
            map.get(key).add(word);
        }
        return new ArrayList<>(map.values());
    }
}