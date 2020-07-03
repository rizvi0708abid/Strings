class Solution {
    
    public Map<Character,Integer> getMapOfStringChars(String str){
        Map<Character,Integer> map = new HashMap<>();
        
        for(char c : str.toCharArray()){
            if(map.get(c)!=null){
                int count = map.get(c);
                map.put(c,count+1);
            }else{
                map.put(c,1);
            }
        }
        return map;
    }
    
    public int strStr(String haystack, String needle) {
       Map<Character,Integer> maphay = new HashMap<>();
       Map<Character,Integer> mapneed = new HashMap<>();
        
       maphay = getMapOfStringChars(haystack);
       mapneed = getMapOfStringChars(needle);
        
        System.out.println(maphay);
        System.out.println(mapneed);
        
        boolean flag = true;
        
        if(needle==null || needle.length()==0 || needle.equals(haystack)) return 0;
        
        for(char c : needle.toCharArray()){
            if(maphay.get(c)==null || maphay.get(c)< mapneed.get(c)) {
                flag= false;
                break;
            }
        }
        if(flag){
            char ch = needle.charAt(0);
            int ind = 0;
            boolean isNeedle=false;
            int nLen = needle.length();
            int hLen = haystack.length();
            for(char c : haystack.toCharArray()){
                if(ch==c && ind+nLen <= hLen  && haystack.substring(ind,ind+nLen).equals(needle)){
                    isNeedle = true;
                    break;
                }
                ind++;
            }
            return (isNeedle) ? ind : -1;
            
        }else{
            return -1;
        }
        
    }
}
