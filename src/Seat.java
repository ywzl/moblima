
public class Seat {
	private int row;
	private int col;
	private boolean taken;
	
	public Seat(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public void assignSeat() {
		taken = true;
	}
	
	public boolean isTaken() {
		return taken;
	}

}
