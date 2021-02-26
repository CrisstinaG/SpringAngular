import { Injectable } from '@angular/core';

enum states {INIT, FIRST_FIGURE, SECOND_FIGURE, RESULT}

@Injectable()
export class CalculatorService {
  private display = '';
  private currentState = states.INIT;
  private firstFigure = 0;
  private secondFigure = 0;
  private result = 0;
  private operator = '';

  constructor() { }

  handleNumber(value: number): string {
    switch (this.currentState) {
      case states.INIT:
        this.firstFigure = value;
        this.currentState = states.FIRST_FIGURE;
        this.display = '' + value;
        return this.display;
      case states.FIRST_FIGURE:
        this.firstFigure = this.firstFigure * 10 + value;
        this.display += value;
        return this.display;
      case states.SECOND_FIGURE:
        this.secondFigure = this.secondFigure * 10 + value;
        this.display += value;
        return this.display;
      case states.RESULT:
        this.result = 0;
        this.secondFigure = 0;
        this.operator = '';
        this.firstFigure = value;
        this.currentState = states.FIRST_FIGURE;
        this.display = '' + value;
        return this.display;
      default:
        break;
    }
  }

  handleSymbol(value: string): string {
    switch (this.currentState) {
      case states.INIT:
      break;
      case states.FIRST_FIGURE:
        if (value === '+' || value === '-' || value === '*' || value === '/'){
          this.operator = value;
          this.currentState = states.SECOND_FIGURE;
          this.display += value;
          return this.display;
        }
        break;
      case states.SECOND_FIGURE:
        if (value === '='){
          this.result = this.resolve();
          this.currentState = states.RESULT;
          this.display = this.display + '=' + this.result;
          return this.display;
        }
        break;
      case states.RESULT:
        this.secondFigure = 0;
        this.operator = value;
        this.firstFigure = this.result;
        this.result = 0;
        this.currentState = states.SECOND_FIGURE;
        this.display = '' + this.firstFigure + this.operator;
        return this.display;
      default:
      break;
    }
  }

  resolve(): number {
    switch (this.operator) {
      case '+':
        return this.firstFigure + this.secondFigure;
      case '-':
        return this.firstFigure - this.secondFigure;
      case '*':
        return this.firstFigure * this.secondFigure;
      case '/':
        return this.firstFigure / this.secondFigure;
      default:
        break;
    }
  }

  getDisplay(): string {
    return this.display;
  }

}
