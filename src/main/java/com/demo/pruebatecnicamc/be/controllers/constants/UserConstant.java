package com.demo.pruebatecnicamc.be.controllers.constants;

public interface UserConstant {

    String NAME                     = "name";
    String USERNAME                 = "username";
    String EMAIL                    = "email";
    String PHONE                    = "phone";


    static final String REQUEST_CREATE_USER_DESCRIPTION = "<div class='alert alert-info'><h3><u><span class='label label-default'>" +
            " Create User </span></u></h3>"
            + "Método que inicia el proceso de creación de usuario. Recibe un json string con los siguientes parámetros:"
            + "<ul class='list-group'> "
            + "<li class='list-group-item list-group-item-warning'><b><u>name:</u></b> Nombre del Usuario. </li>"
            + "<li class='list-group-item list-group-item-warning'><b><u>username:</u></b> Username del Usuario. </li>"
            + "<li class='list-group-item list-group-item-warning'><b><u>email:</u></b> Email del Usuario. </li>"
            + "<li class='list-group-item list-group-item-warning'><b><u>phone:</u></b> Teléfono del Usuario. </li>"
            + "</ul>"
            + "<u>Ejemplo:</u>"
            + "<pre>{<br />"
            +	"    \"<b>name</b>\" : <em>\"Pedro Antonio Lira\"</em>,<br/>"
            +	"    \"<b>username</b>\" : <em>\"plira\"</em>,<br />"
            +	"    \"<b>email</b>\" : <em>\"palira64@test.com\"</em>,<br/>"
            +	"    \"<b>phone</b>\" : <em>\"8940163\"</em><br />"
            + "}</pre>"
            + "En caso de enviar los parámetros correctamente, deberá recibir un json con el resultado del proceso.";

    static final String REQUEST_CREATE_USER_URI = "/createuser";
    static final String RESPONSE_CREATE_USER_SUCCESS = "Usuario creado con éxito";
    static final String RESPONSE_CREATE_USER_FAILED =  "Usuario ya existe";

    static final String REQUEST_GET_USERS_DESCRIPTION = "<div class='alert alert-info'><h3><u><span class='label label-default'>" +
            " Get Users </span></u></h3>"
            + "Método que inicia el proceso de obtener la lista de usuarios.";
    static final String REQUEST_GET_USERS_URI = "/getusers";
    static final String RESPONSE_GET_USERS_SUCCESS = "Usuarios obtenidos con éxito";
    static final String RESPONSE_GET_USERS_FAILED =  "No se encontraron usuarios";

    static final String REQUEST_GET_USER_BY_EMAIL_DESCRIPTION = "<div class='alert alert-info'><h3><u><span class='label label-default'>" +
            " Get User By Email </span></u></h3>"
            + "Método que inicia el proceso de busqueda de usuario por email. Recibe un json string con los siguientes parámetros:"
            + "<ul class='list-group'> "
            + "<li class='list-group-item list-group-item-warning'><b><u>email:</u></b> Email del Usuario. </li>"
            + "</ul>"
            + "<u>Ejemplo:</u>"
            + "<pre>{<br />"
            +	"    \"<b>email</b>\" : <em>\"palira64@test.com\"</em><br/>"
            + "}</pre>"
            + "En caso de enviar los parámetros correctamente, deberá recibir un json con el resultado del proceso.";

    static final String REQUEST_GET_USER_BY_EMAIL_URI = "/getUserByEmail";
    static final String RESPONSE_GET_USER_BY_EMAIL_SUCCESS = "Usuario obtenido con éxito";
    static final String RESPONSE_GET_USER_BY_EMAIL_FAILED =  "No se encontró usuario asociado";

    static final String REQUEST_DELETE_USER_BY_EMAIL_DESCRIPTION = "<div class='alert alert-info'><h3><u><span class='label label-default'>" +
            " Delete User By Email </span></u></h3>"
            + "Método que inicia el proceso de eliminación de usuario por email. Recibe un json string con los siguientes parámetros:"
            + "<ul class='list-group'> "
            + "<li class='list-group-item list-group-item-warning'><b><u>email:</u></b> Email del Usuario. </li>"
            + "</ul>"
            + "<u>Ejemplo:</u>"
            + "<pre>{<br />"
            +	"    \"<b>email</b>\" : <em>\"palira64@test.com\"</em><br/>"
            + "}</pre>"
            + "En caso de enviar los parámetros correctamente, deberá recibir un json con el resultado del proceso.";

    static final String REQUEST_DELETE_USER_BY_EMAIL_URI = "/deleteUserByEmail";
    static final String RESPONSE_DELETE_USER_BY_EMAIL_SUCCESS = "Usuario eliminado con éxito";
    static final String RESPONSE_DELETE_USER_BY_EMAIL_FAILED =  "No se encontró usuario para eliminar";


}
