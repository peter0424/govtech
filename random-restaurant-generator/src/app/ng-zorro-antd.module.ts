
import { NgModule } from '@angular/core';

import { NzGridModule } from 'ng-zorro-antd/grid';
import { NzTableModule } from 'ng-zorro-antd/table';
import { NzInputModule } from 'ng-zorro-antd/input';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzFormModule } from 'ng-zorro-antd/form';
import { NzMessageModule } from 'ng-zorro-antd/message';
import { NzLayoutModule } from 'ng-zorro-antd/layout';

@NgModule({
  exports: [
    NzGridModule,
    NzTableModule,
    NzInputModule,
    NzButtonModule,
    NzFormModule,
    NzMessageModule,
    NzLayoutModule
  ]
})
export class NgZorroAntdModule {

}
