
/*
 * 请判定一个数独是否有效。
 * 该数独可能只填充了部分数字，其中缺少的数字用 . 表示。
 */
public class ValidSudoku {
	 public boolean isValidSudoku(char[][] board) {

	       boolean[][] rows = new boolean[9][9];
	       boolean[][] cols = new boolean[9][9];
	       boolean[][] blocks = new boolean[9][9];

	       for(int i = 0;i<9;i++){
	           for(int j=0;j<9;j++){                
	                if(board[i][j]=='.'){
	                    continue;
	                }
	                int c = board[i][j] - '1';   
	                if(rows[i][c]||cols[j][c]||blocks[i - i % 3 + j / 3][c]){
	                    return false;
	                }
	                rows[i][c] = cols[j][c] = blocks[i - i % 3 + j / 3][c] = true;
	           }
	       }
	       return true;
	    }
}
