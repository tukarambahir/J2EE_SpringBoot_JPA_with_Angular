import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { PgService } from '../pg.service';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {

  allCities: []
  scity = ''
  constructor(private router: Router,private pgService: PgService) { }

  ngOnInit(): void {
    this.GetAllCities()
  }

  GetAllCities()
  {
    this.pgService.onGetAllCities()
    .subscribe(response => 
      {
        console.log("Cities are : " + response)
        this.allCities = response
      })
  }

  searchedCity()
  {
    console.log("The searched city is : " + this.scity);
    sessionStorage['searchedCityForPg'] = this.scity
    this.router.navigate(['/searchedCityPg'])
  }

  onLogout() {
    sessionStorage.removeItem('email')
    sessionStorage.removeItem('customerId')

    this.router.navigate(['/login'])
  }

}
