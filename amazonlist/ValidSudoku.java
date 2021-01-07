import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {

        // encode each visited point at each row, column and sub box
        // use a set to store the encoded point
        Set<String> visited = new HashSet<String>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char number = board[i][j];
                // check if current number is visited or not
                // if visited, return false, else continue
                // for set, the add() will return false if the set already contains the value
                if (number != '.') {
                    StringBuilder row = new StringBuilder();
                    StringBuilder col = new StringBuilder();
                    StringBuilder box = new StringBuilder();
                    row.append(number).append("in row").append(i);
                    col.append(number).append("in column").append(j);
                    box.append(number).append("in box").append(i/3).append(j/3);
                    if (!visited.add(row.toString()) ||
                        !visited.add(col.toString()) ||
                        !visited.add(box.toString())) {
                            return false;
                    }
                }
            }
        }
        return true;
    }
}