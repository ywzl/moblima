
public class Cinema {
	private String name;
	private int col, row;
	
	public Cinema(String name, int row, int col) {
		this.name = name;
		this.row = row;
		this.col = col;
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
}
