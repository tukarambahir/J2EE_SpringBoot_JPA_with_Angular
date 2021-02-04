import { OwnerService } from './../owner.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserSignupService } from '../user-signup.service';
import { ToastrService } from 'ngx-toastr';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit 
{

  email = ''
  password = ''
  role = ''

  constructor(private toastr: ToastrService,
    private ownerService:OwnerService,
    private userSignUpService:UserSignupService,
    private router:Router) { }


  ngOnInit(): void {
  }

  signin()
  {
    console.log("Selected Role is " + this.role)
    if(this.role == 'Owner')
    {
      if(this.email == '' || this.password == '' || !(this.email.includes('@')))
      {
        this.toastr.warning('Please Enter Valid Credentials')
      }
      console.log("Processing Role is " + this.role)
      this.ownerService
      .onsignin(this.email, this.password)
      .subscribe(response => {
        if(response)
        {
          sessionStorage['role'] = this.role
          console.log("From Owner login Role is : " + this.role)
          sessionStorage['OwnerId'] = response['ownerId']
          sessionStorage['OwnerEmail'] = response['email']
          this.toastr.info("Welcome " + response['name'])
          this.router.navigate(['/dashboard'])
        }
  
        })
    }

    if(this.role == 'Customer' || this.role == 'Admin' || !(this.email.includes('@')))
    {
      if(this.email == '' || this.password == '')
      {
        this.toastr.warning('Please Enter Valid Credentials')
      }

      console.log("Processing Role is " + this.role)
      this.userSignUpService.login(this.email, this.password).subscribe(response => {
        if(response)
        {
          sessionStorage['role'] = this.role        
          if(this.role == 'Customer')
          {
            sessionStorage['customerId'] = response['customerId']
            sessionStorage['email'] = response['email']
            this.toastr.success("Welcome " + response['name'])
            this.router.navigate(['/userdashboard'])
          }

          if(this.role == 'Admin')
          {
            console.log("You are in Admin Routes")
            sessionStorage['adminId'] = response['customerId']
            sessionStorage['adminEmail'] = response['email']
            this.toastr.success("Welcome " + response['name'])
            this.router.navigate(['/admindashboard'])
          }
        }
      })
    }

 }
}
  
