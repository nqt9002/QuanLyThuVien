package phanmemquanlythuvien.dto;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QChucVu is a Querydsl query type for ChucVu
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QChucVu extends com.querydsl.sql.RelationalPathBase<ChucVu> {

    private static final long serialVersionUID = 879671680;

    public static final QChucVu ChucVu = new QChucVu("ChucVu");

    public final StringPath chucVu = createString("chucVu");

    public final NumberPath<Integer> maChucVu = createNumber("maChucVu", Integer.class);

    public final com.querydsl.sql.PrimaryKey<ChucVu> _ChucVu_D4639533D532B5BCPK = createPrimaryKey(maChucVu);

    public final com.querydsl.sql.ForeignKey<TaiKhoan> __TaiKhoan_MaChuc_70DDC3D8FK = createInvForeignKey(maChucVu, "MaChucVu");

    public QChucVu(String variable) {
        super(ChucVu.class, forVariable(variable), "dbo", "ChucVu");
        addMetadata();
    }

    public QChucVu(String variable, String schema, String table) {
        super(ChucVu.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QChucVu(Path<? extends ChucVu> path) {
        super(path.getType(), path.getMetadata(), "dbo", "ChucVu");
        addMetadata();
    }

    public QChucVu(PathMetadata metadata) {
        super(ChucVu.class, metadata, "dbo", "ChucVu");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(chucVu, ColumnMetadata.named("ChucVu").withIndex(2).ofType(Types.NVARCHAR).withSize(30).notNull());
        addMetadata(maChucVu, ColumnMetadata.named("MaChucVu").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
    }

}

