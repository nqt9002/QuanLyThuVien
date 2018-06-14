package phanmemquanlythuvien.qdto_test;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QChuDe is a Querydsl query type for ChuDe
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QChuDe extends com.querydsl.sql.RelationalPathBase<ChuDe> {

    private static final long serialVersionUID = -1372593497;

    public static final QChuDe ChuDe = new QChuDe("ChuDe");

    public final NumberPath<Integer> maCD = createNumber("maCD", Integer.class);

    public final StringPath tenChuDe = createString("tenChuDe");

    public final BooleanPath trangThai = createBoolean("trangThai");

    public final com.querydsl.sql.PrimaryKey<ChuDe> _ChuDe_27258E047C05298DPK = createPrimaryKey(maCD);

    public final com.querydsl.sql.ForeignKey<DauSach> __DauSach_MaCD_32E0915FFK = createInvForeignKey(maCD, "MaCD");

    public QChuDe(String variable) {
        super(ChuDe.class, forVariable(variable), "dbo", "ChuDe");
        addMetadata();
    }

    public QChuDe(String variable, String schema, String table) {
        super(ChuDe.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QChuDe(Path<? extends ChuDe> path) {
        super(path.getType(), path.getMetadata(), "dbo", "ChuDe");
        addMetadata();
    }

    public QChuDe(PathMetadata metadata) {
        super(ChuDe.class, metadata, "dbo", "ChuDe");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(maCD, ColumnMetadata.named("MaCD").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(tenChuDe, ColumnMetadata.named("TenChuDe").withIndex(2).ofType(Types.NVARCHAR).withSize(60).notNull());
        addMetadata(trangThai, ColumnMetadata.named("TrangThai").withIndex(3).ofType(Types.BIT).withSize(1).notNull());
    }

}

