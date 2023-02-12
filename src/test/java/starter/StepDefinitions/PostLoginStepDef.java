package starter.StepDefinitions;

import java.io.File;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Reqres.ReqresResponses;
import starter.Utils.Constant;

import static org.hamcrest.Matchers.equalTo;

public class PostLoginStepDef {
    @Steps
    ReqresAPI reqresAPI;
    //LOGINPOSITIF
    @Given("Post login user with valid json")
    public void postLoginUserWithValidJson() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"LoginValidBody.json");
        reqresAPI.setPostLoginSuccessfulUser(jsonReq);
    }
    @When("Send request post login user")
    public void sendLoginPostRegisterUser() {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN_SUCCESSFUL_USER);
    }

    @And("Response body token should be {string}")
    public void responseBodyTokenShouldBe(String token) {
        SerenityRest.then().body("token",equalTo(token));
    }
    @And("Validate post login user json schema")
    public void validatePostLoginUserJsonSchema() {
        File jsonSchemaValidLoginUsers = new File(Constant.JSON_SCHEMA+"LoginValidJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaValidLoginUsers));
    }
    //negative
    //Post login user with invalid "<email>" and invalid "<password>"

    //invalidjson
    @Given("Post login user with invalid json")
    public void postLoginUserWithInvalidJson() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"LoginInvalidBody.json");
        reqresAPI.setPostLoginUnsuccessfulUser(jsonReq);
    }
    @And("Response error body should be {string}")
    public void responseErrorBodyShouldBe(String error) {
        SerenityRest.then().body("error",equalTo(error));
    }
    @And("Validate post login user invalid json schema")
    public void validatePostLoginUserInvalidJsonSchema() {
        File jsonSchemaInvalidLoginUsers = new File(Constant.JSON_SCHEMA+"LoginInvalidJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaInvalidLoginUsers));
    }

    //nullemail
    @Given("Post login user with null email")
    public void postLoginUserWithNullEmail() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"LoginNullEmailBody.json");
        reqresAPI.setPostLoginUnsuccessfulUser(jsonReq);
    }
    @And("Response null email error body should be {string}")
    public void responseErrorBodyNullEmailShouldBe(String error) {
        SerenityRest.then().body("error",equalTo(error));
    }
    @And("Validate post login user null email json schema")
    public void validatePostLoginUserNullEmailJsonSchema() {
        File jsonSchemaInvalidLoginUsers = new File(Constant.JSON_SCHEMA+"LoginInvalidJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaInvalidLoginUsers));
    }
    //nullpassword
    @Given("Post login user with null password")
    public void postLoginUserWithNullPassword() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"LoginNullPasswordBody.json");
        reqresAPI.setPostLoginUnsuccessfulUser(jsonReq);
    }
    @And("Response null password error body should be {string}")
    public void responseErrorBodyNullPasswordShouldBe(String error) {
        SerenityRest.then().body("error",equalTo(error));
    }
    @And("Validate post login user null password json schema")
    public void validatePostLoginUserNullPasswordJsonSchema() {
        File jsonSchemaInvalidLoginUsers = new File(Constant.JSON_SCHEMA+"LoginInvalidJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaInvalidLoginUsers));
    }
}
