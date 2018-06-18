package phanmemquanlythuvien.qdto;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QBanDoc is a Querydsl query type for QBanDoc
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QBanDoc extends com.querydsl.sql.RelationalPathBase<QBanDoc> {

    private static final long serialVersionUID = -1225859303;

    public static final QBanDoc BanDoc = new QBanDoc("BanDoc");

    public final StringPath email = createString("email");

    public final NumberPath<Integer> maBD = createNumber("maBD", Integer.class);

    public final DatePath<java.sql.Date> ngaySinh = createDate("ngaySinh", java.sql.Date.class);

    public final StringPath soDT = createString("soDT");

    public final StringPath tenBD = createString("tenBD");

    public final BooleanPath trangThai = createBoolean("trangThai");

    public final com.querydsl.sql.PrimaryKey<QBanDoc> _BanDoc_272475A7D1744B60PK = createPrimaryKey(maBD);

    public final com.querydsl.sql.ForeignKey<QMuonTra> __MuonTra_MaBD_3D5E1FD2FK = createInvForeignKey(maBD, "MaBD");

    public QBanDoc(String variable) {
        super(QBanDoc.class, forVariable(variable), "dbo", "BanDoc");
        addMetadata();
    }

    public QBanDoc(String variable, String schema, String table) {
        super(QBanDoc.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QBanDoc(Path<? extends QBanDoc> path) {
        super(path.getType(), path.getMetadata(), "dbo", "BanDoc");
        addMetadata();
    }

    public QBanDoc(PathMetadata metadata) {
        super(QBanDoc.class, metadata, "dbo", "BanDoc");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(email, ColumnMetadata.named("Email").withIndex(5).ofType(Types.VARCHAR).withSize(120).notNull());
        addMetadata(maBD, ColumnMetadata.named("MaBD").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(ngaySinh, ColumnMetadata.named("NgaySinh").withIndex(3).ofType(Types.DATE).withSize(10).notNull());
        addMetadata(soDT, ColumnMetadata.named("SoDT").withIndex(4).ofType(Types.VARCHAR).withSize(12).notNull());
        addMetadata(tenBD, ColumnMetadata.named("TenBD").withIndex(2).ofType(Types.NVARCHAR).withSize(60).notNull());
        addMetadata(trangThai, ColumnMetadata.named("TrangThai").withIndex(6).ofType(Types.BIT).withSize(1).notNull());
    }

}

