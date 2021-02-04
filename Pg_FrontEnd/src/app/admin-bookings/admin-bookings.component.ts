import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-admin-bookings',
  templateUrl: './admin-bookings.component.html',
  styleUrls: ['./admin-bookings.component.css']
})
export class AdminBookingsComponent implements OnInit {

  ListOfBookings = []

  constructor(private adminService:AdminService,private toastrService : ToastrService) { }


  ngOnInit(): void {
    this.GetAllBookings()
  }



  GetAllBookings()
  {
    this.adminService.onGetAllBookings()
    .subscribe((response: any[]) => {
      this.ListOfBookings = response
      console.log("Response for getting all bookings Is : " , response)
    //  this.finalList = this.listOfOwnerPg.filter((item)=>{
    //    console.log("Item is : " , item)
    //     return item
    //   })
    this.toastrService.success("All Bookings Loaded")
      console.log("List Of Bookings is : " , this.ListOfBookings)
      //console.log(this.owners[0].address)
    })
  }

}
