package phanmemquanlythuvien.dto;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QTaiKhoan is a Querydsl query type for TaiKhoan
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QTaiKhoan extends com.querydsl.sql.RelationalPathBase<TaiKhoan> {

    private static final long serialVersionUID = 831159889;

    public static final QTaiKhoan TaiKhoan = new QTaiKhoan("TaiKhoan");

    public final StringPath maBaoMat = createString("maBaoMat");

    public final NumberPath<Integer> maChucVu = createNumber("maChucVu", Integer.class);

    public final NumberPath<Integer> maTaiKhoan = createNumber("maTaiKhoan", Integer.class);

    public final StringPath matKhau = createString("matKhau");

    public final StringPath taiKhoan = createString("taiKhoan");

    public final StringPath ten = createString("ten");
    
    public final BooleanPath trangThai = createBoolean("trangThai");

    public final com.querydsl.sql.PrimaryKey<TaiKhoan> _TaiKhoan_AD7C65297B83A62APK = createPrimaryKey(maTaiKhoan);

    public final com.querydsl.sql.ForeignKey<ChucVu> _TaiKhoan_MaChuc_70DDC3D8FK = createForeignKey(maChucVu, "MaChucVu");

    public QTaiKhoan(String variable) {
        super(TaiKhoan.class, forVariable(variable), "dbo", "TaiKhoan");
        addMetadata();
    }

    public QTaiKhoan(String variable, String schema, String table) {
        super(TaiKhoan.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QTaiKhoan(Path<? extends TaiKhoan> path) {
        super(path.getType(), path.getMetadata(), "dbo", "TaiKhoan");
        addMetadata();
    }

    public QTaiKhoan(PathMetadata metadata) {
        super(TaiKhoan.class, metadata, "dbo", "TaiKhoan");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(maBaoMat, ColumnMetadata.named("MaBaoMat").withIndex(6).ofType(Types.NVARCHAR).withSize(40).notNull());
        addMetadata(maChucVu, ColumnMetadata.named("MaChucVu").withIndex(3).ofType(Types.INTEGER).withSize(10));
        addMetadata(maTaiKhoan, ColumnMetadata.named("MaTaiKhoan").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(matKhau, ColumnMetadata.named("MatKhau").withIndex(5).ofType(Types.NVARCHAR).withSize(40).notNull());
        addMetadata(taiKhoan, ColumnMetadata.named("TaiKhoan").withIndex(4).ofType(Types.NVARCHAR).withSize(60).notNull());
        addMetadata(ten, ColumnMetadata.named("Ten").withIndex(2).ofType(Types.NVARCHAR).withSize(60).notNull());
        addMetadata(trangThai, ColumnMetadata.named("TrangThai").withIndex(7).ofType(Types.BIT).withSize(1).notNull());
    }

}

