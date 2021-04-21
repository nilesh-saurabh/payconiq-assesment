package javatestClass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;


@JsonIgnoreProperties(ignoreUnknown = true)

public class Gist_inputDTO {
  private String jsonToString;
  
  public String content;
  
//read content
  public String getContent() {
      return content;
  }

  // set content
  public void setContent(String content) {
      this.content = content;
  }
  
   @Override
	@JsonValue
	public String toString() {
		
    jsonToString= "{\r\n  \"description\": \"Hello World Examples\",\r\n  \"public\": true,\r\n  \"files\": {\r\n    \"hello_world_python.txt\": {\r\n      \"content\":" + "\"" + content + "\"" + "\r\n    }\r\n  }\r\n";
		return jsonToString;
	}
}
