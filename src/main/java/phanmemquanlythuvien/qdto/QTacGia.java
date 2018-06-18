package phanmemquanlythuvien.qdto;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QTacGia is a Querydsl query type for QTacGia
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QTacGia extends com.querydsl.sql.RelationalPathBase<QTacGia> {

    private static final long serialVersionUID = -710859591;

    public static final QTacGia TacGia = new QTacGia("TacGia");

    public final NumberPath<Integer> maTG = createNumber("maTG", Integer.class);

    public final DatePath<java.sql.Date> ngaySinh = createDate("ngaySinh", java.sql.Date.class);

    public final StringPath ten = createString("ten");

    public final StringPath tomTat = createString("tomTat");

    public final BooleanPath trangThai = createBoolean("trangThai");

    public final com.querydsl.sql.PrimaryKey<QTacGia> _TacGia_27250074656D691EPK = createPrimaryKey(maTG);

    public final com.querydsl.sql.ForeignKey<QDauSach> __DauSach_MaTG_33D4B598FK = createInvForeignKey(maTG, "MaTG");

    public QTacGia(String variable) {
        super(QTacGia.class, forVariable(variable), "dbo", "TacGia");
        addMetadata();
    }

    public QTacGia(String variable, String schema, String table) {
        super(QTacGia.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QTacGia(Path<? extends QTacGia> path) {
        super(path.getType(), path.getMetadata(), "dbo", "TacGia");
        addMetadata();
    }

    public QTacGia(PathMetadata metadata) {
        super(QTacGia.class, metadata, "dbo", "TacGia");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(maTG, ColumnMetadata.named("MaTG").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(ngaySinh, ColumnMetadata.named("NgaySinh").withIndex(3).ofType(Types.DATE).withSize(10));
        addMetadata(ten, ColumnMetadata.named("Ten").withIndex(2).ofType(Types.NVARCHAR).withSize(60).notNull());
        addMetadata(tomTat, ColumnMetadata.named("TomTat").withIndex(4).ofType(Types.NVARCHAR).withSize(1000));
        addMetadata(trangThai, ColumnMetadata.named("TrangThai").withIndex(5).ofType(Types.BIT).withSize(1).notNull());
    }

}

