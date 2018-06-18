package phanmemquanlythuvien.qdto;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QPhat is a Querydsl query type for QPhat
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QPhat extends com.querydsl.sql.RelationalPathBase<QPhat> {

    private static final long serialVersionUID = -1466772325;

    public static final QPhat Phat = new QPhat("Phat");

    public final NumberPath<Integer> maCTMT = createNumber("maCTMT", Integer.class);

    public final NumberPath<Integer> maMT = createNumber("maMT", Integer.class);

    public final NumberPath<Integer> maPhat = createNumber("maPhat", Integer.class);

    public final NumberPath<Integer> maSach = createNumber("maSach", Integer.class);

    public final DatePath<java.sql.Date> ngayPhat = createDate("ngayPhat", java.sql.Date.class);

    public final NumberPath<Integer> soNgay = createNumber("soNgay", Integer.class);

    public final NumberPath<Integer> soTien = createNumber("soTien", Integer.class);

    public final StringPath tieuDe = createString("tieuDe");

    public final com.querydsl.sql.PrimaryKey<QPhat> _Phat_4AC072E2381014F2PK = createPrimaryKey(maPhat);

    public final com.querydsl.sql.ForeignKey<QChiTietMuonTra> _Phat_MaCTMT_45F365D3FK = createForeignKey(maCTMT, "MaCTMT");

    public QPhat(String variable) {
        super(QPhat.class, forVariable(variable), "dbo", "Phat");
        addMetadata();
    }

    public QPhat(String variable, String schema, String table) {
        super(QPhat.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QPhat(Path<? extends QPhat> path) {
        super(path.getType(), path.getMetadata(), "dbo", "Phat");
        addMetadata();
    }

    public QPhat(PathMetadata metadata) {
        super(QPhat.class, metadata, "dbo", "Phat");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(maCTMT, ColumnMetadata.named("MaCTMT").withIndex(2).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(maMT, ColumnMetadata.named("MaMT").withIndex(3).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(maPhat, ColumnMetadata.named("MaPhat").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(maSach, ColumnMetadata.named("MaSach").withIndex(4).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(ngayPhat, ColumnMetadata.named("NgayPhat").withIndex(7).ofType(Types.DATE).withSize(10).notNull());
        addMetadata(soNgay, ColumnMetadata.named("SoNgay").withIndex(6).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(soTien, ColumnMetadata.named("SoTien").withIndex(8).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(tieuDe, ColumnMetadata.named("TieuDe").withIndex(5).ofType(Types.CHAR).withSize(200).notNull());
    }

}

