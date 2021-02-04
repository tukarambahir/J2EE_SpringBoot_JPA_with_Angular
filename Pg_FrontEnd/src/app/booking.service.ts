import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  url ='http://ec2-107-23-189-94.compute-1.amazonaws.com:7070/booking'


  constructor(private httpClient:HttpClient) { }

 // bookedPgId = sessionStorage['bookedPgId']
  customerId = sessionStorage['customerId']

  onLoad(customerId)
  {
    return this.httpClient.get('http://ec2-107-23-189-94.compute-1.amazonaws.com:7070/customer/getAllBokings/' + customerId)
  }
 
  
  deleteBooking(id) 
  {
     return this.httpClient.delete('http://ec2-107-23-189-94.compute-1.amazonaws.com:7070/customer/delete/booking/'+ id)
  }

  onNewbooking(UserId,booking,bookedPgId){    

 // console.log(booking['ConfirmationStatus'])
 console.log("booking data received is : " + booking.noOfBookings)
  const body ={
      roomType : booking['roomType'],
      checkInDate :booking['checkInDate'],
      checkOutDate :booking['checkOutDate'],
      checkInTime : booking['checkInTime'],
      checkOutTime : booking['checkOutTime'],    
      noOfBookings : booking.noOfBookings
      
  }
 // console.log(`${UserId}`)
  console.log("Final id "+bookedPgId)
  console.log("Sent URL Is " + this.url+`/add/ `+ bookedPgId + '/'+this.customerId)
  return this.httpClient.post(this.url+`/add/ `+ bookedPgId + '/'+this.customerId,body)
  }

  toggleActivateStatus(booking) {
    // add the token in the request header
    const httpOptions = {
      headers: new HttpHeaders({
        token: sessionStorage['token']
      })
    };
    
    const body = {}
    return this.httpClient.put(this.url + `/update-state/${booking['BookingId']}/${booking['ConfirmationStatus'] == 'No' ? 'yes' : 'No'}`, body, httpOptions)
  }

}
