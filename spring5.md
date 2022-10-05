[TOC]

---

1.Spring概念
============

Spring是轻量级的开源JavaEE框架

Spring可以解决企业应用的开发的复杂性

1.1.Spring两个核心部分
----------------------

IOC、Aop

IOC：控制反转，把创建对象的过程交给Spring管理

Aop：面向切面，在不修改源代码的情况下进行功能的增强

1.2.特点
--------

1.  方便解耦，简化开发

2.  Aop编程支持

3.  方便程序测试

4.  方便和其他框架整合

5.  降低JavaAPI的开发难度

6.  方便进行事务操作

2.Jar包
=======

spring5相关jar包

![image-20220927222138218](C:\Users\AbleLynn\AppData\Roaming\Typora\typora-user-images\image-20220927222138218.png)

注解方式相关jar包

![image-20220927222144257](C:\Users\AbleLynn\AppData\Roaming\Typora\typora-user-images\image-20220927222144257.png)

3.IOC容器
=========

IOC：控制反转。把对象的创建和对象之间的调用过程，交给Spring进行管理，使用IOC的目的是降低耦合度。

3.1.IOC底层原理
---------------

IOC过程，xml解析、工厂模式(降低耦合度的最低限度)、反射

![image-20220927222154428](C:\Users\AbleLynn\AppData\Roaming\Typora\typora-user-images\image-20220927222154428.png)

优势：例如需要创建多个dao包的类，只需要在xml中配置相应类的bean标签，然后调用UserFactory类即可，降低了耦合度。

3.2.IOC接口(BeanFactory)
------------------------

IOC思想基于IOC容器完成，IOC容器底层就是对象工厂

### Spring提供了IOC容器的两种方式(两个接口)

#### BeanFactory

IOC容器基本实现，是Spring内部使用的接口，不提供开发人员使用

特点：加载配置文件时不会创建对象，在获取、使用对象时才创建对象

#### ApplicationContext

BeanFactory接口的子接口，提供更多的功能，一般由开发人员使用

特点：在加载配置文件时就会把配置文件里的对象创建

两个实现类的特点

1.  FileSystemXmlApplicationContext

    a.  需要写类文件在系统盘的路径

2.  ClassPathXmlApplicationContext

    b.  需要写类文件在src下的路径

3.3.Bean管理
------------

1.  Bean 管理指的是两个操作

    a.  Spring 创建对象

    b.  Spirng 注入属性

2.  Bean 管理操作有两种方式

    a.  基于 xml 配置文件方式实现

    b.  基于注解方式实现

3.4.IOC操作Bean管理(基于xml)
----------------------------

### 基于xml方式创建对象

- ```xml
  <!\--配置xxx对象创建\--\>
  \<bean id=\"x\" class=\"xxx的地址\"\>\</bean\>
  ```

在Spring配置文件中使用bean标签，标签内添加对应属性，即可实现创建对象

#### bean标签中的属性

1.  id：唯一标识

2.  class：类的全路径(包类路径)

#### 特点

创建对象时，默认执行无参构造方法完成对象创建

### 基于xml方式注入属性

DI：依懒注入，即注入属性

#### 使用set方法注入

1.  在类中创建属性

2.  在类中创建属性对应的set方法

3.  在Spring配置文件中配置对象创建，配置属性注入

#### 使用有参构造方法注入

1.  在类中创建属性

2.  在类中创建属性对应的有参构造方法

3.  在Spring配置文件中配置对象创建，配置属性注入

#### p名称空间注入(了解)

使用p名称空间注入，可以简化基于xml配置方法

### 基于xml方式注入其他类型属性

#### 字面量

1.  设置null值

    a.  \<property name=\"属性名\"\>\<null/\>\</property\>

2.  属性值包含特殊符号

    a.  使用CDATA

- ```xml
          <!--设置bAddress属性值包含特殊符号
              方式一 把<>转义
              方式二 把特殊符号内容写到CDATA
          -->
          <property name="bAddress">
              <value><![CDATA[<<地址>>]]></value>
          </property>
  ```

#### 注入属性-外部bean

1.  创建两个类service类和dao类

2.  在service类创建dao类对象，生成set方法

3.  在Spring配置文件中配置对象创建，配置属性注入

- ```xml
      <!--4.外部bean，service和dao对象创建-->
      <bean id="userService" class="cn.demo1.service.UserService">
          <!--注入userDao对象
              name属性：类里面属性名称
              ref属性：创建userDao对象bean标签id值
          -->
          <property name="userDao" ref="userDaoImpl"></property>
      </bean>
      <bean id="userDaoImpl" class="cn.demo1.dao.Impl.UserDaoImpl"></bean>
  ```

#### 注入属性-内部bean

1.  一对多关系

eg：部门与员工，一个部门有多个员工，一个员工属于一个部门

2.  在实体类中表示一对多的关系，员工表示所属部门，使用对象类型进行表示

3.  在Spring配置文件中配置

- ```xml
      <!--5.内部bean，一对多关系-->
      <bean id="emp" class="cn.demo1.bean.Emp">
          <!--设置两个普通的属性-->
          <property name="eName" value="姓名"></property>
          <property name="eGender" value="性别"></property>
          <!--内部bean对象属性-->
          <property name="dept">
              <bean id="dept" class="cn.demo1.bean.Dept">
                  <property name="dName" value="部门名称"></property>
              </bean>
          </property>
      </bean>
  ```

#### 注入属性-级联赋值

- ```xml
  	 <!--6.级联赋值-->
       <bean id="emp_1" class="cn.demo1.bean.Emp">
          <!--设置两个普通的属性-->
          <property name="eName" value="姓名"></property>
          <property name="eGender" value="性别"></property>
          <!--级联赋值-->
          <property name="dept" ref="dept_1"></property>
      </bean>
      <bean id="dept_1" class="cn.demo1.bean.Dept">
          <property name="dName" value="部门名称"></property>
      </bean>
  ```

### 基于xml方式注入集合属性

#### 注入数组类型属性

- ```xml
          <!--数组类型属性注入-->
          <property name="sources">
              <array>
                  <value>java</value>
                  <value>c++</value>
              </array>
          </property>
  ```

#### 注入List集合类型的属性

- ```xml
          <!--List属性注入-->
          <property name="list">
              <list>
                  <value>张三</value>
                  <value>李四</value>
              </list>
          </property>
  ```

#### 注入Map集合类型的属性

- ```xml
          <!--Map属性注入-->
          <property name="map">
              <map>
                  <entry key="Java" value="java"></entry>
                  <entry key="C++" value="c++"></entry>
              </map>
          </property>
  ```

#### 注入Set集合类型的属性

- ```xml
          <!--Set属性注入-->
          <property name="set">
              <set>
                  <value>mysql</value>
                  <value>Redis</value>
              </set>
          </property>
  ```

#### 细节

1.  在集合里面设置对象类型值

​	利用bean标签创建多个对象

​	在list标签内使用ref标签，引入创建的多个对象的bean中id

2.  把集合注入部分提取出来作为公共部分

​	在Spring配置文件中引入util

​	使用util标签完成list集合注入提取

3.5.IOC操作Bean管理(FactoryBean)
--------------------------------

Spring有两种类型bean，一种普通的bean，一种工厂bean(FactoryBean)

### 普通bean

特点：在配置文件中定义的bean类型就是返回类型

### FactoryBean

特点：在配置文件中定义的bean类型可以和返回类型不同

#### 步骤

创建类，让这个类作为工厂Bean，实现接口FactoryBean

实现接口里面的方法，在实现的方法中定义返回的bean类型

3.6.IOC操作Bean管理(Bean的作用域)
---------------------------------

在Spring中，设置创建bean实例是单实例还是多实例

在Spring中，默认情况下，创建的bean是单实例对象

### 设置单实例或多实例

Spring配置文件中bean标签里面的scope属性用于设置单实例还是多实例

#### scope属性值

singleton：表示单实例对象，默认值

prototype：表示多实例对象

#### singleton和prototype区别

singleton单实例；prototype多实例

设置scope值是singleton时候，在加载spring配置文件时候就会创建单实例对象；设置scope值是prototype时候，不在加载spring配置文件时候就会创建多实例对象，而是在调用getbean方法时候创建多实例对象

3.7.IOC操作Bean管理(Bean生命周期)
---------------------------------

### 生命周期

从对象创建到对象销毁的过程

### bean的生命周期

1.  通过构造器创建bean实例(无参构造方法)

2.  为bean的属性设置值和对其他bean引用(调用set方法)

3.  把bean实例传递bean后置处理器的方法

    a.  创建类，实现BeanPostProcessor接口

4.  调用bean的初始化方法(需要进行配置)

    b.  在类中创建初始化方法

    c.  在bean标签内，使用init-method属性，设置值为类中创建的初始化方法

5.  把bean实例传递bean后置处理器的方法

    d.  创建类，实现BeanPostProcessor接口

6.  使用bean(获取对象)

7.  当容器关闭时，调用bean的销毁方法(需要进行配置)

3.8.IOC操作Bean管理(基于xml方式，自动装配) 
-------------------------------------------

### 自动装配

根据指定的装配规则(属性名称或属性类型)，Spring自动将匹配的属性值继续进行注入

### 实现

使用bean标签内有一个autowire属性，autowire属性值：byName(根据属性名称注入，注入值bean的id值和类属性名称一样)、byType：根据属性类型注入

3.9.IOC操作Bean管理(基于xml方式，外部属性文件)
----------------------------------------------

eg: 引入外部属性文件配置数据库连接池

1.  创建外部属性文件，properties 格式文件，写数据库信息

2.  把外部 properties 属性文件引入到 spring 配置文件中

3.  引入 context 名称空间

4.  在 spring 配置文件使用标签引入外部属性文件

3.10.IOC操作Bean管理(基于注解方式)
----------------------------------

### 注解

注解可以作用在类上面、方法上面、属性上面

使用注解的目的：简化xml配置

### 基于注解方式，实现对象创建

四个注解功能一样，都可以用来创建bean实例，注解内的value值等价于bean标签内的id值，value也可以不写，默认为类的名称(首字母变小写)

#### @Component

#### @Service

一般用于业务逻辑层或service层

#### @Controller

一般用于web层

#### @Repository

一般用于dao层或持久层

#### 步骤

1.  引入jar包

2.  开启组件扫描

- ```xml
  <--如果扫描多个包，方式1：多个包使用逗号隔开，方式2：扫描包上层目录-->
  <context:component-scan base-package=\"包位置\"\>\</context:component-scan\>
  ```

3.  创建类，在类上面添加创建对象注解，四个注解方式均可

### 基于注解方式，实现属性注入

#### @AutoWired

根据属性类型进行自动装配

注意：如果一个接口有多个实现类，则不能只使用Autowired，需要Qualifier或者Resource指定名称

#### @Qualifier

根据属性名称进行注入

注意：如果一个接口有多个实现类，为了区分相同接口的实现类，在使用时需要和@AutoWired一起使用，需要写出value值，其中value值为具体实现类设置的值，即在具体实现类上添加的创建对象时注解所设置的值

#### @Resource

根据属性类型注入，也可以根据属性名称注入

注意：如果一个接口有多个实现类，则不能只使用Resource，需要Qualifier指定名称或者在Resource内设置具体的name值

#### @value

注入普通类型属性

注意：普通类型属性注解，value值即为普通类型属性设置的值

#### 步骤

1.  在service类和dao类上添加创建对象注解

2.  在service注入dao对象，在service类添加dao类型属性，在属性上面使用注解

### 完全注解开发

#### 步骤

1.  创建配置类，替代xml配置文件，在配置类上面添加注解

- ```java
  @Configuration //作为配置类，替代xml配置文件
  @ComponentScan(basePackages = \"需扫描的包位置\")
  ```

2.  编写测试类

- ```java
  ApplicationContext context = new
  AnnotationConfigApplicationContext(SpringConfig.class);
  ```

4.Aop(面向切面编程)
===================

4.1.概念
--------

1.  面向切面编程（方面），利用 AOP
    可以对业务逻辑的各个部分进行隔离，从而使得业务逻辑各部分之间的耦合度降低，提高程序的可重用性，同时提高了开发的效率。

2.  通俗描述：不通过修改源代码方式，在主干功能里面添加新功能

4.2.底层原理
------------

### AOP底层使用动态代理

两种情况的动态代理

#### 第一种，有接口：使用JDK动态代理

创建接口实现类的代理对象，通过代理对象对实现的接口实现类的功能进行增强

#### 第二种，没有接口：使用CGLIB动态代理

创建当前类子类的代理对象，通过代理对象对实现的接口实现类的功能进行增强

### AOP使用JDK动态代理

步骤

1.  使用 Proxy 类里面的方法创建代理对象

    a.  调用 newProxyInstance 方法

    ​	i.  方法有三个参数：

    ​		第一参数，类加载器

    ​		第二参数，增强方法所在的类，这个类实现的接口，支持多个接口

    ​		第三参数，实现这个接口InvocationHandler，创建代理对象，写增强的部分
    
2.  编写 JDK 动态代理代码

    a.  创建接口，定义方法

    b.  创建接口实现类，实现方法

    c.  使用 Proxy 类创建接口代理对象

3.  eg

    a.  对A接口的B实现类进行增强

    b.  可以创建一个名称为BProxy的类

- ```java
  //创建接口实现类代理对象
  Class[] interfaces = {UserDao.class};
  B b = (B) Proxy.newProxyInstance(BProxy.class.getClassLoader(),interfaces, new AProxy(A));//方式2,使用外部类继承InvocationHandler接口 并重写invoke增强逻辑
  //调用实现类的方法
  //其中
  //B：被增强的实现类
  //BProxy：用于增强B的实现类
  //interfaces：被增强的实现类的接口，是个数组，A可以有多个
  //AProxy(A)：直接在用于增强B的实现类下面定义一个外部类
  ```

g.  直接在用于增强B的实现类下面定义一个外部类实现InvocationHandler接口

- ```java
      //通过有参构造进行传递
      private Object obj;
      public AProxy(Object obj) {
          this.obj = obj;
      }
      //增强逻辑
      @Override
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
          /*
              porxy：代理对象
              method：需要增强的方法
              args：当前参数
           */
       //在被增强的方法之前处理，即在增强方法之前修改
       …
       //被增强的方法执行
       Object res = method.invoke(obj, args);
       //在被增强的方法之后处理，即在增强方法之后修改
       …
       return res;
   }
  ```

4.3.AOP术语
-----------

### 连接点

类中的哪些方法可以增强，这些方法被称为连接点

### 切入点

实际被真正增强的方法被称为切入点

### 通知(增强)

实际增强的逻辑部分被称为通知(增强)

通知有多种类型

#### 前置通知

在执行切入点之前的通知

#### 后置通知

在执行切入点之后的通知

#### 环绕通知

在执行切入点之前和之后都通知

#### 异常通知

在切入点出现异常时的通知

#### 最终通知

不管切入点有没有异常(当切入点出现异常，则后置通知有可能不会执行)，都会执行的通知

### 切面

把通知应用到切入点的过程

4.4.AOP操作(准备工作)
---------------------

步骤

1.  Spring 框架一般都是基于 AspectJ 实现 AOP 操作

    a.  AspectJ 不是 Spring 组成部分，独立 AOP 框架，一般把 AspectJ 和
        Spirng 框架一起使用，进行 AOP 操作

2.  基于 AspectJ 实现 AOP 操作

    a.  基于 xml 配置文件实现

    b.  基于注解方式实现（使用）

3.  在项目工程里面引入 AOP 相关依赖
    
    ![image-20220927215906814](C:\Users\AbleLynn\AppData\Roaming\Typora\typora-user-images\image-20220927215906814.png)
    
4.  切入点表达式

    a.  切入点表达式作用：知道对哪个类里面的哪个方法进行增强

    b.  语法结构： execution(\[权限修饰符\] \[返回类型\] \[类全路径][方法名称\](\[参数列表\]) )
    
    ​		权限修饰符：public、private...一般使用\*(即对所有的权限修饰符都起作用)
    
    ​		返回类型：一般省略

    ​		参数列表：一般写 ..(注意是两个)

    c.  eg：

    ​	对 com.dao.BookDao 类里面的 add 进行增强

    ​	execution(\* com.dao.BookDao.add(..))

    ​	对 com.dao.BookDao 类里面的所有的方法进行增强

    ​	execution(\* com.dao.BookDao.\* (..))

    ​	对 com.dao 包里面所有类，类里面所有方法进行增强

    ​	execution(\* com.dao.\*.\* (..))

### AOP操作(基于AspectJ注解方式)

#### 步骤

1.  创建类，在类中定义方法

2.  创建增强类，编写增强逻辑

    a.  在增强类中创建方法，让不同方法代表不同的通知类型

3.  进行通知配置

    a.  在Spring配置文件中，开启注解扫描

- ```xml
  <xmlns:context="http://www.springframework.org/schema/context"
  xmlns:aop=http://www.springframework.org/schema/aop
  xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
  http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
  http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd">
  ```

​		b.  使用注解创建被增强类和增强类对象

​			i.  被增强类

​				@Component

​			ii. 增强类

​				@Component

​		c.  在增强类上面添加注解\@Aspect

​			@Aspect//生成代理对象

​		d.  在Spring配置文件中开启生成代理对象

- ```xml
  \<aop:aspectj-autoproxy\>\</aop:aspectj-autoproxy\>
  <--扫描类，若类上有注解\@Aspect，则将类生成代理对象-->
  ```

4.  配置不同类型的通知

    a.  在增强类中，作为通知方法上添加通知类型注解，使用切入点表达式配置

    b.  前置通知

    - ```java
      @Before(value = \"切入点表达式\")
      ```

    c.  最终通知

    - ```java
      @After (value = \"切入点表达式\")
      ```

    d.  后置通知

    - ```java
      @AfterReturning (value = \"切入点表达式\")
      ```

    e.  异常通知

    - ```java
      @AfterThrowing (value = \"切入点表达式\")
      ```
    
    f.  环绕通知
    
    - ```java
      @Around (value = \"切入点表达式\")
      
      //在方法体内
      
      System.out.println(\"环绕之前\...\");
      
      //被增强的方法执行
      
      proceedingJoinPoint.proceed();
      
      System.out.println(\"环绕之后\...\");
      ```

5.  相同切入点抽取

- ```java
  @Pointcut(value = "execution(*cn.AOP_AspectJ_annotation.User.add(..))")
  public void pointdemo(){}
  ```

​		a.  使用切入点

​		b.  @After(valure=" pointdemo()")

6.  有多个增强类多同一个方法进行增强，设置增强类优先级

    a.  在增强类上面添加注解@Order(数字类型值)，数字类型值越小优先级越高
    
7.  完全使用注解开发

    a.  创建配置类，不需要创建 xml 配置文件

    - ```java
      @Configuration
      @ComponentScan(basePackages = {\"xxx\"})
      @EnableAspectJAutoProxy(proxyTargetClass = true)
      ```

### AOP操作(基于AspectJ配置文件)

##### 步骤

1.  创建两个类，增强类和被增强类

2.  在Spring配置文件中创建两个类对象

3.  在Spring配置文件中配置切入点

5.JdbcTemplate
==============

5.1.概念
--------

Spring 框架对JDBC进行封装，使用JdbcTemplate方便实现对数据库操作

5.2.准备工作
------------

步骤

1. 引入相关jar包

   ![image-20220927221434289](C:\Users\AbleLynn\AppData\Roaming\Typora\typora-user-images\image-20220927221434289.png)

2.  在spring配置文件配置数据库连接池

- ```xml
  <!-- 数据库连接池 -->
      <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource"
            destroy-method="close">
          <property name="url" value="jdbc:mysql:///user_db" />
          <property name="username" value="root" />
          <property name="password" value="root" />
          <property name="driverClassName" value="com.mysql.jdbc.Driver" />
      </bean>
  ```

3.  配置JdbcTemplate对象，注入DataSource

- ```xml
  <!--JdbcTemplate对象-->
     <bean id="JdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
         <!--注入dataSource-->
         <property name="dataSource" ref="dataSource"></property>
     </bean>
  ```

4.  创建service类，创建dao类，在dao注入jdbcTemplate对象

- ```java
  //注入dao
      @Autowired
      private BookDao bookDao;
  //注入jdbcTemplate
      @Autowired
      private JdbcTemplate jdbcTemplate;
  ```

5.3.JdbcTemplate 操作数据库
---------------------------

### 添加、删除、修改操作

![image-20220927221624401](C:\Users\AbleLynn\AppData\Roaming\Typora\typora-user-images\image-20220927221624401.png)

### 查询操作

#### 查询返回数据库表中的某个值

![image-20220927221633241](C:\Users\AbleLynn\AppData\Roaming\Typora\typora-user-images\image-20220927221633241.png)

T：查询返回的类型

eg：返回 int类型，则为Integer.class

#### 查询返回单条对象

![image-20220927221642986](C:\Users\AbleLynn\AppData\Roaming\Typora\typora-user-images\image-20220927221642986.png)

T：查询返回的类型

RowMapper是接口，针对返回不同类型数据，使用这个接口里面的实现类完成数据封装

#### 查询返回对象集合

![image-20220927221655134](C:\Users\AbleLynn\AppData\Roaming\Typora\typora-user-images\image-20220927221655134.png)

T：查询返回的类型

### 批量操作

#### 批量添加、修改、删除操作

![image-20220927221702905](C:\Users\AbleLynn\AppData\Roaming\Typora\typora-user-images\image-20220927221702905.png)

#### List集合，添加多条记录数据

6.事务管理
==========

6.1.概念
--------

事务是数据库操作的最基本单元，指逻辑上的一组操作，如果有一个操作失败则所有的操作都失败

6.2.事务特性(ACID)
------------------

### 原子性

一个事物要么都成功，要么都失败

### 一致性

操作后的总量不变

### 隔离性

在多事务操作时，相互不产生影响

### 持久性

一个事务操作后，表中的数据永久性改变

6.3.事务的操作
--------------

### 步骤

1.  创建数据库

2.  创建service、dao包

3.  在 dao 创建方法，在 service 创建方法调用dao类方法

    a.  如果执行过程中出现异常，则需要使用事务解决

### Spring事务管理

事务一般添加到service层上

两种方式：编程式事务管理、声明式事务管理(使用)

#### Spring事务管理API

提供一个接口，代表事务管理器，这个接口针对不同的框架提供不同的实现类

#### 编程式事务管理

一般在编写service层代码时加上事务管理

#### 声明式事务管理

两种方式：基于注解方式、基于xml配置文件方式

底层使用AOP

#### 声明式事务管理(基于注解方式)

1.  在 spring 配置文件配置事务管理器

- ```xml
  <!--创建事务管理器-->
      <bean id="DataSourceTransactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
          <property name="dataSource>" ref="dataSource"></property>
      </bean>
  ```

2.  在 spring 配置文件，开启事务注解

    a.  在 spring 配置文件引入名称空间 tx

    b.  开启事务注解

- ```xml
  <!--开启事务注解-->
      <tx:annotation-driven transaction-manager="DataSourceTransactionManager"></tx:annotation-driven>
  ```

3.  在 service 类上面（或者 service 类里面方法上面）添加事务注解

    c.  \@Transactional，这个注解添加到类上面，也可以添加方法上面

    d.  如果把这个注解添加类上面，这个类里面所有的方法都添加事务

    e.  如果把这个注解添加方法上面，为这个方法添加事务

#### 事务操作（声明式事务管理参数配置）

在 service类上面添加注解\@Transactional，在这个注解里面可以配置事务相关参数

1.  propagation：事务传播行为，Spring定义了7中传播行为
    
    |   传播属性    |                             描述                             |
    | :-----------: | :----------------------------------------------------------: |
    |   REQUIRED    | 如果当前没有事务，就创建一个新事务；如果当前存在事务，就加入改事务 |
    | REQUIRES_NEW  | 当前的方法必须启动新事务，并在他自己的事务内运行，如果有事务在运行，则将它挂起 |
    |   SUPPORTS    | 如果有事务在运行，当前的方法就在这个事务内运行，否则他可以不在事务内运行 |
    | NOT_SUPPORTED |   当前事务不应该运行在事务捏，如果有运行的事务，则将他挂起   |
    |   MANDATORY   | 当前的方法必须运行在事务内部，如果没有正在运行的事务，就抛出异常 |
    |     NEVER     |  当前的方法不应该运行在事务中，如果有运行的事务，就抛出异常  |
    |    NESTED     | 如果有事务在运行，当前的方法就应该在这个事务的嵌套事务内运行，否则就启动一个新事务，并在自己的事务内运行 |
    
    a.  REQUIRED：eg：事务A对应方法1，事务B对应方法2，方法1会开启事务A，然后方法1调用方法2时，方法2就会加入事务A中
    
    b.  REQUIRED\_NEW：事务A对应方法1，事务B对应方法2，方法1会开启事务A，然后方法1调用方法2时，方法2只能在事务B中运行，当事务A在运行时，事务B就会挂起。即内层事务和外层事务的关系
    
    c.  SUPPORTS：事务A对应方法1，如果当前事务A在运行，则方法2也在事务A中运行，如果没有事务运行，则方法2可以不在事务中运行
    
2.  isolation：事务隔离级别

    d.  事务隔离性：多事务操作之间不会产生影响，不考虑隔离性则会产生很多问题(脏读、不可重复读、虚读)

    e.  脏读：一个未提交事务读取到另一个未提交事务的数据

    f.  不可重复读：一个未提交事务读取到另一提交事务修改数据

    g.  虚读：一个未提交事务读取到另一提交事务添加数据

    h.  解决：通过设置事务隔离级别，解决读问题
    
    |                            | 脏读 | 不可重复读 | 幻读 |
    | -------------------------- | ---- | ---------- | ---- |
    | READ UNCOMMITTED(读未提交) | 有   | 有         | 有   |
    | READ COMMITED(读已提交)    | 无   | 有         | 有   |
    | REPEATABLE READ(可重复读)  | 无   | 有         | 有   |
    | SERIALIZEBLE(串行化)       | 无   | 无         | 无   |
    
    i.  mysql默认为REPEATABLE\_READ

- ```java
  @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ)
  ```

3.  timeout：超时时间

    j.  事务需要在一定时间内进行提交，如果不提交进行回滚

    k.  默认值是 -1 ，设置时间以秒单位进行计算

4.  readOnly：是否只读

    l.  读：查询操作，写：添加修改删除操作

    m.  readOnly 默认值 false，表示可以查询，可以添加修改删除操作

    n.  设置 readOnly 值是 true，设置成 true 之后，只能查询

5.  rollbackFor：回滚

    o.  设置出现哪些异常进行事务回滚

6.  noRollbackFor：不回滚

    p.  设置出现哪些异常不进行事务回滚

#### 声明式事务管理(基于xml配置文件方式)

在 spring 配置文件中进行配置

1.  配置事务管理器

2.  配置通知

3.  配置切入点和切面

7.Spring新特性
==============

7.1.Spring5 框架新功能
----------------------

1.  整个 Spring5 框架的代码基于 Java8，运行时兼容 JDK9

2.  Spring 5.0 框架自带了通用的日志封装

3.  Spring5 框架核心容器支持\@Nullable 注解

4.  Spring5 核心容器支持函数式风格 GenericApplicationContext

5.  Spring5 支持整合 JUnit5

### Spring 5框架自带了通用的日志封装

Spring5移除了Log4jConfigListener，官方建议使用Log4j2

#### Spring5框架整合Log4j2

1.  引入jar包
    
    ![image-20220927221929959](C:\Users\AbleLynn\AppData\Roaming\Typora\typora-user-images\image-20220927221929959.png)
    
2.  创建Log4j2.xml配置文件

    a.  注意文件名称固定

### Spring5 框架核心容器支持\@Nullable 注解

@Nullable
注解可以使用在方法上面，属性上面，参数上面，参数里面，表示方法返回可以为空，属性值可以为空，参数值可以为空

### Spring5 核心容器支持函数式风格 GenericApplicationContext

可以使用lambda函数

### Spring5 支持整合 JUnit5

#### 整合 JUnit4

1. 引入 Spring 相关针对测试依赖

   ![image-20220927221959407](C:\Users\AbleLynn\AppData\Roaming\Typora\typora-user-images\image-20220927221959407.png)

2.  创建测试类，使用注解方式完成

- ```java
  @RunWith(SpringJUnit4ClassRunner.class)//指定单元测试的框架
  @ContextConfiguration("classpath:xxx.xml")//加载配置文件---相当于创建context对象和context.getbean方法的整合
  public class JTest4 {
      @Autowired
      private Object object;
      @Test
      public void test1(){
          object.function();
      }
  }
  ```

Spring5 整合 JUnit5

1.  引入 JUnit5 的 jar 包

```java
import org.junit.jupiter.api.Test;
```

2.  创建测试类，使用注解完成

- ```java
  \@ExtendWith(SpringExtension.class)
  \@ContextConfiguration(\"classpath:bean\_Spring5\_Junit5.xml\")
  public class JTest5 {
  \@Autowired
  private UserService userService;
  
  \@Test
  public void test(){
  	userService.accountMoney();
  	}
  }
  ```

3.  使用一个复合注解替代上面两个注解完成整合

- ```java
  @SpringJUnitConfig(locations = "classpath:bean_Spring5_Junit5.xml")//简化上面两个注解
  ```
