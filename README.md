# SpringInAction
Spring In Action 项目代码
## Chapter2 - 装填Bean
### 2.2 自动化装配bean
* Spring context会为所有的bean定一个id，如果是自动自动化装配的bean，默认的Id为
类名(第一个字母变成小写)。如果想在自动装填中手动设置，则在Annatation 
@Component当中传入。注解@Named可以实现同样的功能。
* Spring中配置类的@ComponentScan可以指定一个或者多个基础包，可以是字符串
格式，也可以是类名格式。
* @AutoWired()会自动装填尽可能匹配的bean，但可能发现歧义，在其中指定属性
required = false的时候，当没有合适的bean的时候回跳过装填，注意以后调用
出现的空指针问题。 @Inject和@AutoWired()大部分时候可以进行替换，细微差别
以后在查看。
* Spring 中的bean默认是单例实现的
* XML配置bean当中，使用DI的方法有两种，一个是<constructor-arg>， 另一个
是c-命名空间

