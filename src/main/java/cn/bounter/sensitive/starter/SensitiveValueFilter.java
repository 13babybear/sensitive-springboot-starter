package cn.bounter.sensitive.starter;

import com.alibaba.fastjson.serializer.ValueFilter;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;

/**
 * FastJson脱敏过滤器
 */
public class SensitiveValueFilter implements ValueFilter {

    @Override
    public Object process(Object object, String name, Object value) {
        if (!(value instanceof String) || StringUtils.isEmpty(value)) {
            return value;
        }

        Field field = null;
        try {
            field = object.getClass().getDeclaredField(name);
        } catch (NoSuchFieldException e) {
            return value;
        }
        Sensitive sensitive = field.getAnnotation(Sensitive.class);
        if (String.class != field.getType() || sensitive == null) {
            return value;
        }
        String valueStr = (String) value;
        SensitiveTypeEnum type = sensitive.value();
        switch (type) {
            case NAME:
                return SensitiveUtil.name(valueStr);
            case ID_CARD:
                return SensitiveUtil.idCardNum(valueStr);
            case FIXED_PHONE:
                return SensitiveUtil.fixedPhone(valueStr);
            case MOBILE_PHONE:
                return SensitiveUtil.mobilePhone(valueStr);
            case ADDRESS:
                return SensitiveUtil.address(valueStr, 8);
            case EMAIL:
                return SensitiveUtil.email(valueStr);
            case BANK_CARD:
                return SensitiveUtil.bankCard(valueStr);
            case PASSWORD:
                return SensitiveUtil.password(valueStr);
            case CAR_NUMBER:
                return SensitiveUtil.carNumber(valueStr);
            default:
        }

        return value;
    }
}
