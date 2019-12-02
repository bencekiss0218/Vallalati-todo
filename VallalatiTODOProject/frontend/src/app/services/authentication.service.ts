import { Injectable } from '@angular/core';
import { User } from '../domain/user';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { UserRole } from '../domain/user-role';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  get isLoggedIn(): boolean {
    return this.user.role !== UserRole.NotAuthorized;
  }
  get token() {
    return btoa(`${this.user.username}:${this.user.password}`);
  }

  get role(): UserRole {
    return this.user.role;
  }

  private user: User;

  constructor(private router: Router, private http: HttpClient) {
    this.logout(false);
  }

  hasRole(roles: UserRole[]): boolean {
    return roles.some(
      role => role === this.role);
  }

  async login(username: string, password: string) {
    const oldUser = this.user;
    this.user = {
      name: null,
      role: null,
      username: username,
      password: password,
      taskToDo: null,
      comments: null
    };
    try {
      const user = await (this.http.get('workers/login').toPromise() as Promise<User>);
      this.user.name = user.name;
      this.user.role = user.role;
      this.user.taskToDo = user.taskToDo;
      this.user.comments = user.comments;
      this.router.navigate(['/tasks']);
    } catch (e) {
      this.user = oldUser;
    }
  }

  logout(shouldNavigateToRoot: boolean = true) {
    this.user = {
      name: 'NotAuthorized',
      username: null,
      password: null,
      role: UserRole.NotAuthorized,
      taskToDo: null,
      comments: null
    };
    if (shouldNavigateToRoot) {
      this.router.navigate(['/']);
    }
  }
}
