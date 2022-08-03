package com.demo.pruebatecnicamc.be.controllers.constants;

public interface SearchConstant {

    String URL                      = "url";
    String TOKEN                    = "token";
    String BODY                     = "body";
    String REGISTERS_REGEX          = "}, ";
    String RESPONSE_ENCRYPTED_PARAM = "encryptedParam";
    String X_API_KEY                = "X-API-Key";

    static final String REQUEST_GET_API_PARAM_DESCRIPTION = "<div class='alert alert-info'><h3><u><span class='label label-default'>" +
            " Get Api Param </span></u></h3>"
            + "Método que inicia el proceso de consulta a API externa. Recibe un json string con los siguientes parámetros:"
            + "<ul class='list-group'> "
            + "<li class='list-group-item list-group-item-warning'><b><u>url:</u></b> URL del Api. </li>"
            + "<li class='list-group-item list-group-item-warning'><b><u>token:</u></b> Token de Seguridad. </li>"
            + "</ul>"
            + "<u>Ejemplo:</u>"
            + "<pre>{<br />"
            +	"    \"<b>url</b>\" : <em>\"https://my.api.mockaroo.com/test-tecnico/search/FyaSTkGi8So=\"</em>,<br/>"
            +	"    \"<b>token</b>\" : <em>\"f2f719e0\"</em><br />"
            + "}</pre>"
            + "En caso de enviar los parámetros correctamente, deberá recibir un json con el resultado del proceso.";

    static final String REQUEST_GET_API_PARAM_URI = "/getParam";
    static final String RESPONSE_GET_API_PARAM_SUCCESS = "Api consultada con éxito";
    static final String RESPONSE_GET_API_PARAM_FAILED =  "No se logró consultar el Api";


}
