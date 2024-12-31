// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: firstTest.proto

package com.taotao.proto.grpc.demo;

/**
 * <pre>
 *-------------------------------------------------
 * </pre>
 *
 * Protobuf type {@code grpcprotocol.CalculateSumRequest}
 */
public final class CalculateSumRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:grpcprotocol.CalculateSumRequest)
    CalculateSumRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use CalculateSumRequest.newBuilder() to construct.
  private CalculateSumRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CalculateSumRequest() {
    number_ = emptyIntList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new CalculateSumRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private CalculateSumRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
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
          case 8: {

            id_ = input.readInt32();
            break;
          }
          case 16: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              number_ = newIntList();
              mutable_bitField0_ |= 0x00000001;
            }
            number_.addInt(input.readInt32());
            break;
          }
          case 18: {
            int length = input.readRawVarint32();
            int limit = input.pushLimit(length);
            if (!((mutable_bitField0_ & 0x00000001) != 0) && input.getBytesUntilLimit() > 0) {
              number_ = newIntList();
              mutable_bitField0_ |= 0x00000001;
            }
            while (input.getBytesUntilLimit() > 0) {
              number_.addInt(input.readInt32());
            }
            input.popLimit(limit);
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
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        number_.makeImmutable(); // C
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.taotao.proto.grpc.demo.FirstTestServiceProtos.internal_static_grpcprotocol_CalculateSumRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.taotao.proto.grpc.demo.FirstTestServiceProtos.internal_static_grpcprotocol_CalculateSumRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.taotao.proto.grpc.demo.CalculateSumRequest.class, com.taotao.proto.grpc.demo.CalculateSumRequest.Builder.class);
  }

  public static final int ID_FIELD_NUMBER = 1;
  private int id_;
  /**
   * <code>int32 id = 1;</code>
   * @return The id.
   */
  @java.lang.Override
  public int getId() {
    return id_;
  }

  public static final int NUMBER_FIELD_NUMBER = 2;
  private com.google.protobuf.Internal.IntList number_;
  /**
   * <code>repeated int32 number = 2;</code>
   * @return A list containing the number.
   */
  @java.lang.Override
  public java.util.List<java.lang.Integer>
      getNumberList() {
    return number_;
  }
  /**
   * <code>repeated int32 number = 2;</code>
   * @return The count of number.
   */
  public int getNumberCount() {
    return number_.size();
  }
  /**
   * <code>repeated int32 number = 2;</code>
   * @param index The index of the element to return.
   * @return The number at the given index.
   */
  public int getNumber(int index) {
    return number_.getInt(index);
  }
  private int numberMemoizedSerializedSize = -1;

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
    getSerializedSize();
    if (id_ != 0) {
      output.writeInt32(1, id_);
    }
    if (getNumberList().size() > 0) {
      output.writeUInt32NoTag(18);
      output.writeUInt32NoTag(numberMemoizedSerializedSize);
    }
    for (int i = 0; i < number_.size(); i++) {
      output.writeInt32NoTag(number_.getInt(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (id_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, id_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < number_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeInt32SizeNoTag(number_.getInt(i));
      }
      size += dataSize;
      if (!getNumberList().isEmpty()) {
        size += 1;
        size += com.google.protobuf.CodedOutputStream
            .computeInt32SizeNoTag(dataSize);
      }
      numberMemoizedSerializedSize = dataSize;
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
    if (!(obj instanceof com.taotao.proto.grpc.demo.CalculateSumRequest)) {
      return super.equals(obj);
    }
    com.taotao.proto.grpc.demo.CalculateSumRequest other = (com.taotao.proto.grpc.demo.CalculateSumRequest) obj;

    if (getId()
        != other.getId()) return false;
    if (!getNumberList()
        .equals(other.getNumberList())) return false;
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
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + getId();
    if (getNumberCount() > 0) {
      hash = (37 * hash) + NUMBER_FIELD_NUMBER;
      hash = (53 * hash) + getNumberList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.taotao.proto.grpc.demo.CalculateSumRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.taotao.proto.grpc.demo.CalculateSumRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.taotao.proto.grpc.demo.CalculateSumRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.taotao.proto.grpc.demo.CalculateSumRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.taotao.proto.grpc.demo.CalculateSumRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.taotao.proto.grpc.demo.CalculateSumRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.taotao.proto.grpc.demo.CalculateSumRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.taotao.proto.grpc.demo.CalculateSumRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.taotao.proto.grpc.demo.CalculateSumRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.taotao.proto.grpc.demo.CalculateSumRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.taotao.proto.grpc.demo.CalculateSumRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.taotao.proto.grpc.demo.CalculateSumRequest parseFrom(
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
  public static Builder newBuilder(com.taotao.proto.grpc.demo.CalculateSumRequest prototype) {
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
   *-------------------------------------------------
   * </pre>
   *
   * Protobuf type {@code grpcprotocol.CalculateSumRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:grpcprotocol.CalculateSumRequest)
      com.taotao.proto.grpc.demo.CalculateSumRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.taotao.proto.grpc.demo.FirstTestServiceProtos.internal_static_grpcprotocol_CalculateSumRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.taotao.proto.grpc.demo.FirstTestServiceProtos.internal_static_grpcprotocol_CalculateSumRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.taotao.proto.grpc.demo.CalculateSumRequest.class, com.taotao.proto.grpc.demo.CalculateSumRequest.Builder.class);
    }

    // Construct using com.taotao.proto.grpc.demo.CalculateSumRequest.newBuilder()
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
      id_ = 0;

      number_ = emptyIntList();
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.taotao.proto.grpc.demo.FirstTestServiceProtos.internal_static_grpcprotocol_CalculateSumRequest_descriptor;
    }

    @java.lang.Override
    public com.taotao.proto.grpc.demo.CalculateSumRequest getDefaultInstanceForType() {
      return com.taotao.proto.grpc.demo.CalculateSumRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.taotao.proto.grpc.demo.CalculateSumRequest build() {
      com.taotao.proto.grpc.demo.CalculateSumRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.taotao.proto.grpc.demo.CalculateSumRequest buildPartial() {
      com.taotao.proto.grpc.demo.CalculateSumRequest result = new com.taotao.proto.grpc.demo.CalculateSumRequest(this);
      int from_bitField0_ = bitField0_;
      result.id_ = id_;
      if (((bitField0_ & 0x00000001) != 0)) {
        number_.makeImmutable();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.number_ = number_;
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
      if (other instanceof com.taotao.proto.grpc.demo.CalculateSumRequest) {
        return mergeFrom((com.taotao.proto.grpc.demo.CalculateSumRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.taotao.proto.grpc.demo.CalculateSumRequest other) {
      if (other == com.taotao.proto.grpc.demo.CalculateSumRequest.getDefaultInstance()) return this;
      if (other.getId() != 0) {
        setId(other.getId());
      }
      if (!other.number_.isEmpty()) {
        if (number_.isEmpty()) {
          number_ = other.number_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureNumberIsMutable();
          number_.addAll(other.number_);
        }
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
      com.taotao.proto.grpc.demo.CalculateSumRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.taotao.proto.grpc.demo.CalculateSumRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int id_ ;
    /**
     * <code>int32 id = 1;</code>
     * @return The id.
     */
    @java.lang.Override
    public int getId() {
      return id_;
    }
    /**
     * <code>int32 id = 1;</code>
     * @param value The id to set.
     * @return This builder for chaining.
     */
    public Builder setId(int value) {
      
      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearId() {
      
      id_ = 0;
      onChanged();
      return this;
    }

    private com.google.protobuf.Internal.IntList number_ = emptyIntList();
    private void ensureNumberIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        number_ = mutableCopy(number_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated int32 number = 2;</code>
     * @return A list containing the number.
     */
    public java.util.List<java.lang.Integer>
        getNumberList() {
      return ((bitField0_ & 0x00000001) != 0) ?
               java.util.Collections.unmodifiableList(number_) : number_;
    }
    /**
     * <code>repeated int32 number = 2;</code>
     * @return The count of number.
     */
    public int getNumberCount() {
      return number_.size();
    }
    /**
     * <code>repeated int32 number = 2;</code>
     * @param index The index of the element to return.
     * @return The number at the given index.
     */
    public int getNumber(int index) {
      return number_.getInt(index);
    }
    /**
     * <code>repeated int32 number = 2;</code>
     * @param index The index to set the value at.
     * @param value The number to set.
     * @return This builder for chaining.
     */
    public Builder setNumber(
        int index, int value) {
      ensureNumberIsMutable();
      number_.setInt(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int32 number = 2;</code>
     * @param value The number to add.
     * @return This builder for chaining.
     */
    public Builder addNumber(int value) {
      ensureNumberIsMutable();
      number_.addInt(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int32 number = 2;</code>
     * @param values The number to add.
     * @return This builder for chaining.
     */
    public Builder addAllNumber(
        java.lang.Iterable<? extends java.lang.Integer> values) {
      ensureNumberIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, number_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int32 number = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearNumber() {
      number_ = emptyIntList();
      bitField0_ = (bitField0_ & ~0x00000001);
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


    // @@protoc_insertion_point(builder_scope:grpcprotocol.CalculateSumRequest)
  }

  // @@protoc_insertion_point(class_scope:grpcprotocol.CalculateSumRequest)
  private static final com.taotao.proto.grpc.demo.CalculateSumRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.taotao.proto.grpc.demo.CalculateSumRequest();
  }

  public static com.taotao.proto.grpc.demo.CalculateSumRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CalculateSumRequest>
      PARSER = new com.google.protobuf.AbstractParser<CalculateSumRequest>() {
    @java.lang.Override
    public CalculateSumRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new CalculateSumRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<CalculateSumRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CalculateSumRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.taotao.proto.grpc.demo.CalculateSumRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

