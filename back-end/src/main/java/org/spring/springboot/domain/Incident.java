package org.spring.springboot.domain;

public class Incident {
	private Integer id;

	private String memberr;

	private Integer memberrid;

	private String eventdescription;

	private String family;

	private Integer familyid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMemberr() {
		return memberr;
	}

	public void setMemberr(String memberr) {
		this.memberr = memberr == null ? null : memberr.trim();
	}

	public Integer getMemberrid() {
		return memberrid;
	}

	public void setMemberrid(Integer memberrid) {
		this.memberrid = memberrid;
	}

	public String getEventdescription() {
		return eventdescription;
	}

	public void setEventdescription(String eventdescription) {
		this.eventdescription = eventdescription == null ? null : eventdescription.trim();
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family == null ? null : family.trim();
	}

	public Integer getFamilyid() {
		return familyid;
	}

	public void setFamilyid(Integer familyid) {
		this.familyid = familyid;
	}
}