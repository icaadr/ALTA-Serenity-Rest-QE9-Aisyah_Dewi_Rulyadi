package starter.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Utils.Constant;

import java.io.File;

public class GetListSingleResourceStepDef {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Get list single resource with valid parameter {int}")
    public void getListSingleResourceWithValidParameterId(int id) {
        reqresAPI.setGetListSingleResource(id);
    }

    @When("Send request get list single resource")
    public void sendRequestGetListSingleResource() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_SINGLE_RESOURCE);
    }

    @And("Validate get List single resource json schema")
    public void validateGetListSingleResourceJsonSchema() {
        File jsonSchemaListSingleResource = new File(Constant.JSON_SCHEMA+"ListSingleResourceJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaListSingleResource));
    }
    //negative
    @Given("Get list single resource with invalid parameter {string}")
    public void getListSingleResourceWithInvalidParameterId(String id) {
        reqresAPI.setGetListInvalidSingleResource(id);
    }
    @And("Validate get List single resource not found json schema")
    public void validateGetListSingleResourceNotFoundJsonSchema() {
        File jsonSchemaNotFoundListSingleResource = new File(Constant.JSON_SCHEMA+"SingleResourceNotFoundJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaNotFoundListSingleResource));

    }
}
