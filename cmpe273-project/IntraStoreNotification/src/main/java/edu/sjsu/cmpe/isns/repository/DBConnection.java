package edu.sjsu.cmpe.isns.repository;

import java.net.UnknownHostException;
import java.util.ArrayList;

import com.mongodb.*;

public class DBConnection {

	MongoClient mc;
	DB database;
	DBCollection coll;

	// String collectionTable;

	public DBConnection(String collectionTable) throws UnknownHostException {
		MongoClientURI uri = new MongoClientURI(
				"mongodb://admin:password@ds053648.mongolab.com:53648/cmpe273project");
		mc = new MongoClient(uri);
		database = mc.getDB(uri.getDatabase());
		coll = database.getCollection(collectionTable);
		System.out.println(collectionTable);
	}

	public void StoreUser(edu.sjsu.cmpe.isns.domain.User request) {
		BasicDBObject document = new BasicDBObject();
		document.put("id", request.getId());
		document.put("firstName", request.getFirstName());
		document.put("lastName", request.getLastName());
		document.put("eMail", request.geteMail());
		document.put("phoneNumber", request.getPhoneNumber());
		coll.insert(document);
		usersInDepartment("test");
	}

	public ArrayList<edu.sjsu.cmpe.isns.dto.UserDto> usersInDepartment(
			String dept) {
		BasicDBObject findQuery = new BasicDBObject("firstName", "raj");
		DBCursor docs = coll.find(findQuery);
		// System.out.println(docs);
		while (docs.hasNext()) {
			DBObject doc = docs.next();
			System.out.println("In the " + doc.get("firstName") + ", "
					+ doc.get("lastName") + " by " + doc.get("id"));
		}
		return null;
	}
}