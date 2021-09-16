package cn.bounter.sensitive.starter;

/**
 * 数据脱敏类型枚举
 */
public enum SensitiveTypeEnum {

    /** 姓名，如：赵*，刘*华  */
    NAME,
    /** 手机号，如：150****0910 */
    MOBILE_PHONE,
    /** 座机号，如：*******5011 */
    FIXED_PHONE,
    /** 身份证号，如：320125********1034 */
    ID_CARD,
    /** 邮箱，如：1******0@qq.com */
    EMAIL,
    /** 银行卡，如：6222600**********1234 */
    BANK_CARD,
    /** 车牌号，如：苏A****X */
    CAR_NUMBER,
    /** 地址，如：武汉市洪山区***** */
    ADDRESS,
    /** 密码，如：****** */
    PASSWORD;
}
