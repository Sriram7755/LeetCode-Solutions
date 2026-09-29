class Solution {
    public  int count = 0;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];
        Stack<Integer> st = new Stack<>();

        for(int i = 0;i<numCourses;i++)
        {
            if(!visited[i])
            {
                if(dfs(prerequisites,visited,st,i,pathVisited)) return new int[] {};
            }
        }

       
        int[] result = new int[numCourses];

        int i = 0;

        while(!st.isEmpty())
        {
            result[i++] = st.pop(); 
        }
        return result;
        
    }
    public boolean dfs(int[][] edges,boolean[] visited,Stack<Integer> st , int node,boolean[] pathVisited)
    {
        visited[node] = true;
        pathVisited[node] = true;

        for(int[] edge : edges)
        {
            if(edge[1] == node)
            {
                int nei = edge[0];
                if(!visited[nei])
                {
                    if(dfs(edges,visited,st,nei,pathVisited))return true;
                    
                }
                else if(pathVisited[nei])return true;
            }

        }
        pathVisited[node] = false;
            st.push(node);
return false;

    }
}