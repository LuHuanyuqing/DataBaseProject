package com.lqh.system.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author luqiheng
 * @since 2023-06-23
 */
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    private String cno;

    private String cname;

    private String cpno;

    private Integer ccredit;

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
    public String getCpno() {
        return cpno;
    }

    public void setCpno(String cpno) {
        this.cpno = cpno;
    }
    public Integer getCcredit() {
        return ccredit;
    }

    public void setCcredit(Integer ccredit) {
        this.ccredit = ccredit;
    }

    @Override
    public String toString() {
        return "Course{" +
            "cno=" + cno +
            ", cname=" + cname +
            ", cpno=" + cpno +
            ", ccredit=" + ccredit +
        "}";
    }
}
