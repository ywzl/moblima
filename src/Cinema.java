
public class Cinema {
	private String name;
	private Seat[][] seats;
	private int col, row, numSeats;
	
	public Cinema(int row, int col) {
		this.row = row;
		this.col = col;
		numSeats = row * col;
		seats = new Seat[row][col];
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				seats[row][col] = new Seat(row, col);
			}
		}
	}
	
	public String getName() {
		return name;
	}
	
	public int getRows() {
		return row;
	}
	
	public int getCols() {
		return col;
	}
	
	public int getNumSeats() {
		return numSeats;
	}
	
	public Seat getSeat(int row, int col) {
		return seats[row][col];
	}
}
