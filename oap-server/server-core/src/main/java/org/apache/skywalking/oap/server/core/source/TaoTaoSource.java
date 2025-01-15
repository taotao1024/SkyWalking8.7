package org.apache.skywalking.oap.server.core.source;

import lombok.Getter;
import lombok.Setter;
import org.apache.skywalking.oap.server.core.analysis.IDManager;

import static org.apache.skywalking.oap.server.core.source.DefaultScopeDefine.SERVICE_INSTANCE_CATALOG_NAME;
import static org.apache.skywalking.oap.server.core.source.DefaultScopeDefine.TAOTAO_SOURCE;

@ScopeDeclaration(id = TAOTAO_SOURCE, name = "TaoTaoSource", catalog = SERVICE_INSTANCE_CATALOG_NAME)
@ScopeDefaultColumn.VirtualColumnDefinition(fieldName = "entityId", columnName = "entity_id", isID = true, type = String.class)
public class TaoTaoSource extends Source {
    private volatile String entityId;

    @Getter
    @Setter
    @ScopeDefaultColumn.DefinedByField(columnName = "name", requireDynamicActive = true)
    private String name;

    @Getter
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
        return TAOTAO_SOURCE;
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
