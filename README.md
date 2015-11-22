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
 READ  | /travelers/personaldata/{personaldataid} | GET
 UPDATE  | /travelers  | PUT 
 UPDATE  | /travelers/personaldata/{personaldataid} | PUT
 DELETE  | /travelers/{id}  | DELETE 
    
### Trip  
  
 Service | URL | HTTP Method 
 ------- | --- | -----------
 CREATE  | /{traveler_id}/trips  | POST  
 READ  | /trips  | GET |
 READ  | /{traveler_id}/trips  | GET |  
 READ  | /{traveler_name}/timeline  | GET |  
 UPDATE  | /trips  | PUT |
 DELETE  | /trips/{id}  | DELETE |
    
### Friendship  

 Service | URL | HTTP Method 
 ------- | --- | -----------
 CREATE  | /friendships  | POST 
 READ  | /friendships  | GET 
 READ  | /{traveler_id}/friendships  | GET  
 DELETE  | /{traveler_id}/friendships/{friend_id}  | DELETE 
 
### Picture
 
  Service | URL | HTTP Method 
  ------- | --- | -----------
  CREATE  | /gallery/{gallery_id}/pictures  | POST 
  READ  | /places/{places_id}/pictures  | GET 
  READ  | /gallery/{gallery_id}/pictures  | GET 
  
### Places
 
  Service | URL | HTTP Method 
  ------- | --- | -----------
  CREATE  | /trips/{trip_id}/places  | POST 
  READ  | /trips/{trip_id}/places  | GET 