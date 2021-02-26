import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApodDatePickerComponent } from './apod-date-picker.component';

describe('ApodDatePickerComponent', () => {
  let component: ApodDatePickerComponent;
  let fixture: ComponentFixture<ApodDatePickerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ApodDatePickerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ApodDatePickerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
