package cn.voidtech.cruddemo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author RowLingKaslana
 * @project CRUDDemo
 * @date 2024/10/15 21:41
 * This is the honor of the Kaslana!!!!
 * 願 人 類 榮 耀 長 存
 * 人 类 に 栄 光 あ れ
 * Glory to mankind！
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IDDto implements Serializable {
    private Integer id;
}
