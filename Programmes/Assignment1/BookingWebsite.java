public interface HotelWebsite {
    List<Room> searchRooms(String location, int numGuests, int numNights);
    boolean bookRoom(String roomId, String guestName, int numNights);
    boolean cancelBooking(String bookingId);
    List<Review> getReviews(String hotelId);
}

public class BookingWebsite implements HotelWebsite {
    private List<Room> rooms;
    private List<Booking> bookings;
    private List<Review> reviews;

    public List<Room> searchRooms(String location, int numGuests, int numNights) {
        List<Room> availableRooms = new ArrayList<Room>();
        for (Room room : rooms) {
            if (room.getLocation().equals(location) && room.getCapacity() >= numGuests) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public boolean bookRoom(String roomId, String guestName, int numNights) {
        Room room = findRoomById(roomId);
        if (room != null) {
            bookings.add(new Booking(guestName, room, numNights));
            return true;
        } else {
            return false;
        }
    }
    
    public boolean cancelBooking(String bookingId) {
        Booking booking = findBookingById(bookingId);
        if(booking!=null){
            bookings.remove(booking);
            return true;
        }else {
            return false;
        }
    }
    
    public List<Review> getReviews(String hotelId) {
        List<Review> reviewsForHotel = new ArrayList<Review>();
        for (Review review : reviews) {
            if (review.getHotelId().equals(hotelId)) {
                reviewsForHotel.add(review);
            }
        }
        return reviewsForHotel;
    }
    //Other helper methods like findRoomById,findBookingById
}
