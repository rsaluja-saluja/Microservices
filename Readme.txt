Eureka Server : http://localhost:8761/
MovieInfoService : http://localhost:8082/movies/movie1
MovieRatingService : http://localhost:8083/ratings/user1
Catalog Service : http://localhost:8081/catalog/user3
	This srevice call MovieRatingService by passing userId and get list of movie ids and rating that user has given.
	For every movie id it calls MovieInfoService to get that movie details like movie name and description. 
	Combine the response of rating and movie infor service calls and send response back to client.

MovieInfoService Response: 
	{"movieId":"movie1","movieName":"movie1 movie name","movieDesc":"movie1 movie Desc"}

MovieRatingService Response:
	<userRating>
	<userID>user1</userID>
	<userName>user1 User Name</userName>
	<ratings>
		<ratings>
			<movieId>movie1</movieId>
			<rating>4</rating>
		</ratings>
		<ratings>
			<movieId>movie2</movieId>
			<rating>3</rating>
		</ratings>
		<ratings>	
			<movieId>movie3</movieId>
			<rating>5</rating>
		</ratings>
	</ratings>
	</userRating>	

Catalog Service Response:	
	<catalogItem>
	<userId>user3</userId>
	<userName>user3 User Name</userName>
	<userMoviesRatings>
		<userMoviesRatings>
			<movieId>movie1</movieId>
			<movieName>movie1 movie name</movieName>
			<movieDesc>movie1 movie Desc</movieDesc>
			<movieRating>4</movieRating>
			</userMoviesRatings>
		<userMoviesRatings>
			<movieId>movie2</movieId>
			<movieName>movie2 movie name</movieName>
			<movieDesc>movie2 movie Desc</movieDesc>
			<movieRating>3</movieRating>
		</userMoviesRatings>
		<userMoviesRatings>
			<movieId>movie3</movieId>
			<movieName>movie3 movie name</movieName>
			<movieDesc>movie3 movie Desc</movieDesc>
			<movieRating>5</movieRating>
		</userMoviesRatings>
		</userMoviesRatings>
	</catalogItem>