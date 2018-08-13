package point.query;

import java.sql.Date;

public class PointQuery {
	public static final String PRD_INSERT=
			"insert into point values(point_seq.nextval, ? , ?, ?, ?, sysdate ,?, ?)";
	
	public static final String PRD_LIST =
			"select * from point order by po_no desc";
	
	public static final String PRD_READ =
			"select * from point where po_no =? ";
	
	public static final String PRD_DELETE
			="delete from point where po_no=?";
	
	public static final String PRD_UPDATE
			="update point "
			+ "set po_title=?, po_txt=?, po_img=?, po_pt=?, po_state=?, po_count=? "
			+ "where po_no=?";
	
	public static final String PRD_COUNT_UPDATE
			="update point "
			+ "set po_count=po_count-1 where po_no=?";
	
	public static final String PRD_STATE_UPDATE
			="update point "
			+ "set po_state=? where po_no=?";
}


