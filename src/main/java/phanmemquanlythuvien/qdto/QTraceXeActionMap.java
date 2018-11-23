package phanmemquanlythuvien.qdto;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QTraceXeActionMap is a Querydsl query type for QTraceXeActionMap
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QTraceXeActionMap extends com.querydsl.sql.RelationalPathBase<QTraceXeActionMap> {

    private static final long serialVersionUID = -1772035900;

    public static final QTraceXeActionMap traceXeActionMap = new QTraceXeActionMap("trace_xe_action_map");

    public final StringPath packageName = createString("packageName");

    public final NumberPath<Short> traceColumnId = createNumber("traceColumnId", Short.class);

    public final StringPath xeActionName = createString("xeActionName");

    public QTraceXeActionMap(String variable) {
        super(QTraceXeActionMap.class, forVariable(variable), "sys", "trace_xe_action_map");
        addMetadata();
    }

    public QTraceXeActionMap(String variable, String schema, String table) {
        super(QTraceXeActionMap.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QTraceXeActionMap(Path<? extends QTraceXeActionMap> path) {
        super(path.getType(), path.getMetadata(), "sys", "trace_xe_action_map");
        addMetadata();
    }

    public QTraceXeActionMap(PathMetadata metadata) {
        super(QTraceXeActionMap.class, metadata, "sys", "trace_xe_action_map");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(packageName, ColumnMetadata.named("package_name").withIndex(2).ofType(Types.NVARCHAR).withSize(60).notNull());
        addMetadata(traceColumnId, ColumnMetadata.named("trace_column_id").withIndex(1).ofType(Types.SMALLINT).withSize(5).notNull());
        addMetadata(xeActionName, ColumnMetadata.named("xe_action_name").withIndex(3).ofType(Types.NVARCHAR).withSize(60).notNull());
    }

}

