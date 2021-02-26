import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { ApodService } from 'src/app/services/apod.service';

@Component({
  selector: 'app-apod-show',
  templateUrl: './apod-show.component.html',
  styleUrls: ['./apod-show.component.scss']
})
export class ApodShowComponent implements OnInit, OnChanges {

  @Input() date: string;
  apiLoaded = false;
  result: any;

  constructor(public service: ApodService) { }

  ngOnInit(): void {
    if (!this.apiLoaded){
      const tag = document.createElement('script');
      tag.src = 'https://www.youtube.com/iframe_api';
      document.body.appendChild(tag);
      this.apiLoaded = true;
    }
    this.service.getRequest().subscribe(
      (data) => this.processData(data),
      (error) => this.processError(error)
    );
  }

  ngOnChanges(changes: SimpleChanges): void {
      this.service.getRequest(this.date).subscribe(
      (data) => this.processData(data),
      (error) => this.processError(error)
    );

  }

  processData(data: any): void {
    this.result = data;
    if (this.result.media_type === 'video'){
      this.result.id = this.getId(this.result.url);
    }
  }

  processError(error: any): void {
    console.log(error);
  }

  getId(url: string): any{
      const regExp = /^.*((youtu.be\/)|(v\/)|(\/u\/\w\/)|(embed\/)|(watch\?))\??v?=?([^#&?]*).*/;
      const match = url.match(regExp);
      return (match && match[7].length === 11) ? match[7] : false;
  }

}
