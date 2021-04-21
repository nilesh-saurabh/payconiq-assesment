package stepdefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import javatestClass.CreateGist;
import javatestClass.DeleteGist;
import javatestClass.Gist_inputDTO;
import javatestClass.GetGist;
import javatestClass.GetPublicGist;
import javatestClass.GetGistId;
import javatestClass.UpdateGist;

public class StepDefinition_gist {


  public String hostName;
  public String userName;
  public String accessToken;
  public String content;
  public String loginName;
  public Integer statusCode;
  public String gistID;
  public static String gistId;
  public static String gistIdnew;
  public static Gist_inputDTO createGistInputJSONObj;
  public static Gist_inputDTO updateGistInputJSONObj;
  public Response createGistsResponse;
  public Response getGistsResponse;
  public Response getPublicGistsResponse;
  public Response getGistsIdResponse;
  public Response updateGistResponse;
  public Response deleteGistsResponse;


// ==============================================================================================================================================================================================================================================================================================================================================

  @Given("^User should be able to create session with valid username \"([^\"]*)\", accesstoken \"([^\"]*)\" and using host name \"([^\"]*)\"$")
  public void User_should_login_with_valid_username_and_accesstoken_using_host_name(
      String username, String accToken, String hostUrl) throws Throwable {

    userName = username;
    accessToken = accToken;
    hostName = hostUrl;

    String baseURL = hostUrl;
    System.out.println("URL:= " + baseURL);
  }

  // ========================================================================================================================================================================================================================================================================================================================================================
  // Create Gist Service
  @When("^User create gist service with content \"([^\"]*)\" and using host name \"([^\"]*)\"$")
  public void User_create_gist_service_with_content_using_host_name(
      String Content, String hostUrl) throws Throwable {
    System.out.println("Start of ==>> When : user_hits_createGist_service");

    hostName = hostUrl;
    content = Content;

    createGistInputJSONObj = new Gist_inputDTO();
    createGistInputJSONObj.setContent(content);
    System.out.println(createGistInputJSONObj.toString());

    System.out.println("Start of ==>> Creation of Gist Service");
    CreateGist creategist = new CreateGist();
    createGistsResponse = creategist.createGist(hostName, createGistInputJSONObj);
    System.out.println(
        "createGistResponse as a String := " + createGistsResponse.getBody().asString());
    System.out.println(
        "createGistResponse StatusCode := " + createGistsResponse.getStatusCode());
    System.out.println("End of ==>> Creation of Gist Service");
    gistId = createGistsResponse.jsonPath().get("id");
    System.out.println("value of gistID := " + gistId);

    if (createGistsResponse.getStatusCode() != 201) {
      System.out.println("createGist failed");
    }
    else
      System.out.println("createGist passed");
      System.out.println("End of ==>> createGist_service");
  }

  // ========================================================================================================================================================================================================================================================================================================================================================
  // Verify created gist
  @Then("^User should be able to verify the created gist in response body using login name \"([^\"]*)\"$")
  public void User_should_be_able_to_verify_the_created_gist_using_login_name(
      String LoginName) throws Throwable {

    loginName = LoginName;
    System.out.println("Start of ==>> verify_Create_Gist_service");
    assertNotEquals(createGistsResponse.jsonPath().getString("owner.login").toString(),"");
    String login_name = createGistsResponse.jsonPath().get("owner.login");
    System.out.println("value of LoginName is := " + login_name);
    assertEquals(Boolean.TRUE, createGistsResponse.getBody().asString().contains(LoginName));
    assertEquals(createGistsResponse.getStatusCode(),201);
    System.out.println("End of ==>> verify_Create_Gist_service");
  }

  // ========================================================================================================================================================================================================================================================================================================================================================
  // Get Gist Service
  @When("^User fetch gist service using username \"([^\"]*)\" and using host name \"([^\"]*)\"$")
  public void User_should_fetch_gist_service_using_username_and_host_name(
      String Username, String hostUrl) throws Throwable {
    System.out.println("Start of ==>> When : user_hits_getGist_service");

    hostName = hostUrl;
    userName = Username;

    System.out.println("Start ==>> verify gist using username");
    GetGist gist = new GetGist();
    getGistsResponse = gist.getGist(hostName, userName);
    System.out.println(
        "getGistsResponse as a String := " + getGistsResponse.getBody().asString());
    System.out.println(
        "getGistsResponse StatusCode := " + getGistsResponse.getStatusCode());
    System.out.println("End of ==>> getGist_service");
  }
  // ========================================================================================================================================================================================================================================================================================================================================================
  // Verify gist service
  @Then("^User should be able to verify the gist in response body using login name \"([^\"]*)\"$")
  public void User_should_be_able_to_verify_the_gist_using_login_name(
      String LoginName) throws Throwable {

    loginName = LoginName;
    System.out.println("Start of ==>> verify_Get_Gist_service");
    assertNotEquals(getGistsResponse.jsonPath().getString("owner.login").toString(), "");
    assertEquals(getGistsResponse.getStatusCode(),200);
    System.out.println("End of ==>> verify_Get_Gist_service");
  }

  // ========================================================================================================================================================================================================================================================================================================================================================
  // Get Public Gist Service
  @And("^User should fetch all public gist using host name \"([^\"]*)\"$")
  public void User_should_fetch_gist_service_using_host_name(
      String hostUrl) throws Throwable {

    System.out.println("Start of ==>> When : user_hits_getPublicGist_service_using_hostName");
    hostName = hostUrl;
    GetPublicGist publicGist = new GetPublicGist();
    getPublicGistsResponse = publicGist.getPubliGist(hostName);
    System.out.println("getPublicGist------------:" + getPublicGistsResponse.getBody().asString());
    assertNotEquals(getPublicGistsResponse.jsonPath().getString("owner.login").toString(), "");
    assertEquals(getPublicGistsResponse.getStatusCode(),200);
    System.out.println("End of ==>> getPublicGist_service_using_hostName");
  }
  // ========================================================================================================================================================================================================================================================================================================================================================
// Get Gist Service using id
  @And("^User should fetch all gist using host name and gistid \"([^\"]*)\"$")
  public void User_should_fetch_gist_service_using_gist_id(
      String hostUrl) throws Throwable {

    System.out.println("Start of ==>> When : user_hits_getGist_service_using_Id");
    hostName = hostUrl;
    gistID = gistId;
    System.out.println("value of gistID := " + gistID);
    GetGistId gistid = new GetGistId();
    getGistsIdResponse = gistid.getGistId(hostName,gistID);
    System.out.println("getGistId------------:" + getGistsIdResponse.getBody().asString());
    assertNotEquals(getGistsIdResponse.jsonPath().getString("owner.login").toString(), "");
    assertEquals(getGistsIdResponse.getStatusCode(),200);
    System.out.println("End of ==>> getGist_service_using_Id");
  }
  // ========================================================================================================================================================================================================================================================================================================================================================
  // Update Gist Service
  @When("^User update gist service with content \"([^\"]*)\" and using host name \"([^\"]*)\"$")
  public void User_update_gist_service_with_content_using_host_name(
      String Content, String hostUrl) throws Throwable {
    System.out.println("Start of ==>> When : user_hits_updateGist_service");

    hostName = hostUrl;
    content = Content;
    gistID = gistId;

    updateGistInputJSONObj = new Gist_inputDTO();
    updateGistInputJSONObj.setContent(content);
    System.out.println(updateGistInputJSONObj.toString());

    System.out.println("Start of ==>> Updation of Gist Service");
    UpdateGist creategist = new UpdateGist();
    updateGistResponse = creategist.updateGist(hostName, updateGistInputJSONObj,gistID );
    System.out.println(
        "createGistResponse as a String := " + updateGistResponse.getBody().asString());
    System.out.println(
        "createGistResponse StatusCode := " + updateGistResponse.getStatusCode());
    System.out.println("End of ==>> Updation of Gist Service");
    gistIdnew = updateGistResponse.jsonPath().get("id");
    System.out.println("value of gistID := " + gistIdnew);

    if (updateGistResponse.getStatusCode() != 200) {
      System.out.println("updateGist failed");
    }
    else
      System.out.println("updateGist passed");
    System.out.println("End of ==>> UpdateGist_service");
  }

  // ========================================================================================================================================================================================================================================================================================================================================================
  // Verify updated gist
  @Then("^User should be able to verify the created gist in response body using content \"([^\"]*)\"$")
  public void User_should_be_able_to_verify_the_updated_gist_using_content(
      String Content) throws Throwable {

    content = Content;
    System.out.println("Start of ==>> verify_updated_Gist_service");
    assertNotEquals(updateGistResponse.jsonPath().getString("files.\"hello_world_python.txt\".content").toString(),"");
    String content = updateGistResponse.jsonPath().get("files.\"hello_world_python.txt\".content");
    System.out.println("value of Content is := " + content);
    assertEquals(Boolean.TRUE, updateGistResponse.getBody().asString().contains(Content));
    System.out.println("End of ==>> verify_updated_Gist_service");
  }
  // ========================================================================================================================================================================================================================================================================================================================================================
  // Delete Gist Service
  @When("^User should be able to delete gist service using host name \"([^\"]*)\"$")
  public void User_should_delete_gist_service_using_host_name(
      String hostUrl) throws Throwable {
    System.out.println("Start of ==>> When : user_hits_deleteGist_service");

    hostName = hostUrl;

    System.out.println("Start ==>> deleteGist_service");
    DeleteGist gistdelete = new DeleteGist();
    deleteGistsResponse = gistdelete.deleteGist(hostName, gistIdnew);
    //System.out.println("deleteGist------------:" + deleteGistsResponse.getBody().asString());
    System.out.println("End of ==>> deleteGist_service");
  }
  // ========================================================================================================================================================================================================================================================================================================================================================
  // Verify deleted gist service
  @Then("^User should be able to verify the deleted gist using status code \"([^\"]*)\"$")
  public void User_should_be_able_to_verify_the_deleted_gist_using_status_code(
      Integer StatusCode) throws Throwable {

    statusCode = StatusCode;
    System.out.println("value of status code:" + statusCode);
    if (deleteGistsResponse.getStatusCode() != statusCode) {
      System.out.println("deleteGist failed");
    }
    else
      System.out.println("deleteGist passed");
  }
}