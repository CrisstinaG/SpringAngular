import { Component, OnDestroy, OnInit } from '@angular/core';
import { CalculatorService } from 'src/app/services/calculator.service';


@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.scss']
})
export class CalculatorComponent implements OnInit, OnDestroy {

  display = '';

  constructor(public service: CalculatorService) { }

  ngOnDestroy(): void {
    console.log('ngOnDestroy()');
  }

  ngOnInit(): void {
    console.log('ngOnInit()');
    this.display = this.service.getDisplay();
  }

  handleSignal(value: any): void {
    // this.result += value;
    if (typeof value === 'string'){
      this.display = this.service.handleSymbol(value);
    } else if (typeof value === 'number') {
      this.display = this.service.handleNumber(value);
    }
  }

}
