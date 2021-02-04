import { Component, OnInit } from '@angular/core';
import { AddPropertyService } from '../add-property.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-pg',
  templateUrl: './pg.component.html',
  styleUrls: ['./pg.component.css']
})
export class PgComponent implements OnInit {
  
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


  constructor(private toastr: ToastrService,private addPropertyService:AddPropertyService,
    private router:Router) { }

  ngOnInit(): void {
  }

  ownerid = 0
  
  save()
  {
     this.ownerid = parseInt(sessionStorage.getItem('OwnerId'))
     this.addPropertyService
     .onsave(this.name,this.RoomCapacity,this.rent,this.facilities,this.nonacrooms,this.acrooms,this.deposit,this.Status,
      this.city,this.state,this.PhoneNo,this.Landmark,this.address,this.ZipCode)

     .subscribe(response => {
       if(response)
       {
         this.toastr.success("Property added successfully")
         console.log('Property added successfully')

         this.router.navigate(['/dashboard'])
       }
       else{
         console.log(response['error'])
       }
     })
    }

}
