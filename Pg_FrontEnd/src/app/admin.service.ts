import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private router:Router,
    private httpClient:HttpClient) { }

 // url = "http://ec2-107-23-189-94.compute-1.amazonaws.com:7070/admin"

  url = "http://localhost:7070/admin"

  ongetAllOwners()
  {
    return this.httpClient.get(this.url + "/allOwners")
  }

  onGetOwnerPg(ownerId)
  {
    console.log("Sending request to get All Pg of ownerId :" + ownerId)
    //return this.httpClient.get("http://ec2-107-23-189-94.compute-1.amazonaws.com:7070/owner/show/pglist/" + ownerId)
    return this.httpClient.get("http://localhost:7070/owner/show/pglist/" + ownerId)
  
  }

  onGetAllBookings()
  {
    return this.httpClient.get(this.url + '/getallBookings')
  }
}
