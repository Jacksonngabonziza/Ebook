package com.Ebook.api.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Ebook.api.model.Booking;
import com.Ebook.api.repository.BookingRepository;


@RestController
@RequestMapping("/api/v1")
public class BookingController {
    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping("/booking")
    public List<Booking> getAllBooking(){
    return bookingRepository.findAll();
}

@GetMapping("/booking/{id}")
public ResponseEntity<Booking> getBookingById(@PathVariable(value = "id") Long bookingId){

	Booking booking = bookingRepository.findById(bookingId)
			.orElseThrow(() -> new RuntimeException("Booking not found for this id :: " + bookingId));
	return ResponseEntity.ok().body(booking);
}

@PostMapping("/booking")
public Booking createBooking(@Valid @RequestBody Booking booking){
return bookingRepository.save(booking);
}

@PutMapping("/booking/{id}")
public ResponseEntity<Booking> updateBooking(@PathVariable(value = "id") Long bookingId,
@Valid @RequestBody Booking bookingDetails){
	Booking booking = bookingRepository.findById(bookingId)
			.orElseThrow(() -> new RuntimeException("Booking not found for this id :: " + bookingId));

    booking.setRoom(bookingDetails.getRoom());
	booking.setCheckIn(bookingDetails.getCheckIn());
    booking.setCheckOut(bookingDetails.getCheckOut());
   booking.setBooking_date(bookingDetails.getBooking_date());
   booking.setCustomer(bookingDetails.getCustomer());
	booking.setStatus(bookingDetails.getStatus());
    booking.setUser(bookingDetails.getUser());
return ResponseEntity.ok(bookingRepository.save(booking));

}
 @DeleteMapping("/booking/{id}")
 	public ResponseEntity<?> deleteBooking(@PathVariable(value = "id") Long bookingId) {
		bookingRepository.deleteById(bookingId);
		return ResponseEntity.ok().build();
	}

}





