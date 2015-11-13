

/**
 *
 * @author Lloyd
 */
public class Staff {
	String username;
	String password;
	
    /**
     *
     * @param username
     * @param password
     */
    public Staff(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
    /**
     *
     * @return
     */
    public String getUsername() {
		return username;
	}
	
    /**
     *
     * @return
     */
    public String getPassword() {
		return password;
	}

}
