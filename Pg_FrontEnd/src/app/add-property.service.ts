import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class AddPropertyService {

  em = ''

  //url = "http://ec2-107-23-189-94.compute-1.amazonaws.com:7070/pg"
  url = "http://localhost:7070/pg"

  OwnerIdForUpdation = parseInt(sessionStorage.getItem('OwnerId'))
  
  constructor(private router:Router,
  private httpClient:HttpClient) { }


onsave(name: string,RoomCapacity: number,rent: number,facilities: string,nonacrooms: number,acrooms: number,deposit: number,
  Status: string,city: string,state: string,PhoneNo: string,Landmark: string,address: string,ZipCode: string)
  {
    const body = {

      //OwnerId:ownerid,
      pgName:name,
      roomCapacity: RoomCapacity,
      pgRent:rent,
      pgFacilities:facilities,
      nacRooms:nonacrooms,
      acRooms:acrooms,
      pgDeposit:deposit,
      status: Status,
      city:city,
      state:state,
      phoneNo: PhoneNo,
      landmark: Landmark,
      address:address,
      zipCode: ZipCode,

    }
    this.em = sessionStorage['OwnerEmail']
    return this.httpClient.post(this.url + '/add/' + this.em, body)
  }

  ongetpg(id)
  {
    //return this.httpClient.get("http://ec2-107-23-189-94.compute-1.amazonaws.com:7070/owner" + '/show/pglist/'+ id)
    return this.httpClient.get("http://localhost:7070/owner" + '/show/pglist/'+ id)
    //url = "http://localhost:7070/pg"
  }

  ongetallpg(id)
  {
    return this.httpClient.get(this.url + '/get/'+ id)
  }

  ondeletePg(pgIdToDelete)
  {
    return this.httpClient.delete(this.url + '/delete/' + pgIdToDelete)
  }

  onupdatepgone(pgIdToUpdate)
  {
    return this.httpClient.get(this.url + '/get/'+ pgIdToUpdate)
  }

  onupdatepgtwo(pgIdToUpdate: number,name: string,RoomCapacity: number,rent: number,facilities: string,nonacrooms: number,acrooms: number,deposit: number,
    Status: string,city: string,state: string,PhoneNo: string,Landmark: string,address: string,ZipCode: string)
    {
      const body = {
  
        pgId:pgIdToUpdate,
        pgName:name,
        roomCapacity: RoomCapacity,
        pgRent:rent,
        pgFacilities:facilities,
        nacRooms:nonacrooms,
        acRooms:acrooms,
        pgDeposit:deposit,
        status: Status,
        city:city,
        state:state,
        phoneNo: PhoneNo,
        landmark: Landmark,
        address:address,
        zipCode: ZipCode
  
      }
      return this.httpClient.put(this.url + '/updateAll/' + this.OwnerIdForUpdation, body)
    }
  
}
