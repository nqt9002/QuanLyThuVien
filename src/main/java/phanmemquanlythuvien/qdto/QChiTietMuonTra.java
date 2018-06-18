package phanmemquanlythuvien.qdto;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QChiTietMuonTra is a Querydsl query type for QChiTietMuonTra
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QChiTietMuonTra extends com.querydsl.sql.RelationalPathBase<QChiTietMuonTra> {

    private static final long serialVersionUID = -945587900;

    public static final QChiTietMuonTra ChiTietMuonTra = new QChiTietMuonTra("ChiTietMuonTra");

    public final NumberPath<Integer> maCTMT = createNumber("maCTMT", Integer.class);

    public final NumberPath<Integer> maMT = createNumber("maMT", Integer.class);

    public final NumberPath<Integer> maSach = createNumber("maSach", Integer.class);

    public final DatePath<java.sql.Date> ngayTra = createDate("ngayTra", java.sql.Date.class);

    public final StringPath tieuDe = createString("tieuDe");

    public final com.querydsl.sql.PrimaryKey<QChiTietMuonTra> _ChiTietM_1E4E398D24CB7BF9PK = createPrimaryKey(maCTMT);

    public final com.querydsl.sql.ForeignKey<QMuonTra> _ChiTietMuo_MaMT_4222D4EFFK = createForeignKey(maMT, "MaMT");

    public final com.querydsl.sql.ForeignKey<QSach> _ChiTietMu_MaSac_4316F928FK = createForeignKey(maSach, "MaSach");

    public final com.querydsl.sql.ForeignKey<QPhat> __Phat_MaCTMT_45F365D3FK = createInvForeignKey(maCTMT, "MaCTMT");

    public QChiTietMuonTra(String variable) {
        super(QChiTietMuonTra.class, forVariable(variable), "dbo", "ChiTietMuonTra");
        addMetadata();
    }

    public QChiTietMuonTra(String variable, String schema, String table) {
        super(QChiTietMuonTra.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QChiTietMuonTra(Path<? extends QChiTietMuonTra> path) {
        super(path.getType(), path.getMetadata(), "dbo", "ChiTietMuonTra");
        addMetadata();
    }

    public QChiTietMuonTra(PathMetadata metadata) {
        super(QChiTietMuonTra.class, metadata, "dbo", "ChiTietMuonTra");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(maCTMT, ColumnMetadata.named("MaCTMT").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(maMT, ColumnMetadata.named("MaMT").withIndex(2).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(maSach, ColumnMetadata.named("MaSach").withIndex(3).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(ngayTra, ColumnMetadata.named("NgayTra").withIndex(5).ofType(Types.DATE).withSize(10));
        addMetadata(tieuDe, ColumnMetadata.named("TieuDe").withIndex(4).ofType(Types.CHAR).withSize(200).notNull());
    }

}

