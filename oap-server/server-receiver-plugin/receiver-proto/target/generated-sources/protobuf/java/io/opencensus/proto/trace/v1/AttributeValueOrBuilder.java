// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: opencensus/proto/trace/v1/trace.proto

package io.opencensus.proto.trace.v1;

public interface AttributeValueOrBuilder extends
    // @@protoc_insertion_point(interface_extends:opencensus.proto.trace.v1.AttributeValue)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * A string up to 256 bytes long.
   * </pre>
   *
   * <code>.opencensus.proto.trace.v1.TruncatableString string_value = 1;</code>
   * @return Whether the stringValue field is set.
   */
  boolean hasStringValue();
  /**
   * <pre>
   * A string up to 256 bytes long.
   * </pre>
   *
   * <code>.opencensus.proto.trace.v1.TruncatableString string_value = 1;</code>
   * @return The stringValue.
   */
  io.opencensus.proto.trace.v1.TruncatableString getStringValue();
  /**
   * <pre>
   * A string up to 256 bytes long.
   * </pre>
   *
   * <code>.opencensus.proto.trace.v1.TruncatableString string_value = 1;</code>
   */
  io.opencensus.proto.trace.v1.TruncatableStringOrBuilder getStringValueOrBuilder();

  /**
   * <pre>
   * A 64-bit signed integer.
   * </pre>
   *
   * <code>int64 int_value = 2;</code>
   * @return The intValue.
   */
  long getIntValue();

  /**
   * <pre>
   * A Boolean value represented by `true` or `false`.
   * </pre>
   *
   * <code>bool bool_value = 3;</code>
   * @return The boolValue.
   */
  boolean getBoolValue();

  /**
   * <pre>
   * A double value.
   * </pre>
   *
   * <code>double double_value = 4;</code>
   * @return The doubleValue.
   */
  double getDoubleValue();

  public io.opencensus.proto.trace.v1.AttributeValue.ValueCase getValueCase();
}
