import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ParentTableComponent } from './pages/parent-table/parent-table.component';
import { ChildTableComponent } from './pages/child-table/child-table.component';

const routes: Routes = [
  { path: '', redirectTo: '/parent', pathMatch: 'full' },
  { path: 'parent', component: ParentTableComponent },
  { path: 'child/:id', component: ChildTableComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
