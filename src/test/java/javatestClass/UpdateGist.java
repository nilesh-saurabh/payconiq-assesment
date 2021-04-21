package javatestClass;

import static com.jayway.restassured.RestAssured.given;

import com.jayway.restassured.response.Response;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

public class UpdateGist {

	public Response updateGist(String hostname, Gist_inputDTO updateGistRequestBody, String gistId)
			throws ClientProtocolException,IOException,JSONException {

		String baseURL = hostname + Constants.GIST_URL + "/" + gistId;
		System.out.println("URL:= " + baseURL);
		String username = "nilesh-saurabh";
		String password = "26ac1f4c2bc1b9257d8161295c03a73adbaceb5a";
		System.out.println("RequestBody:="+ updateGistRequestBody.toString());
		

		Response updateGistResponse = given().auth().preemptive().basic(username, password).contentType("application/json").body(updateGistRequestBody.toString()).when().patch(baseURL);

		return updateGistResponse;
	} 

}
