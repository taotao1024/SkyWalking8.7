# Mock测试程序

Mock - 测试程序
-
- [apm-application-mock](apm-application-mock) - SpringBoot父工程
- [apm-application-mock-a](apm-application-mock-a) - 应用A
  - mock-a --> mock-b
- [apm-application-mock-b](apm-application-mock-b) - 应用B
  - mock-b --> mock-c
- [apm-application-mock-c](apm-application-mock-c) - 应用C
  - endPoint
- [apm-application-test](apm-application-test) - Demo

# 快速开始
1、启动应用前 添加JVM启动参数
```
-javaagent:D:\002.code\taotao1024\SkyWalking8.7\skywalking-agent\skywalking-agent.jar
-DSW_AGENT_NAME=DEMO::MOCK-A
-DSW_AGENT_INSTANCE_NAME=DEMO-MOCK
-DSW_AGENT_KEEP_TRACING=true
-DSW_AGENT_COLLECTOR_BACKEND_SERVICES=127.0.0.1:11800
-DSW_KAFKA_NAMESPACE=TEST_MOCK
```

```
# 指定Java代理的路径，方便追踪。
-javaagent:D:\002.code\taotao1024\SkyWalking8.7\skywalking-agent\skywalking-agent.jar
# 定义了SkyWalking代理的名称，DEMO为服务MOCK-B为应用。
-DSW_AGENT_NAME=DEMO::MOCK-B
# 定义应用的实例名称，主要用于多实例场景区分不同实例。
-DSW_AGENT_INSTANCE_NAME=DEMO-MOCK
# 请求完成后仍然保留追踪数据
-DSW_AGENT_KEEP_TRACING=true
# 指定SkyWalking Collector的地址，通常是OAP服务地址。
-DSW_AGENT_COLLECTOR_BACKEND_SERVICES=127.0.0.1:11800
# KAFKA命名空间
-DSW_KAFKA_NAMESPACE=TEST_MOCK
```
