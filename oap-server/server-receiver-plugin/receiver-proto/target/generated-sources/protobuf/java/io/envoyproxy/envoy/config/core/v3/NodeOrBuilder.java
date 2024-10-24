// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: envoy/config/core/v3/base.proto

package io.envoyproxy.envoy.config.core.v3;

public interface NodeOrBuilder extends
    // @@protoc_insertion_point(interface_extends:envoy.config.core.v3.Node)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * An opaque node identifier for the Envoy node. This also provides the local
   * service node name. It should be set if any of the following features are
   * used: :ref:`statsd &lt;arch_overview_statistics&gt;`, :ref:`CDS
   * &lt;config_cluster_manager_cds&gt;`, and :ref:`HTTP tracing
   * &lt;arch_overview_tracing&gt;`, either in this message or via
   * :option:`--service-node`.
   * </pre>
   *
   * <code>string id = 1;</code>
   * @return The id.
   */
  java.lang.String getId();
  /**
   * <pre>
   * An opaque node identifier for the Envoy node. This also provides the local
   * service node name. It should be set if any of the following features are
   * used: :ref:`statsd &lt;arch_overview_statistics&gt;`, :ref:`CDS
   * &lt;config_cluster_manager_cds&gt;`, and :ref:`HTTP tracing
   * &lt;arch_overview_tracing&gt;`, either in this message or via
   * :option:`--service-node`.
   * </pre>
   *
   * <code>string id = 1;</code>
   * @return The bytes for id.
   */
  com.google.protobuf.ByteString
      getIdBytes();

  /**
   * <pre>
   * Defines the local service cluster name where Envoy is running. Though
   * optional, it should be set if any of the following features are used:
   * :ref:`statsd &lt;arch_overview_statistics&gt;`, :ref:`health check cluster
   * verification
   * &lt;envoy_api_field_config.core.v3.HealthCheck.HttpHealthCheck.service_name_matcher&gt;`,
   * :ref:`runtime override directory &lt;envoy_api_msg_config.bootstrap.v3.Runtime&gt;`,
   * :ref:`user agent addition
   * &lt;envoy_api_field_extensions.filters.network.http_connection_manager.v3.HttpConnectionManager.add_user_agent&gt;`,
   * :ref:`HTTP global rate limiting &lt;config_http_filters_rate_limit&gt;`,
   * :ref:`CDS &lt;config_cluster_manager_cds&gt;`, and :ref:`HTTP tracing
   * &lt;arch_overview_tracing&gt;`, either in this message or via
   * :option:`--service-cluster`.
   * </pre>
   *
   * <code>string cluster = 2;</code>
   * @return The cluster.
   */
  java.lang.String getCluster();
  /**
   * <pre>
   * Defines the local service cluster name where Envoy is running. Though
   * optional, it should be set if any of the following features are used:
   * :ref:`statsd &lt;arch_overview_statistics&gt;`, :ref:`health check cluster
   * verification
   * &lt;envoy_api_field_config.core.v3.HealthCheck.HttpHealthCheck.service_name_matcher&gt;`,
   * :ref:`runtime override directory &lt;envoy_api_msg_config.bootstrap.v3.Runtime&gt;`,
   * :ref:`user agent addition
   * &lt;envoy_api_field_extensions.filters.network.http_connection_manager.v3.HttpConnectionManager.add_user_agent&gt;`,
   * :ref:`HTTP global rate limiting &lt;config_http_filters_rate_limit&gt;`,
   * :ref:`CDS &lt;config_cluster_manager_cds&gt;`, and :ref:`HTTP tracing
   * &lt;arch_overview_tracing&gt;`, either in this message or via
   * :option:`--service-cluster`.
   * </pre>
   *
   * <code>string cluster = 2;</code>
   * @return The bytes for cluster.
   */
  com.google.protobuf.ByteString
      getClusterBytes();

  /**
   * <pre>
   * Opaque metadata extending the node identifier. Envoy will pass this
   * directly to the management server.
   * </pre>
   *
   * <code>.google.protobuf.Struct metadata = 3;</code>
   * @return Whether the metadata field is set.
   */
  boolean hasMetadata();
  /**
   * <pre>
   * Opaque metadata extending the node identifier. Envoy will pass this
   * directly to the management server.
   * </pre>
   *
   * <code>.google.protobuf.Struct metadata = 3;</code>
   * @return The metadata.
   */
  com.google.protobuf.Struct getMetadata();
  /**
   * <pre>
   * Opaque metadata extending the node identifier. Envoy will pass this
   * directly to the management server.
   * </pre>
   *
   * <code>.google.protobuf.Struct metadata = 3;</code>
   */
  com.google.protobuf.StructOrBuilder getMetadataOrBuilder();

  /**
   * <pre>
   * Locality specifying where the Envoy instance is running.
   * </pre>
   *
   * <code>.envoy.config.core.v3.Locality locality = 4;</code>
   * @return Whether the locality field is set.
   */
  boolean hasLocality();
  /**
   * <pre>
   * Locality specifying where the Envoy instance is running.
   * </pre>
   *
   * <code>.envoy.config.core.v3.Locality locality = 4;</code>
   * @return The locality.
   */
  io.envoyproxy.envoy.config.core.v3.Locality getLocality();
  /**
   * <pre>
   * Locality specifying where the Envoy instance is running.
   * </pre>
   *
   * <code>.envoy.config.core.v3.Locality locality = 4;</code>
   */
  io.envoyproxy.envoy.config.core.v3.LocalityOrBuilder getLocalityOrBuilder();

  /**
   * <pre>
   * Free-form string that identifies the entity requesting config.
   * E.g. "envoy" or "grpc"
   * </pre>
   *
   * <code>string user_agent_name = 6;</code>
   * @return The userAgentName.
   */
  java.lang.String getUserAgentName();
  /**
   * <pre>
   * Free-form string that identifies the entity requesting config.
   * E.g. "envoy" or "grpc"
   * </pre>
   *
   * <code>string user_agent_name = 6;</code>
   * @return The bytes for userAgentName.
   */
  com.google.protobuf.ByteString
      getUserAgentNameBytes();

  /**
   * <pre>
   * Free-form string that identifies the version of the entity requesting config.
   * E.g. "1.12.2" or "abcd1234", or "SpecialEnvoyBuild"
   * </pre>
   *
   * <code>string user_agent_version = 7;</code>
   * @return The userAgentVersion.
   */
  java.lang.String getUserAgentVersion();
  /**
   * <pre>
   * Free-form string that identifies the version of the entity requesting config.
   * E.g. "1.12.2" or "abcd1234", or "SpecialEnvoyBuild"
   * </pre>
   *
   * <code>string user_agent_version = 7;</code>
   * @return The bytes for userAgentVersion.
   */
  com.google.protobuf.ByteString
      getUserAgentVersionBytes();

  /**
   * <pre>
   * Structured version of the entity requesting config.
   * </pre>
   *
   * <code>.envoy.config.core.v3.BuildVersion user_agent_build_version = 8;</code>
   * @return Whether the userAgentBuildVersion field is set.
   */
  boolean hasUserAgentBuildVersion();
  /**
   * <pre>
   * Structured version of the entity requesting config.
   * </pre>
   *
   * <code>.envoy.config.core.v3.BuildVersion user_agent_build_version = 8;</code>
   * @return The userAgentBuildVersion.
   */
  io.envoyproxy.envoy.config.core.v3.BuildVersion getUserAgentBuildVersion();
  /**
   * <pre>
   * Structured version of the entity requesting config.
   * </pre>
   *
   * <code>.envoy.config.core.v3.BuildVersion user_agent_build_version = 8;</code>
   */
  io.envoyproxy.envoy.config.core.v3.BuildVersionOrBuilder getUserAgentBuildVersionOrBuilder();

  /**
   * <pre>
   * List of extensions and their versions supported by the node.
   * </pre>
   *
   * <code>repeated .envoy.config.core.v3.Extension extensions = 9;</code>
   */
  java.util.List<io.envoyproxy.envoy.config.core.v3.Extension> 
      getExtensionsList();
  /**
   * <pre>
   * List of extensions and their versions supported by the node.
   * </pre>
   *
   * <code>repeated .envoy.config.core.v3.Extension extensions = 9;</code>
   */
  io.envoyproxy.envoy.config.core.v3.Extension getExtensions(int index);
  /**
   * <pre>
   * List of extensions and their versions supported by the node.
   * </pre>
   *
   * <code>repeated .envoy.config.core.v3.Extension extensions = 9;</code>
   */
  int getExtensionsCount();
  /**
   * <pre>
   * List of extensions and their versions supported by the node.
   * </pre>
   *
   * <code>repeated .envoy.config.core.v3.Extension extensions = 9;</code>
   */
  java.util.List<? extends io.envoyproxy.envoy.config.core.v3.ExtensionOrBuilder> 
      getExtensionsOrBuilderList();
  /**
   * <pre>
   * List of extensions and their versions supported by the node.
   * </pre>
   *
   * <code>repeated .envoy.config.core.v3.Extension extensions = 9;</code>
   */
  io.envoyproxy.envoy.config.core.v3.ExtensionOrBuilder getExtensionsOrBuilder(
      int index);

  /**
   * <pre>
   * Client feature support list. These are well known features described
   * in the Envoy API repository for a given major version of an API. Client features
   * use reverse DNS naming scheme, for example `com.acme.feature`.
   * See :ref:`the list of features &lt;client_features&gt;` that xDS client may
   * support.
   * </pre>
   *
   * <code>repeated string client_features = 10;</code>
   * @return A list containing the clientFeatures.
   */
  java.util.List<java.lang.String>
      getClientFeaturesList();
  /**
   * <pre>
   * Client feature support list. These are well known features described
   * in the Envoy API repository for a given major version of an API. Client features
   * use reverse DNS naming scheme, for example `com.acme.feature`.
   * See :ref:`the list of features &lt;client_features&gt;` that xDS client may
   * support.
   * </pre>
   *
   * <code>repeated string client_features = 10;</code>
   * @return The count of clientFeatures.
   */
  int getClientFeaturesCount();
  /**
   * <pre>
   * Client feature support list. These are well known features described
   * in the Envoy API repository for a given major version of an API. Client features
   * use reverse DNS naming scheme, for example `com.acme.feature`.
   * See :ref:`the list of features &lt;client_features&gt;` that xDS client may
   * support.
   * </pre>
   *
   * <code>repeated string client_features = 10;</code>
   * @param index The index of the element to return.
   * @return The clientFeatures at the given index.
   */
  java.lang.String getClientFeatures(int index);
  /**
   * <pre>
   * Client feature support list. These are well known features described
   * in the Envoy API repository for a given major version of an API. Client features
   * use reverse DNS naming scheme, for example `com.acme.feature`.
   * See :ref:`the list of features &lt;client_features&gt;` that xDS client may
   * support.
   * </pre>
   *
   * <code>repeated string client_features = 10;</code>
   * @param index The index of the value to return.
   * @return The bytes of the clientFeatures at the given index.
   */
  com.google.protobuf.ByteString
      getClientFeaturesBytes(int index);

  /**
   * <pre>
   * Known listening ports on the node as a generic hint to the management server
   * for filtering :ref:`listeners &lt;config_listeners&gt;` to be returned. For example,
   * if there is a listener bound to port 80, the list can optionally contain the
   * SocketAddress `(0.0.0.0,80)`. The field is optional and just a hint.
   * </pre>
   *
   * <code>repeated .envoy.config.core.v3.Address listening_addresses = 11 [deprecated = true];</code>
   */
  @java.lang.Deprecated java.util.List<io.envoyproxy.envoy.config.core.v3.Address> 
      getListeningAddressesList();
  /**
   * <pre>
   * Known listening ports on the node as a generic hint to the management server
   * for filtering :ref:`listeners &lt;config_listeners&gt;` to be returned. For example,
   * if there is a listener bound to port 80, the list can optionally contain the
   * SocketAddress `(0.0.0.0,80)`. The field is optional and just a hint.
   * </pre>
   *
   * <code>repeated .envoy.config.core.v3.Address listening_addresses = 11 [deprecated = true];</code>
   */
  @java.lang.Deprecated io.envoyproxy.envoy.config.core.v3.Address getListeningAddresses(int index);
  /**
   * <pre>
   * Known listening ports on the node as a generic hint to the management server
   * for filtering :ref:`listeners &lt;config_listeners&gt;` to be returned. For example,
   * if there is a listener bound to port 80, the list can optionally contain the
   * SocketAddress `(0.0.0.0,80)`. The field is optional and just a hint.
   * </pre>
   *
   * <code>repeated .envoy.config.core.v3.Address listening_addresses = 11 [deprecated = true];</code>
   */
  @java.lang.Deprecated int getListeningAddressesCount();
  /**
   * <pre>
   * Known listening ports on the node as a generic hint to the management server
   * for filtering :ref:`listeners &lt;config_listeners&gt;` to be returned. For example,
   * if there is a listener bound to port 80, the list can optionally contain the
   * SocketAddress `(0.0.0.0,80)`. The field is optional and just a hint.
   * </pre>
   *
   * <code>repeated .envoy.config.core.v3.Address listening_addresses = 11 [deprecated = true];</code>
   */
  @java.lang.Deprecated java.util.List<? extends io.envoyproxy.envoy.config.core.v3.AddressOrBuilder> 
      getListeningAddressesOrBuilderList();
  /**
   * <pre>
   * Known listening ports on the node as a generic hint to the management server
   * for filtering :ref:`listeners &lt;config_listeners&gt;` to be returned. For example,
   * if there is a listener bound to port 80, the list can optionally contain the
   * SocketAddress `(0.0.0.0,80)`. The field is optional and just a hint.
   * </pre>
   *
   * <code>repeated .envoy.config.core.v3.Address listening_addresses = 11 [deprecated = true];</code>
   */
  @java.lang.Deprecated io.envoyproxy.envoy.config.core.v3.AddressOrBuilder getListeningAddressesOrBuilder(
      int index);

  public io.envoyproxy.envoy.config.core.v3.Node.UserAgentVersionTypeCase getUserAgentVersionTypeCase();
}
