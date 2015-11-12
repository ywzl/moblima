
public class Cinema {
    public enum Suite {
        STANDARD {
		            @Override
		            public String toString() {
		                return "Standard";
		            }
		        },    	
        GOLD_CLASS {
                    @Override
                    public String toString() {
                        return "Gold Class";
                    }
                },
        D_BOX {
                    @Override
                    public String toString() {
                        return "D-BOX";
                    }
                },
        GEMINI {
                    @Override
                    public String toString() {
                        return "Gemini: Two to View";
                    }
                },
        GRAND_SEATS {
                    @Override
                    public String toString() {
                        return "Grand Seats";
                    }
                },
        GVMAX {
                    @Override
                    public String toString() {
                        return "GVmax";
                    }
                },
        GVMAX_DOLBY {
                    @Override
                    public String toString() {
                        return "GVmax Dolby ATMOS";
                    }
                }
    }
    
	private String name;
	private Suite suite;
	private int col, row;
	
	public Cinema(String name, int row, int col, Suite suite) {
		this.name = name;
		this.row = row;
		this.col = col;
		this.suite = suite;
	}
	
	public Suite getSuite() {
		return suite;
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
