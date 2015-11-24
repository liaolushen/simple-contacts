# Simple Contact System

## Run
```bash
mvn spring-boot:run
```

## Test
```
mvn test
```

## API

### add

添加联系人


##### 调用样例

```
curl -H "Content-Type: application/json" -X POST -d '{ "name":"Mike", "phoneNumber":"123456" }' http://localhost:8080/add
```

##### 返回结果

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

### get-all-contacts
获取所有联系人

##### 调用样例

```
curl http://localhost:8080/get-all-contacts
```

##### 返回结果

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

### get-contact-by-name
通过姓名查找联系人


##### 调用样例

```
curl http://localhost:8080/get-contact-by-name?name=Mike
```

##### 返回结果

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

### get-contact-by-phone-number
通过号码查找联系人

##### 调用样例

```
curl http://localhost:8080/get-contact-by-phone-number?phoneNumber=123456
```

##### 返回结果

```json
{
    "type": "success",
    "data": {
        "name": "Mike",
        "phoneNumber": "123456"
    }
}

```