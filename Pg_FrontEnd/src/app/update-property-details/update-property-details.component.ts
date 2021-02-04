import { Component, OnInit } from '@angular/core';
import { AddPropertyService } from '../add-property.service';
import { Router } from '@angular/router';



@Component({
  selector: 'app-update-property-details',
  templateUrl: './update-property-details.component.html',
  styleUrls: ['./update-property-details.component.css']
})
export class UpdatePropertyDetailsComponent implements OnInit {

  pgToUpdate = {}

name = ''
RoomCapacity = 0
rent = 0
facilities = ''
nonacrooms = 0
acrooms = 0
deposit = 0
Status = ''
city = ''
state = ''
PhoneNo = ''
Landmark = ''
address = ''
ZipCode = ''

  constructor(private addPropertyService:AddPropertyService,
    private router:Router) { }

  pgIdToUpdate = sessionStorage['pgIdToUpdate']

  ngOnInit(): void {
    this.upatePgOne()
  }

  // There are 2 steps to Update PG upatePgOne and updatePgTwo
  upatePgOne()
  {
    console.log("PgId for Updation Is : " + this.pgIdToUpdate)
    this.addPropertyService.onupdatepgone(this.pgIdToUpdate)
    .subscribe(response => {
      console.log(response['country'])
      this.pgToUpdate = response
      console.log(this.pgToUpdate)
    })
  }

  upatePgTwo()
  {
    //this.pgIdToUpdate = parseInt(sessionStorage.getItem('pgIdToUpdate'))
     this.addPropertyService
     .onupdatepgtwo(this.pgIdToUpdate,this.name,this.RoomCapacity,this.rent,this.facilities,this.nonacrooms,this.acrooms,this.deposit,this.Status,
      this.city,this.state,this.PhoneNo,this.Landmark,this.address,this.ZipCode)

     .subscribe(response => {
       if(response)
       {
         console.log('Property Updated successfully')
         this.router.navigate(['/listpg'])
       }
       else{
         console.log(response['error'])
       }
     })
  }


}
