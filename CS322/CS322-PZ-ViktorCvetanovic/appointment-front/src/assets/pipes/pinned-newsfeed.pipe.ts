import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'isPinned'
})
export class PinnedNewsfeedPipe implements PipeTransform {
  transform(value: any[], isPinned: boolean, ...args: unknown[]): any[] {
    return value.filter(ann => ann.pinned === isPinned);
  }
}
