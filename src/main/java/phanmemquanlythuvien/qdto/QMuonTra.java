package phanmemquanlythuvien.qdto;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QMuonTra is a Querydsl query type for QMuonTra
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QMuonTra extends com.querydsl.sql.RelationalPathBase<QMuonTra> {

    private static final long serialVersionUID = -1894561748;

    public static final QMuonTra MuonTra = new QMuonTra("MuonTra");

    public final BooleanPath daTraHet = createBoolean("daTraHet");

    public final NumberPath<Integer> maBD = createNumber("maBD", Integer.class);

    public final NumberPath<Integer> maMT = createNumber("maMT", Integer.class);

    public final DatePath<java.sql.Date> ngayMuon = createDate("ngayMuon", java.sql.Date.class);

    public final DatePath<java.sql.Date> ngayPhaiTra = createDate("ngayPhaiTra", java.sql.Date.class);

    public final NumberPath<Integer> tongSoMuon = createNumber("tongSoMuon", Integer.class);

    public final NumberPath<Integer> tongSoTra = createNumber("tongSoTra", Integer.class);

    public final com.querydsl.sql.PrimaryKey<QMuonTra> _MuonTra_2725DFD506D08726PK = createPrimaryKey(maMT);

    public final com.querydsl.sql.ForeignKey<QBanDoc> _MuonTra_MaBD_3D5E1FD2FK = createForeignKey(maBD, "MaBD");

    public final com.querydsl.sql.ForeignKey<QChiTietMuonTra> __ChiTietMuo_MaMT_4222D4EFFK = createInvForeignKey(maMT, "MaMT");

    public QMuonTra(String variable) {
        super(QMuonTra.class, forVariable(variable), "dbo", "MuonTra");
        addMetadata();
    }

    public QMuonTra(String variable, String schema, String table) {
        super(QMuonTra.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QMuonTra(Path<? extends QMuonTra> path) {
        super(path.getType(), path.getMetadata(), "dbo", "MuonTra");
        addMetadata();
    }

    public QMuonTra(PathMetadata metadata) {
        super(QMuonTra.class, metadata, "dbo", "MuonTra");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(daTraHet, ColumnMetadata.named("DaTraHet").withIndex(7).ofType(Types.BIT).withSize(1));
        addMetadata(maBD, ColumnMetadata.named("MaBD").withIndex(2).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(maMT, ColumnMetadata.named("MaMT").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(ngayMuon, ColumnMetadata.named("NgayMuon").withIndex(3).ofType(Types.DATE).withSize(10).notNull());
        addMetadata(ngayPhaiTra, ColumnMetadata.named("NgayPhaiTra").withIndex(4).ofType(Types.DATE).withSize(10).notNull());
        addMetadata(tongSoMuon, ColumnMetadata.named("TongSoMuon").withIndex(5).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(tongSoTra, ColumnMetadata.named("TongSoTra").withIndex(6).ofType(Types.INTEGER).withSize(10));
    }

}

