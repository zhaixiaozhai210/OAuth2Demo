package com.example.authorization.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * id bigint(20) NOT NULL AUTO_INCREMENT,
 *   parent_id bigint(20) DEFAULT NULL COMMENT '父角色',
 *   name varchar(64) NOT NULL COMMENT '角色名称',
 *   enname varchar(64) NOT NULL COMMENT '角色英文名称',
 *   description varchar(200) DEFAULT NULL COMMENT '备注',
 *   created datetime NOT NULL,
 *   updated datetime NOT NULL,
 */
@Entity
@Table(name = "tb_role")
public class Role implements Serializable {

    public static final long serialVersionUID =1L;

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    @Column(length = 32, name = "id")
    private String id;

    /**
     * 上級角色
     */
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Role parentRole;

    @Column(length = 64, name = "name")
    private String name;

    @Column(length = 64, name = "en_name")
    private String enName;

    @Column(length = 200, name = "description")
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "create_time")
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "update_time")
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Role getParentRole() {
        return parentRole;
    }

    public void setParentRole(Role parentRole) {
        this.parentRole = parentRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
