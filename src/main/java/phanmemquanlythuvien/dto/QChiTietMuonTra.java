package phanmemquanlythuvien.dto;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QChiTietMuonTra is a Querydsl query type for ChiTietMuonTra
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QChiTietMuonTra extends com.querydsl.sql.RelationalPathBase<ChiTietMuonTra> {

    private static final long serialVersionUID = 648237441;

    public static final QChiTietMuonTra ChiTietMuonTra = new QChiTietMuonTra("ChiTietMuonTra");

    public final NumberPath<Integer> maCTMT = createNumber("maCTMT", Integer.class);

    public final NumberPath<Integer> maMT = createNumber("maMT", Integer.class);

    public final NumberPath<Integer> maSach = createNumber("maSach", Integer.class);

    public final DatePath<java.sql.Date> ngayTra = createDate("ngayTra", java.sql.Date.class);

    public final com.querydsl.sql.PrimaryKey<ChiTietMuonTra> _ChiTietM_1E4E398DA407D99EPK = createPrimaryKey(maCTMT);

    public final com.querydsl.sql.ForeignKey<MuonTra> _ChiTietMuo_MaMT_403A8C7DFK = createForeignKey(maMT, "MaMT");

    public final com.querydsl.sql.ForeignKey<Sach> _ChiTietMu_MaSac_412EB0B6FK = createForeignKey(maSach, "MaSach");

    public QChiTietMuonTra(String variable) {
        super(ChiTietMuonTra.class, forVariable(variable), "dbo", "ChiTietMuonTra");
        addMetadata();
    }

    public QChiTietMuonTra(String variable, String schema, String table) {
        super(ChiTietMuonTra.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QChiTietMuonTra(Path<? extends ChiTietMuonTra> path) {
        super(path.getType(), path.getMetadata(), "dbo", "ChiTietMuonTra");
        addMetadata();
    }

    public QChiTietMuonTra(PathMetadata metadata) {
        super(ChiTietMuonTra.class, metadata, "dbo", "ChiTietMuonTra");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(maCTMT, ColumnMetadata.named("MaCTMT").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(maMT, ColumnMetadata.named("MaMT").withIndex(2).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(maSach, ColumnMetadata.named("MaSach").withIndex(3).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(ngayTra, ColumnMetadata.named("NgayTra").withIndex(4).ofType(Types.DATE).withSize(10));
    }

}

