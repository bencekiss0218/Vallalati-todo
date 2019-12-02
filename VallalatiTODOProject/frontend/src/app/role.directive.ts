import { AuthenticationService } from './services/authentication.service';
import { UserRole } from './domain/user-role';
import { Directive, Input, ElementRef, OnInit } from '@angular/core';

@Directive({
  selector: '[appRole]'
})
export class RoleDirective implements OnInit {

  @Input() appRole: UserRole[];

  constructor(
    private elementRef: ElementRef,
    private authService: AuthenticationService
  ) {}

  ngOnInit() {
    if (!this.authService.hasRole(this.appRole)) {
      this.elementRef.nativeElement.style = 'display: none;';
    }
  }
}
