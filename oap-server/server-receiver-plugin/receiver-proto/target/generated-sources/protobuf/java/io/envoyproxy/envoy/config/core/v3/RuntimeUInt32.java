// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: envoy/config/core/v3/base.proto

package io.envoyproxy.envoy.config.core.v3;

/**
 * <pre>
 * Runtime derived uint32 with a default when not specified.
 * </pre>
 *
 * Protobuf type {@code envoy.config.core.v3.RuntimeUInt32}
 */
public final class RuntimeUInt32 extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:envoy.config.core.v3.RuntimeUInt32)
    RuntimeUInt32OrBuilder {
private static final long serialVersionUID = 0L;
  // Use RuntimeUInt32.newBuilder() to construct.
  private RuntimeUInt32(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RuntimeUInt32() {
    runtimeKey_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new RuntimeUInt32();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private RuntimeUInt32(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 16: {

            defaultValue_ = input.readUInt32();
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            runtimeKey_ = s;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.envoyproxy.envoy.config.core.v3.BaseProto.internal_static_envoy_config_core_v3_RuntimeUInt32_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.envoyproxy.envoy.config.core.v3.BaseProto.internal_static_envoy_config_core_v3_RuntimeUInt32_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.envoyproxy.envoy.config.core.v3.RuntimeUInt32.class, io.envoyproxy.envoy.config.core.v3.RuntimeUInt32.Builder.class);
  }

  public static final int DEFAULT_VALUE_FIELD_NUMBER = 2;
  private int defaultValue_;
  /**
   * <pre>
   * Default value if runtime value is not available.
   * </pre>
   *
   * <code>uint32 default_value = 2;</code>
   * @return The defaultValue.
   */
  @java.lang.Override
  public int getDefaultValue() {
    return defaultValue_;
  }

  public static final int RUNTIME_KEY_FIELD_NUMBER = 3;
  private volatile java.lang.Object runtimeKey_;
  /**
   * <pre>
   * Runtime key to get value for comparison. This value is used if defined.
   * </pre>
   *
   * <code>string runtime_key = 3 [(.validate.rules) = { ... }</code>
   * @return The runtimeKey.
   */
  @java.lang.Override
  public java.lang.String getRuntimeKey() {
    java.lang.Object ref = runtimeKey_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      runtimeKey_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * Runtime key to get value for comparison. This value is used if defined.
   * </pre>
   *
   * <code>string runtime_key = 3 [(.validate.rules) = { ... }</code>
   * @return The bytes for runtimeKey.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getRuntimeKeyBytes() {
    java.lang.Object ref = runtimeKey_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      runtimeKey_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (defaultValue_ != 0) {
      output.writeUInt32(2, defaultValue_);
    }
    if (!getRuntimeKeyBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, runtimeKey_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (defaultValue_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(2, defaultValue_);
    }
    if (!getRuntimeKeyBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, runtimeKey_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof io.envoyproxy.envoy.config.core.v3.RuntimeUInt32)) {
      return super.equals(obj);
    }
    io.envoyproxy.envoy.config.core.v3.RuntimeUInt32 other = (io.envoyproxy.envoy.config.core.v3.RuntimeUInt32) obj;

    if (getDefaultValue()
        != other.getDefaultValue()) return false;
    if (!getRuntimeKey()
        .equals(other.getRuntimeKey())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + DEFAULT_VALUE_FIELD_NUMBER;
    hash = (53 * hash) + getDefaultValue();
    hash = (37 * hash) + RUNTIME_KEY_FIELD_NUMBER;
    hash = (53 * hash) + getRuntimeKey().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.envoyproxy.envoy.config.core.v3.RuntimeUInt32 parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.envoyproxy.envoy.config.core.v3.RuntimeUInt32 parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.envoyproxy.envoy.config.core.v3.RuntimeUInt32 parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.envoyproxy.envoy.config.core.v3.RuntimeUInt32 parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.envoyproxy.envoy.config.core.v3.RuntimeUInt32 parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.envoyproxy.envoy.config.core.v3.RuntimeUInt32 parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.envoyproxy.envoy.config.core.v3.RuntimeUInt32 parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.envoyproxy.envoy.config.core.v3.RuntimeUInt32 parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.envoyproxy.envoy.config.core.v3.RuntimeUInt32 parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.envoyproxy.envoy.config.core.v3.RuntimeUInt32 parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.envoyproxy.envoy.config.core.v3.RuntimeUInt32 parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.envoyproxy.envoy.config.core.v3.RuntimeUInt32 parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(io.envoyproxy.envoy.config.core.v3.RuntimeUInt32 prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * Runtime derived uint32 with a default when not specified.
   * </pre>
   *
   * Protobuf type {@code envoy.config.core.v3.RuntimeUInt32}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:envoy.config.core.v3.RuntimeUInt32)
      io.envoyproxy.envoy.config.core.v3.RuntimeUInt32OrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.envoyproxy.envoy.config.core.v3.BaseProto.internal_static_envoy_config_core_v3_RuntimeUInt32_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.envoyproxy.envoy.config.core.v3.BaseProto.internal_static_envoy_config_core_v3_RuntimeUInt32_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.envoyproxy.envoy.config.core.v3.RuntimeUInt32.class, io.envoyproxy.envoy.config.core.v3.RuntimeUInt32.Builder.class);
    }

    // Construct using io.envoyproxy.envoy.config.core.v3.RuntimeUInt32.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      defaultValue_ = 0;

      runtimeKey_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.envoyproxy.envoy.config.core.v3.BaseProto.internal_static_envoy_config_core_v3_RuntimeUInt32_descriptor;
    }

    @java.lang.Override
    public io.envoyproxy.envoy.config.core.v3.RuntimeUInt32 getDefaultInstanceForType() {
      return io.envoyproxy.envoy.config.core.v3.RuntimeUInt32.getDefaultInstance();
    }

    @java.lang.Override
    public io.envoyproxy.envoy.config.core.v3.RuntimeUInt32 build() {
      io.envoyproxy.envoy.config.core.v3.RuntimeUInt32 result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.envoyproxy.envoy.config.core.v3.RuntimeUInt32 buildPartial() {
      io.envoyproxy.envoy.config.core.v3.RuntimeUInt32 result = new io.envoyproxy.envoy.config.core.v3.RuntimeUInt32(this);
      result.defaultValue_ = defaultValue_;
      result.runtimeKey_ = runtimeKey_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof io.envoyproxy.envoy.config.core.v3.RuntimeUInt32) {
        return mergeFrom((io.envoyproxy.envoy.config.core.v3.RuntimeUInt32)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.envoyproxy.envoy.config.core.v3.RuntimeUInt32 other) {
      if (other == io.envoyproxy.envoy.config.core.v3.RuntimeUInt32.getDefaultInstance()) return this;
      if (other.getDefaultValue() != 0) {
        setDefaultValue(other.getDefaultValue());
      }
      if (!other.getRuntimeKey().isEmpty()) {
        runtimeKey_ = other.runtimeKey_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      io.envoyproxy.envoy.config.core.v3.RuntimeUInt32 parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (io.envoyproxy.envoy.config.core.v3.RuntimeUInt32) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int defaultValue_ ;
    /**
     * <pre>
     * Default value if runtime value is not available.
     * </pre>
     *
     * <code>uint32 default_value = 2;</code>
     * @return The defaultValue.
     */
    @java.lang.Override
    public int getDefaultValue() {
      return defaultValue_;
    }
    /**
     * <pre>
     * Default value if runtime value is not available.
     * </pre>
     *
     * <code>uint32 default_value = 2;</code>
     * @param value The defaultValue to set.
     * @return This builder for chaining.
     */
    public Builder setDefaultValue(int value) {
      
      defaultValue_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Default value if runtime value is not available.
     * </pre>
     *
     * <code>uint32 default_value = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearDefaultValue() {
      
      defaultValue_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object runtimeKey_ = "";
    /**
     * <pre>
     * Runtime key to get value for comparison. This value is used if defined.
     * </pre>
     *
     * <code>string runtime_key = 3 [(.validate.rules) = { ... }</code>
     * @return The runtimeKey.
     */
    public java.lang.String getRuntimeKey() {
      java.lang.Object ref = runtimeKey_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        runtimeKey_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * Runtime key to get value for comparison. This value is used if defined.
     * </pre>
     *
     * <code>string runtime_key = 3 [(.validate.rules) = { ... }</code>
     * @return The bytes for runtimeKey.
     */
    public com.google.protobuf.ByteString
        getRuntimeKeyBytes() {
      java.lang.Object ref = runtimeKey_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        runtimeKey_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * Runtime key to get value for comparison. This value is used if defined.
     * </pre>
     *
     * <code>string runtime_key = 3 [(.validate.rules) = { ... }</code>
     * @param value The runtimeKey to set.
     * @return This builder for chaining.
     */
    public Builder setRuntimeKey(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      runtimeKey_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Runtime key to get value for comparison. This value is used if defined.
     * </pre>
     *
     * <code>string runtime_key = 3 [(.validate.rules) = { ... }</code>
     * @return This builder for chaining.
     */
    public Builder clearRuntimeKey() {
      
      runtimeKey_ = getDefaultInstance().getRuntimeKey();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Runtime key to get value for comparison. This value is used if defined.
     * </pre>
     *
     * <code>string runtime_key = 3 [(.validate.rules) = { ... }</code>
     * @param value The bytes for runtimeKey to set.
     * @return This builder for chaining.
     */
    public Builder setRuntimeKeyBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      runtimeKey_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:envoy.config.core.v3.RuntimeUInt32)
  }

  // @@protoc_insertion_point(class_scope:envoy.config.core.v3.RuntimeUInt32)
  private static final io.envoyproxy.envoy.config.core.v3.RuntimeUInt32 DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.envoyproxy.envoy.config.core.v3.RuntimeUInt32();
  }

  public static io.envoyproxy.envoy.config.core.v3.RuntimeUInt32 getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RuntimeUInt32>
      PARSER = new com.google.protobuf.AbstractParser<RuntimeUInt32>() {
    @java.lang.Override
    public RuntimeUInt32 parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new RuntimeUInt32(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<RuntimeUInt32> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RuntimeUInt32> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.envoyproxy.envoy.config.core.v3.RuntimeUInt32 getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

