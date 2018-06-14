package phanmemquanlythuvien.qdto;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QDauSach is a Querydsl query type for QDauSach
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QDauSach extends com.querydsl.sql.RelationalPathBase<QDauSach> {

    private static final long serialVersionUID = -1859994501;

    public static final QDauSach DauSach = new QDauSach("DauSach");

    public final NumberPath<Integer> lanTaiBan = createNumber("lanTaiBan", Integer.class);

    public final NumberPath<Integer> maCD = createNumber("maCD", Integer.class);

    public final NumberPath<Integer> maDS = createNumber("maDS", Integer.class);

    public final NumberPath<Integer> maNXB = createNumber("maNXB", Integer.class);

    public final NumberPath<Integer> maTG = createNumber("maTG", Integer.class);

    public final NumberPath<Integer> soLuong = createNumber("soLuong", Integer.class);

    public final StringPath ten = createString("ten");

    public final BooleanPath trangThai = createBoolean("trangThai");

    public final StringPath ttnd = createString("ttnd");

    public final com.querydsl.sql.PrimaryKey<QDauSach> _DauSach_2725865424D5B1AEPK = createPrimaryKey(maDS);

    public final com.querydsl.sql.ForeignKey<QTacGia> _DauSach_MaTG_30F848EDFK = createForeignKey(maTG, "MaTG");

    public final com.querydsl.sql.ForeignKey<QChuDe> _DauSach_MaCD_32E0915FFK = createForeignKey(maCD, "MaCD");

    public final com.querydsl.sql.ForeignKey<QNxb> _DauSach_MaNXB_31EC6D26FK = createForeignKey(maNXB, "MaNXB");

    public final com.querydsl.sql.ForeignKey<QSach> __Sach_MaDS_36B12243FK = createInvForeignKey(maDS, "MaDS");

    public QDauSach(String variable) {
        super(QDauSach.class, forVariable(variable), "dbo", "DauSach");
        addMetadata();
    }

    public QDauSach(String variable, String schema, String table) {
        super(QDauSach.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QDauSach(Path<? extends QDauSach> path) {
        super(path.getType(), path.getMetadata(), "dbo", "DauSach");
        addMetadata();
    }

    public QDauSach(PathMetadata metadata) {
        super(QDauSach.class, metadata, "dbo", "DauSach");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(lanTaiBan, ColumnMetadata.named("LanTaiBan").withIndex(7).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(maCD, ColumnMetadata.named("MaCD").withIndex(4).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(maDS, ColumnMetadata.named("MaDS").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(maNXB, ColumnMetadata.named("MaNXB").withIndex(3).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(maTG, ColumnMetadata.named("MaTG").withIndex(2).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(soLuong, ColumnMetadata.named("SoLuong").withIndex(6).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(ten, ColumnMetadata.named("Ten").withIndex(5).ofType(Types.NVARCHAR).withSize(60).notNull());
        addMetadata(trangThai, ColumnMetadata.named("TrangThai").withIndex(9).ofType(Types.BIT).withSize(1).notNull());
        addMetadata(ttnd, ColumnMetadata.named("TTND").withIndex(8).ofType(Types.NVARCHAR).withSize(1000).notNull());
    }

}

