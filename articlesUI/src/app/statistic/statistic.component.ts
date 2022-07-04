import { HttpClient, HttpHeaders, HttpParams } from "@angular/common/http";
import { Router } from '@angular/router';
import { Component, Input, Output, EventEmitter, OnInit, OnChanges, SimpleChanges } from '@angular/core';
import { catchError } from 'rxjs/operators';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-statistic',
  templateUrl: './statistic.component.html',
  styleUrls: ['./statistic.component.scss']
})
export class StatisticComponent implements OnInit {
  pages:any;
  elem:any;
  items:any = [];
  pageOfItems: Array<any> = [];
  mainDate:any;
  errorMessage:any;

  constructor(private http:HttpClient, private router: Router) { }

  ngOnInit(): void {
  }

  getAllByDate(page:number, date:String, time:String) {
    this.mainDate = date + "T" + time + ":00.000000Z";
      const headers = new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${sessionStorage.getItem('token')}`
      })
      let num = page - 1;
      this.http.put('http://localhost:8080/article?page=' + num, this.mainDate,{ headers: headers }).subscribe(data => {
          this.errorMessage = null;
          console.log(data);
          let obj:any = data;
          this.pages = obj.totalPages;
          this.elem = obj.totalElements;
          this.items = obj.content;
          this.pageOfItems = Array.from({length: this.pages}, (_, i) => i + 1)
          console.log(this.pages + " : " + this.elem);
          console.log(this.items);
      },err => {
        console.log("Error caught at Subscriber " + err.status)
        this.handleError(err);
      })
  }

  handleError(error: Response) {
    if (error.status == 403) {
      this.errorMessage = "You don't have permision";
    } else {
      this.errorMessage = "Date or Time Incorrect";
    }
}

  return() {
    this.router.navigate(['/articles']);
  }

}
