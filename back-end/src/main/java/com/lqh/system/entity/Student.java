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
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private String sno;

    private String sname;

    private String ssex;

    private Integer sage;

    private String sdept;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }
    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }
    public String getSdept() {
        return sdept;
    }

    public void setSdept(String sdept) {
        this.sdept = sdept;
    }

    @Override
    public String toString() {
        return "Student{" +
            "sno=" + sno +
            ", sname=" + sname +
            ", ssex=" + ssex +
            ", sage=" + sage +
            ", sdept=" + sdept +
        "}";
    }
}
