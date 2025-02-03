package Entity;

public class Room{
    private String roomId;
    private String roomName;
    private int roomPrice; 
    private int roomQuantity;
 
    public Room() {}
 
    public Room(String roomId, String roomName, int roomPrice, int roomQuantity) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomPrice = roomPrice;
        this.roomQuantity = roomQuantity;
    }
 
   
    public void setRoomId(String roomId){
        this.roomId = roomId;
    }
	
	public String getRoomId(){
        return roomId;
    }
 
    public void setRoomName(String roomName){
        this.roomName = roomName;
    }
	
	public String getRoomName(){
        return roomName;
    }
	
 
    public void setRoomPrice(int roomPrice){ // Changed to double
        this.roomPrice = roomPrice;
    }
	
	public int getRoomPrice(){ // Changed to double
        return roomPrice;
    }
 
    public void setRoomQuantity(int roomQuantity){
        this.roomQuantity = roomQuantity;
    }
	
	public int getRoomQuantity(){
        return roomQuantity;
    }
 
    public void showAll(){
        System.out.println("Room Id: " + roomId);
        System.out.println("Room Name: " + roomName);
        System.out.println("Room Price: " + roomPrice); 
        System.out.println("Room Quantity: " + roomQuantity);
    }
		
	public String getRoomAsString()
	{ 
	String ssss ="Room Id : "+roomId +"\n"+ 
	"Room Name : "+roomName+"\n"+ 			
	"Room Price : "+roomPrice+"\n"+ 		
	"Room Quantity : "+roomQuantity; 	
	return ssss; 	
	}
}