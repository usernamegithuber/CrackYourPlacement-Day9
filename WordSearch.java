package CrackYourPlacementDay9;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int row, int col, int ind) {
        if (ind == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(ind)) {
            return false;
        }
        char temp = board[row][col];
        board[row][col] = '*';
        boolean found = dfs(board, word, row + 1, col, ind + 1) ||
                dfs(board, word, row - 1, col, ind + 1) ||
                dfs(board, word, row, col + 1, ind + 1) ||
                dfs(board, word, row, col - 1, ind + 1);
        board[row][col] = temp;
        return found;
    }

    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word1 = "ABCCED";
        String word2 = "SEE";
        String word3 = "ABCB";

        System.out.println(ws.exist(board, word1)); // Output: true
        System.out.println(ws.exist(board, word2)); // Output: true
        System.out.println(ws.exist(board, word3)); // Output: false
    }
}

