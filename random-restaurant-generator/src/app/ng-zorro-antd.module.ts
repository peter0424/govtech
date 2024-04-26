
import { NgModule } from '@angular/core';

import { NzGridModule } from 'ng-zorro-antd/grid';
import { NzTableModule } from 'ng-zorro-antd/table';
import { NzInputModule } from 'ng-zorro-antd/input';
import { NzButtonModule } from 'ng-zorro-antd/button';

@NgModule({
  exports: [
    NzGridModule,
    NzTableModule,
    NzInputModule,
    NzButtonModule
  ]
})
export class NgZorroAntdModule {

}
