package org.spring.springboot.domain;

public class Member {
	private Integer id;

	private String avatar;

	private String family;

	private Integer familyid;

	private String name;

	private String gender;

	private String birthday;

	private String father;

	private Integer fatherid;

	private String mother;

	private Integer motherid;

	private String spouses;

	private Integer spousesid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar == null ? null : avatar.trim();
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender == null ? null : gender.trim();
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday == null ? null : birthday.trim();
	}

	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father == null ? null : father.trim();
	}

	public Integer getFatherid() {
		return fatherid;
	}

	public void setFatherid(Integer fatherid) {
		this.fatherid = fatherid;
	}

	public String getMother() {
		return mother;
	}

	public void setMother(String mother) {
		this.mother = mother == null ? null : mother.trim();
	}

	public Integer getMotherid() {
		return motherid;
	}

	public void setMotherid(Integer motherid) {
		this.motherid = motherid;
	}

	public String getSpouses() {
		return spouses;
	}

	public void setSpouses(String spouses) {
		this.spouses = spouses == null ? null : spouses.trim();
	}

	public Integer getSpousesid() {
		return spousesid;
	}

	public void setSpousesid(Integer spousesid) {
		this.spousesid = spousesid;
	}
}