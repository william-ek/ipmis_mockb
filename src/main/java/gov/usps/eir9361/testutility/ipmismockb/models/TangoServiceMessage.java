package gov.usps.eir9361.testutility.ipmismockb.models;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TangoServiceMessage {
	
	public TangoServiceMessage(String status, String status_message, String total_records, String page_size, String page_no,
			List<Object> records) {
		this.status = status;
		this.status_message = status_message;
		this.total_records = total_records;
		this.page_size = page_size;
		this.page_no = page_no;
		this.records = records;
	}

	private String status;
	
	private String status_message;
	
	private String total_records;
	
	private String page_size;
	
	private String page_no;
	
	private List<Object> records;

}
