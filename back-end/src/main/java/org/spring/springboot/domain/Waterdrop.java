package org.spring.springboot.domain;

public class Waterdrop {
    private Integer id;

    private String imagee;

    private String fort;

    private Integer fortid;

    private String name;

    private String gender;

    private String birthday;

    private String father;

    private Integer fatherid;

    private String mother;

    private Integer motherid;

    private String consort;

    private Integer consortid;

    private String createtime;

    private String updatetime;

    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImagee() {
        return imagee;
    }

    public void setImagee(String imagee) {
        this.imagee = imagee == null ? null : imagee.trim();
    }

    public String getFort() {
        return fort;
    }

    public void setFort(String fort) {
        this.fort = fort == null ? null : fort.trim();
    }

    public Integer getFortid() {
        return fortid;
    }

    public void setFortid(Integer fortid) {
        this.fortid = fortid;
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

    public String getConsort() {
        return consort;
    }

    public void setConsort(String consort) {
        this.consort = consort == null ? null : consort.trim();
    }

    public Integer getConsortid() {
        return consortid;
    }

    public void setConsortid(Integer consortid) {
        this.consortid = consortid;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}