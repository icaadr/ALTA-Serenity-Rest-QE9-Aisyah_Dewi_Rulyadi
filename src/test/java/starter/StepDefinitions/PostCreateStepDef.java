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

public class PostCreateStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Create new user with valid json")
    public void createNewUserWithValidJson() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"UsersReqBody.json");
        reqresAPI.postCreateUser(jsonReq);
    }
    @When("Send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Response body name should be {string} and job is {string}")
    public void responseBodyNameShouldBeAndJobIs(String name, String job) {
        SerenityRest.then()
                .body("name",equalTo(name))
                .body("job",equalTo(job));
    }
}
