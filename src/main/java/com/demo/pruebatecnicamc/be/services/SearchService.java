package com.demo.pruebatecnicamc.be.services;

import com.demo.pruebatecnicamc.be.controllers.constants.CommonConstant;
import com.demo.pruebatecnicamc.be.controllers.constants.SearchConstant;
import com.demo.pruebatecnicamc.be.utils.Result;
import com.demo.pruebatecnicamc.be.utils.Encryption;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@PropertySource(value={"classpath:/constants.properties"})
public class SearchService implements SearchConstant, CommonConstant {

    @Value("${demo.pruebatecnicamc.security.encryption.key}")
    private String encryptionKey;

    @Autowired
    Encryption encryption;

    public Map<String, Object> getParam(String url,
                                        String token) {

        Map<String, Object> response = new HashMap<>();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        ObjectMapper mapper = new ObjectMapper();
        try {
            String endpoint = url;
            headers.set(X_API_KEY, token);
            ResponseEntity<Object> apiResponse = restTemplate.exchange(endpoint, HttpMethod.GET, requestEntity, Object.class);
            Map<String, Object> map = mapper.convertValue(apiResponse, Map.class);
            String respData = mapper.writeValueAsString(map.get(BODY).toString().replaceAll(OPERATOR_EQUALS, TWO_POINTS));
            respData =  StringUtils.substringBetween(respData, OPENING_BRACKET, CLOSING_BRACKET);
            String[] registers = respData.split(REGISTERS_REGEX);
            String[] param = registers[ZERO].replace(OPENING_KEY,EMPTY).replace(CLOSING_KEY, EMPTY)
                                .split(COMMA)[TWO].trim().split(TWO_POINTS);
            String encryptedParam = encryption.encryptToDES(param[ONE], encryptionKey);
            Result result = new Result();
            result.setRegisterCount(registers.length);

            response.put(RESPONSE_CODE, ZERO);
            response.put(RESPONSE_DESCRIPTION, MESSAGE_OK);
            response.put(RESPONSE_ELP_TIME, 0);
            response.put(RESPONSE_RESULT, result);
            response.put(RESPONSE_ENCRYPTED_PARAM, encryptedParam);
        } catch (Exception e) {
            response.put(MESSAGE, MESSAGE_ERROR);
            response.put(TYPE, MESSAGE_TYPE_ERROR);
        }

        return response;
    }
}
