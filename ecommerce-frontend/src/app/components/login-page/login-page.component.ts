import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {Router} from '@angular/router'
import { BackendService } from 'src/app/services/backend.service';
interface User{
  email: string;
  password: string;
}
@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit{

  ngOnInit(): void {
    
  }
  user: User = {email:'', password: ''};
  loginForm: FormGroup;
constructor(private router: Router, private backendService: BackendService, private formBuilder: FormBuilder){
  this.loginForm = this.formBuilder.group({
    email: ['', [Validators.required, Validators.email]],
    password: ['', Validators.required],
  });
}

  onSubmit(){
    if (this.loginForm.valid) {
      const { email, password } = this.loginForm.value; // Get form values
      // Perform login or other actions with email and password
      this.backendService.loginUser(email, password).subscribe(
        response =>{
          this.backendService.setIsLoggedIn(true);
          console.log(this.backendService.getIsLoggedIn());
          this.router.navigate(['/home']);
          console.log(response);
        },
        error =>{
          console.log("Error ocurred");
          console.log(error);
        }
      )
    }
  }
}
