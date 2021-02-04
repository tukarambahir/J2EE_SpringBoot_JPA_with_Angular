import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-searched-pg-list',
  templateUrl: './searched-pg-list.component.html',
  styleUrls: ['./searched-pg-list.component.css']
})
export class SearchedPgListComponent implements OnInit {

  constructor(private router: Router, private userService: UserService) { }

  CityPg = []
  getCity = sessionStorage['searchedCityForPg']
  ngOnInit(): void {
    this.getCity = sessionStorage['searchedCityForPg']
    this.GetSearchedCityPg()

  }

  GetSearchedCityPg()
  {
    this.userService.OnGetSearchedCityPg(this.getCity)
    .subscribe((response :any[]) => 
      {
        console.log("Selected city is : " + this.getCity)
        this.CityPg = response
        console.log("All Pg In Selected City Are ", this.CityPg)
      })
  }

  book(pg){

    this.router.navigate(['/add-booking'], {queryParams: {PgId: pg['pgId']}})
     //this.router.navigate(['/home/booking/add-booking'])
    console.log(this.router.navigate(['/add-booking'], {queryParams: {PgId: pg['pgId']}}))
  
  }

}
