package cn.voidtech.cruddemo.config;

import com.mybatisflex.core.FlexGlobalConfig;
import com.mybatisflex.spring.boot.MyBatisFlexCustomizer;
import org.springframework.context.annotation.Configuration;

/**
 * @author RowLingKaslana
 * @project CRUDDemo
 * @date 2024/10/15 20:18
 * This is the honor of the Kaslana!!!!
 * 願 人 類 榮 耀 長 存
 * 人 类 に 栄 光 あ れ
 * Glory to mankind！
 */
@Configuration
public class MybatisFlexConfig implements MyBatisFlexCustomizer {
    @Override
    public void customize(FlexGlobalConfig flexGlobalConfig) {
        flexGlobalConfig.setLogicDeleteColumn("delete");
    }
}
