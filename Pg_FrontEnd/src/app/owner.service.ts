import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class OwnerService implements CanActivate {

//url = "http://ec2-107-23-189-94.compute-1.amazonaws.com:7070/owner"
url = "http://localhost:7070/owner"

  constructor(private router:Router,
    private httpClient: HttpClient) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean 
  {
    if (sessionStorage['OwnerEmail'] || sessionStorage['email'] || sessionStorage['Adminemail']) 
    {
          return true
    }

        this.router.navigate(['/login'])
    
    return false 
  }



onsignup(name: string, phone: string, email: string, password: string, city: string, address: string)
{
  const body = {
    name:name,
    phone:phone,
    email:email,
    password:password,
    city:city,
    address:address
  }
  return this.httpClient.post(this.url + '/register', body)
}

  onsignin(email: string, password: string)
  {
    const body = {
      email:email,
      password:password
    }

    return this.httpClient.post(this.url + '/login', body)
  }

  onGetBusinessDeatils(ownerId)
  {
    //return this.httpClient.get("http://ec2-107-23-189-94.compute-1.amazonaws.com:7070/pg/getOwnerBusiness/" + ownerId)
    return this.httpClient.get("http://localhost:7070/pg/getOwnerBusiness/" + ownerId)

  }
}

