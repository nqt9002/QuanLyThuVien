package phanmemquanlythuvien.qdto_test;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QSach is a Querydsl query type for Sach
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QSach extends com.querydsl.sql.RelationalPathBase<Sach> {

    private static final long serialVersionUID = -1290733795;

    public static final QSach Sach = new QSach("Sach");

    public final NumberPath<Integer> maDS = createNumber("maDS", Integer.class);

    public final NumberPath<Integer> maSach = createNumber("maSach", Integer.class);

    public final StringPath tieuDe = createString("tieuDe");

    public final NumberPath<Integer> trangThai = createNumber("trangThai", Integer.class);

    public final com.querydsl.sql.PrimaryKey<Sach> _Sach_B235742D94403825PK = createPrimaryKey(maSach);

    public final com.querydsl.sql.ForeignKey<DauSach> _Sach_MaDS_36B12243FK = createForeignKey(maDS, "MaDS");

    public final com.querydsl.sql.ForeignKey<ChiTietMuonTra> __ChiTietMu_MaSac_403A8C7DFK = createInvForeignKey(maSach, "MaSach");

    public QSach(String variable) {
        super(Sach.class, forVariable(variable), "dbo", "Sach");
        addMetadata();
    }

    public QSach(String variable, String schema, String table) {
        super(Sach.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QSach(Path<? extends Sach> path) {
        super(path.getType(), path.getMetadata(), "dbo", "Sach");
        addMetadata();
    }

    public QSach(PathMetadata metadata) {
        super(Sach.class, metadata, "dbo", "Sach");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(maDS, ColumnMetadata.named("MaDS").withIndex(2).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(maSach, ColumnMetadata.named("MaSach").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(tieuDe, ColumnMetadata.named("TieuDe").withIndex(4).ofType(Types.NVARCHAR).withSize(200).notNull());
        addMetadata(trangThai, ColumnMetadata.named("TrangThai").withIndex(3).ofType(Types.INTEGER).withSize(10).notNull());
    }

}

