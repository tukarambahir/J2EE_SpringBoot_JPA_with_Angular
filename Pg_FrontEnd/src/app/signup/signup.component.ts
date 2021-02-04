import { OwnerService } from './../owner.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserSignupService } from '../user-signup.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

name =''
email = ''
phone = ''
password =''
city =''
address =''
role =''
gender = 'male/female'
dob = '2020-10-10'

  constructor(private toastr: ToastrService,private ownerService:OwnerService,
    private userSignUpService: UserSignupService,
    private router:Router) { }

  ngOnInit(): void {

  }

  signup()
  {
    if(this.role != '')
    {
      if(this.role == 'Owner')
      {
        if(!(this.email.includes('@')) )
        {
          this.toastr.warning('Please Enter Valid Email')
        }

        if(this.password == '' || this.phone == '' || this.name == '')
        {
          this.toastr.warning('Please Enter Valid Data')
        }

        this.ownerService
        .onsignup(this.name, this.phone, this.email, this.password, this.city, this.address)
        .subscribe(response => {
          if(response)
          {
            this.toastr.info('Signed-Up Successfully')
            this.router.navigate(['/login'])
          }
          else{
            console.log(response['error'])
          }
        })
      }
  
      if(this.role == 'Customer' || this.role == 'Admin')
      {
        if(!(this.email.includes('@')) )
        {
          this.toastr.warning('Please Enter Valid Email')
        }

        if(this.password == '' || this.phone == '' || this.name == '')
        {
          this.toastr.warning('Please Enter Valid Data')
        }

        this.userSignUpService
        .onsignup(this.name, this.phone, this.email, this.password, this.city, this.address, this.role, this.gender, this.dob)
        .subscribe(response => {
          if(response)
          {
            alert('Signed-Up Successfully')
            this.router.navigate(['/login'])
          }
          else{
            console.log(response['error'])
          }
        })
      }
  
    }

    else
    {
      this.toastr.warning('Select A Valid Role')
    }

  }

}
