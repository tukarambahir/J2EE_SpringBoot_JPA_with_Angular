import { Component, OnInit } from '@angular/core';
import { AddPropertyService } from '../add-property.service';

@Component({
  selector: 'app-property-details',
  templateUrl: './property-details.component.html',
  styleUrls: ['./property-details.component.css']
})
export class PropertyDetailsComponent implements OnInit {

  //hotels : object
  hotels = {}

  pgid = sessionStorage.getItem('pgId')


  constructor(private addPropertyService:AddPropertyService) { }

  ngOnInit(): void {
  this.getpg()
  }

  // getallpg()
  // {debugger;
  //   this.addPropertyService 
  //   .ongetallpg(this.getownerid)
  //   .subscribe(response => {
  //     console.log(response)
  //     console.log(this.getownerid)
  //     if (response['status'] == 'success') {
  //       this.hotels = response['data']
  //       console.log(this.hotels)
  //     } else {
  //       console.log(response['error'])
  //     }
  //   })
  // }


  // if (response['status'] == 'success') 
  //     {
  //       this.hotels = response['data']  
  //     }
  //     else
  //     {
  //       console.log(response['error'])
  //     }
  
  getpg()
  {
    console.log("PgId sent Is : " + this.pgid)
    this.addPropertyService.ongetallpg(this.pgid)
    .subscribe(response => {
      console.log(response['country'])
      this.hotels = response
      console.log(this.hotels)
      console.log(this.hotels['country'])
    })
  }

}









