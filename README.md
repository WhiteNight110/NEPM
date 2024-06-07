# 数据库设计

### User 用户表

| 字段名   | 类型 | 说明                                                         |
| -------- | ---- | ------------------------------------------------------------ |
| id       | int  | 用户id                                                       |
| type     | char | 用户类型（0：公共监督员   1：网格员   2：决策者   3：系统管理员） |
| name     | char | 用户姓名                                                     |
| phone    | char | 用户电话                                                     |
| password | char | 用户密码                                                     |
| age      | int  | 用户年龄                                                     |
| sex      | int  | 用户性别                                                     |

## NEPS公众监督员端

### supervisor 公众监督员表

| 字段名  | 类型 | 说明             |
| ------- | ---- | ---------------- |
| id      | int  | 公众监督员id     |
| user_id | int  | 公众监督员用户id |



### Grid 网格表

| 字段名   | 类型 | 说明     |
| -------- | ---- | -------- |
| id       | int  | 网格id   |
| province | char | 所在省   |
| city     | char | 所在市   |
| address  | char | 具体地址 |

### 反馈表

| 字段名        | 类型 | 说明               |
| ------------- | ---- | ------------------ |
| id            | int  | 反馈id             |
| degree        | int  | 预估AQI等级（1~6） |
| feedback      | char | 反馈信息           |
| time          | date | 反馈时间           |
| supervisor_id | int  | 公众监督员id       |

### 反馈-网格表

| 字段名      | 类型 | 说明   |
| ----------- | ---- | ------ |
| id          | int  | id     |
| feedback_id | int  | 反馈id |
| grid_id     | int  | 网格id |

## NEPG网格员端

### grid operator 网格员表

| 字段名  | 类型 | 说明       |
| ------- | ---- | ---------- |
| id      | int  | 网格员id   |
| user_id | int  | 用户id     |
| number  | char | 登陆编号   |
| grid_id | char | 所属网格id |

### task_detail 任务详情表

| 字段名      | 类型   | 说明                      |
| ----------- | ------ | ------------------------- |
| id          | int    | 任务详情id                |
| feedback_id | int    | 反馈表id                  |
| SO2         | double | SO2浓度                   |
| CO          | double | CO浓度                    |
| PM25        | double | PM2.5指数                 |
| state       | int    | 状态(0:待检测，1：已检测) |

## NEPM系统管理员端

### administrators 管理员表

| 字段名  | 类型 | 说明     |
| ------- | ---- | -------- |
| id      | int  | 管理员id |
| user_id | int  | 用户id   |
| number  | char | 登陆编号 |