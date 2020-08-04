import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { AuthenticationService } from './_services';
import { User } from './_models';

@Component({ selector: 'app', templateUrl: 'app.component.html' })
export class AppComponent {
    currentUser: User;
    isLogged: boolean;

    constructor(
        private router: Router,
        private authenticationService: AuthenticationService
    ) {
        this.isLogged = false
        this.authenticationService.currentUser.subscribe(x => {
            this.currentUser = x
            this.isLogged = true
        });
    }

    logout() {
        this.authenticationService.logout();
        this.router.navigate(['/login']);
        this.isLogged = false
    }
}