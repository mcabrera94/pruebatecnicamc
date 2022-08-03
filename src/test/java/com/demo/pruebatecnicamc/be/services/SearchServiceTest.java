package com.demo.pruebatecnicamc.be.services;

import com.demo.pruebatecnicamc.be.utils.Encryption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {

    @Mock
    Encryption encryption;

    @InjectMocks
    SearchService searchService;

    @BeforeEach
    public void init(){
        ReflectionTestUtils.setField(searchService, "encryptionKey", "ionix123456");
    }

    @Test
    public void getParamTest(){
        Map<String, Object> response = new HashMap<>();
        String url = "https://my.api.mockaroo.com/test-tecnico/search/FyaSTkGi8So=";
        String token = "f2f719e0";
        response = searchService.getParam(url, token);

        assertNotNull(response);
    }

}
