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

public class GetListResourceStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Get list resource with valid parameter unknown")
    public void getListResourceWithValidParameterUnknown() {
        SerenityRest.given();
    }

    @When("Send request get list resource")
    public void sendRequestGetListResource() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_RESOURCE);
    }

    @And("Validate get List resource json schema")
    public void validateGetListResourceJsonSchema() {
        File jsonSchemaListResource = new File(Constant.JSON_SCHEMA+"ListResourceJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaListResource));
    }
}
