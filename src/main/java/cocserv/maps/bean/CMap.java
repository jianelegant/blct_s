package cocserv.maps.bean;

public class CMap {

	/*
	 * level 3,4,5,6,7,8,9,10,11
	 */
	private int level;

	/*
	 * type : 1 - farm, 2 - defense, 3 - hybrid, 4 - war
	 */
	private int type;

	/*
	 * small img
	 */
	private String url_small;
	/**
	 * standard img
	 */
	private String url_standard;

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getUrl_small() {
		return url_small;
	}

	public void setUrl_small(String url_small) {
		this.url_small = url_small;
	}

	public String getUrl_standard() {
		return url_standard;
	}

	public void setUrl_standard(String url_standard) {
		this.url_standard = url_standard;
	}

}
