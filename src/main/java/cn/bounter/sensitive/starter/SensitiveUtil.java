package cn.bounter.sensitive.starter;

import org.apache.commons.lang.StringUtils;

/**
 * 数据脱敏工具类
 */
public class SensitiveUtil {

    /**
     * 【姓名】名字为2个汉字时只显示第一个汉字，大于2个汉字时，只显示首尾2个汉字，其他隐藏为2个星号
     *  如：赵*，刘*华，欧**恭
     * @param fullName
     * @return
     */
    public static String name(String fullName) {
        String result = null;
        if(StringUtils.length(fullName) == 2) {
            String name = StringUtils.left(fullName, 1);
            result = StringUtils.rightPad(name, StringUtils.length(fullName), "*");
        } else if (StringUtils.length(fullName) > 2) {
            String first = StringUtils.left(fullName, 1);
            String last = StringUtils.right(fullName, 1);
            String mid = fullName.substring(1, fullName.length() - 1);
            result = first + mid.replaceAll("([\\s\\S])", "*") + last;
        } else {
            result = fullName;
        }
        return result;
    }

    /**
     * 【身份证号】显示前6后4，其他隐藏
     *  如：320125******1034
     * @param id
     * @return
     */
    public static String idCardNum(String id) {
        if (StringUtils.isBlank(id)) {
            return "";
        }
        return StringUtils.left(id, 6).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(id, 4), StringUtils.length(id), "*"), "******"));
    }

    /**
     * 【固定电话】显示后四位，其他隐藏，如：*******5011
     * @param num
     * @return
     */
    public static String fixedPhone(String num) {
        if (StringUtils.isBlank(num)) {
            return "";
        }
        return StringUtils.leftPad(StringUtils.right(num, 4), StringUtils.length(num), "*");
    }

    /**
     * 【手机号码】前三位，后四位，其他隐藏，如：150****0910
     *
     * @param num
     * @return
     */
    public static String mobilePhone(String num) {
        if (StringUtils.isBlank(num)) {
            return "";
        }
        return StringUtils.left(num, 3).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(num, 4), StringUtils.length(num), "*"), "***"));
    }

    /**
     * 【地址】只显示到地区，不显示详细地址，比如：北京市海淀区****
     *
     * @param address
     * @param sensitiveSize 敏感信息长度
     * @return
     */
    public static String address(String address, int sensitiveSize) {
        if (StringUtils.isBlank(address)) {
            return "";
        }
        int length = StringUtils.length(address);
        return StringUtils.rightPad(StringUtils.left(address, length - sensitiveSize), length, "*");
    }

    /**
     * 【电子邮箱】 邮箱前缀仅显示第一个字母和最后一个字母，其他用星号代替，@及后面的地址显示，比如：s*******o@qq.com
     *
     * @param email
     * @return
     */
    public static String email(String email) {
        if (StringUtils.isBlank(email)) {
            return "";
        }
        int index = StringUtils.indexOf(email, "@");
        if (index <= 1) {
            return email;
        } else {
            return StringUtils.rightPad(StringUtils.left(email, 1), index, "*").concat(StringUtils.mid(email, index - 1, StringUtils.length(email)));
        }
    }

    /**
     * 【银行卡号】前六位，后四位，其他用星号隐藏每位1个星号，比如：6222600**********1234
     *
     * @param cardNum
     * @return
     */
    public static String bankCard(String cardNum) {
        if (StringUtils.isBlank(cardNum)) {
            return "";
        }
        return StringUtils.left(cardNum, 6).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(cardNum, 4), StringUtils.length(cardNum), "*"), "******"));
    }

    /**
     * 【密码】密码的全部字符都用*代替，比如：******
     *
     * @param password
     * @return
     */
    public static String password(String password) {
        if (StringUtils.isBlank(password)) {
            return "";
        }
        String pwd = StringUtils.left(password, 0);
        return StringUtils.rightPad(pwd, StringUtils.length(password), "*");
    }

    /**
     * 【车牌号】前两位后一位，比如：苏A****X
     *
     * @param carNumber
     * @return
     */
    public static String carNumber(String carNumber) {
        if (StringUtils.isBlank(carNumber)) {
            return "";
        }
        return StringUtils.left(carNumber, 2).
                concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(carNumber, 1), StringUtils.length(carNumber), "*"), "**"));

    }
}
