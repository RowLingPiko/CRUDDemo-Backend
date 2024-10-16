package cn.voidtech.cruddemo.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author RowLingKaslana
 * @project CRUDDemo
 * @date 2024/10/15 17:45
 * This is the honor of the Kaslana!!!!
 * 願 人 類 榮 耀 長 存
 * 人 类 に 栄 光 あ れ
 * Glory to mankind！
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {
    @NotBlank(message = "昵称不能为空")
    @Size(min = 2, max = 16, message = "昵称长度在2-16位之间")
    private String nickname;

    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;

    @NotBlank(message = "密码不能为空")
    @Size(min = 6, max = 16, message = "密码长度在6-16位之间")
    private String password;
}
