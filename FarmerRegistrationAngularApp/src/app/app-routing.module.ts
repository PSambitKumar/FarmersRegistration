import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {FarmerComponent} from "./components/farmer/farmer.component";
import {HomeComponent} from "./components/home/home.component";
import {TestComponent} from "./components/test/test.component";

const routes: Routes = [
  {path: "home", component:HomeComponent},
  {path:"", redirectTo:"home", pathMatch:"full"},
  {path:"farmerManagement", component:FarmerComponent},
  {path : "testPurpose", component : TestComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
