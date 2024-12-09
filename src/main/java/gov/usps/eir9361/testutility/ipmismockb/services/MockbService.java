package gov.usps.eir9361.testutility.ipmismockb.services;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import gov.usps.eir9361.testutility.ipmismockb.models.ParametersBean;
import gov.usps.eir9361.testutility.ipmismockb.models.TangoServiceMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class MockbService {
	
	private final ParametersBean parameters;
	
	public TangoServiceMessage buildMessage(String guid, String pageNo) {
		
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName());
		
		String result = parameters.getGuidMessageMap().get(guid+pageNo);
		
		if (result == null) {
			result = parameters.getGuidMessageMap().get(guid+"1");
			if (result == null) {
				return new TangoServiceMessage("ERROR", "Unable to find the request. Please verify the gu_id", null, null, null, null);
			}
			
			String[] results = result.split("\\|");
			
			if (results != null && results.length > 4 ) {
				return new TangoServiceMessage(results[0], results[1], results[2], results[3], pageNo, new JSONArray().toList());
			}

		} else {
			String[] results = result.split("\\|");
			if (results.length > 5) {
				JSONObject jsonObject = new JSONObject(results[5]);
				JSONArray jsonArray = jsonObject.getJSONArray("records");
				return new TangoServiceMessage(results[0], results[1], results[2], results[3], results[4], jsonArray.toList());
			}
			
		}
		
		return new TangoServiceMessage("ERROR", "Internal error.", null, null, null, null);
		
	}

}
