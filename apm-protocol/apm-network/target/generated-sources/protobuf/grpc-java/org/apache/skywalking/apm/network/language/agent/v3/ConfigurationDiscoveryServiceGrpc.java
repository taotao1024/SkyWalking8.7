package org.apache.skywalking.apm.network.language.agent.v3;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Fetch the latest dynamic configurations of the service.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.32.1)",
    comments = "Source: language-agent/ConfigurationDiscoveryService.proto")
public final class ConfigurationDiscoveryServiceGrpc {

  private ConfigurationDiscoveryServiceGrpc() {}

  public static final String SERVICE_NAME = "skywalking.v3.ConfigurationDiscoveryService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.apache.skywalking.apm.network.language.agent.v3.ConfigurationSyncRequest,
      org.apache.skywalking.apm.network.common.v3.Commands> getFetchConfigurationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "fetchConfigurations",
      requestType = org.apache.skywalking.apm.network.language.agent.v3.ConfigurationSyncRequest.class,
      responseType = org.apache.skywalking.apm.network.common.v3.Commands.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.apache.skywalking.apm.network.language.agent.v3.ConfigurationSyncRequest,
      org.apache.skywalking.apm.network.common.v3.Commands> getFetchConfigurationsMethod() {
    io.grpc.MethodDescriptor<org.apache.skywalking.apm.network.language.agent.v3.ConfigurationSyncRequest, org.apache.skywalking.apm.network.common.v3.Commands> getFetchConfigurationsMethod;
    if ((getFetchConfigurationsMethod = ConfigurationDiscoveryServiceGrpc.getFetchConfigurationsMethod) == null) {
      synchronized (ConfigurationDiscoveryServiceGrpc.class) {
        if ((getFetchConfigurationsMethod = ConfigurationDiscoveryServiceGrpc.getFetchConfigurationsMethod) == null) {
          ConfigurationDiscoveryServiceGrpc.getFetchConfigurationsMethod = getFetchConfigurationsMethod =
              io.grpc.MethodDescriptor.<org.apache.skywalking.apm.network.language.agent.v3.ConfigurationSyncRequest, org.apache.skywalking.apm.network.common.v3.Commands>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "fetchConfigurations"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.skywalking.apm.network.language.agent.v3.ConfigurationSyncRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.skywalking.apm.network.common.v3.Commands.getDefaultInstance()))
              .setSchemaDescriptor(new ConfigurationDiscoveryServiceMethodDescriptorSupplier("fetchConfigurations"))
              .build();
        }
      }
    }
    return getFetchConfigurationsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ConfigurationDiscoveryServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConfigurationDiscoveryServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConfigurationDiscoveryServiceStub>() {
        @java.lang.Override
        public ConfigurationDiscoveryServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConfigurationDiscoveryServiceStub(channel, callOptions);
        }
      };
    return ConfigurationDiscoveryServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ConfigurationDiscoveryServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConfigurationDiscoveryServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConfigurationDiscoveryServiceBlockingStub>() {
        @java.lang.Override
        public ConfigurationDiscoveryServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConfigurationDiscoveryServiceBlockingStub(channel, callOptions);
        }
      };
    return ConfigurationDiscoveryServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ConfigurationDiscoveryServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConfigurationDiscoveryServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConfigurationDiscoveryServiceFutureStub>() {
        @java.lang.Override
        public ConfigurationDiscoveryServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConfigurationDiscoveryServiceFutureStub(channel, callOptions);
        }
      };
    return ConfigurationDiscoveryServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Fetch the latest dynamic configurations of the service.
   * </pre>
   */
  public static abstract class ConfigurationDiscoveryServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * fetchConfigurations service requests the latest configuration.
     * Expect command of Commands is:
     *    command: CDS # meaning ConfigurationDiscoveryService's response
     *    args: Include string key and string value pair.
     *          The key depends on the agent implementation.
     *          The value is the latest value in String value. The watcher of key owner takes the responsibility to convert it to the correct type or format.
     *          One reserved key is `UUID`. The value would help reducing the traffic load between agent and OAP if there is no change.
     * Commands could be empty if no change detected based on ConfigurationSyncRequest.
     * </pre>
     */
    public void fetchConfigurations(org.apache.skywalking.apm.network.language.agent.v3.ConfigurationSyncRequest request,
        io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.common.v3.Commands> responseObserver) {
      asyncUnimplementedUnaryCall(getFetchConfigurationsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFetchConfigurationsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.apache.skywalking.apm.network.language.agent.v3.ConfigurationSyncRequest,
                org.apache.skywalking.apm.network.common.v3.Commands>(
                  this, METHODID_FETCH_CONFIGURATIONS)))
          .build();
    }
  }

  /**
   * <pre>
   * Fetch the latest dynamic configurations of the service.
   * </pre>
   */
  public static final class ConfigurationDiscoveryServiceStub extends io.grpc.stub.AbstractAsyncStub<ConfigurationDiscoveryServiceStub> {
    private ConfigurationDiscoveryServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigurationDiscoveryServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConfigurationDiscoveryServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * fetchConfigurations service requests the latest configuration.
     * Expect command of Commands is:
     *    command: CDS # meaning ConfigurationDiscoveryService's response
     *    args: Include string key and string value pair.
     *          The key depends on the agent implementation.
     *          The value is the latest value in String value. The watcher of key owner takes the responsibility to convert it to the correct type or format.
     *          One reserved key is `UUID`. The value would help reducing the traffic load between agent and OAP if there is no change.
     * Commands could be empty if no change detected based on ConfigurationSyncRequest.
     * </pre>
     */
    public void fetchConfigurations(org.apache.skywalking.apm.network.language.agent.v3.ConfigurationSyncRequest request,
        io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.common.v3.Commands> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFetchConfigurationsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Fetch the latest dynamic configurations of the service.
   * </pre>
   */
  public static final class ConfigurationDiscoveryServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ConfigurationDiscoveryServiceBlockingStub> {
    private ConfigurationDiscoveryServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigurationDiscoveryServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConfigurationDiscoveryServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * fetchConfigurations service requests the latest configuration.
     * Expect command of Commands is:
     *    command: CDS # meaning ConfigurationDiscoveryService's response
     *    args: Include string key and string value pair.
     *          The key depends on the agent implementation.
     *          The value is the latest value in String value. The watcher of key owner takes the responsibility to convert it to the correct type or format.
     *          One reserved key is `UUID`. The value would help reducing the traffic load between agent and OAP if there is no change.
     * Commands could be empty if no change detected based on ConfigurationSyncRequest.
     * </pre>
     */
    public org.apache.skywalking.apm.network.common.v3.Commands fetchConfigurations(org.apache.skywalking.apm.network.language.agent.v3.ConfigurationSyncRequest request) {
      return blockingUnaryCall(
          getChannel(), getFetchConfigurationsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Fetch the latest dynamic configurations of the service.
   * </pre>
   */
  public static final class ConfigurationDiscoveryServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ConfigurationDiscoveryServiceFutureStub> {
    private ConfigurationDiscoveryServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigurationDiscoveryServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConfigurationDiscoveryServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * fetchConfigurations service requests the latest configuration.
     * Expect command of Commands is:
     *    command: CDS # meaning ConfigurationDiscoveryService's response
     *    args: Include string key and string value pair.
     *          The key depends on the agent implementation.
     *          The value is the latest value in String value. The watcher of key owner takes the responsibility to convert it to the correct type or format.
     *          One reserved key is `UUID`. The value would help reducing the traffic load between agent and OAP if there is no change.
     * Commands could be empty if no change detected based on ConfigurationSyncRequest.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.apache.skywalking.apm.network.common.v3.Commands> fetchConfigurations(
        org.apache.skywalking.apm.network.language.agent.v3.ConfigurationSyncRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getFetchConfigurationsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FETCH_CONFIGURATIONS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ConfigurationDiscoveryServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ConfigurationDiscoveryServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FETCH_CONFIGURATIONS:
          serviceImpl.fetchConfigurations((org.apache.skywalking.apm.network.language.agent.v3.ConfigurationSyncRequest) request,
              (io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.common.v3.Commands>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ConfigurationDiscoveryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ConfigurationDiscoveryServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.apache.skywalking.apm.network.language.agent.v3.ConfigurationDiscoveryServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ConfigurationDiscoveryService");
    }
  }

  private static final class ConfigurationDiscoveryServiceFileDescriptorSupplier
      extends ConfigurationDiscoveryServiceBaseDescriptorSupplier {
    ConfigurationDiscoveryServiceFileDescriptorSupplier() {}
  }

  private static final class ConfigurationDiscoveryServiceMethodDescriptorSupplier
      extends ConfigurationDiscoveryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ConfigurationDiscoveryServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ConfigurationDiscoveryServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ConfigurationDiscoveryServiceFileDescriptorSupplier())
              .addMethod(getFetchConfigurationsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
