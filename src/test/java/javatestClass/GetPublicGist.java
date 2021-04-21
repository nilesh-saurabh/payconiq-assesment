package javatestClass;

import static com.jayway.restassured.RestAssured.given;

import com.jayway.restassured.response.Response;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

public class GetPublicGist {

	public Response getPubliGist(String hostname)
			throws ClientProtocolException,IOException,JSONException {

		String baseURL = hostname + Constants.GIST_URL;
		System.out.println("URL:= " + baseURL);

		Response getPublicGistsResponse = given().when().get(baseURL);

		return getPublicGistsResponse;
	} 

}
