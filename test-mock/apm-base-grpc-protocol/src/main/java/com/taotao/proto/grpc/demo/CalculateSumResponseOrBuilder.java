// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: firstTest.proto

package com.taotao.proto.grpc.demo;

public interface CalculateSumResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:grpcprotocol.CalculateSumResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * 返回值
   * </pre>
   *
   * <code>int32 code = 1;</code>
   * @return The code.
   */
  int getCode();

  /**
   * <pre>
   *返回消息
   * </pre>
   *
   * <code>string note = 2;</code>
   * @return The note.
   */
  java.lang.String getNote();
  /**
   * <pre>
   *返回消息
   * </pre>
   *
   * <code>string note = 2;</code>
   * @return The bytes for note.
   */
  com.google.protobuf.ByteString
      getNoteBytes();

  /**
   * <code>int32 sum = 3;</code>
   * @return The sum.
   */
  int getSum();
}
