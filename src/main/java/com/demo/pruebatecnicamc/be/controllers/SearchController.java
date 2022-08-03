package com.demo.pruebatecnicamc.be.controllers;


import com.demo.pruebatecnicamc.be.controllers.constants.CommonConstant;
import com.demo.pruebatecnicamc.be.controllers.constants.SearchConstant;
import com.demo.pruebatecnicamc.be.services.SearchService;
import com.demo.pruebatecnicamc.be.utils.CommonMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsondoc.core.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Api(name="Controlador Search", description="Contiene todos los endpoints del Controlador Search", group="Search")
@ApiVersion(since="1.0")
@RestController
@CrossOrigin("*")
@RequestMapping("/search")
public class SearchController implements SearchConstant, CommonConstant {

    @Autowired
    SearchService searchService;

    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = REQUEST_GET_API_PARAM_DESCRIPTION)
    @RequestMapping(method = RequestMethod.POST, value = REQUEST_GET_API_PARAM_URI)
    @ApiResponseObject
    @ResponseBody
    public Object getParam(HttpServletRequest request, HttpServletResponse response,
                             @ApiBodyObject(clazz = String.class) @RequestBody String json) {

        Object objectResult = null;

        if (json != null && !json.isEmpty()) {
            try{
                Map<String, Object> params   = new ObjectMapper().readerFor(Map.class).readValue(json);

                String url = (params.containsKey(URL) && params.get(URL) != null
                        && !params.get(URL).toString().isEmpty())
                        ? params.get(URL).toString().trim() : null;

                String token = (params.containsKey(TOKEN) && params.get(TOKEN) != null
                        && !params.get(TOKEN).toString().isEmpty())
                        ? params.get(TOKEN).toString().trim() : null;


                Long startTime = System.currentTimeMillis();
                objectResult = searchService.getParam(url, token);
                Long stopTime = System.currentTimeMillis();
                Long elapsedTime = stopTime - startTime;

                ((Map) objectResult).put(RESPONSE_ELP_TIME, elapsedTime + MILLI_SECONDS);
            } catch(IOException e){
                objectResult = CommonMessage.commonExceptionErrorMessage(response);
            }
        } else {
            objectResult = CommonMessage.commonErrorMessage(response);
        }

        return objectResult;
    }

}
