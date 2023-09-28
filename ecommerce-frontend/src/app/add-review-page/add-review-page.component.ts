import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { BackendService } from '../services/backend.service';

@Component({
  selector: 'app-add-review-page',
  templateUrl: './add-review-page.component.html',
  styleUrls: ['./add-review-page.component.css']
})
export class AddReviewPageComponent implements OnInit{
  productCode?: number;
  heading?: string;
  rating?: number;
  review?: string;
  showSuccessMessage: boolean = false;
  searchResults: any[] = [];
  reviewForm!: FormGroup;
  error: string = '';
  constructor(private route: ActivatedRoute, private router: Router, private backendService: BackendService, private formBuilder: FormBuilder){}

  ngOnInit(): void {
    this.route.queryParams.subscribe(params =>{
      this.productCode = params['productCode'];
      const results = params['result'];
      console.log(results);
      if(results){
        this.searchResults = JSON.parse(results);
      }
    });
    this.reviewForm = this.formBuilder.group({
      heading: ['', Validators.required],
      rating: ['', [Validators.required, Validators.min(1), Validators.max(5)]],
      review: ['', [Validators.required, Validators.minLength(20), Validators.maxLength(400)]]
    });
  }
addReview(): void{
  if(this.reviewForm.invalid){
    return;
  }
  const review = {
    productCode: this.productCode,
    heading: this.reviewForm.get('heading')?.value,
    rating: this.reviewForm.get('rating')?.value,
    review: this.reviewForm.get('review')?.value
  };
  this.backendService.addReview(review).subscribe(
    response => {
      console.log('Response is',response);
      console.log('Review added sucessfully');
       
       this.router.navigate(['/result'], {queryParams: {result: JSON.stringify(this.searchResults)}});
      
    },
    error =>{
      console.error('Error occured while adding', error);
      console.log('Error body', error.error);
      this.error = 'Error while adding review';
    }
  );
}
goToAdminPage(): void{
  this.router.navigate(['/admin']);
}
}

