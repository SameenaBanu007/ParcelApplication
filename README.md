Please refer word document in this for screenshots.



1.	Install MySQL
2.	create database test;
3.	create 3 tables by using below quereies
A.
CREATE TABLE test.CUSTOMER (
    customer_id BINARY(16) DEFAULT (UUID())  PRIMARY KEY,
    customer_name VARCHAR(255) NOT NULL ,
    customer_slug VARCHAR(255) NOT NULL default ""  
);
B.
CREATE TABLE test.PARCEL (
    parcel_id INT AUTO_INCREMENT PRIMARY KEY,
    origin_country_id VARCHAR(255) NOT NULL ,
	destination_country_id VARCHAR(255) NOT NULL ,
    weight float NOT NULL,
    created_at datetime Not NULL,
    customer_id BINARY(16) Not NULL,    
    tracking_Number  VARCHAR(255) default "",
    count int not null,
    foreign key (customer_id) references CUSTOMER(customer_id)
);
C.
CREATE TABLE test.TRACKING (
    tracking_Number  VARCHAR(255) PRIMARY KEY,
    parcel_id INT Not NULL,
    foreign key (parcel_id) references PARCEL(parcel_id)
);


4. Edit DB details in Springboot Application.properties file as per the installed db credentials
spring.datasource.url=
jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=password
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

5.  Start the application
4. First Create Customer and Parcel in DB using the below APIS
      Note : Calling APIS in postman
A. 
Create customer in DB by calling below API
Method: Post
URL: http://localhost:8080/application/createCustomer
Input : 
{

   "customerName":  "Sameena Logistics",    
    "customerSlug" : "sameena-logistics"    
   
}
Output:
{
    "customerId": "46d98356-a7f2-4663-80c1-8ca29c539983",
    "customerName": "Sameena Logistics",
    "customerSlug": "sameena-logistics"
}



B. 
Create Parcel in DB by calling below API
Method: Post
URL: http://localhost:8080/application/createParcel
Input : 
{
    "originCountryId": "MY",   
     "destinationCountryId" : "SG",    
     "weight": 100,
    "customerId":"46d98356-a7f2-4663-80c1-8ca29c539983"
}
Note : Take customerID from the firstAPI Response

Output:
{
    "parcelId": 12,
    "originCountryId": "MY",
    "destinationCountryId": "SG",
    "weight": 100.0,
    "createdAt": "2024-12-10T09:09:14-08:00",
    "trackingNumber": "46d98356-a7f2-4663-80c1-8ca29c539983-12-2024-12-10T09:09:14-08:00-1",
    "count": 1,
    "customer": {
        "customerId": "46d98356-a7f2-4663-80c1-8ca29c539983",
        "customerName": "Sameena Logistics",
        "customerSlug": "sameena-logistics"
    },
    "customerId": "46d98356-a7f2-4663-80c1-8ca29c539983"
}






C.
 Generate next tracking number for the parcel by calling below API
Method: GET
URL: http://localhost:8080/application/next-tracking-number
Input : 
{
   "customerName":  "Sameena Logistics",    
    "customerSlug" : "sameena-logistics"    ,
    "originCountryId": "MY",    
     "destinationCountryId" : "SG", 
     "weight": 100,
    "customerId":"b6d4e51b-5a13-4081-8f57-e379b43ac336"
}

Output : 
{
    "createdAt": "2024-12-10T09:42:38-08:00",
    "trackingNumber": "b6d4e51b-5a13-4081-8f57-e379b43ac336-13-6"
}

Note : Same input data CAN be submitted , every time it generates unique tracking number for the parcel.
Note:
Formula for Tracking Number :
customerID  - parcelID-parcelcount
Each parcel has count column while will be incremented in every  tracking number request.

 

