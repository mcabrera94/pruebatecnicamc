package com.demo.pruebatecnicamc.be.utils;

import com.demo.pruebatecnicamc.be.controllers.constants.CommonConstant;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class CommonMessage implements CommonConstant {

    public static Map<String, Object> commonErrorMessage(HttpServletResponse response){
        Map<String, Object> errorMessage = new HashMap<String, Object>();

        errorMessage.put(MESSAGE, COMMON_MESSAGE_ERROR);
        errorMessage.put(TYPE, MESSAGE_TYPE_ERROR);

        return errorMessage;
    }

    public static Map<String, Object> commonExceptionErrorMessage(HttpServletResponse response){
        Map<String, Object> errorMessage = new HashMap<String, Object>();

        errorMessage.put(MESSAGE, COMMON_EXCEPTION_MESSAGE_ERROR);
        errorMessage.put(TYPE, MESSAGE_TYPE_ERROR);

        return errorMessage;
    }

}
