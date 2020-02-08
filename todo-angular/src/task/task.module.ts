import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { TaskComponent } from './task.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [
    TaskComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [TaskComponent]
})
export class TaskModule { }
