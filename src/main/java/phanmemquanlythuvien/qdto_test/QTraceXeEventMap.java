package phanmemquanlythuvien.qdto_test;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QTraceXeEventMap is a Querydsl query type for TraceXeEventMap
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QTraceXeEventMap extends com.querydsl.sql.RelationalPathBase<TraceXeEventMap> {

    private static final long serialVersionUID = -1449328790;

    public static final QTraceXeEventMap traceXeEventMap = new QTraceXeEventMap("trace_xe_event_map");

    public final StringPath packageName = createString("packageName");

    public final NumberPath<Short> traceEventId = createNumber("traceEventId", Short.class);

    public final StringPath xeEventName = createString("xeEventName");

    public QTraceXeEventMap(String variable) {
        super(TraceXeEventMap.class, forVariable(variable), "sys", "trace_xe_event_map");
        addMetadata();
    }

    public QTraceXeEventMap(String variable, String schema, String table) {
        super(TraceXeEventMap.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QTraceXeEventMap(Path<? extends TraceXeEventMap> path) {
        super(path.getType(), path.getMetadata(), "sys", "trace_xe_event_map");
        addMetadata();
    }

    public QTraceXeEventMap(PathMetadata metadata) {
        super(TraceXeEventMap.class, metadata, "sys", "trace_xe_event_map");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(packageName, ColumnMetadata.named("package_name").withIndex(2).ofType(Types.NVARCHAR).withSize(60).notNull());
        addMetadata(traceEventId, ColumnMetadata.named("trace_event_id").withIndex(1).ofType(Types.SMALLINT).withSize(5).notNull());
        addMetadata(xeEventName, ColumnMetadata.named("xe_event_name").withIndex(3).ofType(Types.NVARCHAR).withSize(60).notNull());
    }

}

