# start

## MBG的使用

### 两种配置方法

1. 在pom.xml文件中的plugin配置，并在Run as 的configuration中配置maven build设置其中的goals为mybatis-generator:generate

2. eclipse插件中install相关的插件mybatis generator,安装之后可以右键建立generatorConfig模板并在Run as 中设置configuration中设置配置文件路径即可run

在配置文件中Maven build和 eclipse 插件build不一样，maven的基准目录是 ${workspace_loc:/start}不需要加项目名

```
maven: targetProject="src/main/java"
eclipse targetProject="start/src/main/java"
```

### MBG 配置文件

按顺序填写相关属性
(property*,plugin*,commentGenerator?,(connectionFactory|jdbcConnection),javaTypeResolver?,javaModelGenerator,sqlMapGenerator?,javaClientGenerator?,table+)

[配置文件属性](https://www.jianshu.com/p/e09d2370b796)
[官网xmlconfig](http://www.mybatis.org/generator/configreference/xmlconfig.html)

## 使用freemaker

建立 static和templates文件夹
需要配置：

```
spring.freemarker.template-loader-path=classpath:/templates
spring.freemarker.suffix=.html
```
不然总是报错Whitelabel Error Page

## eclipse 配置

### 智能提示

Window － Preferences
Java－Editor－Content Assist
Auto-Activation
Auto Activation triggers for java

```
.abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ
```

## git gui 编码

`git config --global gui.encoding utf-8`


## Mybatis 配置

### 实体注入

无法使用注解生成Example

```
	@Resource
	private ActivityExample activityExample;

	private ActivityExample activityExample = new ActivityExample();
	
	// 正确的使用方式：
	public List<Activity> queryActivities() {
		ActivityExample activityExample = new ActivityExample();
		}
```

**这个应该是要自己在方法里面new一个，使用完之后释放jvm回收。**

### mapper

配置xml: 
mybatis.mapper-locations=classpath:mapper/**/*.xml

接口扫描
@MapperScan(basePackages = {"com.tan.start.dao"})
或者在mapper接口加注解，不然spring无法识别


## 分页 

pagehelper自动配置拦截器，不需要配置，只需一句并开始查询即可

```
PageHelper.startPage(1,3);
List<Activity> list = activityService.queryActivities();
```

[MyBatis-Plus](https://mp.baomidou.com/guide/)


## logback

springboot默认使用logback
添加配置文件并配置路径
logging.config=classpath:logback.xml

## 数据库连接池

Spring 推荐使用dbcp；
Hibernate 推荐使用c3p0和proxool
druid比较强大,pom 配置druid-spring-boot-starter