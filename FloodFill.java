class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // Only start the flood fill if the starting pixel is not already the target color
        if (image[sr][sc] != color) {
            curse(image, sr, sc, color, image[sr][sc]);
        }
        return image;
    }

    public void curse(int[][] image, int sr, int sc, int color, int start) {
        // Check if the current position is out of bounds or not the starting color
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != start) {
            return;
        }
        
        // Change the color of the current pixel
        image[sr][sc] = color;

        // Recursive calls for neighboring pixels
        curse(image, sr + 1, sc, color, start); // Down
        curse(image, sr - 1, sc, color, start); // Up
        curse(image, sr, sc + 1, color, start); // Right
        curse(image, sr, sc - 1, color, start); // Left
    }


    //generate main
    public static void main(String[] args) {
        int[][] image = {{0,0,0},{0,0,0}};
        int sr = 1, sc = 1, color = 2;
        FloodFill obj = new FloodFill();
        obj.floodFill(image, sr, sc, color);
    }

}