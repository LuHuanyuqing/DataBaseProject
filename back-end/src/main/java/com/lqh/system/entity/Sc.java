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
public class Sc implements Serializable {

    private static final long serialVersionUID = 1L;

    private String sno;

    private String cno;

    private Float grade;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }
    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }
    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Sc{" +
            "sno=" + sno +
            ", cno=" + cno +
            ", grade=" + grade +
        "}";
    }
}
