import { Component, OnInit } from '@angular/core';
import { OwnerService } from '../owner.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  Oid = parseInt(sessionStorage['OwnerId'])
  pgList = []
  l = 0;i=0;
  customers = 0
  cust = 0
  money = 0
  money1 = 0
  constructor(private ownerService:OwnerService) { }

  ngOnInit(): void 
  {
    this.Oid = parseInt(sessionStorage['OwnerId'])
    this.GetBusinessDeatils()
  }

  GetBusinessDeatils()
  {
    this.ownerService.onGetBusinessDeatils(this.Oid).subscribe((response :any[]) => 
    {
      this.l = response.length
      for(this.i = 0;this.i<this.l;this.i++)
      {
        this.customers = this.customers + response[this.i].noOfCustomers
      }

      for(this.i = 0;this.i<this.l;this.i++)
      {
        this.money = this.money + response[this.i].totalBusiness
      }
      // this.money1 = this.money
      // this.cust = this.customers
      console.log("No Of Pg " + this.l)
      this.pgList = response
      
      console.log("Response for Dashboard is : " , this.pgList)
    })
  }
}
