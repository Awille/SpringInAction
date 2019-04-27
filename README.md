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


## chapter3 --高级装填
### 3.1 环境与profile
在不同的环境之下，可能同样的bean会有不同的形态，比如数据库连接DataSource Beand对象。
* JNDI (Java Name Directory Interface), 可以分离程程序与数据里的连接，
将数据库配置放于资源文件当中，让程序与数据库的配置解耦。
* 在java的配置当中，可以用注解@Profile注解指定某个bean属于哪一个profile
* 这节当中也写了怎么设置profile，`Spring.profiles.active`与
`Spring.profiles.default`属性。

### 3.2 条件化的bean
Srping4之后，可以设置条件化bean，类似于希望某个bean只有在应用的类路径下
包含某个特定的库，或者某些bean只有在存在一些bean的情况下才创建，或者某些
bean只有在特定的环境变量下才创建。此时可以采用@Conditional注解。Conditional
注解中指定的类可以是任意实现了Condition接口的类，spring会检测condition实例
是否返回ture决定是否在容器中实例化该bean。@Profile注解也是用@Conditional
实现的。

### 3.3 处理自定义装配的歧义性
这一章节过户，我们直接记住这一章节的处理方法就好了，之前章节提到的自动装配
总是感觉有一些不靠谱，还不如采用这种显示配置的方式，减少错误的可能。









