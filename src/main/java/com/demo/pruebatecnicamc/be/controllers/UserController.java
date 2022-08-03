package com.demo.pruebatecnicamc.be.controllers;


import com.demo.pruebatecnicamc.be.ApplicationSecurityConfig;
import com.demo.pruebatecnicamc.be.controllers.constants.CommonConstant;
import com.demo.pruebatecnicamc.be.controllers.constants.UserConstant;
import com.demo.pruebatecnicamc.be.services.UserService;
import com.demo.pruebatecnicamc.be.utils.CommonMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsondoc.core.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Api(name="Controlador User", description="Contiene todos los endpoints del Controlador User", group="User")
@ApiVersion(since="1.0")
@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController implements UserConstant, CommonConstant {

    @Autowired
    UserService userService;

    @ApiAuthBasic(roles = {ROLES})
    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = REQUEST_CREATE_USER_DESCRIPTION)
    @RequestMapping(method = RequestMethod.POST, value = REQUEST_CREATE_USER_URI)
    @ApiResponseObject
    @ResponseBody
    public Object createUser(HttpServletRequest request, HttpServletResponse response,
                                     @ApiBodyObject(clazz = String.class) @RequestBody String json) {

        Object objectResult = null;
        if (json != null && !json.isEmpty()) {
            try{
                Map<String, Object> params   = new ObjectMapper().readerFor(Map.class).readValue(json);

                String name = (params.containsKey(NAME) && params.get(NAME) != null
                            && !params.get(NAME).toString().isEmpty())
                                ? params.get(NAME).toString().trim() : null;

                String username = (params.containsKey(USERNAME) && params.get(USERNAME) != null
                            && !params.get(USERNAME).toString().isEmpty())
                                ? params.get(USERNAME).toString().trim() : null;

                String email = (params.containsKey(EMAIL) && params.get(EMAIL) != null
                            && !params.get(EMAIL).toString().isEmpty())
                                ? params.get(EMAIL).toString().trim() : null;

                String phone = (params.containsKey(PHONE) && params.get(PHONE) != null
                            && !params.get(PHONE).toString().isEmpty())
                                ? params.get(PHONE).toString().trim() : null;

                objectResult = userService.createUser(name, username, email, phone);

            } catch(IOException e){
                objectResult = CommonMessage.commonExceptionErrorMessage(response);
            }
        } else {
            objectResult = CommonMessage.commonErrorMessage(response);
        }
        return objectResult;
    }

    @ApiMethod(produces = APPLICATION_JSON, description = REQUEST_GET_USERS_DESCRIPTION)
    @RequestMapping(method = RequestMethod.GET, value = REQUEST_GET_USERS_URI)
    @ApiResponseObject
    @ResponseBody
    public Object getUsers(HttpServletRequest request, HttpServletResponse response) {

        Object objectResult = null;
        try{
            objectResult = userService.getUsers();
        } catch(Exception e){
            objectResult = CommonMessage.commonExceptionErrorMessage(response);
        }
        return objectResult;
    }

    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = REQUEST_GET_USER_BY_EMAIL_DESCRIPTION)
    @RequestMapping(method = RequestMethod.POST, value = REQUEST_GET_USER_BY_EMAIL_URI)
    @ApiResponseObject
    @ResponseBody
    public Object getUserByEmail(HttpServletRequest request, HttpServletResponse response,
                                 @ApiBodyObject(clazz = String.class) @RequestBody String json) {

        Object objectResult = null;
        if (json != null && !json.isEmpty()) {
            try{
                Map<String, Object> params   = new ObjectMapper().readerFor(Map.class).readValue(json);

                String email = (params.containsKey(EMAIL) && params.get(EMAIL) != null
                        && !params.get(EMAIL).toString().isEmpty())
                        ? params.get(EMAIL).toString().trim() : null;

                objectResult = userService.getUserByEmail(email);

            } catch(IOException e){
                objectResult = CommonMessage.commonExceptionErrorMessage(response);
            }
        } else {
            objectResult = CommonMessage.commonErrorMessage(response);
        }
        return objectResult;
    }

    @ApiAuthBasic(roles = {ROLES})
    @ApiMethod(consumes = TEXT_JSON, produces = APPLICATION_JSON, description = REQUEST_DELETE_USER_BY_EMAIL_DESCRIPTION)
    @RequestMapping(method = RequestMethod.POST, value = REQUEST_DELETE_USER_BY_EMAIL_URI)
    @ApiResponseObject
    @ResponseBody
    public Object deleteUserByEmail(HttpServletRequest request, HttpServletResponse response,
                                 @ApiBodyObject(clazz = String.class) @RequestBody String json) {

        Object objectResult = null;
        if (json != null && !json.isEmpty()) {
            try{
                Map<String, Object> params   = new ObjectMapper().readerFor(Map.class).readValue(json);

                String email = (params.containsKey(EMAIL) && params.get(EMAIL) != null
                        && !params.get(EMAIL).toString().isEmpty())
                        ? params.get(EMAIL).toString().trim() : null;

                objectResult = userService.deleteUserByEmail(email);

            } catch(IOException e){
                objectResult = CommonMessage.commonExceptionErrorMessage(response);
            }
        } else {
            objectResult = CommonMessage.commonErrorMessage(response);
        }
        return objectResult;
    }
}
