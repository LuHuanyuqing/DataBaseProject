package com.lqh.sys.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author luqiheng
 * @since 2023-07-03
 */
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer priId;

    private Integer secId;

    private LocalDateTime data;

    private String describe;

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
    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Event{" +
            "priId=" + priId +
            ", secId=" + secId +
            ", data=" + data +
            ", describe=" + describe +
            ", deleted=" + deleted +
        "}";
    }
}
