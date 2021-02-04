import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ActivatedRoute,Router } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class PgService {
  //url = 'http://ec2-107-23-189-94.compute-1.amazonaws.com:7070/pg'
  url = "http://localhost:7070/pg"

  PgId = this.activatedRoute.snapshot.queryParams['PgId']
  //activatedRoute: any;
  
  constructor(
    private httpClient: HttpClient,
    private activatedRoute: ActivatedRoute) { }
  

    LoadPgList(PgId){
      const httpOptions = {
        headers: new HttpHeaders({
          token: sessionStorage['email']
          
        })
      };
      console.log(this.url + '/' + PgId)
      return this.httpClient.get(this.url + '/' + PgId,httpOptions)
    }

    getPgList(): Observable<any> 
    {
      return this.httpClient.get(this.url+'/getall');
    }

    onGetAllCities(): Observable<any> 
    {
      return this.httpClient.get(this.url+'/getcities');
    }

    

    createPg(product: Object): Observable<Object> {
      return this.httpClient.post(this.url+'/products/', product);
    }


  getpg() {
     // add the token in the request header
     const httpOptions = {
      headers: new HttpHeaders({
        token: sessionStorage['token']
      })
    };
    
    return this.httpClient.get(this.url, httpOptions)
  }



}


 
   
