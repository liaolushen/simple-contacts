# 简易通讯录系统

## 运行程序
```bash
mvn spring-boot:run
```

## 测试程序
```
mvn test
```

## 用户信息接口列表

|  |  |
|:-------------|:-------------|
|[add](#add)|添加联系人|
|[get-all-contacts](#get-all-contacts)|查找所有联系人|
|[get-contact-by-name](#get-contact-by-name)|通过姓名查找联系人|
|[get-contact-by-phone-number](#get-contact-by-phone-number)|通过号码查找联系人|


## 用户信息接口详情

* #### add

添加联系人


##### 请求参数


| 参数名 | 必选 | 类型 | 说明 |
|:-------------:|:-------------|:-------------|
| name | true | String | 联系人名字 |
| phoneNumber | true | String | 联系人号码 |

##### 请求方法

POST

##### 调用样例


```
curl -H "Content-Type: application/json" -X POST -d '{ "name":"Mike", "phoneNumber":"123456" }' http://localhost:8080/add
```

##### 返回结果

*** JSON示例 ***

```json
{
    "type": "success",
    "data": {
        "name": "Mike",
        "phoneNumber": "123456"
    }
}

```

---

* #### get-all-contacts

获取所有联系人


##### 请求参数

无

##### 请求方法

GET

##### 调用样例


```
curl http://localhost:8080/get-all-contacts
```

##### 返回结果

*** JSON示例 ***

```json
{
    "type": "success",
    "data": [{
        "name": "Mike",
        "phoneNumber": "123456"
    }]
}
```

---

* #### get-contact-by-name

通过姓名查找联系人


##### 请求参数


| 参数名 | 必选 | 类型 | 说明 |
|:-------------:|:-------------|:-------------|
| name | true | String | 联系人名字 |

##### 请求方法

GET

##### 调用样例

```
curl http://localhost:8080/get-contact-by-name?name=Mike
```

##### 返回结果

*** JSON示例 ***

```json
{
    type: "success"
    data: {
        name: "Mike"
        phoneNumber: "123456"
    }
}

```

---

* #### get-contact-by-phone-number
通过号码查找联系人


##### 请求参数


| 参数名 | 必选 | 类型 | 说明 |
|:-------------:|:-------------|:-------------|
| phoneNumber | true | String | 联系人号码 |

##### 请求方法

GET

##### 调用样例

```
curl http://localhost:8080/get-contact-by-phone-number?phoneNumber=123456
```

##### 返回结果

*** JSON示例 ***

```json
{
    type: "success"
    data: {
        name: "Mike"
        phoneNumber: "123456"
    }
}

```