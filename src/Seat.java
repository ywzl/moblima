

/**
 *
 * @author Lloyd
 */
public class Seat {
	private int row;
	private int col;
	private boolean taken;
	
    /**
     *
     * @param row
     * @param col
     */
    public Seat(int row, int col) {
		this.setRow(row);
		this.setCol(col);
	}
	
    /**
     *
     */
    public void assignSeat() {
		taken = true;
	}
	
    /**
     *
     * @return
     */
    public boolean isTaken() {
		return taken;
	}
	
    /**
     *
     * @return
     */
    public char getRowAlphabet() {
		return (char) (row+65);
	}
	
    /**
     *
     * @return
     */
    public String getSeatNum() { 
		return getRowAlphabet() + ":" + col;
	}

	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @param row the row to set
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * @return the col
	 */
	public int getCol() {
		return col;
	}

	/**
	 * @param col the col to set
	 */
	public void setCol(int col) {
		this.col = col;
	}

}
