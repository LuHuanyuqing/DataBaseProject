package com.lqh.sys.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author luqiheng
 * @since 2023-07-03
 */
public class Relation implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer priId;

    private Integer secId;

    private String relation;

    private Integer deleted;

    public Integer getPriId() {
        return priId;
    }

    public void setPriId(Integer priId) {
        this.priId = priId;
    }
    public Integer getSecId() {
        return secId;
    }

    public void setSecId(Integer secId) {
        this.secId = secId;
    }
    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Relation{" +
            "priId=" + priId +
            ", secId=" + secId +
            ", relation=" + relation +
            ", deleted=" + deleted +
        "}";
    }
}
