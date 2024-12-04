1. Install MySQL
2. Create 3 tables using below queries
create database test;
CREATE TABLE test.CUSTOMER (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(255) NOT NULL ,
   customer_slug VARCHAR(255) NOT NULL default ""  
); 
CREATE TABLE test.PARCEL (
    parcel_id INT AUTO_INCREMENT PRIMARY KEY,
    origin_country_id VARCHAR(255) NOT NULL ,
    destination_country_id VARCHAR(255) NOT NULL ,
    weight float NOT NULL,
    created_at datetime Not NULL,
    customer_id Int Not NULL,    
    tracking_Number  VARCHAR(255) default "",
    count int not null,
    foreign key (customer_id) references CUSTOMER(customer_id)
);
CREATE TABLE test.TRACKING (
    tracking_Number  VARCHAR(255) PRIMARY KEY,
    parcel_id INT Not NULL,
    foreign key (parcel_id) references PARCEL(parcel_id)

);
Note: All the generated tracking numbers for every parcel are stored in Tracking DB


2. Edit DB details in Springboot Application.properties file as per the installed db credentials
# MySQL Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=password
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

3.  Start the application
4. First Create Customer and Parcel in DB using the below APIS
Calling APIS in postman

1. Create customer in DB by calling below API
Method: Post
URL: http://localhost:8080/application/createCustomer
Input : 
{
    "customerName": "RedBox Logistics",
    "customerSlug" : "redbox-logistics"	 
}
2. Create parcel in DB by calling below API
Method: Post
URL: http://localhost:8080/application/createParcel
Input : {
    "originCountryId": "MY",    
     "destinationCountryId" : "SG",    
     "weight": 100,
    "customerId":1
}
Note : Take customerID from the firstAPI Response
5. Generate next tracking number for the parcel by calling below API
Method: GET
URL: http://localhost:8080/application/next-tracking-number
Input : {

   "customerName":  "Sam",    
    "customerSlug" : "Samm",    
    "originCountryId": "MY",    
     "destinationCountryId" : "SG",    
     "weight": 100,
    "customerId":5   
}
Response : {
    "createdAt": "2024-12-04T13:53:43.496536500",
    "trackingNumber": "5-RedBox Logistics1-redbox-logistics1-6-MY-SG-100.0-2024-12-04T13:52:52-3"
}

Note : Same input data can be submitted , every time it generates unique tracking number for the parcel.





