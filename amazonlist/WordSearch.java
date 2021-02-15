 public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int height = board.length;
        int width = board[0].length;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (exist(board, height, width, row, col, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int height, int width, int row, int col, String word, int ind) {
        // all the character in word exist in board
        if (ind == word.length()) {return true;}
        // check boundary
        if (row < 0 || row >= height || col < 0 || col >= width || board[row][col] != word.charAt(ind)) {
            return false;
        }

        board[row][col] = '*';
        boolean res = exist(board, height, width, row - 1, col, word, ind + 1) ||
                exist(board, height, width, row + 1, col, word, ind + 1) ||
                exist(board, height, width, row, col - 1, word, ind + 1) ||
                exist(board, height, width, row, col + 1, word, ind + 1);
        // Restores the character back to what it was before changing it to '*'.
        // remove the visited mark, so that it can be visited again in the future
        // we need to go back to find another way if current way not work out, so that's why we restore the character
        board[row][col] = word.charAt(ind);
        return res;
    }
}