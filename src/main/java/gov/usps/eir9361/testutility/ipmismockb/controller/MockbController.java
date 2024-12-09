package gov.usps.eir9361.testutility.ipmismockb.controller;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import gov.usps.eir9361.testutility.ipmismockb.models.TangoServiceMessage;
import gov.usps.eir9361.testutility.ipmismockb.services.MockbService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController("")
public class MockbController {
	
	private final MockbService  mockbService;
	
	private final MessageSource messageSource;
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("")
	public ResponseEntity<?> serviceGetRequest( @RequestParam(name = "gu_id") String guid,
            									@RequestParam(name = "page_no") String pageNo) {
		
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName());
		
		
		TangoServiceMessage message = mockbService.buildMessage(guid, pageNo);
		
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	

}
