# sensitive-springboot-starter
轻量级的数据脱敏解决方案
### 快速使用
##### 一、 引入starter包
```xml
<dependency>
    <groupId>cn.bounter</groupId>
    <artifactId>sensitive-springboot-starter</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```
   
   
##### 二、对象字段上加入脱敏注解
```java
@Data
public class User {

    private Long id;

    @Sensitive(SensitiveTypeEnum.NAME)
    private String username;

    @Sensitive(SensitiveTypeEnum.PASSWORD)
    private String password;

    private Integer age;

    @Sensitive(SensitiveTypeEnum.ID_CARD)
    private String idCard;

    @Sensitive(SensitiveTypeEnum.MOBILE_PHONE)
    private String mobilePhone;

    @Sensitive(SensitiveTypeEnum.EMAIL)
    private String email;

    @Sensitive(SensitiveTypeEnum.BANK_CARD)
    private String bankCard;

    @Sensitive(SensitiveTypeEnum.CAR_NUMBER)
    private String carNumber;

    @Sensitive(SensitiveTypeEnum.ADDRESS)
    private String address;

}
```

##### 三、FastJson配置中加入脱敏过滤器
```java
@Configuration
public class FastjsonConfig {

    @Autowired
    private SensitiveValueFilter sensitiveValueFilter;

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        // 需要定义一个convert转换消息的对象;
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        // 添加fastJson的配置信息;
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //  添加自定义的脱敏过滤器
        fastJsonConfig.setSerializeFilters(sensitiveValueFilter);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        return new HttpMessageConverters(fastJsonHttpMessageConverter);
    }
}
```
