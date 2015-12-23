public interface ISequenceAnalyzer {

	/**
	 * A char constant that represents the fact that a solution was obtained from the cell above
	 * in a dynamic programming table.
	 */
	public static final char UP = 'u';
	/**
	 * A char constant that represents the fact that a solution was obtained from the cell to the
	 * left in a dynamic programming table.
	 */
	public static final char LEFT = 'l';
	/**
	 * A char constant that represents the fact that a solution was obtained from the cell diagonally
	 * left and up in a dynamic programming table.
	 */
	public static final char DIAG = 'd';

	/**
	 * Finds the longest common subsequence of <code>x</code> and <code>y</code>.
	 * 
	 * After this method returns, the lengths of the longest common subsequences of any two
	 * prefixes of <code>x</code> and <code>y</code> are stored in the given
	 * <code>lengths</code> table. The length of the longest common subsequence of 
	 * x and y is stored in lengths[x.length()][y.length()].
	 * 
	 * After this method returns, each cell (i,j) of the <code>pointers</code> table contains
	 * a pointer that describes how the corresponding value of the (i,j) cell in the 
	 * <code>lengths</code> table was derived.
	 * A cell in the <code>pointers</code> table can have 3 possible values:
	 * - DIAG: means that the value in lengths[i][j] was based on the value of lengths[i-1][j-1]
	 * - UP: means that the value in lengths[i][j] was based on the value of lengths[i-1][j]
	 * - LEFT: means that the value in lengths[i][j] was based on the value of lengths[i][j-1]
	 * 
	 * PREREQUISITES:
	 * - lengths and pointers have dimensions x.length() + 1 by y.length() + 1
	 * 
	 * @param x
	 * @param y
	 * @param lengths
	 * @param pointers
	 * @return
	 */
	public int lengthLCS(String x, String y, int[][] lengths, char[][] pointers);

	/**
	 * Print the longest common subsequence based on pointers stored in the
	 * <code>pointers</code> table. <code>i</code> and <code>j</code> are are the indices of the
	 * cell that corresponds to the final solution. 
	 * 
	 * @param pointers
	 * @param x
	 * @param i
	 * @param j
	 */
	public void printLCS(char[][] pointers, String x, int i, int j);

}