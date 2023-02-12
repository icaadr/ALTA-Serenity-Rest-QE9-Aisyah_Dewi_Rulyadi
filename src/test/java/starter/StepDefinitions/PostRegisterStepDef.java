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

public class PostRegisterStepDef {
    @Steps
    ReqresAPI reqresAPI;
    //registerpositif
    @Given("Post register user with valid json")
    public void postRegisterUserWithValidJson() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"RegisterBody.json");
        reqresAPI.setPostRegisterSuccessfulUser(jsonReq);
    }

    @When("Send request post register user")
    public void sendRequestPostRegisterUser() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER_SUCCESSFUL_USER);
    }

    @And("Response body id should be {int} and token should be {string}")
    public void responseBodyIdShouldBeAndTokenShouldBe(int id, String token) {
        SerenityRest.then()
                .body("id",equalTo(id))
                .body("token",equalTo(token));
    }

    @And("Validate register using json scheme")
    public void validateRegisterUsingJsonScheme() {
        File jsonSchemaListUsers = new File(Constant.JSON_SCHEMA+"RegisterUserJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaListUsers));
    }


    //registernegatif
    @Given("Post register user with invalid json")
    public void postRegisterUserWithInvalidJson() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"RegisterInvalidBody.json");
        reqresAPI.setPostRegisterUnsuccessfulUser(jsonReq);
    }
    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int BadRequest) {
        SerenityRest.then().statusCode(BadRequest);
    }

    @And("Response register error body should be {string}")
    public void responseRegisterErrorBodyShouldBe(String error) {
        SerenityRest.then().body("error",equalTo(error));

    }

    @And("Validate post register user invalid json schema")
    public void validatePostRegisterUserInvalidJsonSchema() {
        File jsonSchemaInvalidRegisterUsers = new File(Constant.JSON_SCHEMA+"RegisterInvalidJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaInvalidRegisterUsers));

    }

    //nullemail
    @Given("Post register user with null email")
    public void postRegisterUserWithNullEmail() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"RegisterNullEmailBody.json");
        reqresAPI.setPostRegisterUnsuccessfulUser(jsonReq);
    }

    @And("Response register null email error body should be {string}")
    public void responseRegisterNullEmailErrorBodyShouldBe(String error) {
        SerenityRest.then().body("error",equalTo(error));
    }

    @And("Validate post register user null email json schema")
    public void validatePostRegisterUserNullEmailJsonSchema() {
        File jsonSchemaInvalidRegisterUsers = new File(Constant.JSON_SCHEMA+"RegisterInvalidJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaInvalidRegisterUsers));
    }


    //nullpassword
    @Given("Post register user with null password")
    public void postRegisterUserWithNullPassword() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"RegisterNullPasswordBody.json");
        reqresAPI.setPostRegisterUnsuccessfulUser(jsonReq);
    }
    @And("Response register null password error body should be {string}")
    public void responseRegisterNullPasswordErrorBodyShouldBe(String error) {
        SerenityRest.then().body("error",equalTo(error));
    }

    @And("Validate post register user null password json schema")
    public void validatePostRegisterUserNullPasswordJsonSchema() {
        File jsonSchemaInvalidRegisterUsers = new File(Constant.JSON_SCHEMA+"RegisterInvalidJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaInvalidRegisterUsers));
    }
}
