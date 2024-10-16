package cn.voidtech.cruddemo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户表 实体类。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "user")
public class UserEntity {

    /**
     * 唯一标识
     */
    @Id(keyType = KeyType.Auto)
    private Integer id;

    /**
     * 昵称
     */
    @Column(value = "nickname")
    private String nickname;

    /**
     * 邮箱
     */
    @Column(value = "email")
    private String email;

    /**
     * 密码(已加密)
     */
    @Column(value = "password")
    private String password;

    /**
     * 创建时间
     */
    @Column(value = "createTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(value = "updateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date updateTime;

    /**
     * 是否删除
     */
    @Column(value = "delete")
    private Boolean delete;


}
