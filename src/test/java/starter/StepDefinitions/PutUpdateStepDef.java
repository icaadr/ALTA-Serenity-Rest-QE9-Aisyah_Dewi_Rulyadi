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

public class PutUpdateStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Update user with valid json and parameter id {int}")
    public void updateUserWithValidJsonAndParameterId(int id) {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"UsersReqBody.json");
        reqresAPI.putUpdateUser(jsonReq,id);
    }
    @When("Send request put update users")
    public void sendRequestPutUpdateUsers() {

        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }


    //tugas
    @Given("Update user with valid json body and invalid parameter id {string}")
    public void updateUserWithValidJsonBodyAndInvalidParameterIdId(String id) {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"PutUpdateInvalidBody.json");
        reqresAPI.putUpdateInvalidUser(jsonReq,id);
    }
    @And("Validate put update json scheme")
    public void validatePutUpdateJsonSchema() {
        File jsonSchemaPutUpdate = new File(Constant.JSON_SCHEMA+"PutUpdateJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaPutUpdate));
    }
    //invalidjson
    @Given("Put update user with invalid json and valid id {int}")
    public void putUpdateUserWithInvalidJson(int id) {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"PutUpdateInvalidBody.json");
        reqresAPI.putUpdateUser(jsonReq,id);
    }

    @And("Response update error body should be {string}")
    public void responseUpdateErrorBodyShouldBe(String error) {
        SerenityRest.then().body("error",equalTo(error));
    }

    //nullemail
    @Given("Put update user with null name and valid id {int}")
    public void putUpdateUserWithNullName(int id) {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"PutUpdateNullNameBody.json");
        reqresAPI.putUpdateUser(jsonReq,id);
    }

    @And("Response update null name error body should be {string}")
    public void responseUpdateNullNameErrorBodyShouldBe(String error) {
        SerenityRest.then().body("error",equalTo(error));
    }

    //nullpassword
    @Given("Put update user with null job and valid id {int}")
    public void putUpdateUserWithNullJob(int id) {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"PutUpdateNullJobBody.json");
        reqresAPI.putUpdateUser(jsonReq,id);
    }

    @And("Response update with null job error body should be {string}")
    public void responseUpdateWithNullJobErrorBodyShouldBe(String error) {
        SerenityRest.then().body("error",equalTo(error));
    }
}
