import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { BookingService } from '../booking.service';
import { PgService } from '../pg.service';
import { Booking } from './Booking';
import {Router } from '@angular/router';
@Component({
  selector: 'app-add-booking',
  templateUrl: './add-booking.component.html',
  styleUrls: ['./add-booking.component.css']
})
export class AddBookingComponent implements OnInit {

  customerId=sessionStorage['customerId']
  PgId = 0
  Pgdetails =[]
  booking2 = []
  booking1 = []

  checkInDate=''
  checkOutDate=''
  checkInTime = ''
  checkOutTime = ''
  roomType = ''
  noOfBookings = 0
  booking: Booking = new Booking();
  
  submitted 

  constructor(private bookingService:BookingService,private pgdetailsService:PgService,   
     private activatedRoute: ActivatedRoute,private Router:Router,private toastr:ToastrService
    ) { }

  ngOnInit(): void {
    this.LoadPgList()
    console.log("Todays Date : " + Date.now())

  }


  LoadPgList(){
     this.PgId = this.activatedRoute.snapshot.queryParams['PgId']

    //console.log(this.UserId)
    

    this.pgdetailsService.LoadPgList(this.PgId).subscribe(response=>{
      console.log(response)
      if(response['status']="success")
      {
        this.Pgdetails=response['data']
        this.booking['PgName']=this.Pgdetails[0]['PgName']
        this.booking['PgId']= this.Pgdetails[0]['PgId']
      
      }
    })
  }

  
  
  newbooking(booking){


   // this.route.snapshot.paramMap.get('param1');

    this.PgId = this.activatedRoute.snapshot.queryParams['PgId']


    

    console.log(booking)
    console.log("Sent Cust Id Is : " + this.customerId)

    console.log("Sent BookedPG Id Is : " + this.PgId)
    console.log("Booking Data sent is : " + booking.noOfBookings)
    // this.booking2 = booking
    // this.booking1 = this.booking2.filter((item)=>{
    //   return item
    // }) 
    this.bookingService.onNewbooking(this.customerId,this.booking,this.PgId).subscribe(response=>{
     console.log(response)
      this.toastr.success('Booking Added')
      this.Router.navigate(['/booking-list'])

    })
   // this.booking = new Booking();
    this.LoadPgList();

  }

  onCancel(){
    this.toastr.info("Cancelling Booking")
    this.Router.navigate(['/pglist'])
  }
}
