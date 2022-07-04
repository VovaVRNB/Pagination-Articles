import { HttpClient, HttpHeaders, HttpParams } from "@angular/common/http";
import { Router } from '@angular/router';
import { Component, Input, Output, EventEmitter, OnInit, OnChanges, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.scss']
})
export class ArticlesComponent implements OnInit {
    pages:any;
    elem:any;
    items:any = [];
    pageOfItems: Array<any> = [];

  constructor(private http:HttpClient, private router: Router) { }

  ngOnInit(): void {
    this.getAll(1);
  }

  getAll(page:number) {
      const headers = new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${sessionStorage.getItem('token')}`
      })
      let num = page - 1;
      this.http.get('http://localhost:8080/article?page=' + num, { headers: headers }).subscribe(data => {
        console.log(data);
        let obj:any = data;
        this.pages = obj.totalPages;
        this.elem = obj.totalElements;
        this.items = obj.content;
        this.pageOfItems = Array.from({length: this.pages}, (_, i) => i + 1)
        console.log(this.pages + " : " + this.elem);
        console.log(this.items);
      })
  }

  statistic() {
    this.router.navigate(['/statistic']);
  }

  create() {
    this.router.navigate(['/create']);
  }

  loguot() {
    sessionStorage.removeItem('token');
    this.router.navigate(['/login']);
  }

}
