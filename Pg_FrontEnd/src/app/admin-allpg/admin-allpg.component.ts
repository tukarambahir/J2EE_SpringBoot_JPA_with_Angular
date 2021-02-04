import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-admin-allpg',
  templateUrl: './admin-allpg.component.html',
  styleUrls: ['./admin-allpg.component.css']
})
export class AdminAllpgComponent implements OnInit {

  constructor(private adminService:AdminService,private toastrService : ToastrService) { }

  OwnerId = parseInt(sessionStorage['ownerIdForAdmin']) 
  listOfOwnerPg = []
  finalList = []

  ngOnInit(): void {
    this.OwnerId = parseInt(sessionStorage['ownerIdForAdmin']) 
    this.GetOwnerPg()
  }

  GetOwnerPg()
  {
    this.adminService.onGetOwnerPg(this.OwnerId)
    .subscribe((response: any[]) => {
      this.listOfOwnerPg = response
      console.log("Response Is : " , response)
     this.finalList = this.listOfOwnerPg.filter((item)=>{
       console.log("Item is : " , item)
        return item
      })
      this.toastrService.success("List Loaded");
      console.log("List Of Owners Pg is : " , this.finalList[0])
      //console.log(this.owners[0].address)
    })
  }

}
