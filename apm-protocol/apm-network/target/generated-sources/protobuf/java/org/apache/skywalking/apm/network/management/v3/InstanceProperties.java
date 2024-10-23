// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: management/Management.proto

package org.apache.skywalking.apm.network.management.v3;

/**
 * Protobuf type {@code skywalking.v3.InstanceProperties}
 */
public final class InstanceProperties extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:skywalking.v3.InstanceProperties)
    InstancePropertiesOrBuilder {
private static final long serialVersionUID = 0L;
  // Use InstanceProperties.newBuilder() to construct.
  private InstanceProperties(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private InstanceProperties() {
    service_ = "";
    serviceInstance_ = "";
    properties_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new InstanceProperties();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private InstanceProperties(
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
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            service_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            serviceInstance_ = s;
            break;
          }
          case 26: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              properties_ = new java.util.ArrayList<org.apache.skywalking.apm.network.common.v3.KeyStringValuePair>();
              mutable_bitField0_ |= 0x00000001;
            }
            properties_.add(
                input.readMessage(org.apache.skywalking.apm.network.common.v3.KeyStringValuePair.parser(), extensionRegistry));
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
        properties_ = java.util.Collections.unmodifiableList(properties_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.apache.skywalking.apm.network.management.v3.Management.internal_static_skywalking_v3_InstanceProperties_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.apache.skywalking.apm.network.management.v3.Management.internal_static_skywalking_v3_InstanceProperties_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.apache.skywalking.apm.network.management.v3.InstanceProperties.class, org.apache.skywalking.apm.network.management.v3.InstanceProperties.Builder.class);
  }

  public static final int SERVICE_FIELD_NUMBER = 1;
  private volatile java.lang.Object service_;
  /**
   * <code>string service = 1;</code>
   * @return The service.
   */
  @java.lang.Override
  public java.lang.String getService() {
    java.lang.Object ref = service_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      service_ = s;
      return s;
    }
  }
  /**
   * <code>string service = 1;</code>
   * @return The bytes for service.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getServiceBytes() {
    java.lang.Object ref = service_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      service_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SERVICEINSTANCE_FIELD_NUMBER = 2;
  private volatile java.lang.Object serviceInstance_;
  /**
   * <code>string serviceInstance = 2;</code>
   * @return The serviceInstance.
   */
  @java.lang.Override
  public java.lang.String getServiceInstance() {
    java.lang.Object ref = serviceInstance_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      serviceInstance_ = s;
      return s;
    }
  }
  /**
   * <code>string serviceInstance = 2;</code>
   * @return The bytes for serviceInstance.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getServiceInstanceBytes() {
    java.lang.Object ref = serviceInstance_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      serviceInstance_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PROPERTIES_FIELD_NUMBER = 3;
  private java.util.List<org.apache.skywalking.apm.network.common.v3.KeyStringValuePair> properties_;
  /**
   * <code>repeated .skywalking.v3.KeyStringValuePair properties = 3;</code>
   */
  @java.lang.Override
  public java.util.List<org.apache.skywalking.apm.network.common.v3.KeyStringValuePair> getPropertiesList() {
    return properties_;
  }
  /**
   * <code>repeated .skywalking.v3.KeyStringValuePair properties = 3;</code>
   */
  @java.lang.Override
  public java.util.List<? extends org.apache.skywalking.apm.network.common.v3.KeyStringValuePairOrBuilder> 
      getPropertiesOrBuilderList() {
    return properties_;
  }
  /**
   * <code>repeated .skywalking.v3.KeyStringValuePair properties = 3;</code>
   */
  @java.lang.Override
  public int getPropertiesCount() {
    return properties_.size();
  }
  /**
   * <code>repeated .skywalking.v3.KeyStringValuePair properties = 3;</code>
   */
  @java.lang.Override
  public org.apache.skywalking.apm.network.common.v3.KeyStringValuePair getProperties(int index) {
    return properties_.get(index);
  }
  /**
   * <code>repeated .skywalking.v3.KeyStringValuePair properties = 3;</code>
   */
  @java.lang.Override
  public org.apache.skywalking.apm.network.common.v3.KeyStringValuePairOrBuilder getPropertiesOrBuilder(
      int index) {
    return properties_.get(index);
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
    if (!getServiceBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, service_);
    }
    if (!getServiceInstanceBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, serviceInstance_);
    }
    for (int i = 0; i < properties_.size(); i++) {
      output.writeMessage(3, properties_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getServiceBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, service_);
    }
    if (!getServiceInstanceBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, serviceInstance_);
    }
    for (int i = 0; i < properties_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, properties_.get(i));
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
    if (!(obj instanceof org.apache.skywalking.apm.network.management.v3.InstanceProperties)) {
      return super.equals(obj);
    }
    org.apache.skywalking.apm.network.management.v3.InstanceProperties other = (org.apache.skywalking.apm.network.management.v3.InstanceProperties) obj;

    if (!getService()
        .equals(other.getService())) return false;
    if (!getServiceInstance()
        .equals(other.getServiceInstance())) return false;
    if (!getPropertiesList()
        .equals(other.getPropertiesList())) return false;
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
    hash = (37 * hash) + SERVICE_FIELD_NUMBER;
    hash = (53 * hash) + getService().hashCode();
    hash = (37 * hash) + SERVICEINSTANCE_FIELD_NUMBER;
    hash = (53 * hash) + getServiceInstance().hashCode();
    if (getPropertiesCount() > 0) {
      hash = (37 * hash) + PROPERTIES_FIELD_NUMBER;
      hash = (53 * hash) + getPropertiesList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.apache.skywalking.apm.network.management.v3.InstanceProperties parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.apache.skywalking.apm.network.management.v3.InstanceProperties parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.apache.skywalking.apm.network.management.v3.InstanceProperties parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.apache.skywalking.apm.network.management.v3.InstanceProperties parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.apache.skywalking.apm.network.management.v3.InstanceProperties parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.apache.skywalking.apm.network.management.v3.InstanceProperties parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.apache.skywalking.apm.network.management.v3.InstanceProperties parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.apache.skywalking.apm.network.management.v3.InstanceProperties parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.apache.skywalking.apm.network.management.v3.InstanceProperties parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.apache.skywalking.apm.network.management.v3.InstanceProperties parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.apache.skywalking.apm.network.management.v3.InstanceProperties parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.apache.skywalking.apm.network.management.v3.InstanceProperties parseFrom(
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
  public static Builder newBuilder(org.apache.skywalking.apm.network.management.v3.InstanceProperties prototype) {
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
   * Protobuf type {@code skywalking.v3.InstanceProperties}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:skywalking.v3.InstanceProperties)
      org.apache.skywalking.apm.network.management.v3.InstancePropertiesOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.apache.skywalking.apm.network.management.v3.Management.internal_static_skywalking_v3_InstanceProperties_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.apache.skywalking.apm.network.management.v3.Management.internal_static_skywalking_v3_InstanceProperties_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.apache.skywalking.apm.network.management.v3.InstanceProperties.class, org.apache.skywalking.apm.network.management.v3.InstanceProperties.Builder.class);
    }

    // Construct using org.apache.skywalking.apm.network.management.v3.InstanceProperties.newBuilder()
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
        getPropertiesFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      service_ = "";

      serviceInstance_ = "";

      if (propertiesBuilder_ == null) {
        properties_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        propertiesBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.apache.skywalking.apm.network.management.v3.Management.internal_static_skywalking_v3_InstanceProperties_descriptor;
    }

    @java.lang.Override
    public org.apache.skywalking.apm.network.management.v3.InstanceProperties getDefaultInstanceForType() {
      return org.apache.skywalking.apm.network.management.v3.InstanceProperties.getDefaultInstance();
    }

    @java.lang.Override
    public org.apache.skywalking.apm.network.management.v3.InstanceProperties build() {
      org.apache.skywalking.apm.network.management.v3.InstanceProperties result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.apache.skywalking.apm.network.management.v3.InstanceProperties buildPartial() {
      org.apache.skywalking.apm.network.management.v3.InstanceProperties result = new org.apache.skywalking.apm.network.management.v3.InstanceProperties(this);
      int from_bitField0_ = bitField0_;
      result.service_ = service_;
      result.serviceInstance_ = serviceInstance_;
      if (propertiesBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          properties_ = java.util.Collections.unmodifiableList(properties_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.properties_ = properties_;
      } else {
        result.properties_ = propertiesBuilder_.build();
      }
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
      if (other instanceof org.apache.skywalking.apm.network.management.v3.InstanceProperties) {
        return mergeFrom((org.apache.skywalking.apm.network.management.v3.InstanceProperties)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.apache.skywalking.apm.network.management.v3.InstanceProperties other) {
      if (other == org.apache.skywalking.apm.network.management.v3.InstanceProperties.getDefaultInstance()) return this;
      if (!other.getService().isEmpty()) {
        service_ = other.service_;
        onChanged();
      }
      if (!other.getServiceInstance().isEmpty()) {
        serviceInstance_ = other.serviceInstance_;
        onChanged();
      }
      if (propertiesBuilder_ == null) {
        if (!other.properties_.isEmpty()) {
          if (properties_.isEmpty()) {
            properties_ = other.properties_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensurePropertiesIsMutable();
            properties_.addAll(other.properties_);
          }
          onChanged();
        }
      } else {
        if (!other.properties_.isEmpty()) {
          if (propertiesBuilder_.isEmpty()) {
            propertiesBuilder_.dispose();
            propertiesBuilder_ = null;
            properties_ = other.properties_;
            bitField0_ = (bitField0_ & ~0x00000001);
            propertiesBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getPropertiesFieldBuilder() : null;
          } else {
            propertiesBuilder_.addAllMessages(other.properties_);
          }
        }
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
      org.apache.skywalking.apm.network.management.v3.InstanceProperties parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.apache.skywalking.apm.network.management.v3.InstanceProperties) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object service_ = "";
    /**
     * <code>string service = 1;</code>
     * @return The service.
     */
    public java.lang.String getService() {
      java.lang.Object ref = service_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        service_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string service = 1;</code>
     * @return The bytes for service.
     */
    public com.google.protobuf.ByteString
        getServiceBytes() {
      java.lang.Object ref = service_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        service_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string service = 1;</code>
     * @param value The service to set.
     * @return This builder for chaining.
     */
    public Builder setService(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      service_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string service = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearService() {
      
      service_ = getDefaultInstance().getService();
      onChanged();
      return this;
    }
    /**
     * <code>string service = 1;</code>
     * @param value The bytes for service to set.
     * @return This builder for chaining.
     */
    public Builder setServiceBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      service_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object serviceInstance_ = "";
    /**
     * <code>string serviceInstance = 2;</code>
     * @return The serviceInstance.
     */
    public java.lang.String getServiceInstance() {
      java.lang.Object ref = serviceInstance_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        serviceInstance_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string serviceInstance = 2;</code>
     * @return The bytes for serviceInstance.
     */
    public com.google.protobuf.ByteString
        getServiceInstanceBytes() {
      java.lang.Object ref = serviceInstance_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        serviceInstance_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string serviceInstance = 2;</code>
     * @param value The serviceInstance to set.
     * @return This builder for chaining.
     */
    public Builder setServiceInstance(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      serviceInstance_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string serviceInstance = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearServiceInstance() {
      
      serviceInstance_ = getDefaultInstance().getServiceInstance();
      onChanged();
      return this;
    }
    /**
     * <code>string serviceInstance = 2;</code>
     * @param value The bytes for serviceInstance to set.
     * @return This builder for chaining.
     */
    public Builder setServiceInstanceBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      serviceInstance_ = value;
      onChanged();
      return this;
    }

    private java.util.List<org.apache.skywalking.apm.network.common.v3.KeyStringValuePair> properties_ =
      java.util.Collections.emptyList();
    private void ensurePropertiesIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        properties_ = new java.util.ArrayList<org.apache.skywalking.apm.network.common.v3.KeyStringValuePair>(properties_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        org.apache.skywalking.apm.network.common.v3.KeyStringValuePair, org.apache.skywalking.apm.network.common.v3.KeyStringValuePair.Builder, org.apache.skywalking.apm.network.common.v3.KeyStringValuePairOrBuilder> propertiesBuilder_;

    /**
     * <code>repeated .skywalking.v3.KeyStringValuePair properties = 3;</code>
     */
    public java.util.List<org.apache.skywalking.apm.network.common.v3.KeyStringValuePair> getPropertiesList() {
      if (propertiesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(properties_);
      } else {
        return propertiesBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .skywalking.v3.KeyStringValuePair properties = 3;</code>
     */
    public int getPropertiesCount() {
      if (propertiesBuilder_ == null) {
        return properties_.size();
      } else {
        return propertiesBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .skywalking.v3.KeyStringValuePair properties = 3;</code>
     */
    public org.apache.skywalking.apm.network.common.v3.KeyStringValuePair getProperties(int index) {
      if (propertiesBuilder_ == null) {
        return properties_.get(index);
      } else {
        return propertiesBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .skywalking.v3.KeyStringValuePair properties = 3;</code>
     */
    public Builder setProperties(
        int index, org.apache.skywalking.apm.network.common.v3.KeyStringValuePair value) {
      if (propertiesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePropertiesIsMutable();
        properties_.set(index, value);
        onChanged();
      } else {
        propertiesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .skywalking.v3.KeyStringValuePair properties = 3;</code>
     */
    public Builder setProperties(
        int index, org.apache.skywalking.apm.network.common.v3.KeyStringValuePair.Builder builderForValue) {
      if (propertiesBuilder_ == null) {
        ensurePropertiesIsMutable();
        properties_.set(index, builderForValue.build());
        onChanged();
      } else {
        propertiesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .skywalking.v3.KeyStringValuePair properties = 3;</code>
     */
    public Builder addProperties(org.apache.skywalking.apm.network.common.v3.KeyStringValuePair value) {
      if (propertiesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePropertiesIsMutable();
        properties_.add(value);
        onChanged();
      } else {
        propertiesBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .skywalking.v3.KeyStringValuePair properties = 3;</code>
     */
    public Builder addProperties(
        int index, org.apache.skywalking.apm.network.common.v3.KeyStringValuePair value) {
      if (propertiesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePropertiesIsMutable();
        properties_.add(index, value);
        onChanged();
      } else {
        propertiesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .skywalking.v3.KeyStringValuePair properties = 3;</code>
     */
    public Builder addProperties(
        org.apache.skywalking.apm.network.common.v3.KeyStringValuePair.Builder builderForValue) {
      if (propertiesBuilder_ == null) {
        ensurePropertiesIsMutable();
        properties_.add(builderForValue.build());
        onChanged();
      } else {
        propertiesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .skywalking.v3.KeyStringValuePair properties = 3;</code>
     */
    public Builder addProperties(
        int index, org.apache.skywalking.apm.network.common.v3.KeyStringValuePair.Builder builderForValue) {
      if (propertiesBuilder_ == null) {
        ensurePropertiesIsMutable();
        properties_.add(index, builderForValue.build());
        onChanged();
      } else {
        propertiesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .skywalking.v3.KeyStringValuePair properties = 3;</code>
     */
    public Builder addAllProperties(
        java.lang.Iterable<? extends org.apache.skywalking.apm.network.common.v3.KeyStringValuePair> values) {
      if (propertiesBuilder_ == null) {
        ensurePropertiesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, properties_);
        onChanged();
      } else {
        propertiesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .skywalking.v3.KeyStringValuePair properties = 3;</code>
     */
    public Builder clearProperties() {
      if (propertiesBuilder_ == null) {
        properties_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        propertiesBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .skywalking.v3.KeyStringValuePair properties = 3;</code>
     */
    public Builder removeProperties(int index) {
      if (propertiesBuilder_ == null) {
        ensurePropertiesIsMutable();
        properties_.remove(index);
        onChanged();
      } else {
        propertiesBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .skywalking.v3.KeyStringValuePair properties = 3;</code>
     */
    public org.apache.skywalking.apm.network.common.v3.KeyStringValuePair.Builder getPropertiesBuilder(
        int index) {
      return getPropertiesFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .skywalking.v3.KeyStringValuePair properties = 3;</code>
     */
    public org.apache.skywalking.apm.network.common.v3.KeyStringValuePairOrBuilder getPropertiesOrBuilder(
        int index) {
      if (propertiesBuilder_ == null) {
        return properties_.get(index);  } else {
        return propertiesBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .skywalking.v3.KeyStringValuePair properties = 3;</code>
     */
    public java.util.List<? extends org.apache.skywalking.apm.network.common.v3.KeyStringValuePairOrBuilder> 
         getPropertiesOrBuilderList() {
      if (propertiesBuilder_ != null) {
        return propertiesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(properties_);
      }
    }
    /**
     * <code>repeated .skywalking.v3.KeyStringValuePair properties = 3;</code>
     */
    public org.apache.skywalking.apm.network.common.v3.KeyStringValuePair.Builder addPropertiesBuilder() {
      return getPropertiesFieldBuilder().addBuilder(
          org.apache.skywalking.apm.network.common.v3.KeyStringValuePair.getDefaultInstance());
    }
    /**
     * <code>repeated .skywalking.v3.KeyStringValuePair properties = 3;</code>
     */
    public org.apache.skywalking.apm.network.common.v3.KeyStringValuePair.Builder addPropertiesBuilder(
        int index) {
      return getPropertiesFieldBuilder().addBuilder(
          index, org.apache.skywalking.apm.network.common.v3.KeyStringValuePair.getDefaultInstance());
    }
    /**
     * <code>repeated .skywalking.v3.KeyStringValuePair properties = 3;</code>
     */
    public java.util.List<org.apache.skywalking.apm.network.common.v3.KeyStringValuePair.Builder> 
         getPropertiesBuilderList() {
      return getPropertiesFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        org.apache.skywalking.apm.network.common.v3.KeyStringValuePair, org.apache.skywalking.apm.network.common.v3.KeyStringValuePair.Builder, org.apache.skywalking.apm.network.common.v3.KeyStringValuePairOrBuilder> 
        getPropertiesFieldBuilder() {
      if (propertiesBuilder_ == null) {
        propertiesBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            org.apache.skywalking.apm.network.common.v3.KeyStringValuePair, org.apache.skywalking.apm.network.common.v3.KeyStringValuePair.Builder, org.apache.skywalking.apm.network.common.v3.KeyStringValuePairOrBuilder>(
                properties_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        properties_ = null;
      }
      return propertiesBuilder_;
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


    // @@protoc_insertion_point(builder_scope:skywalking.v3.InstanceProperties)
  }

  // @@protoc_insertion_point(class_scope:skywalking.v3.InstanceProperties)
  private static final org.apache.skywalking.apm.network.management.v3.InstanceProperties DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.apache.skywalking.apm.network.management.v3.InstanceProperties();
  }

  public static org.apache.skywalking.apm.network.management.v3.InstanceProperties getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<InstanceProperties>
      PARSER = new com.google.protobuf.AbstractParser<InstanceProperties>() {
    @java.lang.Override
    public InstanceProperties parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new InstanceProperties(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<InstanceProperties> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<InstanceProperties> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.apache.skywalking.apm.network.management.v3.InstanceProperties getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

