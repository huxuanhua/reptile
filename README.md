# reptile
前言:
我们使用SpringBootWeb的方式。可以直接 java -jar reptile.jar启动该项目。安装Mysql数据库
2017.8.22
- 首次上传，可以扒虎族的dota饰品内容

设计模型:
- 定时 + 手动方式 更新饰品列表，增加新饰品名称
- 根据指定需要的饰品，定时获取最新数据
- 查询饰品最近价格数据，准备做K线处理