import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {StudentComponent} from "./student/student.component";
import {UpdateStudentComponent} from "./update-student/update-student.component";

const routes: Routes = [{
  path:"",
  component:StudentComponent
},
  {
    path:"update/:sId",
    component:UpdateStudentComponent

  }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
