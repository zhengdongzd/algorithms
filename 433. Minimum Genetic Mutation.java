//initialize three things: queue for BFS; visited for checking duplicates; hashset for bankSet
//queue size is in the current level, when arriving 0 means going to the next level
//two 'for' loops, 8 positions * 4 chars ACGT; remember charArray[i] = oldGetBack; in each 8 position

public class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        HashSet<String> visited = new HashSet<String>();
        visited.add(start);

        HashSet<String> hs = new HashSet<String>();
        for(String s : bank)
            hs.add(s);

        // char[] charSet = new char['A', 'C', 'G', 'T'];
        char[] charSet = {'A', 'C', 'G', 'T'};
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size--!=0){
                String curr = queue.poll();
                if(curr.equals(end)){
                    return level;
                }
                // char[] charArray = curr.toCharArray[];
                char[] charArray = curr.toCharArray();
                for(int i = 0; i<charArray.length; i++){
                    char oldGetBack = charArray[i];
                    for (char c : charSet){
                        charArray[i] = c;
                        String newString = new String(charArray);
                        if((!visited.contains(newString))&&(hs.contains(newString))){
                           queue.add(newString);
                           visited.add(newString);
                        }
                    }
                    charArray[i] = oldGetBack;
                }
            }
            level++;
        }
        return -1;
    }
}