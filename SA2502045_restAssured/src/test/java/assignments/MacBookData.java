package assignments;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MacBookData {

	private int year;
	private double price;

	@JsonProperty("CPUmodel")
	private String cpuModel;

	@JsonProperty("Harddisk size")
	private String harddiskSize;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCpuModel() {
		return cpuModel;
	}

	public void setCpuModel(String cpuModel) {
		this.cpuModel = cpuModel;
	}

	public String getHarddiskSize() {
		return harddiskSize;
	}

	public void setHarddiskSize(String harddiskSize) {
		this.harddiskSize = harddiskSize;
	}

}
