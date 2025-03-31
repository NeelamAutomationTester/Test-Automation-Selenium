package com.ui.pojo;

public class AddressPojo {

	private String companyName;
	private String address1;
	private String address2;
	private String cityName;
	private String postcode;
	private String homePhone;
	private String mobilePhone;
	private String additionalInfo;
	private String addressAlias;
	private String stateName;

	public AddressPojo(String companyName, String address1, String address2, String cityName, String postcode,
			String homePhone, String mobilePhone, String additionalInfo, String addressAlias, String stateName) {
		super();
		this.companyName = companyName;
		this.address1 = address1;
		this.address2 = address2;
		this.cityName = cityName;
		this.postcode = postcode;
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.additionalInfo = additionalInfo;
		this.addressAlias = addressAlias;
		this.stateName = stateName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getAddress1() {
		return address1;
	}

	public String getAddress2() {
		return address2;
	}

	public String getCityName() {
		return cityName;
	}

	public String getPostcode() {
		return postcode;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public String getAddressAlias() {
		return addressAlias;
	}

	public String getStateName() {
		return stateName;
	}

	@Override
	public String toString() {
		return "AddressPojo [companyName=" + companyName + ", address1=" + address1 + ", address2=" + address2
				+ ", cityName=" + cityName + ", postcode=" + postcode + ", homePhone=" + homePhone + ", mobilePhone="
				+ mobilePhone + ", additionalInfo=" + additionalInfo + ", addressAlias=" + addressAlias + ", stateName="
				+ stateName + "]";
	}

}
