import { AuthenticationService } from './../services/authentication.service';
import { User } from './../domain/user';
import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User = {
    name: null,
    password: '',
    role: null,
    username: '',
    taskToDo: null,
    comments: null
  };

  constructor(private authService: AuthenticationService ) { }

  ngOnInit() {
  }

  onSubmit(form: FormGroup) {
    const user = form.value as User;
    this.authService.login(user.username, user.password);
  }
}
