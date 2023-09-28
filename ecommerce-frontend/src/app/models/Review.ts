export class Review{
    reviewId: number;
    productId: number;
    heading: string;
    rating: number;
    review: string;
    approved: boolean;
    constructor(reviewId: number, productId: number, heading: string, rating: number, review:string, approved: boolean){
        this.review = review;
        this.reviewId = reviewId;
        this.productId = productId;
        this.heading = heading;
        this.rating = rating;
        this.approved = approved;
    }
}