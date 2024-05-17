// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};

        if(image[sr][sc] == color) return image;

        int m = image.length;
        int n = image[0].length;

        Queue<Integer> q = new LinkedList<>();
        q.add(sr);
        q.add(sc);

        int oldColor = image[sr][sc];
        image[sr][sc]= color;

        while(!q.isEmpty()){
            int r = q.poll();
            int c = q.poll();

            for(int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >= 0 && nc >=0 && nr < m && nc < n && image[nr][nc] == oldColor) {
                    image[nr][nc] = color;
                    q.add(nr);
                    q.add(nc);
                }
            }

        }

        return image;
    }
}

//DFS Approach
class Solution {
    int[][] dirs;
    int m;
    int n;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};

        if(image[sr][sc] == color) return image;

        m = image.length;
        n = image[0].length;

        int oldColor = image[sr][sc];

        dfs(image, sr, sc, color, oldColor);

        return image;
    }

    private void dfs(int[][] image, int i, int j, int color, int oldColor) {

        image[i][j] = color;
        for(int[] dir: dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            if(nr >= 0 && nc >= 0 && nr< m && nc <n && image[nr][nc] == oldColor) {
                image[nr][nc] = color;
                dfs(image,nr,nc,color, oldColor);
            }
        }

    }
}