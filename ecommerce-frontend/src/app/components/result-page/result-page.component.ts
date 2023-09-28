import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { forkJoin, map } from 'rxjs';
import { BackendService } from 'src/app/services/backend.service';

interface SearchResults {
  productName: string;
  brandName: string;
  price: number;
}
@Component({
  selector: 'app-result-page',
  templateUrl: './result-page.component.html',
  styleUrls: ['./result-page.component.css'],
})
export class ResultPageComponent implements OnInit {
  searchResults: SearchResults[] = [];
  error: string = '';
  filterValue: string = '';
  selectedFilter: string = '';
  filteredResults: any[] = [];
  constructor(
    private route: ActivatedRoute,
    private backendService: BackendService,
    private router: Router
  ) {}
  ngOnInit(): void {
    this.route.queryParams.subscribe((params) => {
      const results = params['result'];
      if (results) {
        // Parse the JSON string back into an array
        console.log('Received results:', results); // Check if data is received
        this.searchResults = JSON.parse(results);
        console.log('Parsed results:', this.searchResults); // Check parsed data
        this.filteredResults = this.searchResults;
      }
    });
  }
  applyFilter(): void {
    if (this.selectedFilter && this.filterValue) {
      let filteredResults: any[];

      switch (this.selectedFilter) {
        case 'productName':
          filteredResults = this.searchResults.filter((result) =>
            result.productName
              .toLowerCase()
              .includes(this.filterValue.toLowerCase())
          );
          break;
        case 'brandName':
          filteredResults = this.searchResults.filter((result) =>
            result.brandName
              .toLowerCase()
              .includes(this.filterValue.toLowerCase())
          );
          break;
          //Price Filter not working
        case 'price':
          filteredResults = this.searchResults.filter((result) =>
            result.price
              ?.toString()
              .toLowerCase()
              .includes(this.filterValue.toLowerCase())
          );
          break;
        default:
          filteredResults = this.searchResults;
          break;
      }

      this.filteredResults = filteredResults;
    } else {
      this.filteredResults = this.searchResults;
    }
  }

  // updateReviewInfo(): void {
  //   const requests = [];

  //   for (const result of this.searchResults) {
  //     const productId = result.productId;
  //     const request = this.backendService.getReviews(productId).pipe(
  //       map(response => {
  //         const approvedReviews = response.filter(review => review.approved);
  //         const totalReviews = approvedReviews.length;
  //         const totalRating = approvedReviews.reduce((sum, review) => sum + review.rating, 0);
  //         result.numberOfReviews = totalReviews;
  //         result.averageRating = totalReviews > 0 ? (totalRating / totalReviews).toFixed(1) : 0;
  //       }),
  //       catchError(error =>{
  //         this.error = 'Error fetching search results';
  //         return throwError(error);
  //       })
  //     );
  //     requests.push(request);
  //   }

  //   forkJoin(requests).subscribe(
  //     () => {
  //       this.filteredResults = this.searchResults;
  //     },
  //     error => {
  //       console.error(error);
  //     }
  //   );
  // }

  addReview(product: any): void {
    const productId = product.productId;
    const queryParams = {
      productId,
      result: JSON.stringify(this.searchResults),
    };
    this.router.navigate(['/addreview'], { queryParams });
    //this.router.navigate(['/result'], {queryParams: {result: JSON.stringify(this.searchResults), }});
  }
  viewReviews(product: any): void {
    console.log();
    const productId = product.productId;
    this.router.navigate(['/reviews'], { queryParams: { productId } });
  }
  logout(): void {
    this.backendService.setIsLoggedIn(false);
    this.router.navigate(['/']);
  }
}
