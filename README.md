# yelp-api
Sample Rest API for Usage of Yelp API
This is only a Sample Rest API that uses and integrates with Yelp API.


Contains an API endpoint that retrieves and processes reviews of businesses from Yelp API and outputs the information in a JSON response format. 

HOW TO USE:
1. Get your Yelp API key and input it in the application.properties. If you don't have one, you can create your own from here: https://www.yelp.com/developers/v3/manage_app 
2. Run ApiApplication.java
3. Once application has started, go to browser and access swagger ui to test: http://localhost:8080/yelp-api/swagger-ui.html
4. Or you can also call the endpoint directly: http://localhost:8080/yelp-api/yelp/businesses/{{businessId}}/reviews
