package javatestClass;

import static com.jayway.restassured.RestAssured.given;

import com.jayway.restassured.response.Response;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

public class DeleteGist {

	public Response deleteGist(String hostname, String gistId)
			throws ClientProtocolException,IOException,JSONException {

		String baseURL = hostname + Constants.GIST_URL + "/" +gistId;
		System.out.println("URL:= " + baseURL);

		Response getGistResponse = given().when().delete(baseURL);

		return getGistResponse;
	} 

}
