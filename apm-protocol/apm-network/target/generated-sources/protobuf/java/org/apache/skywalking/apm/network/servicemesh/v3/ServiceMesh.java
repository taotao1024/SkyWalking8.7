// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service-mesh-probe/service-mesh.proto

package org.apache.skywalking.apm.network.servicemesh.v3;

public final class ServiceMesh {
  private ServiceMesh() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_skywalking_v3_ServiceMeshMetric_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_skywalking_v3_ServiceMeshMetric_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_skywalking_v3_TCPInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_skywalking_v3_TCPInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_skywalking_v3_MeshProbeDownstream_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_skywalking_v3_MeshProbeDownstream_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n%service-mesh-probe/service-mesh.proto\022" +
      "\rskywalking.v3\032\023common/Common.proto\"\235\003\n\021" +
      "ServiceMeshMetric\022\021\n\tstartTime\030\001 \001(\003\022\017\n\007" +
      "endTime\030\002 \001(\003\022\031\n\021sourceServiceName\030\003 \001(\t" +
      "\022\035\n\025sourceServiceInstance\030\004 \001(\t\022\027\n\017destS" +
      "erviceName\030\005 \001(\t\022\033\n\023destServiceInstance\030" +
      "\006 \001(\t\022\020\n\010endpoint\030\007 \001(\t\022\017\n\007latency\030\010 \001(\005" +
      "\022\024\n\014responseCode\030\t \001(\005\022\016\n\006status\030\n \001(\010\022)" +
      "\n\010protocol\030\013 \001(\0162\027.skywalking.v3.Protoco" +
      "l\022/\n\013detectPoint\030\014 \001(\0162\032.skywalking.v3.D" +
      "etectPoint\022\017\n\007tlsMode\030\r \001(\t\022\031\n\021internalE" +
      "rrorCode\030\016 \001(\t\022#\n\003tcp\030\017 \001(\0132\026.skywalking" +
      ".v3.TCPInfo\"3\n\007TCPInfo\022\025\n\rreceivedBytes\030" +
      "\001 \001(\003\022\021\n\tsentBytes\030\002 \001(\003\"\025\n\023MeshProbeDow" +
      "nstream*\'\n\010Protocol\022\010\n\004HTTP\020\000\022\010\n\004gRPC\020\001\022" +
      "\007\n\003TCP\020\0022o\n\030ServiceMeshMetricService\022S\n\007" +
      "collect\022 .skywalking.v3.ServiceMeshMetri" +
      "c\032\".skywalking.v3.MeshProbeDownstream\"\000(" +
      "\001B\215\001\n0org.apache.skywalking.apm.network." +
      "servicemesh.v3P\001Z7skywalking.apache.org/" +
      "repo/goapi/collect/servicemesh/v3\252\002\035SkyW" +
      "alking.NetworkProtocol.V3b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          org.apache.skywalking.apm.network.common.v3.Common.getDescriptor(),
        });
    internal_static_skywalking_v3_ServiceMeshMetric_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_skywalking_v3_ServiceMeshMetric_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_skywalking_v3_ServiceMeshMetric_descriptor,
        new java.lang.String[] { "StartTime", "EndTime", "SourceServiceName", "SourceServiceInstance", "DestServiceName", "DestServiceInstance", "Endpoint", "Latency", "ResponseCode", "Status", "Protocol", "DetectPoint", "TlsMode", "InternalErrorCode", "Tcp", });
    internal_static_skywalking_v3_TCPInfo_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_skywalking_v3_TCPInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_skywalking_v3_TCPInfo_descriptor,
        new java.lang.String[] { "ReceivedBytes", "SentBytes", });
    internal_static_skywalking_v3_MeshProbeDownstream_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_skywalking_v3_MeshProbeDownstream_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_skywalking_v3_MeshProbeDownstream_descriptor,
        new java.lang.String[] { });
    org.apache.skywalking.apm.network.common.v3.Common.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
