package org.apache.skywalking.oap.server.core.source;

import lombok.Getter;
import lombok.Setter;
import org.apache.skywalking.oap.server.core.analysis.IDManager;

import static org.apache.skywalking.oap.server.core.source.DefaultScopeDefine.SERVICE_INSTANCE_CATALOG_NAME;
import static org.apache.skywalking.oap.server.core.source.DefaultScopeDefine.TAO_PORT_INGRESS_SOURCE;

@ScopeDeclaration(id = TAO_PORT_INGRESS_SOURCE, name = "TaoPortIngressSource", catalog = SERVICE_INSTANCE_CATALOG_NAME)
@ScopeDefaultColumn.VirtualColumnDefinition(fieldName = "entityId", columnName = "entity_id", isID = true, type = String.class)
public class TaoPortIngressSource extends Source {
    private volatile String entityId;

    @Getter
    @Setter
    @ScopeDefaultColumn.DefinedByField(columnName = "name", requireDynamicActive = true)
    private String name;

    @Getter
    @Setter
    @ScopeDefaultColumn.DefinedByField(columnName = "service_id")
    private String serviceId;

    @Getter
    @Setter
    @ScopeDefaultColumn.DefinedByField(columnName = "service_name", requireDynamicActive = true)
    private String serviceName;

    @Getter
    @Setter
    private long totalLen;


    @Override
    public int scope() {
        return TAO_PORT_INGRESS_SOURCE;
    }

    @Override
    public String getEntityId() {
        if (entityId == null) {
            entityId = IDManager.EndpointID.buildId(serviceId, name);
        }
        return entityId;
    }

    @Override
    public void prepare() {
    }
}
