package org.spring.springboot.domain;

public class Taste {
    private Integer id;

    private String waterdrop;

    private Integer waterdropid;

    private String content;

    private String fort;

    private Integer fortid;

    private String createtime;

    private String updatetime;

    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWaterdrop() {
        return waterdrop;
    }

    public void setWaterdrop(String waterdrop) {
        this.waterdrop = waterdrop == null ? null : waterdrop.trim();
    }

    public Integer getWaterdropid() {
        return waterdropid;
    }

    public void setWaterdropid(Integer waterdropid) {
        this.waterdropid = waterdropid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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