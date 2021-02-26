import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'abv'
})
export class AbvPipe implements PipeTransform {

  transform(value: unknown, ...args: unknown[]): unknown {
    if (typeof value === 'number') {
      if (args.length > 0) {
        return '' + value.toLocaleString('es-ES') + args[0];
      }
      return value.toLocaleString('es-ES') + '%';
    }
    // Error case
    else{
      console.error('AbvPipe: ' + value + ' [Not supported type]');
      return value;
    }
  }

}
