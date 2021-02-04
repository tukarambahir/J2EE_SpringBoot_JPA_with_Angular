import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-admin-allowners',
  templateUrl: './admin-allowners.component.html',
  styleUrls: ['./admin-allowners.component.css']
})
export class AdminAllownersComponent implements OnInit {

  owners = {}
  constructor(private adminService:AdminService,private toastrService : ToastrService,
    private router:Router,) { }

  ngOnInit(): void {
    this.getAllOwners()
  }
  
  getAllOwners()
  {
    this.adminService.ongetAllOwners()
    .subscribe(response => {
      console.log("Response for Owners: " + response)
      this.owners = response
      this.toastrService.info("Owners List Loaded")
      //console.log(this.owners[0].address)
    })
  }

  getHisPgs(ownerIdForAdmin)
  {
    console.log("ownerIdForAdmin is : " + ownerIdForAdmin)
    sessionStorage['ownerIdForAdmin'] = ownerIdForAdmin
    this.router.navigate(['/adminpgs'])  
  }
}
