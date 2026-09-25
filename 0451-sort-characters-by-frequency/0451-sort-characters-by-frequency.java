class Solution {
    public String frequencySort(String s) {
        
        HashMap<Character,Integer> map = new HashMap<>();

        for(char ch : s.toCharArray())
        {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        ArrayList<Character> list = new ArrayList<>(map.keySet());

        list.sort((a,b)->(map.get(b) - map.get(a)));

        StringBuilder sb = new StringBuilder();
        
        for(int i = 0;i<list.size();i++)
        {
            for(int j = 0;j<map.get(list.get(i));j++)
            {
                sb.append(list.get(i));
            }
        }
        return sb.toString();
    }
}