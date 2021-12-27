//package com.chovietz.config;
//
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoDatabase;
//
//public class MongoDbConfig {
//	private String connection = "mongodb+srv://r12:r12@dichothuez.vgf8x.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";
//	private String DbName = "dichothuez";
//	
//	public MongoDatabase createConnection() {
//		MongoClient client = MongoClients.create(connection);
//		return client.getDatabase(DbName);
//	}
//}

//ConnectionString connectionString = new ConnectionString("mongodb+srv://r12:r12@dichothuez.vgf8x.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
//MongoClientSettings settings = MongoClientSettings.builder()
//        .applyConnectionString(connectionString)
//        .build();
//MongoClient mongoClient = MongoClients.create(settings);
//MongoDatabase database = mongoClient.getDatabase("test");
