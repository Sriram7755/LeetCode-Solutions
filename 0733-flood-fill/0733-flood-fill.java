class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        if(image[sr][sc] == color) return image;
        int old_color = image[sr][sc];
        dfs(image,sr,sc,color,old_color);

        return image;
    }

    public void dfs(int[][] image , int row,int col,int color,int old_color)
    {
        if(row<0 || col<0 || row>=image.length || col>=image[0].length || image[row][col]!= old_color)return;
        
        image[row][col] = color;

        dfs(image,row-1,col,color,old_color);
        dfs(image,row+1,col,color,old_color);
        dfs(image,row,col-1,color,old_color);
        dfs(image,row,col+1,color,old_color);
    }
}