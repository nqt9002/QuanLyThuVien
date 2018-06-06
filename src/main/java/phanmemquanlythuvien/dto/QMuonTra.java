package phanmemquanlythuvien.dto;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QMuonTra is a Querydsl query type for MuonTra
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QMuonTra extends com.querydsl.sql.RelationalPathBase<MuonTra> {

    private static final long serialVersionUID = 1526303375;

    public static final QMuonTra MuonTra = new QMuonTra("MuonTra");

    public final NumberPath<Integer> maBD = createNumber("maBD", Integer.class);

    public final NumberPath<Integer> maMT = createNumber("maMT", Integer.class);

    public final DatePath<java.sql.Date> ngayMuon = createDate("ngayMuon", java.sql.Date.class);

    public final DatePath<java.sql.Date> ngayPhaiTra = createDate("ngayPhaiTra", java.sql.Date.class);

    public final com.querydsl.sql.PrimaryKey<MuonTra> _MuonTra_2725DFD5BE4D5970PK = createPrimaryKey(maMT);

    public final com.querydsl.sql.ForeignKey<BanDoc> _MuonTra_MaBD_3D5E1FD2FK = createForeignKey(maBD, "MaBD");

    public final com.querydsl.sql.ForeignKey<ChiTietMuonTra> __ChiTietMuo_MaMT_403A8C7DFK = createInvForeignKey(maMT, "MaMT");

    public final com.querydsl.sql.ForeignKey<Phat> __Phat_MaMT_440B1D61FK = createInvForeignKey(maMT, "MaMT");

    public QMuonTra(String variable) {
        super(MuonTra.class, forVariable(variable), "dbo", "MuonTra");
        addMetadata();
    }

    public QMuonTra(String variable, String schema, String table) {
        super(MuonTra.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QMuonTra(Path<? extends MuonTra> path) {
        super(path.getType(), path.getMetadata(), "dbo", "MuonTra");
        addMetadata();
    }

    public QMuonTra(PathMetadata metadata) {
        super(MuonTra.class, metadata, "dbo", "MuonTra");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(maBD, ColumnMetadata.named("MaBD").withIndex(2).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(maMT, ColumnMetadata.named("MaMT").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(ngayMuon, ColumnMetadata.named("NgayMuon").withIndex(3).ofType(Types.DATE).withSize(10).notNull());
        addMetadata(ngayPhaiTra, ColumnMetadata.named("NgayPhaiTra").withIndex(4).ofType(Types.DATE).withSize(10).notNull());
    }

}

