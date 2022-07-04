import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from "@angular/common/http";
import { Router } from '@angular/router';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.scss']
})
export class CreateComponent implements OnInit {
  errorMessage:any;

  constructor(private http:HttpClient, private router: Router) { }

  ngOnInit(): void {
  }

  createArt(title:string, content:string) {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${sessionStorage.getItem('token')}`
    })
    let options = { headers: headers };
    let body = {
      "title":title,
      "content":content
    };
    this.http.post('http://localhost:8080/article', body, options).subscribe(data => {
      if (data) {
        console.log(data);
        this.router.navigate(['/articles']);
      }
    },err => {
      console.log("Error caught at Subscriber " + err.status)
      this.errorMessage = "Title should be less then 100 symbols";
    })
  }

  return() {
    this.router.navigate(['/articles']);
  }

}
