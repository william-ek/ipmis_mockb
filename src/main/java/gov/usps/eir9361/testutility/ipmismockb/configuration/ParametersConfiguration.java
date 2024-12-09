package gov.usps.eir9361.testutility.ipmismockb.configuration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import gov.usps.eir9361.testutility.ipmismockb.models.ParametersBean;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class ParametersConfiguration {
	
	private final ParametersBean parameters;
	
	@Bean
	public Map<String, String> instantiateGuidMessageMap() {
		
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName());
		
		parameters.setGuidMessageMap(populateMap(parameters.getMapValuesFilePath()));
		
		return parameters.getGuidMessageMap();
		
	}
	
	private Map<String, String> populateMap(String filePath) {
		
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName());
		
		Map<String, String> guidMessageMap = new HashMap<String, String>();
		
		BufferedReader reader = null;
		
		try {
			
			reader = new BufferedReader(new FileReader(filePath));
            String line;

            guidMessageMap = new HashMap<>();
            while ((line = reader.readLine()) != null) {
                log.debug("line: " + line);
                String[] tokens = line.split("~");
                guidMessageMap.put(tokens[0], tokens[1]);
            }

		} catch(Exception e) {
			log.info(e.getMessage());	
		} finally {
			try {
				reader.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
        return guidMessageMap;
		
		
	}

}
