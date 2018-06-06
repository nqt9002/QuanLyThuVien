package phanmemquanlythuvien.dto;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QPhat is a Querydsl query type for Phat
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QPhat extends com.querydsl.sql.RelationalPathBase<Phat> {

    private static final long serialVersionUID = 156984600;

    public static final QPhat Phat = new QPhat("Phat");

    public final NumberPath<Integer> maMT = createNumber("maMT", Integer.class);

    public final NumberPath<Integer> maPhat = createNumber("maPhat", Integer.class);

    public final DatePath<java.sql.Date> ngayPhat = createDate("ngayPhat", java.sql.Date.class);

    public final NumberPath<Integer> soNgay = createNumber("soNgay", Integer.class);

    public final NumberPath<Integer> soTien = createNumber("soTien", Integer.class);

    public final com.querydsl.sql.PrimaryKey<Phat> _Phat_4AC072E27ECB103EPK = createPrimaryKey(maPhat);

    public final com.querydsl.sql.ForeignKey<MuonTra> _Phat_MaMT_440B1D61FK = createForeignKey(maMT, "MaMT");

    public QPhat(String variable) {
        super(Phat.class, forVariable(variable), "dbo", "Phat");
        addMetadata();
    }

    public QPhat(String variable, String schema, String table) {
        super(Phat.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QPhat(Path<? extends Phat> path) {
        super(path.getType(), path.getMetadata(), "dbo", "Phat");
        addMetadata();
    }

    public QPhat(PathMetadata metadata) {
        super(Phat.class, metadata, "dbo", "Phat");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(maMT, ColumnMetadata.named("MaMT").withIndex(2).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(maPhat, ColumnMetadata.named("MaPhat").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(ngayPhat, ColumnMetadata.named("NgayPhat").withIndex(4).ofType(Types.DATE).withSize(10).notNull());
        addMetadata(soNgay, ColumnMetadata.named("SoNgay").withIndex(3).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(soTien, ColumnMetadata.named("SoTien").withIndex(5).ofType(Types.INTEGER).withSize(10).notNull());
    }

}

