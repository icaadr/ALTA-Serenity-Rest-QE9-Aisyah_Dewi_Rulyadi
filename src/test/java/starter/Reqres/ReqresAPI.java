package starter.Reqres;

import java.io.File;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constant;

public class ReqresAPI {

    public static String GET_LIST_USERS = Constant.BASE_URL+"/api/users?page={page}";
    public static String POST_CREATE_USER = Constant.BASE_URL+"/api/users";
    public static String PUT_UPDATE_USER = Constant.BASE_URL+"/api/users/{id}";
    public static String PUT_INVALID_UPDATE_USER = Constant.BASE_URL+"/api/users/{id}";
    public static String DELETE_USER = Constant.BASE_URL+"/api/users/{id}";
    public static String DELETE_INVALID_USER = Constant.BASE_URL+"/api/users/{id}";
    public static String GET_SINGLE_USER = Constant.BASE_URL+"/api/users/{id}";
    public static String GET_INVALID_SINGLE_USER = Constant.BASE_URL+"/api/users/{id}";
    public static String POST_REGISTER_SUCCESSFUL_USER = Constant.BASE_URL+"/api/register";
    public static String POST_REGISTER_UNSUCCESSFUL_USER = Constant.BASE_URL+"/api/register";
    public static String POST_LOGIN_SUCCESSFUL_USER = Constant.BASE_URL+"/api/login";
    public static String POST_LOGIN_UNSUCCESSFUL_USER = Constant.BASE_URL+"/api/login";
    public static String GET_LIST_RESOURCE = Constant.BASE_URL+"/api/unknown";
    public static String GET_LIST_SINGLE_RESOURCE = Constant.BASE_URL+"/api/unknown/{id}";
    public static String GET_LIST_INVALID_SINGLE_RESOURCE = Constant.BASE_URL+"/api/unknown/{id}";
    @Step("Get list users")
    public void getListUsers(int page){
        SerenityRest.given()
                .pathParam("page",page);
    }
    @Step("Post create new user")
    public void postCreateUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Put update user")
    public void putUpdateUser(File json, int id){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Put update invalid user")
    public void putUpdateInvalidUser(File json, String id){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Delete user")
    public void deleteUser(int id){
        SerenityRest.given()
                .pathParam("id",id);

    }
    @Step("Delete invalid user")
    public void deleteInvalidUser(String id){
        SerenityRest.given()
                .pathParam("id",id);

    }
    @Step("Get single users")
    public void getSingleUser(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }
    @Step("Get single invalid users")
    public void getInvalidSingleUser(String id){
        SerenityRest.given()
                .pathParam("id",id);
    }
    @Step("Post register successful")
    public void setPostRegisterSuccessfulUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post register unsuccessful")
    public void setPostRegisterUnsuccessfulUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post login successful")
    public void setPostLoginSuccessfulUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post login unsuccessful")
    public void setPostLoginUnsuccessfulUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Get list resource")
    public void setGetListResource(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Get list single resource")
    public void setGetListSingleResource(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }
    @Step("Get list single resource")
    public void setGetListInvalidSingleResource(String id){
        SerenityRest.given()
                .pathParam("id",id);
    }


}
