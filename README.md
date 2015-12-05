# TravelApp-Server

REST Services
-----------

Base URL for non-HATEOAS services: https://localhost:8443/
Base URL for HATEOAS services: https://localhost:8443/hateoas/

    
### Traveler  
  
 Service | URL | HTTP Method 
 ------- | --- | -----------
 CREATE  | /travelers  | POST 
 READ  | /travelers  | GET  
 READ  | /travelers/{id}  | GET 
 READ  | /travelers/{name}/personaldata  | GET
 READ  | /travelers/personaldata/{personaldataid} | GET
 UPDATE  | /travelers  | PUT 
 UPDATE  | /travelers/personaldata/{personaldataid} | PUT
 DELETE  | /travelers/{id}  | DELETE 
    
### Trip  
  
 Service | URL | HTTP Method 
 ------- | --- | -----------
 CREATE  | /{traveler_id}/trips  | POST  
 READ  | /trips  | GET |
 READ  | /trips/{id}  | GET |
 READ  | /{traveler_id}/trips  | GET |  
 READ  | /{traveler_name}/timeline  | GET |  
 UPDATE  | /trips  | PUT |
 DELETE  | /trips/{id}  | DELETE |
    
### Followers

 Service | URL | HTTP Method 
 ------- | --- | -----------
 CREATE  | /follows  | POST 
 READ  | /follows  | GET 
 READ  | /{traveler_id}/follows  | GET  
 DELETE  | /{traveler_id}/follows/{followed_id}  | DELETE 
 
### Picture
 
  Service | URL | HTTP Method 
  ------- | --- | -----------
  CREATE  | /gallery/{gallery_id}/pictures  | POST 
  READ  | /place/{place_id}/pictures  | GET 
  READ  | /gallery/{gallery_id}/pictures  | GET 
  DELETE  | /pictures/{picture_id}  | DELETE 
  
### Place
 
  Service | URL | HTTP Method 
  ------- | --- | -----------
  CREATE  | /trips/{trip_id}/place  | POST 
  READ  | /trips/{trip_id}/place  | GET 
  DELETE  | /place/{place_id}  | DELETE 
  
### Authentication Service
 
  Service | URL | HTTP Method 
  ------- | --- | -----------
  READ  | /authenticationdata/{username}  | GET 
  
  
  