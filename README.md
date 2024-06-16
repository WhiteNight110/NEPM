# NEP (neusoft environmental protection东软环保)系统数据库设计书）

| No   | 名称          | 中文名                 | 说明                                                         |
| ---- | ------------- | ---------------------- | ------------------------------------------------------------ |
|      | aqi           | 空气质量指数级别表     | 存储AQI空气质量指数级别(Air quality index)信息               |
|      | grid_member   | 空气质量监测网格员表   | 存储空气质量监测网格员信息                                   |
|      | grid_province | 系统网格覆盖省区域表   | 存储系统网格覆盖省区域信息                                   |
|      | grid_city     | 系统网格覆盖市区域表   | 存储系统网格覆盖市区域信息                                   |
|      | api_feedback  | 空气质量公众监督反馈表 | 存储从公众监督员对于空气质量的反馈信息                       |
|      | statistics    | 空气质量监测数据统计表 | 存储网格员实地检测的空气质量监测数据作                       |
|      | admins        | 系统管理员表           | 存储系统管理员信息(系统管理员负责对反馈信息指派相应的网格员去处理) |
|      | supervisor    | 公众监督员表           | 存储公众监督员信息                                           |

# 数据库设计

## aqi 空气质量指数级别表

| 名称            | 类型    | size | 说明                         |
| --------------- | ------- | ---- | ---------------------------- |
| aqi_id          | int     |      | 空气质量指数级别（共六级）   |
| chinese_explain | varchar | 10   | 空气质量指数级别汉字描述     |
| aqi_explain     | varchar | 20   | 空气质量指数级别描述         |
| color           | varchar | 7    | 空气质量指数级别表示颜色     |
| health_impact   | varchar | 500  | 对健康的影响情况             |
| take_steps      | varchar | 500  | 建议采取的措施               |
| so2_min         | int     |      | 本级别二氧化硫最小限值       |
| so2_max         | int     |      | 本级别二氧化硫最大限值       |
| co_min          | int     |      | 本级别一氧化碳最小限值       |
| co_max          | int     |      | 本级别一氧化碳最大限值       |
| spm_min         | int     |      | 本级别悬浮颗粒物浓度最小限值 |
| spm_max         | int     |      | 本级别悬浮颗粒物浓度最大限值 |
| remarks         | varchar | 100  |                              |

## 空气质量监测网格员表（grid_member）

| 名称        | 类型    | size | 说明                                              |
| ----------- | ------- | ---- | ------------------------------------------------- |
| gm_id       | varchar | 11   | 网格员手机号码                                    |
| gm_name     | varchar | 20   | 网格员名称                                        |
| gm_code     | varchar | 20   | 网格员登陆编码                                    |
| password    | varchar | 20   | 登陆密码                                          |
| province_id | int     |      | 网格区域：省编号                                  |
| city_id     | int     |      | 网格区域：市编号                                  |
| tel         | varchar | 20   | 联系电话                                          |
| state       | int     |      | 网格员状态：0 可工作状态 1 临时抽调 2 休假 3 其他 |
| remarks     | varchar | 200  | 备注                                              |

## 系统网格覆盖省区域表（grid_province）

| 名称          | 类型    | size | 说明                   |
| ------------- | ------- | ---- | ---------------------- |
| province_id   | int     |      | 系统网格覆盖省区域编号 |
| province_name | varchar | 20   | 系统网格覆盖省区域名称 |
| province_abbr | varchar | 2    | 系统网格覆盖省区域简称 |
| remarks       | varchar | 200  | 备注                   |

## 系统网格覆盖市区域表（grid_city）

| 名称        | 类型    | size | 说明                   |
| ----------- | ------- | ---- | ---------------------- |
| city_id     | int     |      | 系统网格覆盖市区域编号 |
| city_name   | varchar | 20   | 系统网格覆盖市区域名称 |
| province_id | int     |      | 所属省区域编号         |
| remarks     | varchar | 20o  | 备注                   |

## 空气质量公众监督反馈表（aqi_feedback）

| 名称            | 类型    | size | 说明                       |
| --------------- | ------- | ---- | -------------------------- |
| aqi_id          | int     |      | 空气质量指数级别（共六级） |
| chinese_explain | varchar | 10   | 空气质量指数级别汉字描述   |

## 空气质量监测数据统计表（statistics）

| 名称            | 类型    | size | 说明                                 |
| --------------- | ------- | ---- | ------------------------------------ |
| af_id           | int     |      | 空气质量公共监督反馈信息编号         |
| tel_id          | varchar | 20   | 所属公共监督员编号（手机号码）       |
| province_id     | int     |      | 反馈信息所在省区域编号               |
| city_id         | int     |      | 反馈信息所在市区域编号               |
| address         | varchar | 200  | 反馈信息所在区域详细地址             |
| information     | varchar | 400  | 反馈信息描述                         |
| estimated_grade | int     |      | 反馈者对空气质量指数级别的预估等级   |
| af_date         | varchar | 20   | 反馈日期                             |
| af_time         | varchar | 20   | 反馈时间                             |
| gm_id           | int     |      | 指派网格员编号                       |
| assign_date     | varchar | 20   | 指派日期                             |
| assign_time     | varchar | 20   | 指派时间                             |
| state           | int     |      | 信息状态：0 未指派 1 已指派 2 已确认 |
| remarks         | varchar | 200  | 备注                                 |

## 系统管理员表（admins）

| 名称       | 类型    | size | 说明               |
| ---------- | ------- | ---- | ------------------ |
| admin_id   | int     |      | 系统管理员编号     |
| admin_code | varchar | 20   | 系统管理员登录编码 |
| password   | varchar | 20   | 系统管理员登陆密码 |
| remarks    | varchar | 100  | 备注               |

## 公众监督员表（supervisor）

| 名称      | 类型    | size | 说明                       |
| --------- | ------- | ---- | -------------------------- |
| tel_id    | varchar | 11   | 公共监督员编号（手机号码） |
| password  | varchar | 20   | 公共监督员登陆密码         |
| real_name | varchar | 20   | 公共监督员真实姓名         |
| birthday  | varchar | 20   | 公共监督员出生日期         |
| sex       | int     |      | 公共监督员性别 1 男 0 女   |
| remarks   | varchar | 100  | 备注                       |

# 服务器端接口API

## admins

1. admins/getAdminsByCode 

- 参数：Admins对象
- 返回值：Admins对象
- 功能：根据管理员编码和密码进行查询，用于登录

## aqi

1. aqi/listAqiAll 

- 参数：无
- 返回值：List<Aqi>
- 功能：全查询AQI信息

## aqiFeedback

1. aqiFeedback/saveAqiFeedback 

- 参数：AqiFeedback对象
- 返回值：int
- 功能：保存公众监督员的AQI反馈信息

2. aqiFeedback/listAqiFeedbackByTelId 

- 参数：AqiFeedback对象
- 返回值：List<AqiFeedback>
- 功能：根据TelId查询AQI反馈情况

3. aqiFeedback/listAqiFeedbackPage  （管理员端）

- 参数：AfPageRequestDto对象
- 返回值：PageResponseDto<AqiFeedback>
- 功能：查询AQI反馈信息，并有模糊查询和分页功能

4. aqiFeedback/getAqiFeedbackById

- 参数：afId
- 返回值：AqiFeedback对象
- 功能：根据主键查询AQI反馈信息

5. aqiFeedback/updateAqiFeedbackAssign 

- 参数：AqiFeedback对象
- 返回值：int
- 功能：根据主键更新AQI反馈信息（更新指派信息）

6. aqiFeedback/listAqiFeedbackByGmId 

- 参数：GmId 
- 返回值：List<AqiFeedback>
- 功能：根据网格员编号查询指派给网格员的AQI反馈信息

7. aqiFeedback/updateAqiFeedbackState（同updateAqiFeedbackAssign  略）

- 参数：AqiFeedback对象
- 返回值：int
- 功能：根据主键更新AQI反馈信息（更新状态）

## gridCity

1. gridCity/listGridCityByProvinceId 

- 参数：ProvinceId
- 返回值：List<GridCity>
- 功能：根据所属省查询市信息列表

## gridMember

1. gridMember/listGridMemberByProvinceId

- 参数：ProvinceId
- 返回值：List<GridMember>
- 功能：根据省和市查询可工作状态的所属网格员信息列表

2. gridMember/getGridMemberByCodeByPass 

- 参数：gmCode 网格员账号 password 网格员密码
- 返回值：GridMember对象
- 功能：根据网格员登录编码和密码进行查询，用于登录

## gridProvince

​	1. gridProvince/getGridProvinceByGridMember

- 参数：GridMember对象
- 返回值：GridProvince对象
- 功能：根据网格员信息找到网格所在省市区域

## statistics

1. statistics/saveStatistics 

- 参数：Statistics对象
- 返回值：int
- 功能：保存网格员提交的AQI确认信息

2. statistics/listStatisticsPage 

- 参数：StatisPageRequestDto对象
- 返回值：PageResponseDto<Statistics>
- 功能：查询确认AQI信息列表，并有模糊查询和分页功能

3. statistics/getStatisticsById 

- 参数：Statistics对象
- 返回值：Statistics对象
- 功能：根据主键查询确认AQI信息

4. statistics/listProvinceItemTotalStatis 

- 参数：无
- 返回值：List<ProvinceItemTotalStatisDto>
- 功能：查询省分组AQI超标累计信息

5. statistics/listAqiDistributeTotalStatis 

- 参数：无
- 返回值：List<AqiDistributeTotalStatisDto>
- 功能：查询以AQI等级为分组的AQI超标分布统计信息

6. statistics/listAqiTrendTotalStatis 

- 参数：无
- 返回值：List<AqiTrendTotalStatisDto>
- 功能：查询当前12个月的AQI超标趋势统计信息

7. statistics/getAqiCount 

- 参数：无
- 返回值：long
- 功能：查询确认AQI数据数量

8. statistics/getAqiGoodCount 

- 参数：无
- 返回值：long
- 功能：查询确认AQI良好数据数量

9. tatistics/getProvinceCoverage 

- 参数：无
- 返回值：String
- 功能：查询省网格的全国覆盖率

10. statistics/getCityCoverage 

- 参数：无
- 返回值：String
- 功能：查询大城市网格的全国覆盖率

## supervisor

1. supervisor/getSupervisorById 

- 参数：Supervisor对象
- 返回值：Supervisor对象
- 功能：根据主键查询公众监督员，用于注册时手机号码是否存在验证

2. supervisor/saveSupervisor 

- 参数：Supervisor对象
- 返回值：int
- 功能：保存公众监督员信息，用于注册

3. upervisor/getSupervisorByIdByPass 

- 参数：Supervisor对象
- 返回值：Supervisor对象
- 功能：根据公众监督员手机号码和密码查询，用于登录。