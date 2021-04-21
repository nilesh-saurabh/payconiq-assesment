Feature: To_create_read_update_and_delete_gists
 @TC01
 Scenario Outline: GIST_Create: To Create a gist service.
  Given User should be able to create session with valid username "<USERNAME>", accesstoken "<ACCESS_TOKEN>" and using host name "<HOST_NAME>"
  When User create gist service with content "<CONTENT>" and using host name "<HOST_NAME>"
  Then User should be able to verify the created gist in response body using login name "<USERNAME>"
  Examples:
  |USERNAME 	  | ACCESS_TOKEN 							  |	   HOST_NAME	              |  	CONTENT   		|
  |nilesh-saurabh | 26ac1f4c2bc1b9257d8161295c03a73adbaceb5a  |     https://api.github.com    |  print Hello World  |
##############################################################################################################################################
 @TC02
 Scenario Outline: GIST_Read: To read a gist service.
  Given User should be able to create session with valid username "<USERNAME>", accesstoken "<ACCESS_TOKEN>" and using host name "<HOST_NAME>"
  When User fetch gist service using username "<USERNAME>" and using host name "<HOST_NAME>"
  Then User should be able to verify the gist in response body using login name "<USERNAME>"
  And User should fetch all public gist using host name "<HOST_NAME>"
  And User should fetch all gist using host name and gistid "<HOST_NAME>"
  Examples:
  |USERNAME 	  |               ACCESS_TOKEN 				  |	     HOST_NAME	                 |
  |nilesh-saurabh | 26ac1f4c2bc1b9257d8161295c03a73adbaceb5a  |      https://api.github.com      |
##############################################################################################################################################
 @TC03
 Scenario Outline: GIST_Update: To Update a gist service.
  Given User should be able to create session with valid username "<USERNAME>", accesstoken "<ACCESS_TOKEN>" and using host name "<HOST_NAME>"
  When User update gist service with content "<CONTENT>" and using host name "<HOST_NAME>"
  Then User should be able to verify the created gist in response body using content "<CONTENT>"
  Examples:
  |USERNAME 	  |            ACCESS_TOKEN 		          |	   HOST_NAME	              |  	CONTENT     |
  |nilesh-saurabh | 26ac1f4c2bc1b9257d8161295c03a73adbaceb5a  |     https://api.github.com    |  my app test    |
##############################################################################################################################################
 @TC04
 Scenario Outline: GIST_Delete: To Delete a gist service.
  Given User should be able to create session with valid username "<USERNAME>", accesstoken "<ACCESS_TOKEN>" and using host name "<HOST_NAME>"
  When User should be able to delete gist service using host name "<HOST_NAME>"
  Then User should be able to verify the deleted gist using status code "<STATUS_CODE>"
  Examples:
  |USERNAME 	  |               ACCESS_TOKEN 				  |	     HOST_NAME	                 |  	STATUS_CODE   |
  |nilesh-saurabh | 26ac1f4c2bc1b9257d8161295c03a73adbaceb5a  |      https://api.github.com      |         204        |
