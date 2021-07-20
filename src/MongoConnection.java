import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {

	public static void main(String[] args) {
		
	}
	public static MongoClient getClient(){
		try{
			MongoClient client=new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
			System.out.println("========Connection opened=======");
			return client;
		}
		catch(Exception e) {
			System.out.println("Connection Error");
			e.printStackTrace();
			throw e;
		}
	}
}
