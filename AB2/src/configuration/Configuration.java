package configuration;

import finder.Finder;

public class Configuration {

	private int amount;
	private int expansions;
	private int minCost;
	private int maxCost;
	private int cpuTime;
	private Finder finder = null;

	public Configuration(int amount, int expansions, int minCost, int maxCost,
			int cpuTime, Finder finder) {
		this.amount = amount;
		this.expansions = expansions;
		this.minCost = minCost;
		this.maxCost = maxCost;
		this.cpuTime = cpuTime;
		this.finder = finder;

		System.out.println("Configuration: " + " Amount= " + amount
				+ " Expansions= " + expansions + " MinCost= " + minCost
				+ " MaxCost= " + maxCost + " CPUTime= " + cpuTime + " Finder= "
				+ finder);
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getExpansions() {
		return expansions;
	}

	public void setExpansions(int expansions) {
		this.expansions = expansions;
	}

	public int getMinCost() {
		return minCost;
	}

	public void setMinCost(int minCost) {
		this.minCost = minCost;
	}

	public int getMaxCost() {
		return maxCost;
	}

	public void setMaxCost(int maxCost) {
		this.maxCost = maxCost;
	}

	public int getCpuTime() {
		return cpuTime;
	}

	public void setCpuTime(int cpuTime) {
		this.cpuTime = cpuTime;
	}

	public Finder getFinder() {
		return finder;
	}

	public void setFinder(Finder finder) {
		this.finder = finder;
	}

	@Override
	public String toString() {
		return "Configuration [amount=" + amount + ", expansions=" + expansions
				+ ", minCost=" + minCost + ", maxCost=" + maxCost
				+ ", cpuTime=" + cpuTime + ", finder=" + finder + "]";
	}

}
