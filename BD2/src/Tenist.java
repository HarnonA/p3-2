public class Tenist {
	private String name;
	private String nickname;
	private int yearBirth;
	private String yearCity;
	private String residenceCity;
	private int isActive;

	public Tenist(String name, String nickname, int yearBirth, String yearCity,
			String residenceCity, int isActive) {
		this.name = name;
		this.nickname = nickname;
		this.yearBirth = yearBirth;
		this.yearCity = yearCity;
		this.residenceCity = residenceCity;
		this.isActive = isActive;
	}

	public String getName() {
		return name;
	}

	public int getYearBirth() {
		return yearBirth;
	}

	public String getYearCity() {
		return yearCity;
	}

	public String getResidenceCity() {
		return residenceCity;
	}

	public int isActive() {
		return isActive;
	}


	public String getNickname() {
		return nickname;
	}

}