import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'sort',
  pure: false
})
export class SortPipe implements PipeTransform {

  transform(countries: any[], ...args: unknown[]): unknown {

    let result =  countries;
    const model: any = args[0];
    switch (model.order) {
      case 0:
        result = countries.sort((a, b) => a.name.localeCompare(b.name));
        break;
      case 1:
        result = countries.sort((a, b) => a.population - b.population);
        break;
      case 2:
        result = countries.sort((a, b) => a.area - b.area);
        break;
    
      default:
        break;
    }
    if (!model.ascendent) {
      result = result.reverse();
    }
    console.log('Pipe: ' + args[0]);
    return result;
  }

}
