package javatestClass;

import static com.jayway.restassured.RestAssured.given;

import com.jayway.restassured.response.Response;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

public class GetGist {

	public Response getGist(String hostname, String username)
			throws ClientProtocolException,IOException,JSONException {

		String baseURL = hostname + "/users/" + username + "/gists";
		System.out.println("URL:= " + baseURL);

		Response getGistResponse = given().when().get(baseURL);

		return getGistResponse;
	} 

}
