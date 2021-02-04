import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { }

  OnGetSearchedCityPg(city)
  {
    //return this.httpClient.get("http://ec2-107-23-189-94.compute-1.amazonaws.com:7070/pg/findByName/" + city)
    return this.httpClient.get("http://localhost:7070/pg/findByName/" + city)
   
  }
}
