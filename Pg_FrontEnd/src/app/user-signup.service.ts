import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserSignupService implements CanActivate{

  //url = 'http://ec2-107-23-189-94.compute-1.amazonaws.com:7070/customer'
  url = "http://localhost:7070/customer"

  constructor(private router:Router,
    private httpClient: HttpClient) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot)
  {
    if (sessionStorage['email'] || sessionStorage['Adminemail']) 
    {
          return true
    }

        this.router.navigate(['/login'])
    
    return false 
  }

  onsignup(name: string, phone: string, email: string, password: string, city: string, address: string, role: string,
    gender: string, dob: string)
{
  const body = {
    name:name,
    phone:phone,
    email:email,
    password:password,
    city:city,
    address:address,
    role: role,
    gender: gender,
    dob: dob
  }
  return this.httpClient.post(this.url + '/register', body)
}

login(email: string, password: string) {
  const body = {
    email: email,
    password: password
  }

  return this.httpClient.post(this.url + '/login', body)
}
}
