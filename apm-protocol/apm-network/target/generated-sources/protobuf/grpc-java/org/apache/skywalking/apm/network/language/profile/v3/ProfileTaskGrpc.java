package org.apache.skywalking.apm.network.language.profile.v3;

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
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.32.1)",
    comments = "Source: profile/Profile.proto")
public final class ProfileTaskGrpc {

  private ProfileTaskGrpc() {}

  public static final String SERVICE_NAME = "skywalking.v3.ProfileTask";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.apache.skywalking.apm.network.language.profile.v3.ProfileTaskCommandQuery,
      org.apache.skywalking.apm.network.common.v3.Commands> getGetProfileTaskCommandsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getProfileTaskCommands",
      requestType = org.apache.skywalking.apm.network.language.profile.v3.ProfileTaskCommandQuery.class,
      responseType = org.apache.skywalking.apm.network.common.v3.Commands.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.apache.skywalking.apm.network.language.profile.v3.ProfileTaskCommandQuery,
      org.apache.skywalking.apm.network.common.v3.Commands> getGetProfileTaskCommandsMethod() {
    io.grpc.MethodDescriptor<org.apache.skywalking.apm.network.language.profile.v3.ProfileTaskCommandQuery, org.apache.skywalking.apm.network.common.v3.Commands> getGetProfileTaskCommandsMethod;
    if ((getGetProfileTaskCommandsMethod = ProfileTaskGrpc.getGetProfileTaskCommandsMethod) == null) {
      synchronized (ProfileTaskGrpc.class) {
        if ((getGetProfileTaskCommandsMethod = ProfileTaskGrpc.getGetProfileTaskCommandsMethod) == null) {
          ProfileTaskGrpc.getGetProfileTaskCommandsMethod = getGetProfileTaskCommandsMethod =
              io.grpc.MethodDescriptor.<org.apache.skywalking.apm.network.language.profile.v3.ProfileTaskCommandQuery, org.apache.skywalking.apm.network.common.v3.Commands>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getProfileTaskCommands"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.skywalking.apm.network.language.profile.v3.ProfileTaskCommandQuery.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.skywalking.apm.network.common.v3.Commands.getDefaultInstance()))
              .setSchemaDescriptor(new ProfileTaskMethodDescriptorSupplier("getProfileTaskCommands"))
              .build();
        }
      }
    }
    return getGetProfileTaskCommandsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.apache.skywalking.apm.network.language.profile.v3.ThreadSnapshot,
      org.apache.skywalking.apm.network.common.v3.Commands> getCollectSnapshotMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "collectSnapshot",
      requestType = org.apache.skywalking.apm.network.language.profile.v3.ThreadSnapshot.class,
      responseType = org.apache.skywalking.apm.network.common.v3.Commands.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<org.apache.skywalking.apm.network.language.profile.v3.ThreadSnapshot,
      org.apache.skywalking.apm.network.common.v3.Commands> getCollectSnapshotMethod() {
    io.grpc.MethodDescriptor<org.apache.skywalking.apm.network.language.profile.v3.ThreadSnapshot, org.apache.skywalking.apm.network.common.v3.Commands> getCollectSnapshotMethod;
    if ((getCollectSnapshotMethod = ProfileTaskGrpc.getCollectSnapshotMethod) == null) {
      synchronized (ProfileTaskGrpc.class) {
        if ((getCollectSnapshotMethod = ProfileTaskGrpc.getCollectSnapshotMethod) == null) {
          ProfileTaskGrpc.getCollectSnapshotMethod = getCollectSnapshotMethod =
              io.grpc.MethodDescriptor.<org.apache.skywalking.apm.network.language.profile.v3.ThreadSnapshot, org.apache.skywalking.apm.network.common.v3.Commands>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "collectSnapshot"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.skywalking.apm.network.language.profile.v3.ThreadSnapshot.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.skywalking.apm.network.common.v3.Commands.getDefaultInstance()))
              .setSchemaDescriptor(new ProfileTaskMethodDescriptorSupplier("collectSnapshot"))
              .build();
        }
      }
    }
    return getCollectSnapshotMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.apache.skywalking.apm.network.language.profile.v3.ProfileTaskFinishReport,
      org.apache.skywalking.apm.network.common.v3.Commands> getReportTaskFinishMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "reportTaskFinish",
      requestType = org.apache.skywalking.apm.network.language.profile.v3.ProfileTaskFinishReport.class,
      responseType = org.apache.skywalking.apm.network.common.v3.Commands.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.apache.skywalking.apm.network.language.profile.v3.ProfileTaskFinishReport,
      org.apache.skywalking.apm.network.common.v3.Commands> getReportTaskFinishMethod() {
    io.grpc.MethodDescriptor<org.apache.skywalking.apm.network.language.profile.v3.ProfileTaskFinishReport, org.apache.skywalking.apm.network.common.v3.Commands> getReportTaskFinishMethod;
    if ((getReportTaskFinishMethod = ProfileTaskGrpc.getReportTaskFinishMethod) == null) {
      synchronized (ProfileTaskGrpc.class) {
        if ((getReportTaskFinishMethod = ProfileTaskGrpc.getReportTaskFinishMethod) == null) {
          ProfileTaskGrpc.getReportTaskFinishMethod = getReportTaskFinishMethod =
              io.grpc.MethodDescriptor.<org.apache.skywalking.apm.network.language.profile.v3.ProfileTaskFinishReport, org.apache.skywalking.apm.network.common.v3.Commands>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "reportTaskFinish"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.skywalking.apm.network.language.profile.v3.ProfileTaskFinishReport.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.skywalking.apm.network.common.v3.Commands.getDefaultInstance()))
              .setSchemaDescriptor(new ProfileTaskMethodDescriptorSupplier("reportTaskFinish"))
              .build();
        }
      }
    }
    return getReportTaskFinishMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProfileTaskStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProfileTaskStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProfileTaskStub>() {
        @java.lang.Override
        public ProfileTaskStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProfileTaskStub(channel, callOptions);
        }
      };
    return ProfileTaskStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProfileTaskBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProfileTaskBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProfileTaskBlockingStub>() {
        @java.lang.Override
        public ProfileTaskBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProfileTaskBlockingStub(channel, callOptions);
        }
      };
    return ProfileTaskBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProfileTaskFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProfileTaskFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProfileTaskFutureStub>() {
        @java.lang.Override
        public ProfileTaskFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProfileTaskFutureStub(channel, callOptions);
        }
      };
    return ProfileTaskFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ProfileTaskImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * query all sniffer need to execute profile task commands
     * </pre>
     */
    public void getProfileTaskCommands(org.apache.skywalking.apm.network.language.profile.v3.ProfileTaskCommandQuery request,
        io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.common.v3.Commands> responseObserver) {
      asyncUnimplementedUnaryCall(getGetProfileTaskCommandsMethod(), responseObserver);
    }

    /**
     * <pre>
     * collect dumped thread snapshot
     * </pre>
     */
    public io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.language.profile.v3.ThreadSnapshot> collectSnapshot(
        io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.common.v3.Commands> responseObserver) {
      return asyncUnimplementedStreamingCall(getCollectSnapshotMethod(), responseObserver);
    }

    /**
     * <pre>
     * report profiling task finished
     * </pre>
     */
    public void reportTaskFinish(org.apache.skywalking.apm.network.language.profile.v3.ProfileTaskFinishReport request,
        io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.common.v3.Commands> responseObserver) {
      asyncUnimplementedUnaryCall(getReportTaskFinishMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetProfileTaskCommandsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.apache.skywalking.apm.network.language.profile.v3.ProfileTaskCommandQuery,
                org.apache.skywalking.apm.network.common.v3.Commands>(
                  this, METHODID_GET_PROFILE_TASK_COMMANDS)))
          .addMethod(
            getCollectSnapshotMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                org.apache.skywalking.apm.network.language.profile.v3.ThreadSnapshot,
                org.apache.skywalking.apm.network.common.v3.Commands>(
                  this, METHODID_COLLECT_SNAPSHOT)))
          .addMethod(
            getReportTaskFinishMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.apache.skywalking.apm.network.language.profile.v3.ProfileTaskFinishReport,
                org.apache.skywalking.apm.network.common.v3.Commands>(
                  this, METHODID_REPORT_TASK_FINISH)))
          .build();
    }
  }

  /**
   */
  public static final class ProfileTaskStub extends io.grpc.stub.AbstractAsyncStub<ProfileTaskStub> {
    private ProfileTaskStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProfileTaskStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProfileTaskStub(channel, callOptions);
    }

    /**
     * <pre>
     * query all sniffer need to execute profile task commands
     * </pre>
     */
    public void getProfileTaskCommands(org.apache.skywalking.apm.network.language.profile.v3.ProfileTaskCommandQuery request,
        io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.common.v3.Commands> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetProfileTaskCommandsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * collect dumped thread snapshot
     * </pre>
     */
    public io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.language.profile.v3.ThreadSnapshot> collectSnapshot(
        io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.common.v3.Commands> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getCollectSnapshotMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * report profiling task finished
     * </pre>
     */
    public void reportTaskFinish(org.apache.skywalking.apm.network.language.profile.v3.ProfileTaskFinishReport request,
        io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.common.v3.Commands> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReportTaskFinishMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ProfileTaskBlockingStub extends io.grpc.stub.AbstractBlockingStub<ProfileTaskBlockingStub> {
    private ProfileTaskBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProfileTaskBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProfileTaskBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * query all sniffer need to execute profile task commands
     * </pre>
     */
    public org.apache.skywalking.apm.network.common.v3.Commands getProfileTaskCommands(org.apache.skywalking.apm.network.language.profile.v3.ProfileTaskCommandQuery request) {
      return blockingUnaryCall(
          getChannel(), getGetProfileTaskCommandsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * report profiling task finished
     * </pre>
     */
    public org.apache.skywalking.apm.network.common.v3.Commands reportTaskFinish(org.apache.skywalking.apm.network.language.profile.v3.ProfileTaskFinishReport request) {
      return blockingUnaryCall(
          getChannel(), getReportTaskFinishMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ProfileTaskFutureStub extends io.grpc.stub.AbstractFutureStub<ProfileTaskFutureStub> {
    private ProfileTaskFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProfileTaskFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProfileTaskFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * query all sniffer need to execute profile task commands
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.apache.skywalking.apm.network.common.v3.Commands> getProfileTaskCommands(
        org.apache.skywalking.apm.network.language.profile.v3.ProfileTaskCommandQuery request) {
      return futureUnaryCall(
          getChannel().newCall(getGetProfileTaskCommandsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * report profiling task finished
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.apache.skywalking.apm.network.common.v3.Commands> reportTaskFinish(
        org.apache.skywalking.apm.network.language.profile.v3.ProfileTaskFinishReport request) {
      return futureUnaryCall(
          getChannel().newCall(getReportTaskFinishMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PROFILE_TASK_COMMANDS = 0;
  private static final int METHODID_REPORT_TASK_FINISH = 1;
  private static final int METHODID_COLLECT_SNAPSHOT = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ProfileTaskImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ProfileTaskImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_PROFILE_TASK_COMMANDS:
          serviceImpl.getProfileTaskCommands((org.apache.skywalking.apm.network.language.profile.v3.ProfileTaskCommandQuery) request,
              (io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.common.v3.Commands>) responseObserver);
          break;
        case METHODID_REPORT_TASK_FINISH:
          serviceImpl.reportTaskFinish((org.apache.skywalking.apm.network.language.profile.v3.ProfileTaskFinishReport) request,
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
        case METHODID_COLLECT_SNAPSHOT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.collectSnapshot(
              (io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.common.v3.Commands>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ProfileTaskBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProfileTaskBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.apache.skywalking.apm.network.language.profile.v3.Profile.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProfileTask");
    }
  }

  private static final class ProfileTaskFileDescriptorSupplier
      extends ProfileTaskBaseDescriptorSupplier {
    ProfileTaskFileDescriptorSupplier() {}
  }

  private static final class ProfileTaskMethodDescriptorSupplier
      extends ProfileTaskBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ProfileTaskMethodDescriptorSupplier(String methodName) {
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
      synchronized (ProfileTaskGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProfileTaskFileDescriptorSupplier())
              .addMethod(getGetProfileTaskCommandsMethod())
              .addMethod(getCollectSnapshotMethod())
              .addMethod(getReportTaskFinishMethod())
              .build();
        }
      }
    }
    return result;
  }
}
