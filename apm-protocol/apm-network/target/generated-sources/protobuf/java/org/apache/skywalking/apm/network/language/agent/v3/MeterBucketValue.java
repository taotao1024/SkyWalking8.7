// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: language-agent/Meter.proto

package org.apache.skywalking.apm.network.language.agent.v3;

/**
 * <pre>
 * The histogram element definition. It includes the bucket lower boundary and the count in the bucket.
 * </pre>
 *
 * Protobuf type {@code skywalking.v3.MeterBucketValue}
 */
public final class MeterBucketValue extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:skywalking.v3.MeterBucketValue)
    MeterBucketValueOrBuilder {
private static final long serialVersionUID = 0L;
  // Use MeterBucketValue.newBuilder() to construct.
  private MeterBucketValue(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private MeterBucketValue() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new MeterBucketValue();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private MeterBucketValue(
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
          case 9: {

            bucket_ = input.readDouble();
            break;
          }
          case 16: {

            count_ = input.readInt64();
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
    return org.apache.skywalking.apm.network.language.agent.v3.Meter.internal_static_skywalking_v3_MeterBucketValue_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.apache.skywalking.apm.network.language.agent.v3.Meter.internal_static_skywalking_v3_MeterBucketValue_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.apache.skywalking.apm.network.language.agent.v3.MeterBucketValue.class, org.apache.skywalking.apm.network.language.agent.v3.MeterBucketValue.Builder.class);
  }

  public static final int BUCKET_FIELD_NUMBER = 1;
  private double bucket_;
  /**
   * <pre>
   * The value represents the min value of the bucket,
   * the  upper boundary is determined by next MeterBucketValue$bucket,
   * if it doesn't exist, the upper boundary is positive infinity.
   * Also, could use Int32.MIN_VALUE to represent negative infinity.
   * </pre>
   *
   * <code>double bucket = 1;</code>
   * @return The bucket.
   */
  @java.lang.Override
  public double getBucket() {
    return bucket_;
  }

  public static final int COUNT_FIELD_NUMBER = 2;
  private long count_;
  /**
   * <code>int64 count = 2;</code>
   * @return The count.
   */
  @java.lang.Override
  public long getCount() {
    return count_;
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
    if (bucket_ != 0D) {
      output.writeDouble(1, bucket_);
    }
    if (count_ != 0L) {
      output.writeInt64(2, count_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (bucket_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(1, bucket_);
    }
    if (count_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, count_);
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
    if (!(obj instanceof org.apache.skywalking.apm.network.language.agent.v3.MeterBucketValue)) {
      return super.equals(obj);
    }
    org.apache.skywalking.apm.network.language.agent.v3.MeterBucketValue other = (org.apache.skywalking.apm.network.language.agent.v3.MeterBucketValue) obj;

    if (java.lang.Double.doubleToLongBits(getBucket())
        != java.lang.Double.doubleToLongBits(
            other.getBucket())) return false;
    if (getCount()
        != other.getCount()) return false;
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
    hash = (37 * hash) + BUCKET_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getBucket()));
    hash = (37 * hash) + COUNT_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getCount());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.apache.skywalking.apm.network.language.agent.v3.MeterBucketValue parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.apache.skywalking.apm.network.language.agent.v3.MeterBucketValue parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.apache.skywalking.apm.network.language.agent.v3.MeterBucketValue parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.apache.skywalking.apm.network.language.agent.v3.MeterBucketValue parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.apache.skywalking.apm.network.language.agent.v3.MeterBucketValue parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.apache.skywalking.apm.network.language.agent.v3.MeterBucketValue parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.apache.skywalking.apm.network.language.agent.v3.MeterBucketValue parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.apache.skywalking.apm.network.language.agent.v3.MeterBucketValue parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.apache.skywalking.apm.network.language.agent.v3.MeterBucketValue parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.apache.skywalking.apm.network.language.agent.v3.MeterBucketValue parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.apache.skywalking.apm.network.language.agent.v3.MeterBucketValue parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.apache.skywalking.apm.network.language.agent.v3.MeterBucketValue parseFrom(
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
  public static Builder newBuilder(org.apache.skywalking.apm.network.language.agent.v3.MeterBucketValue prototype) {
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
   * The histogram element definition. It includes the bucket lower boundary and the count in the bucket.
   * </pre>
   *
   * Protobuf type {@code skywalking.v3.MeterBucketValue}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:skywalking.v3.MeterBucketValue)
      org.apache.skywalking.apm.network.language.agent.v3.MeterBucketValueOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.apache.skywalking.apm.network.language.agent.v3.Meter.internal_static_skywalking_v3_MeterBucketValue_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.apache.skywalking.apm.network.language.agent.v3.Meter.internal_static_skywalking_v3_MeterBucketValue_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.apache.skywalking.apm.network.language.agent.v3.MeterBucketValue.class, org.apache.skywalking.apm.network.language.agent.v3.MeterBucketValue.Builder.class);
    }

    // Construct using org.apache.skywalking.apm.network.language.agent.v3.MeterBucketValue.newBuilder()
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
      bucket_ = 0D;

      count_ = 0L;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.apache.skywalking.apm.network.language.agent.v3.Meter.internal_static_skywalking_v3_MeterBucketValue_descriptor;
    }

    @java.lang.Override
    public org.apache.skywalking.apm.network.language.agent.v3.MeterBucketValue getDefaultInstanceForType() {
      return org.apache.skywalking.apm.network.language.agent.v3.MeterBucketValue.getDefaultInstance();
    }

    @java.lang.Override
    public org.apache.skywalking.apm.network.language.agent.v3.MeterBucketValue build() {
      org.apache.skywalking.apm.network.language.agent.v3.MeterBucketValue result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.apache.skywalking.apm.network.language.agent.v3.MeterBucketValue buildPartial() {
      org.apache.skywalking.apm.network.language.agent.v3.MeterBucketValue result = new org.apache.skywalking.apm.network.language.agent.v3.MeterBucketValue(this);
      result.bucket_ = bucket_;
      result.count_ = count_;
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
      if (other instanceof org.apache.skywalking.apm.network.language.agent.v3.MeterBucketValue) {
        return mergeFrom((org.apache.skywalking.apm.network.language.agent.v3.MeterBucketValue)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.apache.skywalking.apm.network.language.agent.v3.MeterBucketValue other) {
      if (other == org.apache.skywalking.apm.network.language.agent.v3.MeterBucketValue.getDefaultInstance()) return this;
      if (other.getBucket() != 0D) {
        setBucket(other.getBucket());
      }
      if (other.getCount() != 0L) {
        setCount(other.getCount());
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
      org.apache.skywalking.apm.network.language.agent.v3.MeterBucketValue parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.apache.skywalking.apm.network.language.agent.v3.MeterBucketValue) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private double bucket_ ;
    /**
     * <pre>
     * The value represents the min value of the bucket,
     * the  upper boundary is determined by next MeterBucketValue$bucket,
     * if it doesn't exist, the upper boundary is positive infinity.
     * Also, could use Int32.MIN_VALUE to represent negative infinity.
     * </pre>
     *
     * <code>double bucket = 1;</code>
     * @return The bucket.
     */
    @java.lang.Override
    public double getBucket() {
      return bucket_;
    }
    /**
     * <pre>
     * The value represents the min value of the bucket,
     * the  upper boundary is determined by next MeterBucketValue$bucket,
     * if it doesn't exist, the upper boundary is positive infinity.
     * Also, could use Int32.MIN_VALUE to represent negative infinity.
     * </pre>
     *
     * <code>double bucket = 1;</code>
     * @param value The bucket to set.
     * @return This builder for chaining.
     */
    public Builder setBucket(double value) {
      
      bucket_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * The value represents the min value of the bucket,
     * the  upper boundary is determined by next MeterBucketValue$bucket,
     * if it doesn't exist, the upper boundary is positive infinity.
     * Also, could use Int32.MIN_VALUE to represent negative infinity.
     * </pre>
     *
     * <code>double bucket = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearBucket() {
      
      bucket_ = 0D;
      onChanged();
      return this;
    }

    private long count_ ;
    /**
     * <code>int64 count = 2;</code>
     * @return The count.
     */
    @java.lang.Override
    public long getCount() {
      return count_;
    }
    /**
     * <code>int64 count = 2;</code>
     * @param value The count to set.
     * @return This builder for chaining.
     */
    public Builder setCount(long value) {
      
      count_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 count = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearCount() {
      
      count_ = 0L;
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


    // @@protoc_insertion_point(builder_scope:skywalking.v3.MeterBucketValue)
  }

  // @@protoc_insertion_point(class_scope:skywalking.v3.MeterBucketValue)
  private static final org.apache.skywalking.apm.network.language.agent.v3.MeterBucketValue DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.apache.skywalking.apm.network.language.agent.v3.MeterBucketValue();
  }

  public static org.apache.skywalking.apm.network.language.agent.v3.MeterBucketValue getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MeterBucketValue>
      PARSER = new com.google.protobuf.AbstractParser<MeterBucketValue>() {
    @java.lang.Override
    public MeterBucketValue parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new MeterBucketValue(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<MeterBucketValue> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<MeterBucketValue> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.apache.skywalking.apm.network.language.agent.v3.MeterBucketValue getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

