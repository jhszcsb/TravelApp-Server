# TravelApp-Server

REST Services
-----------
    
### Traveler  
  
 Service | URL | HTTP Method 
 ------- | --- | -----------
 CREATE  | /travelers  | POST 
 READ  | /travelers  | GET  
 READ  | /travelers/{id}  | GET 
 READ  | /travelers/{name}/personaldata  | GET
 READ  | /travelers/personaldataid/{personaldataid} | GET
 UPDATE  | /travelers  | PUT 
 UPDATE  | /travelers/{personaldataid}/personaldata | PUT
 DELETE  | /travelers/{id}  | DELETE 
    
### Trip  
  
 Service | URL | HTTP Method 
 ------- | --- | -----------
 CREATE  | /{traveler_id}/trips  | POST  
 READ  | /trips  | GET |
 READ  | /{traveler_id}/trips  | GET |  
    
### Friendship  

 Service | URL | HTTP Method 
 ------- | --- | -----------
 READ  | /friendships  | GET 
 READ  | /{traveler_id}/friendships  | GET  