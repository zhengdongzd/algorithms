//the length of the string "/tabc" is 4 not 5.
//use a stack and the number if \t to remember the hierarchy structure.

public class Solution {
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<Integer>();
        String[] strArr = input.split("\n");
        stack.push(0);
        int maxLen = 0;
        for(String s : strArr){
            int lev = s.lastIndexOf("\t") + 1; //lev is the number of \t
            while(lev < stack.size() - 1){
                stack.pop();
            }
            int len = stack.peek()+s.length() - lev + 1;
            stack.push(len); // forget at the first time
            if(s.contains(".")){
                maxLen = Math.max(maxLen, len-1); // here -1 is tricky, the last file doesnt have \
            }
        }
        return maxLen;
    }
}