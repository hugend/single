package point.service;

import java.util.ArrayList;

import point.dto.PointDTO;

public interface PointService {
	int po_insert(PointDTO dto);
	ArrayList<PointDTO> po_list();
	PointDTO po_read(int po_no);
	int po_delete(String po_no);
	int po_update(PointDTO prd);
	int buy_update(int me_point, String me_id, int po_no);
	int po_state_update(int po_state, int po_no);

}
