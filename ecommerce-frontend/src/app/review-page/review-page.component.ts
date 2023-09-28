import { Component, OnInit } from '@angular/core';
import { Review } from '../models/Review';
import { ActivatedRoute, Router } from '@angular/router';
import { BackendService } from '../services/backend.service';

@Component({
  selector: 'app-review-page',
  templateUrl: './review-page.component.html',
  styleUrls: ['./review-page.component.css']
})
export class ReviewPageComponent implements OnInit {
  productId: number = 0;
  reviews:Review[] = [];
  error: string = '';
  constructor(private router: Router, private route: ActivatedRoute, private backendService: BackendService){

  }
  ngOnInit(): void {
    this.route.queryParams.subscribe(params =>{
      const productId = params['productId'];
      this.productId = productId;
      this.loadReviews();
    })
  }
  loadReviews(): void{
    this.backendService.getReviews(this.productId).subscribe(
      (response: Review[]) => {
        this.reviews = response.filter(review => review.approved);
      },
      (error: any) =>{
        console.error(error);
        this.error = 'Error occured while loading reviews';
      }
    )
  }
  askReview(): void{
    const productCode = this.productId;
    this.router.navigate(['/askreview'], {queryParams: {productCode}});
  }
}
