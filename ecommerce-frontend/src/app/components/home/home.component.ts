import { Component,OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BackendService } from 'src/app/services/backend.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{
  products: any[] = [];
  isLoggedIn: boolean = false;
  constructor(private backendService: BackendService, private router: Router){}
  ngOnInit(): void {
    this.isLoggedIn = this.backendService.getIsLoggedIn();
    this.backendService.getAllProducts().subscribe(
      response =>{
        this.products = response
      },
      error =>{
        console.log(error);
      }
    )
  }
  searchValue: string ='';
  searchResults: any[] = [];

  search(): void{
    if(!this.searchValue){
      return;
    }
    this.backendService.searchProduct(this.searchValue).subscribe(
      (response:any) =>{
        this.searchResults = response;
        console.log('Backend',this.searchResults);
        this.router.navigate(['/result'], {queryParams: {result: JSON.stringify(this.searchResults)}});
      },
      (error: any) =>{
        console.log(error);
      }
    )
    
  }

  clearSearch(): void{
    
  }
}
