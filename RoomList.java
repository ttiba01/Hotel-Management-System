package EntityList;
 
import Entity.Room;
 
public class RoomList {
    private Room[] rooms;
 
    public RoomList() {
        rooms = new Room[10];
    }
 
    public RoomList(int size) {
        rooms = new Room[size];
    }
 
    public void insert(Room r) {
        boolean flag = false;
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i] == null) {
                rooms[i] = r;
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("Successfully Inserted :)");
        } else {
            System.out.println("Insertion Failed :(");
        }
    }
	
	public Room getById(String roomId){
		boolean flag = false;
		Room r = null;
		for(int i=0; i<rooms.length; i++){
			if(rooms[i] != null){
				if(rooms[i].getRoomId().equals(roomId)){
					r = rooms[i];
					flag = true;
					break;
				}
			}
			if(flag){
			System.out.println("Room found :)");
		}
		else{
			System.out.println("No Room with this ID :(");
		    }
	    }
		return r;
	}
	
	public void removeById(String roomId){
		boolean flag = false;
		for(int i=0; i<rooms.length; i++){
			if(rooms[i] != null){
				if(rooms[i].getRoomId().equals(roomId)){
					rooms[i] = null;
					flag = true;
					break;
				}
			}
		}
		if(flag){
			System.out.println("Successfully Removed.");
		}
		else{
			System.out.println("Failed to Remove.(Recheck Id)!");			
		}
	}

	public void showAll(){
		for(int i=0; i<rooms.length; i++){
			if(rooms[i] != null){
				System.out.println("--------------------------------");
				rooms[i].showAll();
				System.out.println("--------------------------------");
			}
		}
	}
	public String getAllRoomAsString(){
		String allRoom = "";
		for(int i=0;i<rooms.length;i++){
			if(rooms[i]!=null){
				allRoom += "--------------"+"\n"+
				rooms[i].getRoomAsString()+"\n"+
				"--------------"+"\n";
			}
		}
		return allRoom;
	}
}
