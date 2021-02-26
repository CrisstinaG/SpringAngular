import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-apod-date-picker',
  templateUrl: './apod-date-picker.component.html',
  styleUrls: ['./apod-date-picker.component.scss']
})
export class ApodDatePickerComponent implements OnInit {

  @Output() dateSignal = new EventEmitter<string>();

  constructor() { }

  ngOnInit(): void {
  }

  handleNavigate(value: any): void {
    console.log(value);
    // date=yyyy-mm-dd
    const dateString = value.year + '-' + value.month + '-' + value.day;
    this.dateSignal.emit(dateString);
  }

}
