
public class ManagementCompany {
	private int MAX_PROPERTY = 5;
	private double mgmFeePer;
	private String name;
	private Property[] properties;
	private String taxID;
	private int MGMT_WIDTH = 10;
	private int MGMT_DEPTH = 10;
	private Plot plot;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMgmFeePer() {
		return mgmFeePer;
	}

	public void setMgmFeePer(double mgmFeePer) {
		this.mgmFeePer = mgmFeePer;
	}

	public String getTaxID() {
		return taxID;
	}

	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}

	public Plot getPlot() {
		return plot;
	}

	public Plot setPlot(int x, int y, int width, int depth) {
		plot = new Plot(x, y, width, depth);
		return plot;
	}

	public int getMGMT_WIDTH() {
		return MGMT_WIDTH;
	}

	public int getMGMT_DEPTH() {
		return MGMT_DEPTH;
	}

	public ManagementCompany() {
		this.name = "";
		this.taxID = "";
		this.mgmFeePer = 0;
		this.plot = new Plot(0, 0, 10, 10);
		properties = new Property[MAX_PROPERTY];
	}

	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.properties = new Property[MAX_PROPERTY];
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}

	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.properties = new Property[MAX_PROPERTY];
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.plot = new Plot(x, y, width, depth);
	}

	public ManagementCompany(ManagementCompany otherCompany) {
		this.properties = new Property[MAX_PROPERTY];
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFeePer = otherCompany.mgmFeePer;
		this.plot = new Plot(otherCompany.plot);
	}

	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}

	public int addProperty(Property property) {
		if (property == null) {
			return -2;
		}
		if (!plot.encompasses(property.getPlot())) {
			return -3;
		}
		for (int i = 0; i < properties.length; i++) {
			if (properties[i] != null) {
				if (properties[i].getPlot().overlaps(property.getPlot())) {
					return -4;
				}
			} else {
				properties[i] = property;
				return i;
			}
		}
		return -1;
	}

	public int addProperty(String name, String city, double rent, String owner) {
		Property property = new Property(name, city, rent, owner);
		if (property == null) {
			return -2;
		}
		if (!plot.encompasses(property.getPlot())) {
			return -3;
		}
		for (int i = 0; i < properties.length; i++) {
			if (properties[i] != null) {
				if (properties[i].getPlot().overlaps(property.getPlot())) {
					return -4;
				}
			} else {
				properties[i] = property;
				return i;
			}
		}
		return -1;
	}

	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		Property property = new Property(name, city, rent, owner);
		if (property == null) {
			return -2;
		}
		if (!plot.encompasses(property.getPlot())) {
			return -3;
		}
		for (int i = 0; i < properties.length; i++) {
			if (properties[i] != null) {
				if (properties[i].getPlot().overlaps(property.getPlot())) {
					return -4;
				}
			} else {
				properties[i] = property;
				return i;
			}
		}
		return -1;
	}

	public double totalRent() {
		double total = 0.0;
		for (Property property : properties) {
			if (property == null) {
				break;
			}
			total += property.getRentAmount();
		}
		return total;
	}

	public double maxRentProp() {
		double maxRentAmount = 0.0;
		maxRentAmount = properties[maxRentPropertyIndex()].getRentAmount();
		return maxRentAmount;
	}

	public int maxRentPropertyIndex() {
		int index = 0;
		for (int i = 0; i < properties.length; i++) {
			if (properties[i] == null) {
				break;
			}
			if (properties[i].getRentAmount() >= properties[index].getRentAmount()) {
				index = i;
			}
		}
		return index;
	}

	public String displayPropertyAtIndex(int i) {
		String string = properties[i].toString();
		return string;
	}

	public String toString() {
		String output = "List of the properties for " + name + ", taxID: " + taxID + "\n___________________________________\n";
		for (int i = 0; i < MAX_PROPERTY; i++) {
			if (properties[i] == null) {
				break;
			}
			output += properties[i].toString() + "\n";
		}
		output += "\n" + "___________________________________\ntotal " + "management Fee: " + (totalRent() * mgmFeePer / 100);
		return output;
	}
}