class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] indegree = new int[numCourses];

        for(int[] edge : prerequisites)
        {
            indegree[edge[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0;i<indegree.length;i++)
        {
            if(indegree[i] == 0)q.offer(i);
        }
        int count = 0;

        while(!q.isEmpty())
        {
            int node = q.poll();
            count++;
            for(int[] edge : prerequisites)
            {
                if(edge[1] == node)
                {
                    int nei = edge[0];
                    indegree[nei]--;
                    if(indegree[nei] == 0)
                    {
                        q.offer(nei);
                    }
                }
            }
        }

        return count==numCourses;
    }
}