import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AddPropertyService } from '../add-property.service';

@Component({
  selector: 'app-property-list',
  templateUrl: './property-list.component.html',
  styleUrls: ['./property-list.component.css']
})
export class PropertyListComponent implements OnInit {

  hotels = {}
  
  getownerid = sessionStorage.getItem('OwnerId')


  constructor(private router:Router,
    private addPropertyService:AddPropertyService) { }

  ngOnInit(): void {
    this.getpg()
  }

  getpg()
  {
    this.addPropertyService
    .ongetpg(this.getownerid)
    .subscribe(response => 
      {
        this.hotels = response
    })
  }
  // if (response['status'] == 'success') 
  //       {
  //         this.hotels = response['data']
  //         console.log(this.hotels)
  //       }
  //       else 
  //       {
  //         console.log(response['error'])
  //       }
  getdetails(pgId)
  {
    sessionStorage['pgId'] = pgId
    this.router.navigate(['/pgdetail'])
  }

  deletePg(pgIdToDelete)
  {
    this.addPropertyService
    .ondeletePg(pgIdToDelete)
    .subscribe(response => {
      if(response)
      {
        this.getpg()
      }
      else
      {
        console.log("Error while deleting")
      }
    })
  }

  updatePg(pgIdToUpdate)
  {
    sessionStorage['pgIdToUpdate'] = pgIdToUpdate
    this.router.navigate(['/updatepgdetail'])
  }

  // getpg()
  // {
  //   this.addPropertyService
  //   .ongetpg(this.getownerid)
  //   .subscribe(response => {
  //     if (response['status'] == 'success') {
  //      console.log('hello')
  //     } else {
  //       console.log(response['error'])
  //     }
  //   })
  // }

}
