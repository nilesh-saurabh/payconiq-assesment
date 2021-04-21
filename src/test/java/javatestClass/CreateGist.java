package javatestClass;

import static com.jayway.restassured.RestAssured.given;

import com.jayway.restassured.response.Response;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

public class CreateGist {

	public Response createGist(String hostname, Gist_inputDTO createGistRequestBody)
			throws ClientProtocolException,IOException,JSONException {

		String baseURL = hostname + Constants.GIST_URL;
		System.out.println("URL:= " + baseURL);
		String username = "nilesh-saurabh";
		String password = "26ac1f4c2bc1b9257d8161295c03a73adbaceb5a";
		System.out.println("RequestBody:="+ createGistRequestBody.toString());

		Response createGistResponse = given().auth().preemptive().basic(username, password).contentType("application/json").body(createGistRequestBody.toString()).when().post(baseURL);

		return createGistResponse;	
	} 

}
