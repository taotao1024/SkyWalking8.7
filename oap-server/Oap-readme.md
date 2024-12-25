# OAP端

oap-server
-
- [analyzer](analyzer) - 分析器 LAL(Log Analysis Language) 负责分析数据指标项等信息
  - [agent-analyzer](analyzer\agent-analyzer) - JVM、链路、数据解析和指标数据
  - [event-analyzer](analyzer\event-analyzer) - 事件解析
  - [log-analyzer](analyzer\log-analyzer) - 分析 Log 数据，利用 LAL 生成日志相关指标
  - [meter-analyzer](analyzer\meter-analyzer) - 分析 Meter 数据，利用 MAL 生成需要观测指标
  - **这里可以添加模块，自定义数据分析器**
- [exporter](exporter) - 提供GRPC出口
- [oal-grammar](oal-grammar) - OAL语法
  - OAL聚焦于Service、ServiceInstance、EndPoint、其他Source对象的指标。基于Altlr与Javassist将OAL脚本转换为动态生成的类文件。
  - 指标声明过程 -> 从某一个Scope（域）中获取数据、过滤(Filter)部分数据、使用聚合函数(Function)将数据聚合
  - 自定义指标
    - Agent端 修改 [JVMMetric.proto](..%2Fapm-protocol%2Fapm-network%2Fsrc%2Fmain%2Fproto%2Flanguage-agent%2FJVMMetric.proto) 添加指标
    - Agent端 模拟 [JVMMetricsSender.java](..%2Fapm-sniffer%2Fapm-agent-core%2Fsrc%2Fmain%2Fjava%2Forg%2Fapache%2Fskywalking%2Fapm%2Fagent%2Fcore%2Fjvm%2FJVMMetricsSender.java) 实现指标计算
    - Agent端 修改 [JVMService.java](..%2Fapm-sniffer%2Fapm-agent-core%2Fsrc%2Fmain%2Fjava%2Forg%2Fapache%2Fskywalking%2Fapm%2Fagent%2Fcore%2Fjvm%2FJVMService.java) 实现数据采集与推送
    - OAP端 在 [DefaultScopeDefine.java](server-core%2Fsrc%2Fmain%2Fjava%2Forg%2Fapache%2Fskywalking%2Foap%2Fserver%2Fcore%2Fsource%2FDefaultScopeDefine.java) 中新增业务
    - OAP端 自定义 [XxxSource.java](server-core%2Fsrc%2Fmain%2Fjava%2Forg%2Fapache%2Fskywalking%2Foap%2Fserver%2Fcore%2Fsource%2FSource.java) 实现数据存储和查询
    - OAP端 注册 别名到引擎 [OALLexer.g4](oal-grammar%2Fsrc%2Fmain%2Fantlr4%2Forg%2Fapache%2Fskywalking%2Foal%2Frt%2Fgrammar%2FOALLexer.g4) 中
    - OAP端 在 [OALParser.g4](oal-grammar%2Fsrc%2Fmain%2Fantlr4%2Forg%2Fapache%2Fskywalking%2Foal%2Frt%2Fgrammar%2FOALParser.g4) 中声明范围
    - OAP端 定义对应流水线 [java-agent.oal](server-bootstrap%2Fsrc%2Fmain%2Fresources%2Foal%2Fjava-agent.oal)
- [oal-rt](oal-rt) - OAL-runtime读取器和解析器(Anltr-V4)
- [server-alarm-plugin](server-alarm-plugin) - 告警插件
- [server-bootstrap](server-bootstrap) - OAP Web启动
- [server-cluster-plugin](server-cluster-plugin) - 实现集群间的协商机制
  - [cluster-consul-plugin](server-cluster-plugin\cluster-consul-plugin) - 集群领导者插件
  - [cluster-etcd-plugin](server-cluster-plugin\cluster-etcd-plugin) - 集群模式 ETCD
  - [cluster-kubernetes-plugin](server-cluster-plugin\cluster-kubernetes-plugin) - 集群模式 k8s
  - [cluster-nacos-plugin](server-cluster-plugin\cluster-nacos-plugin) - 集群模式 nacos
  - [cluster-standalone-plugin](server-cluster-plugin\cluster-standalone-plugin) - 单机模式
  - [cluster-zookeeper-plugin](server-cluster-plugin\cluster-zookeeper-plugin) - 集群模式 ZK
-  [server-configuration](server-configuration) - 服务配置 提供了接入多种配置管理组件的
- [configuration-api](server-configuration\configuration-api) - 配置的通用代码及 API 定义
- [configuration-apollo](server-configuration\configuration-apollo) - Apollo 配置中心
- [configuration-consul](server-configuration\configuration-consul) - Spring Consul 配置中心
- [configuration-etcd](server-configuration\configuration-etcd) - etcd(分布式KV存储) 配置中心
- [configuration-k8s-configmap](server-configuration\configuration-k8s-configmap) - k8s
- [configuration-nacos](server-configuration\configuration-nacos) - nacos
- [configuration-zookeeper](server-configuration\configuration-zookeeper) - zookeeper
- [grpc-configuration-sync](server-configuration\grpc-configuration-sync) - grpc
- 可以扩展SW配置管理
- [server-core](server-core) - OAP服务核心衔接所有功能
  - 可以重构L1、L2数据聚合
  - [DownSamplingConfigService.java](server-core\src\main\java\org\apache\skywalking\oap\server\core\config\DownSamplingConfigService.java) 降低采样，通过减少数据采集，降低存储压力。
  - [SourceReceiver.java](server-core\src\main\java\org\apache\skywalking\oap\server\core\source\SourceReceiver.java) 添加数据上报的处理服务
  - [NetworkAddressAliasCache.java](server-core\src\main\java\org\apache\skywalking\oap\server\core\cache\NetworkAddressAliasCache.java) Address别名缓存
  - storage模块的接口定义：
    - org.apache.skywalking.oap.server.core.storage 包中定义接口 [storage](server-core\src\main\java\org\apache\skywalking\oap\server\core\storage)
    - org.apache.skywalking.oap.server.core.storage.StorageModule 中声明 方便其他模块使用 [StorageModule.java](server-core\src\main\java\org\apache\skywalking\oap\server\core\storage\StorageModule.java)
```java
public class StorageModule extends ModuleDefine {

  public Class[] services() {
    return new Class[] {
            // ...
            ITraceQueryDAO.class,
            // ...
    };
  }
}
```
- **可以重构L1、L2数据聚合**
- [server-fetcher-plugin](server-fetcher-plugin) - 提取器（主动拉取数据）
  - [kafka-fetcher-plugin](server-fetcher-plugin\kafka-fetcher-plugin) - 基于Kafka的数据拉取
  - [prometheus-fetcher-plugin](server-fetcher-plugin\prometheus-fetcher-plugin) - 基于Netty的Prometheus数据拉取
- [server-health-checker](server-health-checker) - 健康检查
- [server-library](server-library) - 公共模块部分
  - [library-client](server-library\library-client) - 连接 ES，gRpc，jdbc，redis 等客户端工具类
  - [library-module](server-library\library-module) - 模块管理相关功能
    - 所有模块的父类 org.apache.skywalking.oap.server.library.module.ModuleDefine [ModuleDefine.java](server-library\library-module\src\main\java\org\apache\skywalking\oap\server\library\module\ModuleDefine.java)
      - 自定义模块
```java
/**
 * SW使用SPI进行实例化
 */
public class StorageModule extends ModuleDefine {
  /**
   * NAME代表模块的名称，该名称与配置文件中的名称要一致
   */
  public static final String NAME = "storage";

  public StorageModule() {
    super(NAME);
  }

  /**
   * services方法中代表该模块能够提供哪些服务实现
   * @return Class[]
   */
  @Override
  public Class[] services() {
    return new Class[] {
            StorageDAO.class,
    };
  }
}
```

- [library-module](server-library\library-module)
  - 所有服务提供者的父类 org.apache.skywalking.oap.server.library.module.ModuleProvider [ModuleProvider.java](server-library\library-module\src\main\java\org\apache\skywalking\oap\server\library\module\ModuleProvider.java)
- [library-server](server-library\library-server) - gRpc，jetty 的服务发布的实现数据监听的工具类
- [library-util](server-library\library-util) - 工具包 包含 prometheus 数据格式解析，yaml 文本解析等
- [server-query-plugin](server-query-plugin) - 处理的是SKywalking前台发过来的查询请求
  - [query-graphql-plugin](server-query-plugin\query-graphql-plugin) - graphQL从查询处理
  - **这里自定义RestFull风格的查询处理**
  - V10版本引入了新的查询模块：PromQL、zipkin、logQL、debug等
- [server-receiver-plugin](server-receiver-plugin) - 接收器（被动接收数据）
  - SkyWalking Agent 发送来的 Metrics、Trace 以及 Register 等写入请求都是首先由该模块接收处理
  - [configuration-discovery-receiver-plugin](server-receiver-plugin\configuration-discovery-receiver-plugin) - 处理动态配置下发到 agent 的插件
  - [envoy-metrics-receiver-plugin](server-receiver-plugin\envoy-metrics-receiver-plugin)
  - [otel-receiver-plugin](server-receiver-plugin\otel-receiver-plugin) - 用于接收 OpenTelemetry 数据的插件
  - [receiver-proto](server-receiver-plugin\receiver-proto) - GRPC通讯定义
  - [skywalking-browser-receiver-plugin](server-receiver-plugin\skywalking-browser-receiver-plugin) - 接收端对端页面相关数据的插件
  - [skywalking-clr-receiver-plugin](server-receiver-plugin\skywalking-clr-receiver-plugin)
  - [skywalking-event-receiver-plugin](server-receiver-plugin\skywalking-event-receiver-plugin) - 用来接收事件数据
  - [skywalking-jvm-receiver-plugin](server-receiver-plugin\skywalking-jvm-receiver-plugin) - jvm 进程上报 Metrics 的 receiver 模块
  - [skywalking-log-recevier-plugin](server-receiver-plugin\skywalking-log-recevier-plugin) - 日志接收器插件
  - [skywalking-management-receiver-plugin](server-receiver-plugin\skywalking-management-receiver-plugin) - 用于接收管理数据，包括 agent 地址，版本信息，运行配置等
  - [skywalking-mesh-receiver-plugin](server-receiver-plugin\skywalking-mesh-receiver-plugin) - 用于接收 Mesh 上报的数据模块
  - [skywalking-meter-receiver-plugin](server-receiver-plugin\skywalking-meter-receiver-plugin) - 用于接收和处理度量数据，比如指标、计数器等
  - [skywalking-profile-receiver-plugin](server-receiver-plugin\skywalking-profile-receiver-plugin) - 处理性能剖析相关数据的模块
  - [skywalking-sharing-server-plugin](server-receiver-plugin\skywalking-sharing-server-plugin)
    - 额外的服务器模块,依据配置决定另起 grpc 和 jetty 服务,亦或是共用 core 模块的 grpc 与 jetty。
  - [skywalking-trace-receiver-plugin](server-receiver-plugin\skywalking-trace-receiver-plugin) - 链路 trace 数据上报的 receiver 模块
  - [skywalking-zabbix-receiver-plugin](server-receiver-plugin\skywalking-zabbix-receiver-plugin) - 对接 zabbix 相关数据插件
  - [zipkin-receiver-plugin](server-receiver-plugin\zipkin-receiver-plugin) - 对接 zipkin 相关数据插件。
- [server-starter](server-starter) - OAP 服务启动
- [server-starter-es7](server-starter-es7) - OAP 后端使用ES启动
- [server-storage-plugin](server-storage-plugin) - 存储模块
  - [storage-elasticsearch7-plugin](server-storage-plugin\storage-elasticsearch7-plugin) - elasticsearch 新特性升级
  - [storage-elasticsearch-plugin](server-storage-plugin\storage-elasticsearch-plugin) - elasticsearch
    - 分布式RESTful 搜索和分析引擎、可扩展的数据存储和向量数据库
    - 该模块包含了所有的操作ES的dao实现功能
    - DAO实现类需要在 org.apache.skywalking.oap.server.storage.plugin.elasticsearch.StorageModuleElasticsearchProvider 中声明 [StorageModuleElasticsearchProvider.java](server-storage-plugin\storage-elasticsearch-plugin\src\main\java\org\apache\skywalking\oap\server\storage\plugin\elasticsearch\StorageModuleElasticsearchProvider.java)
```java
public class StorageModuleElasticsearchProvider extends ModuleProvider {

  public void prepare() throws ServiceNotProvidedException {
    // ...
    this.registerServiceImplementation(StorageDAO.class, new StorageEsDAO(elasticSearchClient));
    // ...
  }
}
```
- [storage-influxdb-plugin](server-storage-plugin\storage-influxdb-plugin) - 分布式时序、事件和指标数据库
- [storage-jdbc-hikaricp-plugin](server-storage-plugin\storage-jdbc-hikaricp-plugin) - Java数据库连接池库
  - 添加自定义数据库
- [storage-tidb-plugin](server-storage-plugin\storage-tidb-plugin) - 分布式关系型数据库
- [storage-zipkin-elasticsearch7-plugin](server-storage-plugin\storage-zipkin-elasticsearch7-plugin) - 分布式实时数据追踪系统
- [server-telemetry](server-telemetry) - 自监控数据暴露模块
  - [telemetry-api](server-telemetry\telemetry-api) - 自监控公用 API
  - [telemetry-prometheus](server-telemetry\telemetry-prometheus) - 通过 prometheus 接口暴露自监控数据
- [server-testing](server-testing) - 测试服务
- [server-tools](server-tools) - 通用工具
  - [profile-exporter](server-tools\profile-exporter) - 导出
- 可以针对MQ进行扩展
- 可以针对业务进行扩展