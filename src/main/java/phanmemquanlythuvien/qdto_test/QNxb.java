package phanmemquanlythuvien.qdto_test;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QNxb is a Querydsl query type for Nxb
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QNxb extends com.querydsl.sql.RelationalPathBase<Nxb> {

    private static final long serialVersionUID = 374001326;

    public static final QNxb nxb = new QNxb("NXB");

    public final NumberPath<Integer> maNXB = createNumber("maNXB", Integer.class);

    public final StringPath tenNXB = createString("tenNXB");

    public final BooleanPath trangThai = createBoolean("trangThai");

    public final com.querydsl.sql.PrimaryKey<Nxb> _nxb_3a19482c364a0bdcPk = createPrimaryKey(maNXB);

    public final com.querydsl.sql.ForeignKey<DauSach> __DauSach_MaNXB_31EC6D26FK = createInvForeignKey(maNXB, "MaNXB");

    public QNxb(String variable) {
        super(Nxb.class, forVariable(variable), "dbo", "NXB");
        addMetadata();
    }

    public QNxb(String variable, String schema, String table) {
        super(Nxb.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QNxb(Path<? extends Nxb> path) {
        super(path.getType(), path.getMetadata(), "dbo", "NXB");
        addMetadata();
    }

    public QNxb(PathMetadata metadata) {
        super(Nxb.class, metadata, "dbo", "NXB");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(maNXB, ColumnMetadata.named("MaNXB").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(tenNXB, ColumnMetadata.named("TenNXB").withIndex(2).ofType(Types.NVARCHAR).withSize(60).notNull());
        addMetadata(trangThai, ColumnMetadata.named("TrangThai").withIndex(3).ofType(Types.BIT).withSize(1).notNull());
    }

}

