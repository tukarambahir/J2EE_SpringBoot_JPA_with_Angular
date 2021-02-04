import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { BookingService } from '../booking.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-booking-list',
  templateUrl: './booking-list.component.html',
  styleUrls: ['./booking-list.component.css']
})
export class BookingListComponent implements OnInit {

  bookings = []
   booking = {}
   bookDeets = []

   ConfirmationStatus = 'Confirm'
   customerId= sessionStorage['customerId']
  constructor(private bookingService:BookingService,private Router:Router, private toastrService : ToastrService ) { }

  ngOnInit(): void {
  this.onLoad(this.customerId)
  }

  
  onDelete(booking) 
  {
    if(confirm('Do you want to cancle Booking ..?'))
    {
      console.log("Booking Id to be deleted is : " + booking['bookingId'])
      this.bookingService
      .deleteBooking(booking['bookingId'])
      .subscribe(response => {
        if (response['status'] == 'success') 
        {
          this.onLoad(this.customerId)
          this.toastrService.success('deleted booking')
          //alert('Deleting booking')
        }
        
      })
    }
    else
    {
    this.toastrService.error('Booking not canceled')
       // alert('Booking not canceled')
    }
    //this.onLoad(this.customerId)
  }
  
onConfirm(){
 // Has to be done
  //this.Router.navigate(['/home/booking/transaction'])
}


  onLoad(customerId)
  {
   this.bookingService.onLoad(customerId)
   .subscribe((response : any[])=>
   {

    if(response[0] == null)
    {
      this.toastrService.info("You Have No Bookings Currently")
    }
     console.log("Response for bookingList is : " + response[0].bookingId) 
     
     this.bookings =response
     this.bookDeets = this.bookings.filter((item)=>{
       return item
     })  
     console.log(this.bookDeets)
     this.toastrService.info('Booking List Loaded')
     //alert('Booking List Loaded')
   })
  }
}