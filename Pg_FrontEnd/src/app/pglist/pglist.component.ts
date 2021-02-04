import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Observable } from 'rxjs';
import { PgService } from '../pg.service';
import { Pg } from './Pg';

@Component({
  selector: 'app-pglist',
  templateUrl: './pglist.component.html',
  styleUrls: ['./pglist.component.css']
})
export class PglistComponent implements OnInit {

  pgdetails = []
  
  UserId = ''

  pgs : Observable<Pg[]>;

  constructor(
    private toastr: ToastrService,
    private router: Router,
    private pgService: PgService) { }

    pg: Pg = new Pg();

  ngOnInit(): void {
    this.loadallPg()

  }

book(pg){

  //sessionStorage['bookedPgId'] = pg['pgId'] 
  this.router.navigate(['/add-booking'], {queryParams: {PgId: pg['pgId']}})
   //this.router.navigate(['/home/booking/add-booking'])
  console.log(this.router.navigate(['/add-booking'], {queryParams: {PgId: pg['pgId']}}))

}


loadallPg() {
  this.pgs = this.pgService.getPgList();
  console.log(this.pgs)
}


  loadPg() {
    this.pgService

      .getpg()
      .subscribe(response => {
        if (response['status'] == 'success') {
          this.toastr.info('PG List')
          alert('Pg List')
          this.pgdetails = response['data']
          console.log(this.pgdetails)
        } else {
          console.log(response['error'])
        }
      })
  }

}
