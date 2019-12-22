# 在线答题交友APP-ANS

### 一. 前言

**古之学者必有师。师者，所以传道受业解惑也。人非生而知之者，孰能无惑？惑而不从师，其为惑也，终不解矣。生乎吾前，其闻道也固先乎吾，吾从而师之；生乎吾后，其闻道也亦先乎吾，吾从而师之。吾师道也，夫庸知其年之先后生于吾乎？是故无贵无贱，无长无少，道之所存，师之所存也。**

**嗟乎！师道之不传也久矣！欲人之无惑也难矣！古之圣人，其出人也远矣，犹且从师而问焉；今之众人，其下圣人也亦远矣，而耻学于师。是故圣益圣，愚益愚。圣人之所以为圣，愚人之所以为愚，其皆出于此乎？爱其子，择师而教之；于其身也，则耻师焉，惑矣。彼童子之师，授之书而习其句读者，非吾所谓传其道解其惑者也。句读之不知，惑之不解，或师焉，或不焉，小学而大遗，吾未见其明也。巫医乐师百工之人，不耻相师。士大夫之族，曰师曰弟子云者，则群聚而笑之。问之，则曰：“彼与彼年相若也，道相似也。位卑则足羞，官盛则近谀。”呜呼！师道之不复可知矣。巫医乐师百工之人，君子不齿，今其智乃反不能及，其可怪也欤！**

**圣人无常师。孔子师郯子、苌弘、师襄、老聃。郯子之徒，其贤不及孔子。孔子曰：三人行，则必有我师。是故弟子不必不如师，师不必贤于弟子，闻道有先后，术业有专攻，如是而已。**

**李氏子蟠，年十七，好古文，六艺经传皆通习之，不拘于时，学于余。余嘉其能行古道，作《师说》以贻之。**

**竭而所学，道之所寻，是谓"寻道"**

**如何打造一款爆款的答题类app?**

**市面上答题类软件层出不穷，但是纵观这些软件，题目单一，枯燥乏味，答题解析几乎没有，题库也是少得可怜，题目质量欠缺，出题人为了答题而出题，根本没有考虑到为什么而出题，是为了提升用户的知识素养，还是单纯的只是想要出题。除此之外，app的模式也十分地无趣，毫无可玩性，使得用户答题也十分没有动力，设立头衔等级也似乎只在排名中有些许用，一个好的模式对于一款答题类app是多么的重要。哪个男孩不想要一款有趣好玩，有竞争性，让人沉迷于知识的海洋，可以学到知识的app呢。**

### 二. 数据库设计

#### 1.基本表

###### 用户表（user）

|       字段名       |  数据类型   |    约束条件    |        注释         |
| :----------------: | :---------: | :------------: | :-----------------: |
|       **id**       |   **int**   | **主键、自增** |       **id**        |
|    **username**    | **varchar** |                |     **用户名**      |
|    **password**    | **varchar** |                | **密码（md5加密）** |
|    **nickname**    | **varchar** |                |      **昵称**       |
|   **avatar_url**   | **varchar** |                |    **头像地址**     |
|   **tel_number**   | **varchar** |                |    **电话号码**     |
|      **rank**      |   **int**   |                |      **等级**       |
|      **sign**      | **varchar** |                |      **签名**       |
|   **ans_number**   |   **int**   |                |    **回答总数**     |
| **correct_number** |   **int**   |                |   **正确答题数**    |
|    **good_at**     | **varchar** |                |      **擅长**       |
| **register_time**  | **varchar** |                |    **注册时间**     |
|   **devote_num**   |   **int**   |                |    **贡献题量**     |

###### 角色表（role）

|      字段名       |  数据类型   |    约束条件    |     注释     |
| :---------------: | :---------: | :------------: | :----------: |
|      **id**       |   **int**   | **主键、自增** |    **id**    |
|   **role_name**   | **varchar** |                |  **角色名**  |
| **role_describe** | **varchar** |                | **角色描述** |

###### 权限表（permission）

|         字段名          |  数据类型   |    约束条件    |     注释     |
| :---------------------: | :---------: | :------------: | :----------: |
|         **id**          |   **int**   | **主键、自增** |    **id**    |
|   **permission_name**   | **varchar** |                |  **权限名**  |
| **permission_describe** | **varchar** |                | **权限描述** |

###### 用户角色表（user_role）

| 字段名  | 数据类型 |    约束条件    |    注释    |
| :-----: | :------: | :------------: | :--------: |
| **id**  | **int**  | **主键、自增** |   **id**   |
| **uid** | **int**  |                | **用户id** |
| **rid** | **int**  |                | **角色id** |

###### 角色权限表（role_permission）

| 字段名  | 数据类型 |    约束条件    |    注释    |
| :-----: | :------: | :------------: | :--------: |
| **id**  | **int**  | **主键、自增** |   **id**   |
| **rid** | **int**  |                | **角色id** |
| **pid** | **int**  |                | **权限id** |

#### 2.聊天表

###### 消息表（chat）

|     字段名      |  数据类型   |    约束条件    |           注释           |
| :-------------: | :---------: | :------------: | :----------------------: |
|     **id**      |   **int**   | **主键、自增** |          **id**          |
|   **send_id**   |   **int**   |                |       **发送者id**       |
| **receive_id**  |   **int**   |                |       **接收者id**       |
|   **content**   | **varchar** |                |       **消息内容**       |
| **read_status** |   **int**   |                | **阅读状态 1已读 3未读** |
|    **time**     | **varchar** |                |       **发送时间**       |

###### 好友表（friend）

|    字段名    |  数据类型   |    约束条件    |     注释     |
| :----------: | :---------: | :------------: | :----------: |
|    **id**    |   **int**   | **主键、自增** |    **id**    |
|   **sid**    |   **int**   |                | **自己的id** |
|   **oid**    |   **int**   |                |  **对方id**  |
| **add_time** | **varchar** |                | **添加时间** |

###### 验证表（verification）

|     字段名     |  数据类型   |    约束条件    |                注释                |
| :------------: | :---------: | :------------: | :--------------------------------: |
|     **id**     |   **int**   | **主键、自增** |               **id**               |
|  **send_id**   |   **int**   |                |            **发送者id**            |
| **receive_id** |   **int**   |                |            **接收者id**            |
|  **ver_time**  | **varchar** |                |            **验证时间**            |
| **ver_status** |   **int**   |                | **验证状态 1通过 2不通过 3未处理** |

#### 3.答题表

###### 类型表（type）

|      字段名       |  数据类型   |    约束条件    |     注释     |
| :---------------: | :---------: | :------------: | :----------: |
|      **id**       |   **int**   | **主键、自增** |    **id**    |
|   **type_name**   | **varchar** |                |  **类型名**  |
| **type_describe** | **varchar** |                | **类型描述** |
|      **hot**      |   **int**   |                |   **热度**   |
|  **difficulty**   |   **int**   |                |   **难度**   |

###### 题目表（question）

|        字段名         |  数据类型   |    约束条件    |                注释                |
| :-------------------: | :---------: | :------------: | :--------------------------------: |
|        **id**         |   **int**   | **主键、自增** |               **id**               |
|    **create_time**    | **varchar** |                |            **创建时间**            |
|     **type_name**     | **varchar** |                |            **题目类型**            |
|  **question_owner**   |   **int**   |                |             **出题者**             |
| **question_describe** | **varchar** |                |            **问题描述**            |
| **question_explain**  | **varchar** |                |            **问题解释**            |
|      **item_a**       | **varchar** |                |           **A选项内容**            |
|      **item_b**       | **varchar** |                |           **B选项内容**            |
|      **item_c**       | **varchar** |                |           **C选项内容**            |
|      **item_d**       | **varchar** |                |           **D选项内容**            |
|     **item_ans**      | **varchar** |                |            **正确选项**            |
|  **question_status**  |   **int**   |                | **题目状态 1审核通过 2审核不通过** |

###### 比赛表（contest）

|      字段名      |  数据类型   |    约束条件    |     注释     |
| :--------------: | :---------: | :------------: | :----------: |
|      **id**      |   **int**   | **主键、自增** |    **id**    |
|    **user_a**    |   **int**   |                |  **用户a**   |
|    **user_b**    |   **int**   |                |  **用户b**   |
| **contest_type** | **varchar** |                | **比赛类型** |
|    **win_id**    |   **int**   |                | **胜利者id** |
| **contest_time** | **varchar** |                | **比赛时间** |

###### 比赛记录表（contest_record）

|     字段名      | 数据类型 |    约束条件    |       注释       |
| :-------------: | :------: | :------------: | :--------------: |
|     **id**      | **int**  | **主键、自增** |      **id**      |
| **contest_id**  | **int**  |                | **contest(id)**  |
| **question_id** | **int**  |                | **question(id)** |
|   **win_id**    | **int**  |                |   **user(id)**   |

**这里不使用外键约束是因为没有太复杂的逻辑**，**只要sql语句使用得当，外键不添加也可。**

### 三. 功能模块

#### 1.基础板块（basic）

##### 登陆注册

###### 后端

- 注册采用md5加密算法，用户注册后，密码将不会明文保存在数据库中，而是添加md5加密后的哈希值到数据库中，这样即使数据库密码被盗窃，也无法登录，因为md5的加密算法是不可逆的。

- 用户注册后，系统会随机赋予用户头像与昵称，用户进入系统后可更改。

- 登录采用的是shiro权限框架，通过自定义的realm，可对用户进行授权与认证，用户登陆时，错误的登录都会抛出相应的异常

```java
@RestControllerAdvice
public class ExceptionHandle {

    /**
     * 无权限抛出的异常
     * */
    @ExceptionHandler
    public String errorHandler(AuthorizationException e){
        return "Sorry,you don't have permission.";
    }

    @ExceptionHandler
    public HashMap<Integer, String> unknownAccountException(UnknownAccountException e){
        HashMap<Integer, String> map = new HashMap<>(1);
        map.put(500,"Unknown Account.");
        return map;
    }

    @ExceptionHandler
    public HashMap<Integer, String> incorrectCredentialsException(IncorrectCredentialsException e){
        HashMap<Integer, String> map = new HashMap<>(1);
        map.put(500,"Password Wrong.");
        return map;
    }

    @ExceptionHandler
    public HashMap<Integer, String> lockedAccountException(LockedAccountException e){
        HashMap<Integer, String> map = new HashMap<>(1);
        map.put(500,"Account Locked.");
        return map;
    }

    @ExceptionHandler
    public HashMap<Integer, String> excessiveAttemptsException(ExcessiveAttemptsException e){
        HashMap<Integer, String> map = new HashMap<>(1);
        map.put(500,"Too Much Input Wrong.");
        return map;
    }

    @ExceptionHandler
    public HashMap<Integer, String> authenticationException (AuthenticationException e){
        HashMap<Integer, String> map = new HashMap<>(1);
        map.put(500,"Username Or Password Wrong.");
        return map;
    }
}
```

- 登陆时若选择remember me，则会通过cookie将用户状态保留，这样退出再次登录即可恢复状态
- 为了缓解服务器的压力，每个用户登陆后，Shiro产生的session通过RedisCacheManager来保存在redis中，而不是在本程序中。

###### 前端

- app用户未登录，将通过router的路由守卫限制用户的随意访问，只有登陆后，获得状态才能进行app的使用，未登录则会跳转回 /Login。
- app登陆成功后将会保存用户的登录信息。
- 管理页面只有admin权限的用户才能进入。后端Shiro将会限制接口访问

##### 角色及权限管理

###### Role

每个用户可以拥有多个角色，各种程序的vip1 vip2就是用户的一个角色

###### Permission

每个角色可以拥有多种权限，类似vip1用户拥有观看独播视频的权限，vip2拥有下载视频的权限

###### User

基本的用户

###### 需要建立五个表

- User  -用户表
- Role  -角色表
- Permission -权限表
-  UserRole  -用户角色表
- RolePermission -角色权限表

UserRole用来管理用户的角色，RolePermission用来管理角色的权限

##### 角色权限应用

- 每个等级拥有不同的角色，“高一”开始可以获得出题权限，“硕士”及以上可获得审核题目权限

- 使用管理员需要特定的权限，管理员拥有最高权限

#### 2.聊天板块（chat）

#### 3.答题板块（ans）

##### 3-1等级设定

**每个等级升级经验为100exp，答题获得经验，平手5分，获胜得10分，失败不得分**

- **学前班 0-1级**
- **小班 2-3级**
- **大班 4-5级**
- **一年级 6-8级**
- **二年级 9-11级**
- **三年级 12-14级**
- **四年级 15-17级**
- **五年级 18-20级**
- **六年级 21-23级**
- **初一 24-27级**
- **初二 28-31级**
- **初三 32-35级**
- **高一 36-39级**
- **高二 40-43级**
- **高三 44-47级**
- **大一 48-52级**
- **大二 53-57级**
- **大三 58-62级**
- **大四 63-67级**
- **硕士 68-73级**
- **博士 74-80级**
- **博士后 81-88级**
- **副教授 89-97级**
- **教授 98级以上**

##### 3-2等级权限

**“高一”开始可以获得出题权限，“硕士”及以上可获得审核题目权限**

##### 3-3比赛匹配

```java
@Data
@Accessors(chain = true)
public class Match {
	private String type;
	private Integer userId;
}
```

使用Vector匹配对手，Vector是一个线程安全的集合

```java
private static Vector<Match> matchList = new Vector<>(18);
```

通过比赛类型来匹配对手，将自己的id与请求类型发送到Netty服务器，若Vector中存在相同的类型等待者，则匹配成功，然后将等待者从Vector中移除，若不存在这个等待者，则自己成为等待者，加入Vector，等待下一个匹配者。如此循环往复。

![1577017949512](C:\Users\NICE\AppData\Roaming\Typora\typora-user-images\1577017949512.png)

### 四. 技术栈

#### 1.后端技术栈

###### SpringBoot

###### Mybatis

###### SpringCloud

###### Shiro

###### Redis

###### WebSocket

###### Netty

###### Feign

###### Hystrix

###### Eureka

#### 2.运维

###### Tomcat

###### Nginx反向代理及分布式

###### Docker容器技术

#### 3.前端技术栈

###### Node.js

###### Vue

###### Muse-ui

###### Element-ui

#### 4.项目管理

###### Git

###### Maven

### 五.技术要点

#### 安全管理

#### 角色管理、权限管理、认证、授权

#### 添加好友、认证好友、实时通讯

#### Netty搭建WebSocket服务器聊天功能

#### Netty搭建WebSocket服务器答题功能

