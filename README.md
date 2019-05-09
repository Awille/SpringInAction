# SpringInAction
Spring In Action 项目代码
## Chapter2 - 装填Bean
### 2.2 自动化装配bean
* Spring context会为所有的bean定一个id，如果是自动自动化装配的bean，默认的Id为
类名(第一个字母变成小写)。如果想在自动装填中手动设置，则在Annotation 
`@Component`当中传入（以后尽量采用这种方式）。注解`@Named`可以实现同样的功能。
* Spring中配置类的`@ComponentScan`可以指定一个或者多个基础包，可以是字符串
格式，也可以是类名格式。
* `@AutoWired()`会自动装填尽可能匹配的bean，但可能发现歧义，在其中指定属性
required = false的时候，当没有合适的bean的时候回跳过装填，注意以后调用
出现的空指针问题。 @Inject和@AutoWired()大部分时候可以进行替换，细微差别
以后在查看。
* Spring 中的bean默认是单例实现的
* XML配置bean当中，使用DI的方法有两种，一个是`<constructor-arg>`， 另一个
`是c-命名空间`。


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
bean只有在特定的环境变量下才创建。此时可以采用`@Conditional`注解。Conditional
注解中指定的类可以是任意实现了Condition接口的类，spring会检测condition实例
是否返回ture决定是否在容器中实例化该bean。`@Profile`注解也是用@Conditional
实现的。

### 3.3 处理自定义装配的歧义性
这一章节过户，我们直接记住这一章节的处理方法就好了，之前章节提到的自动装配
总是感觉有一些不靠谱，还不如采用这种显示配置的方式，减少错误的可能。
以下是几种歧义的解决方案
* 标志首选bean，将几个相同类型的bean设置一个为首选，那么spring装填的时候
就会采用该手写bean。通过`@Primary`注解可以标注首选bean。该注解既可以在java
显示配置中使用、也可以在直接在源类上使用。如果在xml中则让primary属性为true。

* 限定自动装配bean(如果是我，以后就会一直使用这种方式、从根本上避免了歧义。
在类的set方法中装配的时候，配合`@AutoWired`，使用`@Qualifier("beanId")`来
显示装填，避免了歧义。`@Qualifier("beanId")`中的值既可以使用beanId，也可以
使用限定符，限定符可在装填的时候或者在类定义的时候进行设定，系统默认的限定
符与beanId相同。

### 3.4 bean的作用域
bean的作用域分为四种，`Singleton`在整个应用中只创建一个bean实例，默认也是
这个, `Prototype`每次注入或者通过上下文获取bean的时候都会创建一个实例, 
`Session`在web应用中，每个会话建立一个bean实例, `Request`在web应用当中，
为每个请求创建一个web实例。

作用域的声明方式为：在类的声明或者bean配置当中使用`@Scope("作用域")`, 
作用域的选择可以使用`ConfigurableBeanFactory.SCOPE_PROTOTYPE`来指定，
避免出错。

* 会话作用域一般运用于购物车等，与用户强关联，在一次会话汇总使用同一个购物车。
即在一个会话中，购物车是以单例模式存在的。
* `@Scope`中的proxyMode属性，用于解决将会话作用域的bean注入到单例的bean中
会出现的问题。比如在购物车当中，每个会话开启都在businessService注入购物车
实例，首先这个实例在没有会话的时候就没注入，businessService对整个应用来说
是单例模式存在的。使用`@Scope` 下图的功能。`@Scope`内的属性值有两个，一个是
`proxyMode = ScopedProxyMode.INTERFACES`这个值表示该类是一个接口类型，
这也是我们所期待的，当然也可以是单纯的class类型，则值采用
`ScopedProxyMode.TARGET_CLASS`
\<img src="https://github.com/Awille/SpringInAction/blob/master/src/main/resources/readimg/scope_proxymode.PNG" width="400" hegiht="313" align=center />
* 在xml实现以上代理模式，则用aop命名空间，首先scope属性赋值，然后用aop
命名空间，然后通过调节proxy-target-class属性为true或者false来设置这是
接口类型还是单纯的类类型。

### 3.5 运行时的依赖注入
某些bean构造器传入的参数我们希望是运行的时候才确定的。spring提供了两种
方式来实现，一个是属性占位符(Property placeholder),另一个是spring表达式
语言。该章节的内容快速过了一下，以后细节可以再倒回来看。


## chapter4 - 面向切面的Spring
之前的章节都是在对依赖注入做一些解释，这里我们开始关注spring原理的第二大
部分-AOP（Aspect Oriented Programming）
### 4.1 面向切面编程的概念
* AOP术语：advice(通知，指切面要完成的工作)， pointcut（切点），
join point（连接点），aspect(切面)， 引入（Introduction），
织入（weaving）。
织入的三种时机：
1、编译器，需要特殊的编译器支持，如AspectJ的织入编译器
2、类加载时期：切面在目标类加载在JVM时织入，这种方式需要特殊的
类加载器，AspectJ5的加载时织入(load-time weaving)可以支持该种
方式织入切面。
3、运行期：切面在应用运行的某个时刻被织入。一般在织入切面是，
AOP容器会为目标对形象动态的创建一个代理对象。SpringAOP为经典例子。
* Spring AOP框架，spring通知都是java编写的。Spring在运行时通知对象，
spring只支持方法级别的连接点。
*截止Spring 的AOP命名空间，我们可以将纯POJO住转换为切面，这种方式
需要使用XML来进行配置。


### 4.2 通过切点来选择连接点
* AspectJ 推荐书籍  AspectJ in Action











