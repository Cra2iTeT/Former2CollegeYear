## 注解说明：
1. @autowired：自动装配通过类型、名字
    + 如果不能唯一自动装配上属性，则需要通过@Qualifier(value = "xxx")
2. @Nulable：字段标记了这个注释，说明这个字段可以为null
3. @Resource：自动装配通过名字、类型
4. @Component：组件，放在类上，说明这个类被Spring管理了，就是bean
5. 