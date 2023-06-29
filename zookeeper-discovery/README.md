
[官方文档](https://zookeeper.apache.org/)

[官方项目](https://github.com/apache/zookeeper)

[配置方法](https://zhuanlan.zhihu.com/p/388992122)

### 注意
新环境部署时注意修改 `conf/zoo.cfg` 文件里的 `dataDir` 和 `dataLogDir` 路径。

### 启动服务器
```bash
# macos
./zkServer start
```

### 关闭服务器
```bash
# macos
./zkServer stop
```