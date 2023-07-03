package com.lqh.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author luqiheng
 * @since 2023-07-03
 */
@TableName("family_user")
public class FamilyUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer familyId;

    private Integer userId;

    private Integer deleted;

    public Integer getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Integer familyId) {
        this.familyId = familyId;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "FamilyUser{" +
            "familyId=" + familyId +
            ", userId=" + userId +
            ", deleted=" + deleted +
        "}";
    }
}
